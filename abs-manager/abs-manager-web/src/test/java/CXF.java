import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CXF {

	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		 Client client = clientFactory.createClient("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");  
		 Object[] invoke = client.invoke("byProvinceName ", "all");
	        System.out.println(invoke);  

	}

}
