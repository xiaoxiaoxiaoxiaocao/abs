package abs.pubs.utils;


import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
//
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
//



/**
 * HTTP 访问 可以自动识别 HTTP HTTPS
 * 
 * @author Administrator
 * 
 */
public class HttpSender {

	private String reSendPath;
	private Integer reSendTime = -1;

	public HttpSender() {
	}
	//org.apache.commons.

	public enum SEND_METHOD {
		POST, GET
	}

	private boolean useProxy = false;
	private String proxyHost;
	private Integer proxyPort;

	static {
		Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
		Protocol.registerProtocol("https", myhttps);
	}


	/**
	 * POST发送
	 * 
	 * @param ipAddress
	 *            IP地址
	 * @param port
	 *            端口
	 * @param charset
	 *            字符集
	 * @param timeout
	 *            超时时间
	 * @param reqData
	 *            发送数据
	 * @return
	 * @throws Exception
	 */
	public String send(String ipAddress, Integer port, String charset,
			Integer timeout, String reqData) throws Exception {
		String result = null;

		HttpClient httpClient = new HttpClient();

		PostMethod postMethod = new PostMethod("http://" + ipAddress + ":"
				+ port);
		
		postMethod.addRequestHeader("Content-Type", "text/html;charset="
				+ charset);
		postMethod.setRequestEntity(new StringRequestEntity(reqData,
				"text/html", charset));
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		if (useProxy) {
			httpClient.getHostConfiguration().setProxy(proxyHost, proxyPort);
			httpClient.getParams().setAuthenticationPreemptive(true);
		}
		try {
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ postMethod.getStatusLine());
			}
			byte[] responseBody = postMethod.getResponseBody();
			result = new String(responseBody, charset);

		} finally {
			postMethod.releaseConnection();
		}
		return result;
	}

	/**
	 * 
	 * @param ipAddress
	 *            发送地址 可为IP或URL
	 * @param port
	 *            发送端口（当发送地址为url时可随便填写）
	 * @param charset
	 *            字符集
	 * @param timeout
	 *            超时时间
	 * @param reqData
	 *            发送数据
	 * @param head
	 *            头信息
	 * @param sendMethod
	 *            发送方式（GET POST）
	 * @return
	 * @throws Exception
	 */
	public String send(String ipAddress, Integer port, String charset,
			Integer timeout, String reqData, Map<String, String> head,
			SEND_METHOD sendMethod) throws Exception {
		Map<String, Object> methodParam = new HashMap<String, Object>();
		methodParam.put(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		return send(ipAddress, port, charset, timeout, reqData, head,
				methodParam, sendMethod);
	}

	/**
	 * 
	 * @param ipAddress
	 *            发送地址 可为IP或URL
	 * @param port
	 *            发送端口（当发送地址为url时可随便填写）
	 * @param charset
	 *            字符集
	 * @param timeout
	 *            超时时间
	 * @param reqData
	 *            发送数据
	 * @param sendMethod
	 *            发送方式（GET POST）
	 * @return
	 * @throws Exception
	 */
	public String send(String ipAddress, Integer port, String charset,
			Integer timeout, String reqData, SEND_METHOD sendMethod)
	throws Exception {
		Map<String, String> head = new HashMap<String, String>();
		if (sendMethod == SEND_METHOD.GET) {
			head.put("Content-Type", "text/html;charset=" + charset);
		} else if (sendMethod == SEND_METHOD.POST) {
			head.put("Content-Type",
					"application/x-www-form-urlencoded;charset=" + charset);
		}
		return send(ipAddress, port, charset, timeout, reqData, head,
				sendMethod);
	}

	/**
	 * @param url
	 *            发送地址 可为IP或URL
	 * @param charset
	 *            发送字符集
	 * @param timeout
	 *            超时时间
	 * @param reqData
	 *            发送数据
	 * @param sendMethod
	 *            发送方法 （GET POST）
	 * @return
	 * @throws Exception
	 */
	public String send(String url, String charset, Integer timeout,
			String reqData, SEND_METHOD sendMethod) throws Exception {
		return send(url, 80, charset, timeout, reqData, sendMethod);
	}

	/**
	 * 
	 * @param url
	 *            发送地址 可为IP或URL
	 * @param timeout
	 *            超时时间
	 * @param reqData
	 *            发送数据
	 * @param sendMethod
	 *            发送方式 （GET POST）
	 * @return
	 * @throws Exception
	 */
	public String send(String url, Integer timeout, String reqData,
			SEND_METHOD sendMethod) throws Exception {
		return send(url, "utf-8", timeout, reqData, sendMethod);
	}

	/**
	 * 
	 * @param url
	 *            发送地址 可为IP或URL
	 * @param reqData
	 *            发送数据
	 * @param charSet
	 *            发送字符集
	 * @param sendMethod
	 *            发送方法 （GET POST）
	 * @return
	 * @throws Exception
	 */
	public String send(String url, String reqData, String charSet,
			SEND_METHOD sendMethod) throws Exception {
		return send(url, charSet, 30000, reqData, sendMethod);
	}

	/**
	 * 
	 * @param url
	 * @param groupDate
	 * @param sendCharSet
	 * @param method
	 * @return
	 * @throws Exception
	 */
	public String send(String url, Map<String, String> groupDate,
			String sendCharSet, SEND_METHOD method) throws Exception {
		StringBuilder builder = new StringBuilder();
		String reqData = "";
		if (groupDate != null && groupDate.size() > 0) {
			for (Map.Entry<String, String> item : groupDate.entrySet()) {
				builder.append(item.getKey()).append("=").append(
						URLEncoder.encode(item.getValue(), sendCharSet))
						.append("&");
			}
			reqData = builder.substring(0, builder.length() - 1);
		}
		return send(url, reqData, sendCharSet, method);
	}

	/**
	 * 
	 * @param ipAddress
	 * @param port
	 * @param charset
	 * @param timeout
	 * @param data
	 * @param head
	 * @param methodParams
	 * @param sendMethod
	 * @return
	 * @throws Exception
	 */
	public String send(String ipAddress, Integer port, String charset,
			Integer timeout, String data, Map<String, String> head,
			Map<String, Object> methodParams, SEND_METHOD sendMethod)
	throws Exception {
		HttpClient httpClient = new HttpClient();
		// 设置超时时间
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(
				timeout);
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeout);

		// 设置代理
		if (useProxy) {
			httpClient.getHostConfiguration().setProxy(proxyHost, proxyPort);
			httpClient.getParams().setAuthenticationPreemptive(true);
		}

		// 设置发送URL
		HttpMethod method = null;
		String sendURL = null;
		sendURL = ipAddress.toLowerCase().indexOf("http") >= 0 ? ipAddress
				: "http://" + ipAddress + ":" + port;

		// 根据发送方式选择发送方法
		String result = null;
		switch (sendMethod) {
		case POST:
			PostMethod postMethod = new PostMethod(sendURL);
			//acqInsCode=48465840&txnSubType=00&version=3.0.0&txnAmt=1&backUrl=&billNo=&encoding=UTF-8&merCatCode=4511&subMerId=846440345110011&encryptCertId=38419312202645712532417650457361576245&signature=pkEQcLwfUKfXwNabUgTVdqToGa62BVkIAH1JKxAMm2Oncrf3t2%2FfWNsC%2BqIbcBFvSuRs%2FD95QG5dG5sV3qtLqQFk89dWiU0DIeOwOWRVEDIl0u0NP9eECpJ1ZkPvqYKOV5XDlvWNNwFTPuAOh%2F%2FRR18tqAV%2FK54hMUW7K7ha3is%3D&orderId=20140422175758452&txnType=12&billType=&currencyCode=156&merId=846440345110011&subMerName=%E6%B7%B1%E5%9C%B3%E5%B8%82%E8%85%BE%E4%BB%98%E9%80%9A%E7%94%B5%E5%AD%90%E6%94%AF%E4%BB%98%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&reserved=&customerInfo=ezAxfHx8fHx8fH0%3D&accType=01&accNo=6222024000019810304&billPeriod=&certId=137445463701&merName=%E6%B7%B1%E5%9C%B3%E5%B8%82%E8%85%BE%E4%BB%98%E9%80%9A%E7%94%B5%E5%AD%90%E6%94%AF%E4%BB%98%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&merType=1&bizType=000000&reqReserved=&accessType=1&txnTime=20140422175758
			//acqInsCode=48465840&txnSubType=00&version=3.0.0&txnAmt=1&backUrl=&billNo=&encoding=UTF-8&merCatCode=4511&subMerId=846440345110011&encryptCertId=38419312202645712532417650457361576245&signature=rdSOHLNIzwkvAMp4mQJJ2fccLplWIGe1ZSgLxGDAGw1cQL9Uy0mvaBEwcpVfayPAyEpxVAvsf9d2MYQAR8eeA%2FrR4ivq22%2Bj94docjkQt%2F2i6ZVszXywB%2FIx02iLFQDJ7CHodijSp%2Fip9Eu3jHxhgm7M0Ec9Hb%2FXd3EgPD97zQc%3D&orderId=20140422175917134&txnType=12&billType=&currencyCode=156&merId=846440345110011&subMerName=%E6%B7%B1%E5%9C%B3%E5%B8%82%E8%85%BE%E4%BB%98%E9%80%9A%E7%94%B5%E5%AD%90%E6%94%AF%E4%BB%98%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&reserved=&customerInfo=ezAxfHx8fHx8fH0%3D&accType=01&accNo=6222024000019810304&billPeriod=&certId=137445463701&merName=%E6%B7%B1%E5%9C%B3%E5%B8%82%E8%85%BE%E4%BB%98%E9%80%9A%E7%94%B5%E5%AD%90%E6%94%AF%E4%BB%98%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&merType=1&bizType=000000&reqReserved=&accessType=1&txnTime=20140422175916
			//acqInsCode=48465840&txnSubType=00&version=3.0.0&txnAmt=1&backUrl=&billNo=&encoding=UTF-8&merCatCode=4511&subMerId=846440345110011&encryptCertId=38419312202645712532417650457361576245&signature=rdSOHLNIzwkvAMp4mQJJ2fccLplWIGe1ZSgLxGDAGw1cQL9Uy0mvaBEwcpVfayPAyEpxVAvsf9d2MYQAR8eeA%2FrR4ivq22%2Bj94docjkQt%2F2i6ZVszXywB%2FIx02iLFQDJ7CHodijSp%2Fip9Eu3jHxhgm7M0Ec9Hb%2FXd3EgPD97zQc%3D&orderId=20140422175917134&txnType=12&billType=&currencyCode=156&merId=846440345110011&subMerName=%E6%B7%B1%E5%9C%B3%E5%B8%82%E8%85%BE%E4%BB%98%E9%80%9A%E7%94%B5%E5%AD%90%E6%94%AF%E4%BB%98%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&reserved=&customerInfo=ezAxfHx8fHx8fH0%3D&accType=01&accNo=6222024000019810304&billPeriod=&certId=137445463701&merName=%E6%B7%B1%E5%9C%B3%E5%B8%82%E8%85%BE%E4%BB%98%E9%80%9A%E7%94%B5%E5%AD%90%E6%94%AF%E4%BB%98%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&merType=1&bizType=000000&reqReserved=&accessType=1&txnTime=20140422175916
			postMethod.setRequestEntity(new StringRequestEntity(data));
			method = postMethod;
			break;
		case GET:
			method = new GetMethod(sendURL);
			method.setQueryString(data);
			break;
		}

		// 设置头信息
		if (null != head) {
			for (Map.Entry<String, String> item : head.entrySet()) {
				method.addRequestHeader(item.getKey(), item.getValue());
			}
		}

		// 设置发送参数
		if (null != methodParams) {
			for (Map.Entry<String, Object> item : methodParams.entrySet()) {
				method.getParams().setParameter(item.getKey(), item.getValue());
			}
		}

		// 发送数据
		try {
			int statusCode = httpClient.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				this.statusCode = statusCode;
				System.out.println("Method failed: " + method.getStatusLine());
				//				throw new RuntimeException(this.statusCode + "");
			}
			// System.out.println("result code:"+statusCode);
			byte[] responseBody = method.getResponseBody();
			result = new String(responseBody, charset);
			// System.out.println("result Date:"+result);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			method.releaseConnection();
		}
		return result;
	}

	private int statusCode;

	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * 设置代理
	 * 
	 * @param proxyAddress
	 *            代理地址
	 * @param proxyPort
	 *            代理端口
	 */
	public void setProxy(String proxyAddress, Integer proxyPort) {
		this.useProxy = true;
		this.proxyHost = proxyAddress;
		this.proxyPort = proxyPort;
	}

	public static void main(String[] args) throws Exception {
	}
}