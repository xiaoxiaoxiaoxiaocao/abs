package abs.pubs.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Title:http工具类
 * Description:
 * Copyright: Copyright (c)2017
 * Company: pay
 *
 * @author cheng.chen
 */

public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static final String DEFAULT_CHARSET = "UTF-8";

    public static final int CONNECT_TIMEOUT = 15000;
    public static final int SOCKET_TIMEOUT = 15000;

    /**
     * get方法获取字符串
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String getByString(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;

        RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpGet.setConfig(config);

        try {
            httpResponse = httpclient.execute(httpGet);
            return executeResponse(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            close(httpResponse);
        }
    }

    /**
     * post方法获取字符串
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String postByString(String url, String param, String dataType) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse httpResponse = null;

        RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPost.setConfig(config);

        StringEntity entity = new StringEntity(param, ContentType.create(dataType, Consts.UTF_8));
//        entity.setChunked(true);

        httpPost.setEntity(entity);

        try {
            httpResponse = httpclient.execute(httpPost);
            return executeResponse(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            close(httpResponse);
        }
    }

    public static String postByMap(String url, Map<String, String> param, String dataType) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse httpResponse = null;

        RequestConfig config = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPost.setConfig(config);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));

            httpResponse = httpclient.execute(httpPost);

            return executeResponse(httpResponse);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        } finally {
            close(httpResponse);
        }
    }

    /**
     * 处理http响应
     *
     * @param httpResponse
     */
    private static String executeResponse(CloseableHttpResponse httpResponse) throws IOException {
        StatusLine statusLine = httpResponse.getStatusLine();

        logger.debug("statusCode:" + statusLine.getStatusCode());
        HttpEntity responseEntity = httpResponse.getEntity();
        String resp = EntityUtils.toString(httpResponse.getEntity(), DEFAULT_CHARSET);
        logger.debug(resp);
        EntityUtils.consume(responseEntity);

        if (statusLine.getStatusCode() == 200) {
            return resp;
        } else {
            throw new RuntimeException("http响应错，状态码：" + statusLine.getStatusCode());
        }
    }

    /**
     * 关闭CloseableHttpResponse
     *
     * @param response
     */
    private static void close(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    /**
	 * post 方式传递json
	 * @throws Exception
	 */
	public static String post(String strURL, String params,String dataType) {
		logger.info("======= http post method start =====");
		logger.info("======= http post url =====" + strURL);
		logger.info("======= http post params =====" + params);
		try {
			URL url = new URL(strURL);// 创建连接
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST"); // 设置请求方式
			connection.setRequestProperty("Accept", "application/"+dataType); // 设置接收数据的格式
			connection.setRequestProperty("Content-Type", "application/"+dataType); // 设置发送数据的格式
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream(), "UTF-8"); // utf-8编码
			out.append(params);
			out.flush();
			out.close();
			// 读取响应
			int length = (int) connection.getContentLength();// 获取长度
			InputStream is = connection.getInputStream();
			if (length != -1) {
				byte[] data = new byte[length];
				byte[] temp = new byte[512];
				int readLen = 0;
				int destPos = 0;
				while ((readLen = is.read(temp)) > 0) {
					System.arraycopy(temp, 0, data, destPos, readLen);
					destPos += readLen;
				}
				String result = new String(data, "UTF-8"); // utf-8编码
				logger.info("======= http post method end ,result =====" + result);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error"; // 自定义错误信息
	}
}
