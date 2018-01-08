package abs.pubs.utils;

import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @Title: TestDom4j.java
 * @Package
 * @Description: 解析xml字符串
 * @version V1.0
 */
public class Dom4jUtil {

	public static void readStringXml(String xml) throws DocumentException {
		Document doc = null;
		doc = DocumentHelper.parseText(xml);
		Element rootElement = doc.getRootElement();
		getNodes(rootElement);
		
	}
	
	
	public static void getNodes(Element node){  
	      
	    //当前节点的名称、文本内容和属性  
	    System.out.println("当前节点名称："+node.getName());//当前节点名称  
	    System.out.println("当前节点的内容："+node.getTextTrim());//当前节点名称  
	    List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list  
	    for(Attribute attr:listAttr){//遍历当前节点的所有属性  
	        String name=attr.getName();//属性名称  
	        String value=attr.getValue();//属性的值  
	        System.out.println("属性名称："+name+"属性值："+value);  
	    }  
	      
	    //递归遍历当前节点所有的子节点  
	    List<Element> listElement=node.elements();//所有一级子节点的list  
	    for(Element e:listElement){//遍历所有一级子节点  
	        getNodes(e);//递归  
	    }  
	}
	
	
		/*// 下面的是通过解析xml字符串的
		try {
			 // 将字符串转为XML
			
			

		   
		    public static Element getRootElement{ 
		    	Element rootElement = doc.getRootElement(); // 获取根节点
		        return rootElement; 
		    } 
			
			

			// 获取迭代器
			Iterator it = rootElement.elementIterator();
			// 遍历迭代器获取根节点的信息
			while (it.hasNext()) {
				Element next = (Element) it.next();
				
				// 获取节点的属性名和属性值
				List<Attribute> Attributes = next.attributes();
				for (Attribute attribute : Attributes) {
					System.out.println(attribute.getName() + ":" + attribute.getValue());
				}
				
				// 获取子节点信息
				Iterator itt = next.elementIterator();
				while (itt.hasNext()) {
					Element childNext = (Element) itt.next();
					List list = childNext.elements();
					if(list.size()>0){
						
						System.out.println(childNext.getName() + ":" + childNext.getStringValue());
						
					}
				}

			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}*/
	/*public static void getInfo(Element rootElement){
		@SuppressWarnings({ "unused", "rawtypes" })
		List elements = rootElement.elements();
		// 获取迭代器
		@SuppressWarnings("rawtypes")
		Iterator it = rootElement.elementIterator();
		// 遍历迭代器获取根节点的信息
		while (it.hasNext()) {
			Element next = (Element) it.next();
			
			// 获取节点的属性名和属性值
			List<Attribute> Attributes = next.attributes();
			for (Attribute attribute : Attributes) {
				System.out.println(attribute.getName() + ":" + attribute.getValue());
			}
			
			// 获取子节点信息
			Iterator itt = next.elementIterator();
			while (itt.hasNext()) {
				Element childNext = (Element) itt.next();
				List elements2 = childNext.elements();
				if(elements2.size()>0){
					//有子节点
					getInfo(childNext);
					
				}else{
					System.out.println(childNext.getName() + ":" + childNext.getStringValue());
					
				}
				
			}

}
		}*/
	

		
	
		
	
	

}
