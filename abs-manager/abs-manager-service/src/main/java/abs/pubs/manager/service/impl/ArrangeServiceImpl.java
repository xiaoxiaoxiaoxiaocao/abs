package abs.pubs.manager.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.Base64;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import abs.pubs.domain.AddmaterialTem;
import abs.pubs.domain.AddmaterialTemExample;
import abs.pubs.domain.Area;
import abs.pubs.domain.AreaExample;
import abs.pubs.domain.AreaExample.Criteria;
import abs.pubs.domain.Device;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Material;
import abs.pubs.domain.Model;
import abs.pubs.domain.ModelExample;
import abs.pubs.domain.Pls;
import abs.pubs.domain.PlsExample;
import abs.pubs.domain.ProDevice;
import abs.pubs.domain.ProDeviceExample;
import abs.pubs.domain.ProPackage;
import abs.pubs.domain.ProPackageExample;
import abs.pubs.domain.ProPls;
import abs.pubs.domain.ProPlsExample;
import abs.pubs.domain.Res;
import abs.pubs.domain.ResExample;
import abs.pubs.domain.Taskitem;
import abs.pubs.domain.TaskitemExample;
import abs.pubs.domain.User;
import abs.pubs.led.LEDSender2010;
import abs.pubs.led.MyUdpSocket;
import abs.pubs.led.ProtocolDemo;
import abs.pubs.manager.service.IArrangeService;
import abs.pubs.manager.service.IMaterialServicce;
import abs.pubs.mapper.AddmaterialTemMapper;
import abs.pubs.mapper.AreaMapper;
import abs.pubs.mapper.DeviceMapper;
import abs.pubs.mapper.ModelMapper;
import abs.pubs.mapper.PlsMapper;
import abs.pubs.mapper.ProDeviceMapper;
import abs.pubs.mapper.ProPackageMapper;
import abs.pubs.mapper.ProPlsMapper;
import abs.pubs.mapper.ResMapper;
import abs.pubs.mapper.TaskitemMapper;
import abs.pubs.utils.MD5;

