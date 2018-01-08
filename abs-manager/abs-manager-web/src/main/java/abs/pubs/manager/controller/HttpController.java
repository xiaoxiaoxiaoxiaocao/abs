package abs.pubs.manager.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DefaultMessageCodesResolver.Format;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import abs.pubs.domain.Pls;
import abs.pubs.domain.ProPackage;
import abs.pubs.domain.ProPls;
import abs.pubs.domain.Res;
import abs.pubs.domain.Taskitem;
import abs.pubs.domain.TaskitemExample;
import abs.pubs.domain.TaskitemExample.Criteria;
import abs.pubs.manager.service.IArrangeService;
import abs.pubs.manager.service.IDeviceService;
import abs.pubs.manager.service.IHttpService;
import abs.pubs.manager.service.IXmlService;
import abs.pubs.mapper.ProPlsMapper;
import abs.pubs.mapper.TaskitemMapper;
import abs.pubs.utils.Base64Util;
import abs.pubs.utils.MD5;
import abs.pubs.utils.XmlUtil;

@Controller
@RequestMapping("/zhyh")
public class HttpController {

	@Autowired
	private IDeviceService deviceService;

	@Autowired
	private IXmlService xmlService;

	@Autowired
	private IHttpService httpService;

	@Autowired
	private IArrangeService arrangeService;

	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	//@RequestMapping("/PlayDev",produces = "application/json; charset=utf-8")
	/*@RequestMapping(value="/PlayDev",method=RequestMethod.POST,produces="text/html;charset=UTF-8")*/
	@RequestMapping(value="/PlayDev",produces="text/html;charset=UTF-8")
	public @ResponseBody String test(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		/* String string2 = request.getParameter("xmlString"); */
		BufferedReader br = request.getReader();
		String inputLine;
		String st = "";
		while ((inputLine = br.readLine()) != null) {
			st += inputLine;
		}
		br.close();

		// 获取请求头中的mac地址
		String mac = request.getHeader("mac");
		String type = request.getHeader("command");
		/*
		String mac =request.getParameter("mac");
		String type =request.getParameter("command");*/
		// String mac = "08:00:27:1C:CE:47";
		// 获取本地所有设备的mac地址
		List<String> macs = deviceService.findAllValidMac();
		boolean flag = false;
		for (String str : macs) {
			if (mac != null && mac.equals(str)) {
				flag = true;
			}
		}
		System.out.println(flag);
		if (flag) {
			Document doc = DocumentHelper.createDocument();
			doc.setXMLEncoding("UTF-8");

			if (type.equals("getTask")) {
				//在任务表查询紧急列表
				//获取任务表中为紧急插播的集合
			Element command = doc.addElement("command");
			Element tasklist = command.addElement("tasklist");
			
					List<Taskitem> list = httpService.findAllTask(mac);
					if (list.size() == 0) {
						// List<Taskitem> pList= httpService.findAllTask("program");
						// 无任务时响应
						tasklist.addElement("taskcount").setText("0");

					} else {

						// 请求心跳
						System.out.println("心跳");

						tasklist.addElement("taskcount").setText(list.size() + "");

						for (int i = 0; i < list.size(); i++) {
							// 循环遍历任务列表
							Element taskitem = tasklist.addElement("taskitem");
							taskitem.addElement("tasktype").setText(list.get(i).getTasktype());
							taskitem.addElement("taskid").setText(list.get(i).getTaskid());
							if ("program".equals(list.get(i).getTasktype())){
								Element contents = taskitem.addElement("contents");
								// 获取该任务对应的所有content
								Element content = contents.addElement("content");
								File file = new File("D://ABS//xml//insert_program.xml");
								content.addElement("csize").setText(file.length() + "");
								content.addElement("link").setText("xml/insert_program.xml");
								content.addElement("md5").setText(MD5.getFileMD5(file));
								/*content.addElement("stardate").setText("");
								content.addElement("enddate").setText("");*/
								Integer proid = list.get(i).getProid();
								ProPackage proPackage = arrangeService.findPropackageById(proid);
								content.addElement("playmode").setText(proPackage.getPkgType() + "");
							}
							if ("downloadres".equals(list.get(i).getTasktype())) {
								Element contents = taskitem.addElement("contents");
								// 获取该任务对应的所有content
								Element content = contents.addElement("content");


								File file = new File("D://ABS//xml//insert_resource.xml");
								content.addElement("csize").setText(file.length() + "");
								content.addElement("link").setText("xml/insert_resource.xml");
								content.addElement("md5").setText(MD5.getFileMD5(file));
							}
							if("control".equals(list.get(i).getTasktype())){
								taskitem.addElement("control").setText(list.get(i).getProid()+"");
							}
							if("realtimemsg".equals(list.get(i).getTasktype())){
								ProPls proPls = arrangeService.selectByProid(list.get(i).getProid());
								
								
								//taskitem.addElement("taskid").setText(list.get(i).getTaskid());
								taskitem.addElement("fontsize").setText(proPls.getFontsize());
								taskitem.addElement("bgcolor").setText(proPls.getBcolor());
								taskitem.addElement("fontcolor").setText(proPls.getTcolor());
								taskitem.addElement("position").setText(proPls.getLocation());
								taskitem.addElement("speed").setText(proPls.getSpeed());
								taskitem.addElement("count").setText(proPls.getCount()+"");
								taskitem.addElement("message").setText(proPls.getMessage());
								taskitem.addElement("title").setText(proPls.getName());
							}
							/*if("cancelrealtimemsg".equals(list.get(i).getTasktype())){
								taskitem.addElement("tasktype").setText(list.get(i).getTasktype());
								taskitem.addElement("taskid").setText(list.get(i).getTaskid());
							}*/
							
						}
					}
					
				/*if("control".equals(tp)){
					
				} 

				if("screenshot".equals(tp)){
					
					List<Taskitem> list = httpService.findCustomTaskByMac(mac, "monitorreport");
					if(list.size()>0){
						
					}else{
						command.addElement("result").setText("1");
						
					}
				}*/

				
				

			}
			
			if (type.equals("programsync")) {
				Element command = doc.addElement("command");
				
					List<Taskitem> list = httpService.findAllSyncTask(mac);
					File file = new File("D://ABS//xml//program.xml");
					if(list.size()>0){
						command.addElement("result").setText("0");
						command.addElement("csize").setText(file.length() + "");
						command.addElement("link").setText("xml/program.xml");
						command.addElement("md5").setText(MD5.getFileMD5(file));
					}else{
					command.addElement("result").setText("1");
					
				}
				// 循环遍历任务列表
				// 获取该任务对应的所有content

				// 请求同步节目包
				System.out.println("同步节目包");

			}

			if (type.equals("taskreport")) {
				Document document = DocumentHelper.parseText(st);
				Element root = document.getRootElement();
				Element taskid = root.element("taskid");
				String taskId = taskid.getStringValue();
				if (!taskId.isEmpty()) {
					arrangeService.setTaskInvalid(taskId, mac);
				}else{
					arrangeService.setTaskInvalid(mac);
				}
			}
			if (type.equals("resourcesync")) {
				List<Taskitem> list = httpService.findAllSyncTask(mac);
				Element command = doc.addElement("command");
				if (list.size() > 0) {

					List<Taskitem> pList = new ArrayList<Taskitem>();
					for (Taskitem taskitem : list) {
						if (taskitem.getTasktype().equals("program")) {
							pList.add(taskitem);
						}

					}
					// List<Taskitem> pList= httpService.findAllTask("program");
					if (pList != null && pList.size() > 0) {

						File file = new File("D://ABS//xml//resource.xml");
						command.addElement("result").setText("0");
						command.addElement("csize").setText(file.length() + "");
						command.addElement("link").setText("xml/resource.xml");
						command.addElement("md5").setText(MD5.getFileMD5(file));

					} 

				}else {
					command.addElement("result").setText("1");
				}
			}
			if (type.equals("timesync")) {
				Element command = doc.addElement("command");
				Element servertime = command.addElement("servertime");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				servertime.setText(df.format(new Date()));
			}
			/*if(type.equals("monitorreport")){
				List<Taskitem> list = httpService.findCustomTaskByMac(mac, "monitorreport");
				Element command = doc.addElement("command");
				if(list.size()>0){
					command.addElement("result").setText("0");
					command.addElement("cmdtype").setText("monitorreport");
				}else{
					command.addElement("result").setText("1");
					
				}
				
			}*/
			if(type.equals("monitorreport")){
				Document document = DocumentHelper.parseText(st);
				System.out.println(st);
				Element root = document.getRootElement();
				Element picture = root.element("picture");
				//String string = picture.getStringValue();
				//session.setAttribute("base64","DDDDDDD");
				//Base64Util.GenerateImage(string, "D://ABS//screenshot//a.jpg");
				System.out.println("上报"); 
				Element command = doc.addElement("command");
				command.addElement("result").setText("0");
				System.out.println("上报结束");
			}

			String str = doc.asXML();
			System.out.println(str);
			return str;

		} else {
			// 在本地不存在该mac地址
			return "403";
		}
	}
}




