package abs.pubs.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

public class XmlUtil {
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws Exception{
		HashMap<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		ServletInputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for (Element element : list) {
			map.put(element.getName(), element.getText());
		}
		ins.close();
		return map;
	}
	
	/*public static String textToXml(TextMessage textMessage){
		XStream xStream = new XStream();
		xStream.toXML(textMessage);
	}*/

}
