package abs.pubs.manager.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.http.HttpResponse;
import org.apache.xml.resolver.apps.xread;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import abs.pubs.domain.AddmaterialTem;
import abs.pubs.domain.Area;
import abs.pubs.domain.Device;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Material;
import abs.pubs.domain.Model;
import abs.pubs.domain.Pls;
import abs.pubs.domain.ProPackage;
import abs.pubs.domain.ProPls;
import abs.pubs.domain.Res;
import abs.pubs.domain.Taskitem;
import abs.pubs.manager.service.IArrangeService;
import abs.pubs.manager.service.IDeviceService;
import abs.pubs.manager.service.IMaterialServicce;
import abs.pubs.utils.MD5;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/arrange")
public class ArrangeController {
	@Autowired
	private IArrangeService arrangeService;
	
	@Autowired
	private IMaterialServicce materialService;
	
	@Autowired
	private IDeviceService deviceService;
	
	@RequestMapping("/plsList")
	public @ResponseBody EasyUIResult findAllPls(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) throws Exception {
		EasyUIResult easyUIResult = arrangeService.findAllPls(page, rows);
		return easyUIResult;

	}
	@RequestMapping("/modelList")
	public @ResponseBody List<Model> findAllList(){
		List<Model> models = arrangeService.findAllModel();
		
		return models;
		
	}
	
	@RequestMapping("/findAreaByModelId")
	public @ResponseBody List<Area> findAreaByModelId(String id){
		List<Area> list = arrangeService.findAreaByModelId(id);
		return list;
	}
	
	@RequestMapping("/findModelById")
	public @ResponseBody Model findModelById(String id){
		Model model = arrangeService.findModelById(id);
		return model;
		
		
	}
	@RequestMapping("/selectMsterialByArea")
	public @ResponseBody List<Material> selectMsterialByArea(String area) throws Exception{
		List<Integer> idList = arrangeService.selectMsterialByArea(area);
		ArrayList<Material> list = new ArrayList<Material>();
		for (Integer id : idList) {
			Material material = materialService.findById(id);
			list.add(material);
		}
		return list;
		
	}
	
	@RequestMapping("/addMaterial")
	public @ResponseBody HashMap<String,String> addMaterial(String[] ids,String area){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			for (String strId : ids) {
				int id = Integer.parseInt(strId);
				//根据id判断是否已经存在该素材
				List<AddmaterialTem> list = arrangeService.selectCountByIdAndArea(id,area);
				if(list.size()==0){
					AddmaterialTem addmaterialTem = new AddmaterialTem();
					addmaterialTem.setMaterialid(id);
					addmaterialTem.setName(area);
					addmaterialTem.setBackground((short) 0);
					addmaterialTem.setPlaycnt(1);
					addmaterialTem.setPriority(1);
					arrangeService.saveTem(addmaterialTem);
					map.put("status", "200");
				}else{
					map.put("status", "300");
				}
			}
		} catch (NumberFormatException e) {
			map.put("status", "400");
			e.printStackTrace();
		}
		