@Service
public class ArrangeServiceImpl implements IArrangeService {
	 public static LEDSender2010 ledsender = new LEDSender2010();
	 private static MyUdpSocket myUdpSocket;
	 static{
		 try {
			 myUdpSocket = new MyUdpSocket(8868);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	@Autowired
	private PlsMapper plsMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private AddmaterialTemMapper addmaterialTemMapper;
	
	@Autowired
	private IMaterialServicce materialService;
	
	@Autowired
	private ResMapper resMapper;
	
	@Autowired
	private ProPackageMapper proPackageMapper;
	
	@Autowired
	private ProPlsMapper proplsMapper;
	
	@Autowired
	private ProDeviceMapper proDeviceMapper;
	
	@Autowired
	private TaskitemMapper taskitemMapper;
	
	@Autowired
	private DeviceMapper deviceMapper;

	
	@Override
	public List<Model> findAllModel() {
		ModelExample example = new ModelExample();
		List<Model> list = modelMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Area> findAreaByModelId(String id) {
		AreaExample areaExample = new AreaExample();
		Criteria criteria = areaExample.createCriteria();
		criteria.andModelIdEqualTo(id);
		List<Area> list = areaMapper.selectByExample(areaExample);
		return list;
	}
	
	@Override
	public int inssertPls(Pls pls) {
		 plsMapper.insert(pls);
		 Integer plsId = pls.getId();
		 return plsId;
		
	}



	/*@Override
	public void saveTem(String area, int id) {
		AddmaterialTem addmaterialTem = new AddmaterialTem();
		addmaterialTem.setId(id);
		addmaterialTem.setName(area);
		addmaterialTemMapper.insert(addmaterialTem);
	}*/

	@Override
	public List<Integer> selectMsterialByArea(String area) {
		AddmaterialTemExample example = new AddmaterialTemExample();
		abs.pubs.domain.AddmaterialTemExample.Criteria criteria = example.createCriteria();
		if(area !=null){
			criteria.andNameEqualTo(area);
		}
		List<AddmaterialTem> list = addmaterialTemMapper.selectByExample(example);
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (AddmaterialTem addmaterialTem : list) {
			Integer id = addmaterialTem.getMaterialid();
			idList.add(id);
		}
		return idList;
	}

	@Override
	public int savePls(String name, String model, String stdtime, String endtime) {
		Pls pls = new Pls();
		pls.setName(name);
		pls.setAreatype(model);
		pls.setEdtime(endtime);
		pls.setStdtime(stdtime);
		int id = plsMapper.insert(pls);
		return id;
		
	}

	@Override
	public EasyUIResult findAllPls(int page,int rows) {
		PlsExample example = new PlsExample();
		example.setOrderByClause("id desc");
		PageHelper.startPage(page, rows);
		List<Pls> list = plsMapper.selectByExample(example);
		PageInfo<Pls> pageInfo = new PageInfo<>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(pageInfo.getTotal());
		return easyUIResult;
	}

	

	@Override
	public List<AddmaterialTem> findAllAddmaterialTem() {
		AddmaterialTemExample example = new AddmaterialTemExample();
		List<AddmaterialTem> list = addmaterialTemMapper.selectByExample(example);
		return list;
	}

	

	@Override
	public void saveTemToDb(List<AddmaterialTem> addmaterialTems, int plsId) {
		for (AddmaterialTem addmaterialTem : addmaterialTems) {
			try {
				UUID uuid = UUID.randomUUID();
				Res res = new Res();
				res.setResid(uuid.toString().replace("-", ""));
				res.setArea(addmaterialTem.getName());
				res.setPlsId(plsId);
				//得到文件的id
				Integer id = addmaterialTem.getMaterialid();
				if(id != null){
					Material material = materialService.findById(id);
					File file = new File("D:\\ABS\\material\\"+material.getName());
					String md5 = MD5.getFileMD5(file);
					res.setFilesize(material.getSize());
					res.setHref("/material/"+material.getName());
					res.setMd5(md5);
					res.setResname(material.getName());
				}
				if(addmaterialTem.getText() != null){
					res.setText(addmaterialTem.getText());
					
				}
				
				res.setPlaycnt(addmaterialTem.getPlaycnt());
				res.setPriority(addmaterialTem.getPriority()+"");
				res.setDefau((byte)0);
				resMapper.insert(res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteAll() {
		AddmaterialTemExample example = new AddmaterialTemExample();
		addmaterialTemMapper.deleteByExample(example);
	}

	@Override
	public void deleteTemById(int id, String area) {
		AddmaterialTemExample example = new AddmaterialTemExample();
		abs.pubs.domain.AddmaterialTemExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(area);
		criteria.andMaterialidEqualTo(id);
		addmaterialTemMapper.deleteByExample(example);
		
	}

	@Override
	public void deletePlsById(int id) {
		plsMapper.deleteByPrimaryKey(id);
		//删除该节目单下的res
		ResExample example = new ResExample();
		abs.pubs.domain.ResExample.Criteria criteria = example.createCriteria();
		criteria.andPlsIdEqualTo(id);
		resMapper.deleteByExample(example);
		//删除包含此节目单的节目包
		List<Integer> proids = proplsMapper.selectProidByPlsId(id);
		for (Integer proId : proids) {
			proPackageMapper.deleteByPrimaryKey(proId);
		}
		
		
		
		
		//删除对应的pro_pls
		ProPlsExample proPlsExample = new ProPlsExample();
		abs.pubs.domain.ProPlsExample.Criteria createCriteria = proPlsExample.createCriteria();
		createCriteria.andPlsIdEqualTo(id);
		proplsMapper.deleteByExample(proPlsExample);
		
		
	}

	@Override
	public int selectCountAddmaterialTem() {
		AddmaterialTemExample example = new AddmaterialTemExample();
		int i = addmaterialTemMapper.countByExample(example);
		return i;
	}

	@Override
	public List<AddmaterialTem> selectCountByIdAndArea(int id,String area) {
		// 在addMaterial_tem 表中查询 该area 中是否已经存在该id的素材
		AddmaterialTemExample example = new AddmaterialTemExample();
		abs.pubs.domain.AddmaterialTemExample.Criteria criteria = example.createCriteria();
		criteria.andMaterialidEqualTo(id);
		criteria.andNameEqualTo(area);
		List<AddmaterialTem> list = addmaterialTemMapper.selectByExample(example);
		
		return list;
	}
	
	@Override
	public List<AddmaterialTem> findByName(String temName) {
		AddmaterialTemExample example = new AddmaterialTemExample();
		abs.pubs.domain.AddmaterialTemExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(temName);
		List<AddmaterialTem> list = addmaterialTemMapper.selectByExample(example);
		return list;
	}

	@Override
	public void updateTemByNameAndMaterialId(String temName, int temId, int bgimg, int playcnt, int priority) {
		/*addmaterialTemMapper.saveTemByNameAndId(temName,temId,bgimg,playcnt,priority);*/
		AddmaterialTem record = new AddmaterialTem();
		record.setBackground((short) bgimg);
		record.setPlaycnt(playcnt);
	/*	if(priority<10){
			
		}*/
		record.setPriority(priority);
		record.setName(temName);
		record.setMaterialid(temId);
		AddmaterialTemExample example = new AddmaterialTemExample();
		abs.pubs.domain.AddmaterialTemExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(temName);
		criteria.andMaterialidEqualTo(temId);
		List<AddmaterialTem> list = addmaterialTemMapper.selectByExample(example);
		Integer id = list.get(0).getId();
		record.setId(id);
		addmaterialTemMapper.updateByPrimaryKey(record);
		/*if(list != null && list.size()>0){
			addmaterialTemMapper.updateByExample(record, example);
		}*/
	}

	@Override
	public void updateById(Integer id) {
		addmaterialTemMapper.updateById(id);
	}
 
	@Override
	public List<Res> findResByPlsId(Integer id) {
		ResExample example = new ResExample();
		abs.pubs.domain.ResExample.Criteria criteria = example.createCriteria();
		criteria.andPlsIdEqualTo(id);
		List<Res> list = resMapper.selectByExample(example);
		return list;
	}

	@Override
	public EasyUIResult findAllArrange(int page, int rows) {
		ModelExample example = new ModelExample();
		PageHelper.startPage(page, rows);
		List<Model> list = modelMapper.selectByExample(example);
		PageInfo<Model> pageInfo = new PageInfo<>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(pageInfo.getTotal());
		return easyUIResult;
		
	}

	@Override
	public void saveArea(Area area,int model_id) {
		area.setModelId(model_id+"");
		areaMapper.insert(area);
	}

	@Override
	public int saveModel(String modelName, String modelSize) {
		Model model = new Model();
		model.setName(modelName);
		model.setResolution(modelSize);
		modelMapper.customInsert(model);
		return model.getId();
		//
		
	}

	@Override
	public Model findModelById(String id) {
		Model model = modelMapper.selectByPrimaryKey(Integer.parseInt(id));
		return model;
	}

	@Override
	public void saveTem(AddmaterialTem addmaterialTem) {
		addmaterialTemMapper.insert(addmaterialTem);
	}

	
	@Override
	public EasyUIResult findAllProgram(int page, int rows) {
		ProPackageExample example = new ProPackageExample();
		example.setOrderByClause("id desc");
		PageHelper.startPage(page, rows);
		List<ProPackage> list = proPackageMapper.selectByExample(example);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(new PageInfo<>(list).getTotal());
		return easyUIResult;
	}

	@Override
	public void inssertPro(String name, int type) {
		
		User user =(User)SecurityUtils.getSubject().getPrincipal();
		ProPackage proPackage = new ProPackage();
		proPackage.setPkgName(name);
		proPackage.setPkgType(type);
		proPackage.setUpdttime(new Date());
		if(user != null){
			proPackage.setOperator(user.getId());
		}
		proPackage.setStates(0);
		proPackageMapper.insert(proPackage);
	}

	@Override
	public void deleteProById(int id) {
		proPackageMapper.deleteByPrimaryKey(id);
		//删除节目包的同时，删除任务表中的数据
		TaskitemExample example = new TaskitemExample();
		abs.pubs.domain.TaskitemExample.Criteria criteria = example.createCriteria();
		criteria.andProidEqualTo(id);
		taskitemMapper.deleteByExample(example);
		//删除节目包的同时，删除prodivice中proid为该节目包id的数据
		ProDeviceExample deviceExample = new ProDeviceExample();
		abs.pubs.domain.ProDeviceExample.Criteria createCriteria = deviceExample.createCriteria();
		createCriteria.andProidEqualTo(id);
		proDeviceMapper.deleteByExample(deviceExample);
		
	}

	/*@Override
	public EasyUIResult findproPls(int page, int rows,int id) {
		List<Integer> list = proplsMapper.selectPlsidsByProId(id);
		ArrayList<Pls> plss = new ArrayList<Pls>();
		if(list != null){
			for (Integer i : list) {
				Pls pls = plsMapper.selectByPrimaryKey(i);
				plss.add(pls);
			}
		}
		PageInfo<Pls> pageInfo = new PageInfo<>(plss);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(plss);
		easyUIResult.setTotal(pageInfo.getTotal());
		return easyUIResult;
	}*/
	@Override
	public EasyUIResult findproPls(int page, int rows,int id) {
		ProPlsExample example = new ProPlsExample();
		abs.pubs.domain.ProPlsExample.Criteria criteria = example.createCriteria();
		criteria.andProIdEqualTo(id);
		PageHelper.startPage(page, rows);
		List<ProPls> list = proplsMapper.selectByExample(example);
		PageInfo<ProPls> pageInfo = new PageInfo<>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(pageInfo.getTotal());
		return easyUIResult;
	}

	@Override
	public void inssertPropls(int proId, int parseInt,String format) {
			ProPls proPls = new ProPls();
			proPls.setCreatetime(format);
			proPls.setPlsId(parseInt);
			proPls.setProId(proId);
			proplsMapper.insert(proPls);
	}

	@Override
	public String selectPlsNameById(int id) {
		Pls pls = plsMapper.selectByPrimaryKey(id);
		return pls.getName();
	}

	@Override
	public void deleteProplsById(int id) {
		proplsMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void relevance(int proId, int id) {
		proDeviceMapper.insert(new ProDevice(proId,id));
		
	}

	@Override
	public Integer[] findProeviceById(int id) {
		ProDeviceExample example = new ProDeviceExample();
		abs.pubs.domain.ProDeviceExample.Criteria criteria = example.createCriteria();
		criteria.andProidEqualTo(id);
		List<ProDevice> list = proDeviceMapper.selectByExample(example);
		List<Integer> listIds = new ArrayList<Integer>();
		for (ProDevice proDevice : list) {
			listIds.add(proDevice.getDeviceid());
		}
		
		 Integer[] array = listIds.toArray(new Integer[listIds.size()]);
		return array;
	}

	@Override
	public void unRelevance(int proId, int id) {
		ProDeviceExample example = new ProDeviceExample();
		abs.pubs.domain.ProDeviceExample.Criteria criteria = example.createCriteria();
		criteria.andProidEqualTo(proId);
		criteria.andDeviceidEqualTo(id);
		proDeviceMapper.deleteByExample(example);
	}

	@Override
	public void issue(int id) {
		proPackageMapper.updateIssue(id);
		
	}
	

	@Override
	public void addTaskitem(int id) {
		//查询节目包和设备关联的所有设备id
		List<Integer> devIds = proDeviceMapper.selectDivids(id);
		String arr = "" ;
		for (Integer devId : devIds) {
			//根据id查询设备的mac地址
			String mac = deviceMapper.selectMacById(devId);
			arr+=mac+"_";
		}
		Taskitem pTaskitem = new Taskitem();
		Taskitem rTaskitem = new Taskitem();
		pTaskitem.setMacs(arr);
		rTaskitem.setMacs(arr);
		
		pTaskitem.setTasktype("program");
		String ptaskid = UUID.randomUUID().toString().replaceAll("-", "");
		String rtaskid = UUID.randomUUID().toString().replaceAll("-", "");
		pTaskitem.setTaskid(ptaskid);
		pTaskitem.setProid(id);
		rTaskitem.setTasktype("downloadres");
		rTaskitem.setTaskid(rtaskid);
		rTaskitem.setProid(id);
		ProPackage proPackage = proPackageMapper.selectByPrimaryKey(id);
		rTaskitem.setType(proPackage.getPkgType());
		pTaskitem.setType(proPackage.getPkgType());
		//把对应的任务id存入节目包
		proPackage.setPtaskid(ptaskid);
		proPackage.setRtaskid(rtaskid);
		proPackageMapper.updateByPrimaryKey(proPackage);
		taskitemMapper.insert(rTaskitem);
		taskitemMapper.insert(pTaskitem);
	}

	@Override
	public void deleteModelById(int id) {
		modelMapper.deleteByPrimaryKey(id);
		AreaExample example = new AreaExample();
		Criteria criteria = example.createCriteria();
		criteria.andModelIdEqualTo(id+"");
		areaMapper.deleteByExample(example);
	}

	@Override
	public ProPackage findById(int id) {
		ProPackage proPackage = proPackageMapper.selectByPrimaryKey(id);
		return proPackage;
	}

	@Override
	public List<ProPls> findProPlsByProId(int id) {
		ProPlsExample example = new ProPlsExample();
		abs.pubs.domain.ProPlsExample.Criteria criteria = example.createCriteria();
		criteria.andProIdEqualTo(id);
		List<ProPls> list = proplsMapper.selectByExample(example);
		return list;
	}

	@Override
	public Pls findPlsById(Integer plsId) {
		Pls pls = plsMapper.selectByPrimaryKey(plsId);
		return pls;
	}

	@Override
	public ProPackage findPropackageById(Integer proid) {
		ProPackage proPackage = proPackageMapper.selectByPrimaryKey(proid);
		return proPackage;
	}

	@Override
	public void setTaskInvalid(String i,String mac) {
		
		TaskitemExample example = new TaskitemExample();
		abs.pubs.domain.TaskitemExample.Criteria criteria = example.createCriteria();
		criteria.andTaskidEqualTo(i);
		List<Taskitem> list = taskitemMapper.selectByExample(example);
		Taskitem taskitem = list.get(0);
		String macs = taskitem.getMacs();
		//把macs转换成数组
		String[] macArr = macs.split("_");
		String[] newArr = new String[macArr.length-1];
		 int index  =0 ; //新数组使用的索引值  
		for(int a=0;a<macArr.length;a++){
			if(!macArr[a].equals(mac)){
				newArr[index]=macArr[a];
				index++;
			}
		}
		//把新数组转换成字符串保存到数据库
		String s ="";
		for (String string : newArr) {
			s+=string+"_";
		}
		taskitem.setMacs(s);
		taskitemMapper.updateByPrimaryKey(taskitem);
	}

	@Override
	public void setTaskUsable(String string,int id) {
		//通过任务id，把该节目单关联的设备mac数组字符串更新到数据库
		//查询节目包和设备关联的所有设备id
				List<Integer> devIds = proDeviceMapper.selectDivids(id);
				String arr = "" ;
				for (Integer devId : devIds) {
					//根据id查询设备的mac地址
					String mac = deviceMapper.selectMacById(devId);
					arr+=mac+"_";
				}
				System.out.println(arr);
		TaskitemExample example = new TaskitemExample();
		abs.pubs.domain.TaskitemExample.Criteria criteria = example.createCriteria();
		criteria.andTaskidEqualTo(string);
		List<Taskitem> list = taskitemMapper.selectByExample(example);
		Taskitem taskitem = list.get(0);
		taskitem.setMacs(arr);
		taskitemMapper.updateByPrimaryKey(taskitem);
	}

	@Override
	public void addControlTask(String deviceMac, String opId) {
		Taskitem taskitem = new Taskitem();
		taskitem.setTasktype("control");
		taskitem.setTaskid(UUID.randomUUID().toString().replaceAll("-", ""));
		/*0:重启 1：关机；2：开机 3:截屏*/
		String s = opId.substring(opId.length()-1,opId.length());
		taskitem.setProid(Integer.parseInt(s));
		taskitem.setMacs(deviceMac);
		taskitem.setType(0);
		taskitemMapper.insert(taskitem);
		
	}

	@Override
	public void setTaskInvalid(String mac) {
		//任务表中存在该mac地址的macs全部去掉 
		TaskitemExample example = new TaskitemExample();
		abs.pubs.domain.TaskitemExample.Criteria criteria = example.createCriteria();
		criteria.andMacsIsNotNull();
		List<Taskitem> list = taskitemMapper.selectByExample(example);
		for (Taskitem taskitem : list) {
			if(taskitem.getMacs().contains(mac)){
				String[] macArr = taskitem.getMacs().split("_");
				String[] newArr = new String[macArr.length-1];
				 int index  =0 ; //新数组使用的索引值  
				 for(int a=0;a<macArr.length;a++){
						if(!macArr[a].equals(mac)){
							newArr[index]=macArr[a];
							index++;
						}
					}
				 String s ="";
					for (String string : newArr) {
						s+=string+"_";
					}
					taskitem.setMacs(s);
					taskitemMapper.updateByPrimaryKey(taskitem);
			}
		}
	}

	@Override
	public void addScreenShotTask(String deviceMac) {
		//向任务表添加截屏任务
		Taskitem taskitem = new Taskitem();
		taskitem.setTasktype("monitorreport");
		taskitem.setTaskid(UUID.randomUUID().toString().replaceAll("-", ""));
		taskitem.setMacs(deviceMac);
		taskitem.setType(0);
		taskitemMapper.insert(taskitem);
	}

	@Override
	public void createModelXml() {
		//生成model.xml文件
				File file = new File("D://ABS//xml//model.xml");
				/*boolean b = file.exists();
				if(b==true){
					file.delete();
				}*/
				 File dir = file.getParentFile();  
				    if (!dir.exists()) {  
				        dir.mkdirs();  
				    }  
				 if(!file.exists()){       
			            System.out.println("不存在");
			            try {
							file.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
			        } 

					//文件不存在
					Document document = DocumentHelper.createDocument();
					Element models = DocumentHelper.createElement("models");
					document.setRootElement(models);
					//遍历数据库生成model
					ModelExample example = new ModelExample();
					List<Model> modelss = modelMapper.selectByExample(example);
					//List<Model> modelss= arrangeService.findAllModel();
					for (Model model : modelss) {
						Element mod = models.addElement("model");
						mod.addAttribute("id", model.getId()+"");
						String bgcolor;
						String bgimg;
						Model model_po = modelMapper.selectByPrimaryKey(Integer.parseInt(model.getId()+""));
						//Model model_po = arrangeService.findModelById(model.getId()+"");
						bgcolor=model_po.getBgcolor()==null?"ff0000":model.getBgcolor();
						bgimg=model_po.getBgimg()==null?"":model.getBgimg();
						mod.addAttribute("bgcolor",bgcolor);
						mod.addAttribute("bgimg", bgimg);
						
						//List<Area> areas = arrangeService.findAreaByModelId(model.getId()+"");
						AreaExample areaExample = new AreaExample();
						Criteria criteria = areaExample.createCriteria();
						criteria.andModelIdEqualTo(model.getId()+"");
						List<Area> areas = areaMapper.selectByExample(areaExample);
						for (Area area : areas) {
							Element ar = mod.addElement("area");
							ar.addAttribute("id", area.getId()+"");
							ar.addAttribute("x", area.getX()*3+"");
							ar.addAttribute("y", area.getY()*3+"");
							ar.addAttribute("width", area.getWidth()*3+"");
							ar.addAttribute("height", area.getHeight()*3+"");
							
						}
					}
					
					/*OutputFormat format = OutputFormat.createPrettyPrint();
					 format.setEncoding("utf-8");
					 Writer out;
					 out = new FileWriter(file);
					 XMLWriter writer = new XMLWriter(out, format);
					 writer.write(document);
					 writer.close();*/
				
				
					   /* OutputFormat format = new OutputFormat("    ",true);  
				        format.setEncoding("GBK");//设置编码格式  
				        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file),format);  
				        xmlWriter.write(document);  
				        xmlWriter.close();*/
					OutputFormat format = OutputFormat.createPrettyPrint();
					 format.setEncoding("utf-8");
					 Writer out;
					 try {
						out = new FileWriter(file);
						 XMLWriter writer = new XMLWriter(out, format);
						 writer.write(document);
						 writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
		
	}


/*
	@Override
	public void addTextTask(String name, String message, String fontSize, String tColor, String location,
			String speed) {
		String taskId = UUID.randomUUID().toString().replaceAll("-", "");
		Taskitem taskitem = new Taskitem();
		taskitem.setTaskid(taskId);
		taskitem.setTasktype("realtimemsg");
		taskitem.setMessage(message);
		taskitem.setFontsizze(fontSize);
		taskitem.setFontcolor(tColor);
		taskitem.setPosition(location);
		taskitemMapper.insert(taskitem);
		
	}*/

	@Override
	public void textProPls(int proId, String name, String message, String fontSize, String tColor, String bColor, String location,
			String speed,int count) {
		List<ProPls> list =findProPlsByProId(proId);
		if(list != null && list.size()>0){
			ProPls proPls = list.get(0);
			proPls.setName(name);
			proPls.setFontsize(fontSize);
			proPls.setProId(proId);
			proPls.setLocation(location);
			proPls.setMessage(message);
			proPls.setSpeed(speed);
			proPls.setTcolor(tColor);
			proPls.setBcolor(bColor);
			proPls.setCount(count);
			proplsMapper.updateByPrimaryKey(proPls);
		}else{
			ProPls proPls = new ProPls();
			proPls.setName(name);
			proPls.setFontsize(fontSize);
			proPls.setProId(proId);
			proPls.setLocation(location);
			proPls.setMessage(message);
			proPls.setSpeed(speed);
			proPls.setTcolor(tColor);
			proPls.setBcolor(bColor);
			proPls.setCount(count);
			proplsMapper.insert(proPls);
		}
	}

	@Override
	public void addTestTask(int id) {
		List<Integer> devIds = proDeviceMapper.selectDivids(id);
		String arr = "" ;
		for (Integer devId : devIds) {
			//根据id查询设备的mac地址
			String mac = deviceMapper.selectMacById(devId);
			arr+=mac+"_";
		}
		Taskitem taskitem = new Taskitem();
		taskitem.setMacs(arr);
		String taskid = UUID.randomUUID().toString().replaceAll("-", "");
		taskitem.setTaskid(taskid);
		taskitem.setProid(id);
		taskitem.setTasktype("realtimemsg");
		taskitem.setType(0);
		taskitemMapper.insert(taskitem);

	}

	@Override
	public ProPls selectByProid(Integer proid) {
		ProPlsExample example = new ProPlsExample();
		abs.pubs.domain.ProPlsExample.Criteria criteria = example.createCriteria();
		criteria.andProIdEqualTo(proid);
		List<ProPls> list = proplsMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public ProPls findproplsByProidAndPlsid(int id, int plsId) {
		ProPlsExample example = new ProPlsExample();
		abs.pubs.domain.ProPlsExample.Criteria criteria = example.createCriteria();
		criteria.andProIdEqualTo(id);
		criteria.andPlsIdEqualTo(plsId);
		List<ProPls> list = proplsMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public List<Integer> findDevicesByProId(int id) {
		//根据节目单id查询所有关联的设备
		List<Integer> list = proDeviceMapper.selectDivids(id);
		return list;
	}

	@Override
	public Device findDeviceById(Integer i) {
		Device device = deviceMapper.selectByPrimaryKey(i);
		return device;
	}

	@Override
	public void addCancelMsg(String s) {
		Taskitem taskitem = new Taskitem();
		String taskid = UUID.randomUUID().toString().replaceAll("_", "");
		taskitem.setTasktype("cancelrealtimemsg");
		taskitem.setTaskid(taskid);
		taskitem.setMacs(s);
		taskitem.setType(0);
		taskitemMapper.insert(taskitem);
	}

	@Override
	public void clean() {
	TaskitemExample example = new TaskitemExample();
	taskitemMapper.deleteByExample(example);
	}

	@Override
	public void addTaskitem(int proId, int[] ids) {
		// 向任务表中添加数据
		String str="";
		for (int id : ids) {
			String mac = deviceMapper.selectMacById(id);
			str+=mac+"_";
		}
		System.out.println("所有设备的mac地址集合"+str);
		//创建两个任务对象
		Taskitem pTaskitem = new Taskitem();
		Taskitem rTaskitem = new Taskitem();
		pTaskitem.setMacs(str);
		rTaskitem.setMacs(str);
		pTaskitem.setTasktype("program");
		rTaskitem.setTasktype("downloadres");
		String ptaskid = UUID.randomUUID().toString().replaceAll("-", "");
		String rtaskid = UUID.randomUUID().toString().replaceAll("-", "");
		pTaskitem.setTaskid(ptaskid);
		rTaskitem.setTaskid(rtaskid);
		pTaskitem.setProid(proId);
		rTaskitem.setProid(proId);
		ProPackage proPackage = proPackageMapper.selectByPrimaryKey(proId);
		rTaskitem.setType(proPackage.getPkgType());
		pTaskitem.setType(proPackage.getPkgType());
		taskitemMapper.insert(rTaskitem);
		taskitemMapper.insert(pTaskitem);
		
	}

	@Override
	public void addShutdownTask(int id,int d) {
		//根据id获取设备类型，如果是led。。。其他。。。
		Device device = deviceMapper.selectByPrimaryKey(id);
		if(device != null && device.getDevicetypeid()==4){
			//是led显示屏
			ProtocolDemo demo = new ProtocolDemo();
			demo.my_udp=myUdpSocket;
			demo.ledhost="192.168.0.99";
			demo.demo_power_off();
		}
		String mac = deviceMapper.selectMacById(id);
		Taskitem taskitem = new Taskitem();
		taskitem.setTasktype("control");
		taskitem.setMacs(mac);
		taskitem.setTaskid(UUID.randomUUID().toString().replaceAll("-", ""));
		/*0:重启 1：关机；2：开机 3:截屏*/
		taskitem.setProid(d);
		taskitem.setType(0);
		taskitemMapper.insert(taskitem);
		
	}

	@Override
	public void startup(int id) {
		Device device = deviceMapper.selectByPrimaryKey(id);
		if(device != null && device.getDevicetypeid()==4){
			//是led显示屏
			ProtocolDemo demo = new ProtocolDemo();
			demo.my_udp=myUdpSocket;
			demo.ledhost="192.168.0.99";
			demo.demo_power_on();
		}
		
	}

	

	
	

	

}
