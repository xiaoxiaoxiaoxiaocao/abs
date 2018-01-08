package abs.pubs.utils;


import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

public class MySSLSocketFactory implements ProtocolSocketFactory {
	private SSLContext sslcontext = null;

	private static SSLContext createEasySSLContext() throws Exception {
		try {
			SSLContext context = SSLContext.getInstance("SSL");
			context.init(null, new TrustManager[] { new MyX509TrustManager() },
					null);
			return context;
		} catch (Exception e) {
			throw e;
		}
	}

	private SSLContext getSSLContext() throws Exception {
		if (this.sslcontext == null)
			this.sslcontext = createEasySSLContext();
		return this.sslcontext;
	}

	public Socket createSocket(String host, int port, InetAddress clientHost,
			int clientPort) throws IOException, UnknownHostException {
		try {
			return getSSLContext().getSocketFactory().createSocket(host, port,
					clientHost, clientPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Socket createSocket(String host, int port, InetAddress localAddress,
			int localPort, HttpConnectionParams params) throws IOException,
			UnknownHostException {
		return createSocket(host, port, localAddress, localPort);
	}

	public Socket createSocket(String host, int port) throws IOException,
			UnknownHostException {
		try {
			return getSSLContext().getSocketFactory().createSocket(host, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean equals(Object obj) {
		return (obj != null)
				&& (obj.getClass().equals(MySSLSocketFactory.class));
	}

	public int hashCode() {
		return MySSLSocketFactory.class.hashCode();
	}

	public static class MyX509TrustManager implements X509TrustManager {
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public void checkClientTrusted(X509Certificate[] chain, String authType) {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) {
		}
	}
}