		return map;
		
		
	}
	
	@RequestMapping("/arrangeSave")
	public @ResponseBody Map<String,String> arrangeSave(String name,String model,String stdtime,
								String endtime,String stardate,String enddate){
		Pls pls = new Pls(name,model,stardate,enddate,stdtime,endtime);
		HashMap<String,String> map = new HashMap<>();
		try {
			int plsId = arrangeService.inssertPls(pls);
			//把addmaterialTem表中的数据保存到数据库
			List<AddmaterialTem> addmaterialTems=arrangeService.findAllAddmaterialTem();
			arrangeService.saveTemToDb(addmaterialTems,plsId);
			arrangeService.deleteAll();
			map.put("status","200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status","400");
		}
		return map;
		
	}
	
	@RequestMapping("/deleteTemById")
	public @ResponseBody Map<String,String> deleteTemById(int id,String area){
		HashMap<String,String> map = new HashMap<>();
		try {
			arrangeService.deleteTemById(id,area);
			map.put("status","200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status","400");
		}
		return map;
	}
	
	@RequestMapping("/cl")
	public @ResponseBody void clear() {
		arrangeService.deleteAll();
	}
	
	@RequestMapping("/deletePlsById")
	public @ResponseBody Map<String,String> deletePlsById(String[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			for (String strId : ids) {
				int id = Integer.parseInt(strId);
				arrangeService.deletePlsById(id);
				
				map.put("status", "200");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
		
	}
	
	@RequestMapping("/selectCountAddmaterialTem")
	public @ResponseBody int selectCountAddmaterialTem(){
		int i = arrangeService.selectCountAddmaterialTem();
		return i;
		
	}
	
	@RequestMapping("/deleteModel")
	public @ResponseBody Map<String,String> deleteModel(int[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		File file = new File("D://ABS//xml//model.xml");
		try {
			/*Document document = reader.read(file);*/
			for (int id : ids) {
				arrangeService.deleteModelById(id);
				//删除model.xml中对应的节点
				/*List<Node> list = document.selectNodes("/model[@id="+id+"]");
				Node node = list.get(0);
				Element element = node.getParent();
				System.out.println(element.toString());*/
			}
			map.put("states", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("states", "400");
		}
		
		return map;
		
	}
	
	@RequestMapping("/detailSave")
	public @ResponseBody Map<String,String> detailSave(int priority,int playcnt,int bgimg,String temName,int temId){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			/**
			 * 如果bgimg==1，表示设为背景，要把该区域的其他资源bgimg的值设置为0，
			 * 一个区域只能设置一张背景图片
			 */
			if(bgimg==1){
				List<AddmaterialTem> list=arrangeService.findByName(temName);
				for (AddmaterialTem addmaterialTem : list) {
					arrangeService.updateById(addmaterialTem.getId());
				}
			}
			arrangeService.updateTemByNameAndMaterialId(temName,temId,bgimg,playcnt,priority);
			map.put("status","200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status","400");
		}
		return map;
	}
	
	@RequestMapping("/findResByPlsId")
	public @ResponseBody List<Res> findResByPlsId(Integer id){
		List<Res> list=arrangeService.findResByPlsId(id);
		return list;
		
	}
	
	@RequestMapping("/findAllArrange")
	public @ResponseBody EasyUIResult findAllArrange(@RequestParam(defaultValue="1") int page,
													 @RequestParam(defaultValue="10") int rows){
		EasyUIResult easyUIResult = arrangeService.findAllArrange(page,rows);
		return easyUIResult;
		
	}
	
	@RequestMapping("/temSave")
	public @ResponseBody void temSave(String type,Integer x,Integer y,Integer width,Integer height,String color,String divId,HttpSession session){
		
			Area area = new Area();
			area.setHeight(height);
			area.setWidth(width);
			area.setX(x);
			area.setY(y);
			area.setAreatype(type);
			area.setBgcolor(color);
			//把区域对象临时存放在session中，key值是divId，value是area对象
			session.setAttribute(divId, area);
	}
	
	@RequestMapping("/updateColor")
	public @ResponseBody void updateColor(HttpSession session,String id,String color){
		Area area = (Area) session.getAttribute(id);
		area.setBgcolor(color);
		session.setAttribute(id, area);
	}
	
	@RequestMapping("/getColor")
	public @ResponseBody String getColor(String id,HttpSession session){
		Object object = session.getAttribute(id);
		String color="#FFFFFF";
		if(object != null && object instanceof Area){
			Area area = (Area) object;
			color= area.getBgcolor();
		}
		return color;
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/delDiv")
	public @ResponseBody void delDiv(String id,HttpSession session){
		session.removeValue(id);
	}
	
	@RequestMapping("/saveModel")
	@SuppressWarnings({ "deprecation", "resource" })
	public @ResponseBody Map<String,String> saveModel(HttpSession session,String modelName,String modelSize){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			//保存模块信息
			int model_id=arrangeService.saveModel(modelName, modelSize);
			
			String[] names = session.getValueNames();
			//创建list集合，用于存放从session中取出的area对象
			for (String key : names) {
				Object object = session.getAttribute(key);
				if(object instanceof Area){
					Area area = (Area) object;
					//获取area对象保存到数据库
					arrangeService.saveArea(area,model_id);
					session.removeAttribute(key);
				}
			}
			
			
			map.put("status","200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status","400");
		}
		
		return map;
		
	}
	
	@RequestMapping("/saveText")
	public @ResponseBody Map<String,String> saveText(String text,String areaId) throws IOException{
		AddmaterialTem addmaterialTem = new AddmaterialTem();
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			addmaterialTem.setName(areaId);
			addmaterialTem.setText(text);
			arrangeService.saveTem(addmaterialTem);
			map.put("states","200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("states","400");
		}
		return map;
	}
	
	@RequestMapping("/proPls")
	public @ResponseBody EasyUIResult proPls(@RequestParam(defaultValue="1")int page,
												  @RequestParam(defaultValue="10")int rows,int id){
		EasyUIResult easyUIResult = arrangeService.findproPls(page,rows,id);
		
		
		return easyUIResult;
	}
	@RequestMapping("/findPlsSdate")
	public @ResponseBody Pls findPlsSdate(int plsId){
		Pls pls = arrangeService.findPlsById(plsId);
		return pls;
	}
	
	/*@RequestMapping("/proPls")
	public @ResponseBody EasyUIResult proPls(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int rows){
			EasyUIResult easyUIResult = new EasyUIResult();
		
		return easyUIResult;
	}*/
	@RequestMapping("/programList")
	public @ResponseBody EasyUIResult programList(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int rows){
		EasyUIResult easyUIResult = arrangeService.findAllProgram(page,rows);
		return easyUIResult;
	}
	
	
	@RequestMapping("/savePropls")
	public @ResponseBody Map<String,String> savePropls(String[] ids,int proId){
		HashMap<String,String> map = new HashMap<String,String>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			for (String plsId : ids) {
				arrangeService.inssertPropls(proId, Integer.parseInt(plsId),df.format(new Date()));
				map.put("states","200");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			map.put("states","400");
		}
		return map;
	}
	
	@RequestMapping("/savepro")
	public @ResponseBody void savepro(String name,int type){
		arrangeService.inssertPro(name,type);
	}
	
	@RequestMapping("/proDelete")
	public @ResponseBody Map<String,String> proDelete(int id){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
				arrangeService.deleteProById(id);
			map.put("states", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("states", "400");
		}
		return map;
		
	}
	
	@RequestMapping(value = "getPlsNameById",produces="text/html;charset=UTF-8;")
	public @ResponseBody String getPlsNameById(int id){
		String name = arrangeService.selectPlsNameById(id);
		return name;
	}
	
	@RequestMapping("/proplsDelete")
	public @ResponseBody Map<String,String> proplsDelete(int[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			for (int id : ids) {
				arrangeService.deleteProplsById(id);
			}
			map.put("states", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("states", "400");
		}
		return map;
	}
	
	@RequestMapping("/relevance")
	public @ResponseBody Map<String,String> relevance(int proId,int[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			//根据要发布的节目包的id 和所选择的设备的id集合发布信息

			ProPackage proPkg = arrangeService.findById(proId);
			//创建model.xml文件
			arrangeService.createModelXml();
			//向数据库任务表添加任务
			if(proPkg.getPkgType()==2){
				//该节目包是字幕包
				arrangeService.addTestTask(proId);
			}else{
				arrangeService.addTaskitem(proId,ids);
			}
			arrangeService.issue(proId);
			
			
			
			File file;
			File file1;
			if(proPkg.getPkgType()==1){
				file = new File("D://ABS//xml//program.xml");
				file1 = new File("D://ABS//xml//resource.xml");
				
			}else{
				file = new File("D://ABS//xml//insert_program.xml");
				file1 = new File("D://ABS//xml//insert_resource.xml");
			}
			//若没有，则正常发布
			//ProPackage proPackage = arrangeService.findById(id);
			/* 向任务表添加任务 */
			//生成program.xml文件
			boolean b = file.exists();
			boolean b1 = file1.exists();
			if(b==true){
				//如果存在就删除
				file.delete();
			}
			if(b1==true){
				//如果存在就删除
				file1.delete();
			}
			//用于操作program.xml
			Document document = DocumentHelper.createDocument();
			Element program = DocumentHelper.createElement("program");
			document.setRootElement(program);
			
			//用于操作rescource.xml
			Document doc = DocumentHelper.createDocument();
			Element resource = DocumentHelper.createElement("resource");
			//2document.setRootElement(resource);
			doc.setRootElement(resource);
			Element model = resource.addElement("model");
			File bgfile = new File("D://ABS//material//g.jpg");
			String bgmd5 = MD5.getFileMD5(bgfile);
			
			
			model.addAttribute("ftpAdd", "");
			model.addAttribute("href", "/xml/model.xml");
			model.addAttribute("md5",MD5.getFileMD5(new File("D://ABS//xml//model.xml")));
			//File file2 = new File("D://ABS//xml//model.xml");
			model.addAttribute("filesize",new File("D://ABS//xml//model.xml").length()+"");
			Element bgimg = resource.addElement("bgimg");
			bgimg.addAttribute("ftpAdd", "");
			/*bgimg.addAttribute("href", "");
			bgimg.addAttribute("md5","");
			bgimg.addAttribute("filesize","");*/
			bgimg.addAttribute("href", "/material/g.jpg");
			bgimg.addAttribute("md5", bgmd5);
			bgimg.addAttribute("filesize", bgfile.length()+"");
			
			
			List<ProPls> proplss =  arrangeService.findProPlsByProId(proId);
			for (ProPls proPls : proplss) {
				Pls pls_po = arrangeService.findPlsById(proPls.getPlsId());
				Element pls = program.addElement("pls");
				pls.addAttribute("areatype",pls_po.getAreatype() +"");
				pls.addAttribute("stdtime",pls_po.getStdtime() +"");
				pls.addAttribute("edtime",pls_po.getEdtime() +"");
				Element resarr = pls.addElement("resarr");
				List<Res> ress = arrangeService.findResByPlsId(pls_po.getId());
				for (Res res_po : ress) {
					Element res = resarr.addElement("res");
					res.addAttribute("resname",res_po.getResname());
					res.addAttribute("resid",res_po.getResid());
					res.addAttribute("area",res_po.getArea());
					
					int playcnt = res_po.getPlaycnt();
					if(playcnt<10){
						res.addAttribute("playcnt","0"+res_po.getPlaycnt());
					}else{
						res.addAttribute("playcnt",""+res_po.getPlaycnt());
						
					}
					/*String priority = res_po.getPriority();
					int i = Integer.parseInt(priority);
					if(i<10){
						priority="0"+priority;
					}*/
					String priority = res_po.getPriority();
					int i = Integer.parseInt(priority);
					if(i<10){
						priority="0"+priority;
					}
					
					res.addAttribute("priority",priority);
					res.addAttribute("stdtime",res_po.getStdtime());
					res.addAttribute("edtime",res_po.getEndtime());
					
					Element f = resource.addElement("file");
					f.addAttribute("resid", res_po.getResid());
					f.addAttribute("resname", res_po.getResname());
					f.addAttribute("ftpAdd","");
					f.addAttribute("href", res_po.getHref());
					f.addAttribute("md5", res_po.getMd5());
					f.addAttribute("filesize", res_po.getFilesize()+"");
					
				}
				
			}
			OutputFormat format = OutputFormat.createPrettyPrint();
			 format.setEncoding("utf-8");
			 Writer out;
			 out = new FileWriter(file);
			 Writer out1 = new FileWriter(file1);
			XMLWriter writer = new XMLWriter(out, format);
			 XMLWriter writer1 = new XMLWriter(out1, format);
			 writer.write(document);
			writer.close();
			 writer1.write(doc);
			 writer1.close();
			 map.put("states","200");
		}catch (Exception e) {
			e.printStackTrace();
			map.put("states","400");
		}
		
		
	
	return map; 
	}

	@RequestMapping("/unRelevance")
	public @ResponseBody Map<String,String> unRelevance(int proId,int[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			for (int id : ids) {
				arrangeService.unRelevance(proId,id);
				map.put("states","200");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("states","400");
		}
		
		return map;
		
	}
	
	@RequestMapping("/findRelevanceId")
	public @ResponseBody Integer[] findRelevanceIds(int id){
		Integer[] ids = arrangeService.findProeviceById(id);
		return ids;
	}
	@RequestMapping("/issue")
	public @ResponseBody Map<String,String> issue(int id){
		HashMap<String,String> map = new HashMap<String,String>();
		arrangeService.createModelXml();
		
		
		
		try {
			//先查询该节目包有没有对应的任务id，如果有，则直接把该任务的state改成0，
			ProPackage proPackage = arrangeService.findById(id);
			if(proPackage.getPkgType()==2){
				//把节目包添加到任务表中
				arrangeService.addTestTask(id);
			}else{
				if(proPackage.getPtaskid()==null || proPackage.getRtaskid()==null){
					arrangeService.addTaskitem(id);
				}else{
					arrangeService.setTaskUsable(proPackage.getPtaskid(),id);
					arrangeService.setTaskUsable(proPackage.getRtaskid(),id);
				}
				
				arrangeService.issue(id);
				ProPackage proPkg = arrangeService.findPropackageById(id);
				File file;
				File file1;
				if(proPkg.getPkgType()==1){
					file = new File("D://ABS//xml//program.xml");
					file1 = new File("D://ABS//xml//resource.xml");
					
				}else{
					file = new File("D://ABS//xml//insert_program.xml");
					file1 = new File("D://ABS//xml//insert_resource.xml");
				}
				//若没有，则正常发布
				//ProPackage proPackage = arrangeService.findById(id);
				/* 向任务表添加任务 */
				//生成program.xml文件
				boolean b = file.exists();
				boolean b1 = file1.exists();
				if(b==true){
					//如果存在就删除
					file.delete();
				}
				if(b1==true){
					//如果存在就删除
					file1.delete();
				}
				//用于操作program.xml
				Document document = DocumentHelper.createDocument();
				Element program = DocumentHelper.createElement("program");
				document.setRootElement(program);
				
				//用于操作rescource.xml
				Document doc = DocumentHelper.createDocument();
				Element resource = DocumentHelper.createElement("resource");
				//2document.setRootElement(resource);
				doc.setRootElement(resource);
				Element model = resource.addElement("model");
				File bgfile = new File("D://ABS//material//g.jpg");
				String bgmd5 = MD5.getFileMD5(bgfile);
				
				
				model.addAttribute("ftpAdd", "");
				model.addAttribute("href", "/xml/model.xml");
				model.addAttribute("md5",MD5.getFileMD5(new File("D://ABS//xml//model.xml")));
				//File file2 = new File("D://ABS//xml//model.xml");
				model.addAttribute("filesize",new File("D://ABS//xml//model.xml").length()+"");
				Element bgimg = resource.addElement("bgimg");
				bgimg.addAttribute("ftpAdd", "");
				/*bgimg.addAttribute("href", "");
				bgimg.addAttribute("md5","");
				bgimg.addAttribute("filesize","");*/
				bgimg.addAttribute("href", "/material/g.jpg");
				bgimg.addAttribute("md5", bgmd5);
				bgimg.addAttribute("filesize", bgfile.length()+"");
				
				
				List<ProPls> proplss =  arrangeService.findProPlsByProId(id);
				for (ProPls proPls : proplss) {
					Pls pls_po = arrangeService.findPlsById(proPls.getPlsId());
					Element pls = program.addElement("pls");
					pls.addAttribute("areatype",pls_po.getAreatype() +"");
					pls.addAttribute("stdtime",pls_po.getStdtime() +"");
					pls.addAttribute("edtime",pls_po.getEdtime() +"");
					Element resarr = pls.addElement("resarr");
					List<Res> ress = arrangeService.findResByPlsId(pls_po.getId());
					for (Res res_po : ress) {
						Element res = resarr.addElement("res");
						res.addAttribute("resname",res_po.getResname());
						res.addAttribute("resid",res_po.getResid());
						res.addAttribute("area",res_po.getArea());
						
						int playcnt = res_po.getPlaycnt();
						if(playcnt<10){
							res.addAttribute("playcnt","0"+res_po.getPlaycnt());
						}else{
							res.addAttribute("playcnt",""+res_po.getPlaycnt());
							
						}
						/*String priority = res_po.getPriority();
						int i = Integer.parseInt(priority);
						if(i<10){
							priority="0"+priority;
						}*/
						String priority = res_po.getPriority();
						int i = Integer.parseInt(priority);
						if(i<10){
							priority="0"+priority;
						}
						
						res.addAttribute("priority",priority);
						res.addAttribute("stdtime",res_po.getStdtime());
						res.addAttribute("edtime",res_po.getEndtime());
						
						Element f = resource.addElement("file");
						f.addAttribute("resid", res_po.getResid());
						f.addAttribute("resname", res_po.getResname());
						f.addAttribute("ftpAdd","");
						f.addAttribute("href", res_po.getHref());
						f.addAttribute("md5", res_po.getMd5());
						f.addAttribute("filesize", res_po.getFilesize()+"");
						
					}
					
				}
				OutputFormat format = OutputFormat.createPrettyPrint();
				 format.setEncoding("utf-8");
				 Writer out;
				 out = new FileWriter(file);
				 Writer out1 = new FileWriter(file1);
				XMLWriter writer = new XMLWriter(out, format);
				 XMLWriter writer1 = new XMLWriter(out1, format);
				 writer.write(document);
				writer.close();
				 writer1.write(doc);
				 writer1.close();
				
				
			}
			
			map.put("states", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("states", "400");
		}
		return map; 
		
	}
	/**
	 * 终端控制,tasktype:control
	 * @param deviceMac 设备id
	 * @param opId 动作id
	 */
	@RequestMapping("/shutdown")
	public @ResponseBody Map<String,String> shutdown(int[] ids,int instruct){
		HashMap<String,String> map = new HashMap<String,String>();
		
		//添加到任务表
		try {
			for (int id : ids) {
				arrangeService.addShutdownTask(id,instruct);
			}
			map.put("status", "200");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	
	
	
	
	@RequestMapping("/startup")
	public @ResponseBody Map<String,String> startup(int[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		
		//添加到任务表
		try {
			for (int id : ids) {
				arrangeService.startup(id);
			}
			map.put("status", "200");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	/*@RequestMapping("/control")
	public @ResponseBody void control(String deviceMac,String opId){
		//添加到任务表
		arrangeService.addControlTask(deviceMac,opId);
	}*/
	/**
	 * 截屏
	 * @param deviceMac 设备id
	 */
	@RequestMapping("/screenshot")
	public @ResponseBody void screenshot(String deviceMac){
		//添加到任务表
		File file = new File("D://ABS//screenshot//a.png");
		File dir = file.getParentFile();  
		if (!dir.exists()) {  
			dir.mkdirs();  
		}  
		if(file.exists()){
				file.delete();
		}
		arrangeService.addScreenShotTask(deviceMac);
	}
	
	/**
	 * 添加字幕消息
	 * @param name
	 * @param message
	 * @param fontSize
	 * @param tColor
	 * @param location
	 * @param speed
	 * @return
	 */
	@RequestMapping("/textProPls")
	public @ResponseBody Map<String,String> textProPls(org.springframework.ui.Model model,int proId,String name,String message,String fontSize,String tColor,String bColor,String location,String speed,int count){
		HashMap<String,String> map = new HashMap<String,String>();
		//向任务表中添加消息字幕
		try{
				arrangeService.textProPls(proId,name,message,fontSize,tColor,bColor,location,speed,count);
			map.put("status","200");
		}catch(Exception e){
			map.put("status","400");
		}
		//model.addAttribute("map",map);
		return map;
		
	}
	
	@RequestMapping("/echo")
	public @ResponseBody ProPls echo(int id){
		List<ProPls> list = arrangeService.findProPlsByProId(id);
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 取消即时消息
	 * @param id 节目包的id
	 * @return
	 */
	@RequestMapping("/cancelrealtimemsg")
	public @ResponseBody Map<String,String> cancelrealtimemsg(int id){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			List<Integer> ids = arrangeService.findDevicesByProId(id);
			//根据设备id获取mac地址，拼接成字符串，以“_”分割
			String s="";
			for (Integer i : ids) {
				Device device = arrangeService.findDeviceById(i);
				s=s+device.getMac()+"_";
			}
			arrangeService.addCancelMsg(s);
			map.put("status", "200");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	
	
	@RequestMapping("/clean")
	public String clean(){
			arrangeService.clean();
			return "login";
	}
	@SuppressWarnings("resource")
	@RequestMapping("/zip")
	public @ResponseBody Map<String,String> zip(int[] deviceIds,int[] zipIds){
		HashMap<String,String> map = new HashMap<String,String>();
		for (int id : deviceIds) {
			Device device = deviceService.selectById(id);
			if(device != null){
				File file = new File("D://ABS//xml//"+device.getMac().replaceAll(":","-")+".xml");
				if(file.exists()){
					file.delete();
				}
				Document document = DocumentHelper.createDocument();
				Element programPack = DocumentHelper.createElement("programPack");
				document.setRootElement(programPack);
				for (int i : zipIds) {
					
					try {
						Material material = materialService.findById(i);
						programPack.addElement("addr").setText("/ABS/zip/"+material.getName());
						OutputFormat format = OutputFormat.createPrettyPrint();
						format.setEncoding("utf-8");
						FileWriterWithEncoding out = new FileWriterWithEncoding(file, "UTF-8");
						//Writer out = new FileWriter(file);
						XMLWriter writer = new XMLWriter(out, format);
						writer.write(document);
						writer.close();
						out.close();
						map.put("status","200");
					} catch (Exception e) {
						e.printStackTrace();
						map.put("status","400");
					}
				}
			}
			
		}
		return map;
	}
/*	@RequestMapping("/zip")
	public @ResponseBody Map<String,String> zip(int[] deviceIds,int[] zipIds){
		HashMap<String,String> map = new HashMap<String,String>();
		File file = new File("D://ABS//xml//zip.xml");
		if(file.exists()){
			file.delete();
		}
		Document document = DocumentHelper.createDocument();
		Element zip = DocumentHelper.createElement("zip");
		document.setRootElement(zip);
		Writer out;
		XMLWriter writer;
		try {
			for (int i : deviceIds) {
				Device device = deviceService.selectById(i);
				if(device != null){
					Element programPack = zip.addElement("programPack");
					programPack.addAttribute("mac",device.getMac());
					for (int id : zipIds) {
						Material material = materialService.findById(id);
						programPack.addElement("addr").setText("/ABS/zip/"+material.getName());
						
					}
				}
			}
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			out = new FileWriter(file);
			writer = new XMLWriter(out, format);
			writer.write(document);
			writer.close();
			out.close();
			map.put("status","200");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("status","400");
		}
		return map;
	}
*/	
	

}
