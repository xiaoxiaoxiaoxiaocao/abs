package abs.pubs.manager.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;

import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.EditResult;
import abs.pubs.domain.Material;
import abs.pubs.domain.Playplan;
import abs.pubs.domain.Playplanlist;
import abs.pubs.domain.ProMaterial;
import abs.pubs.domain.Program;
import abs.pubs.domain.Programrelease;
import abs.pubs.domain.UploadStatus;
import abs.pubs.domain.User;
import abs.pubs.manager.service.IDeviceService;
import abs.pubs.manager.service.IMaterialServicce;
import abs.pubs.manager.service.IPlayPlanService;
import abs.pubs.manager.service.IPlayPlanListService;
import abs.pubs.manager.service.IProMaterialService;
import abs.pubs.manager.service.IProgramService;
import abs.pubs.manager.service.IReleaseService;
import abs.pubs.manager.service.IUserService;
import abs.pubs.utils.DelDir;
import abs.pubs.utils.FileToZip;
import abs.pubs.utils.Mkdir;
import abs.pubs.utils.ReadRadio;
/**
 * 对素材的所有操作controller层，包括素材和压缩包，等等
 * @author 曹起坤
 *
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
	@Autowired
	private IMaterialServicce materialService;
	
	@Autowired
	private IProgramService programService;
	
	@Autowired
	private IProMaterialService proMaterialService;
	
	@Autowired
	private IPlayPlanListService playPlanListService;
	
	@Autowired
	private IDeviceService deviceService;
	
	@Autowired
	private IPlayPlanService planService;
	
	@Autowired
	private IReleaseService releaseService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("file")MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws Exception {
			Material material = new Material();
			if(files != null && files.length>0){
				for (MultipartFile mFile : files) {
					String filename = mFile.getOriginalFilename();
					if(filename.endsWith(".mp4")||filename.endsWith(".wmv")||filename.endsWith(".mov")||filename.endsWith(".avi")){
						material.setType(1);
					}
					if(filename.endsWith(".jpg")||filename.endsWith(".bmp")||filename.endsWith(".gif")){
						material.setType(0);
					}
					String path;
					if(filename.endsWith(".zip")||filename.endsWith(".rar")){
						material.setType(2);//2是压缩包格式
						 path= "D:\\ABS\\zip\\";
						
					}else if(filename.endsWith(".xml")){
						material.setType(3);//3是xml格式
						 path= "D:\\ABS\\xml\\";
					}else{
						// 随机字符串+ 源图片的扩展名组成新文件名称, 防止图片重名
						//String newFilename = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
						path = "D:\\ABS\\material\\";
					}
						
						File file = new File(path + filename);
						if (!file.exists()) {
							file.mkdirs();
						}
						try {
							mFile.transferTo(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
						material.setName(filename);
						Date date = new Date(System.currentTimeMillis());
						material.setAddtime(date);
						//获取文件大小
						long size = mFile.getSize();
						int i = (int) (size/1024);
						material.setSize(i);
						int maxTimeSize =10000;
						if(filename.endsWith(".mp4")){
							//是视频文件，计算时长
							int timeSize = ReadRadio.getDuration(file);
							if(timeSize>maxTimeSize){
								maxTimeSize=timeSize;
							}
							
						}
						material.setTimesize(maxTimeSize/1000);
						//获取userid
						//principals.getPrimaryPrincipal();
						User user =(User)SecurityUtils.getSubject().getPrincipal();
						
						if(user != null){
							material.setAdduserid(user.getId());
						}
						material.setState((short) 0);
						material.setChecktime(null);
						materialService.savePsd(material);
				}
			}
			return "success";
			}
	
	@RequestMapping("/progress")
	public @ResponseBody UploadStatus progress(HttpSession session){
		return (UploadStatus)session.getAttribute("upload_status");
	}

	/*@RequestMapping("/zips")
	public @ResponseBody EasyUIResult findAllZips(@RequestParam(defaultValue="1") int page,
												@RequestParam(defaultValue="10") int rows){
		EasyUIResult easyUIResult = materialService.findAllZips(page,rows);
		return easyUIResult;
		
	}*/
	@RequestMapping("/zips")
	public @ResponseBody List<Material> findAllZips(){
		List<Material> list = materialService.findAllZips();
		return list;
		
	}
	
	@RequestMapping("/list")
	public @ResponseBody EasyUIResult findItemByPage(@RequestParam(defaultValue="1")int page,
												  @RequestParam(defaultValue="10")int rows,
												  @RequestParam(defaultValue="-1")int id) throws Exception{
		EasyUIResult easyUIResult = materialService.findAllByPage(page, rows,id);
		return easyUIResult;
		
	}
	
	
	@RequestMapping("/listButCheckOk")
	public @ResponseBody EasyUIResult listButCheckOk(@RequestParam(defaultValue="1")int page,
			  @RequestParam(defaultValue="10")int rows,
			  @RequestParam(defaultValue="-1")int id) throws Exception{
	EasyUIResult easyUIResult = materialService.newProList(page, rows);
	return easyUIResult;

}
	
	@RequestMapping("/selectByIds")
	public @ResponseBody List<Material> selectByIds(String[] ids) throws Exception{
		ArrayList<Material> list = new ArrayList<Material>();
		for (String strId : ids) {
			int id = Integer.parseInt(strId);
			Material material = materialService.findById(id);
			list.add(material);
			
		}
		return list;
		
	}
	
	
	@RequestMapping("proList")
	public @ResponseBody EasyUIResult findProList(@RequestParam(defaultValue="1")int page,
												  @RequestParam(defaultValue="10")int rows) throws Exception{
		EasyUIResult easyUIResult = programService.findProList(page, rows);
		return easyUIResult;
		
	}

	
	@RequestMapping("/getValue")
	@ResponseBody
	public Map<String,String> getValue(String[] ids,Program program,HttpServletRequest request) throws Exception{
		
		File file = new File("D:\\tem\\");
		if(!file.exists()){
			file.mkdirs();
		}
		Mkdir.mkdir("D:\\ABS\\Download\\");
		User user =(User)SecurityUtils.getSubject().getPrincipal();
		/*User user = (User) request.getSession().getAttribute("user");*/
		program.setZipuserid(user.getId());
		int maxId =0;
		int total = programService.findTotal();
		if(total>0){
			maxId=programService.findMaxId()+1;
		}
	
		
		String str = "0000000";
		str = str+maxId;
		//获得截取最后8位之后的值，即zip包的名称
		str="pro-"+str.substring(str.length()-8);
		Date date = new Date(System.currentTimeMillis());
		program.setZiptime(date);
		int i =ids.length;
		//int countTime = 0;
		for (int j=0;j<i;j++) {
		//获取每一个素材id后，根据id值查找对应的素材
			Material material = materialService.findById(Integer.parseInt(ids[j]));
			Playplanlist playplanList = new Playplanlist();
			playplanList.setPlayorder(j+1);
			//playplanList.setName(material.getId()+"");
			playplanList.setMaterialid(material.getId());
			playplanList.setPlayduration(material.getTimesize());
			playplanList.setPropackage(str);
			//playplanList.setPlayplanid(maxId);
			Integer id = planService.findMaxId();
			playplanList.setPlayplanid(id+1);
			playPlanListService.savePlayPlanList(playplanList);
			playplanList.setPlayduration(material.getTimesize());
			File file_in = new File("D:\\ABS\\material\\"+material.getName());
			File file_out = new File("D:\\tem\\"+material.getName());
			
			FileInputStream inputStream = new FileInputStream(file_in);
			FileOutputStream outputStream = new FileOutputStream(file_out);
			FileCopyUtils.copy(inputStream, outputStream);
			inputStream.close();
			outputStream.close();
		}
		program.setZipname(str);
		program.setMaterialcount(i);
		boolean flag = FileToZip.fileToZip("D:\\tem\\", "D:\\ABS\\Download\\",str);
		if(flag)
		{
			DelDir.deletefile(file);
			programService.savePro(program);
		
		}
		//保存playplan
		Playplan playplan = new Playplan();
		playplan.setCreateuser(user.getUsername());
		playplan.setName(str);
		playplan.setCreatetime(date);
		planService.save(playplan);
		Map<String,String> map = new HashMap<String,String>();
		ProMaterial proMaterial = new ProMaterial();
		 String string=StringUtils.join(ids, "-");
		 proMaterial.setMaterialId(string);
		 proMaterial.setProId(maxId);
		try
		{
			map.put("state", "200");
			proMaterialService.save(proMaterial);
		}catch(Exception e)
		{
			map.put("state", "400");
		}
		return map;
	}
	
	/**
	 * 删除素材
	 * @return 
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,String> delete(String[] ids){
		Map<String,String> map = new HashMap<String,String>();
		try
		{	for (String strId : ids) {
			int id = Integer.parseInt(strId);
			materialService.delete(id);
			//查询与该素材名字相同的素材个数
			materialService.countSameName(id);
			
			}
			map.put("state", "200");
			//删除硬盘指定id的文件
		}catch(Exception e)
		{
			map.put("state", "400");
		}
		
		
		return map;
	}
	
	@RequestMapping("/proDelete")
	public @ResponseBody Map<String,String> proDelete(String[] ids)throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		try
		{
			//删除硬盘指定id的文件
			for (String s : ids) {
				String zipname = programService.findProById(Integer.parseInt(s)).getZipname();
				File file = new File("D:\\source\\"+zipname+".zip");
				file.delete();
			}
			programService.proDelete(ids);
			
			//删除pro_psd中的文件
			proMaterialService.deleteById(ids);
			playPlanListService.deleteByids(ids);
			
			map.put("state", "200");
		}catch(Exception e)
		{
			map.put("state", "400");
		}
		return map;
	}
	@RequestMapping("/detail")
	@ResponseBody
	public EasyUIResult showDetail(HttpServletRequest request,ModelAndView modelAndView)throws Exception{
		String id=request.getParameter("id");
		//String name=request.getParameter("name");
		EasyUIResult easyUIResult = new EasyUIResult();
		if(StringUtils.isEmpty(id))
		{
			return easyUIResult;
		}
		//获取压缩包的名称
		Program program = programService.findProById(Integer.parseInt(id));
		String zipname = program.getZipname();
		//string类型的IDS，转换成数组后可以遍历所有素材
		String ids = proMaterialService.findDetailById(Integer.parseInt(id));
		
		String[] arrayIds = ids.split("-");
		ArrayList<EditResult> list = new ArrayList<EditResult>();
		for (String str : arrayIds) {
				//获取每一个素材id
				EditResult editResult = new EditResult();
				Playplanlist playPlan = playPlanListService.findPlayPlanList(zipname, str);
				Material material = materialService.findById(Integer.parseInt(str));
				if(playPlan!=null &&material != null )
				{	
					editResult.setAddTime(material.getAddtime());
					editResult.setMaterialId(material.getId());
					editResult.setMaterialName(material.getName());
					editResult.setMaterialSize(material.getSize());
					editResult.setPlayduration(playPlan.getPlayduration());
					editResult.setPlayorder(playPlan.getPlayorder());
					editResult.setZipName(program.getZipname());
					list.add(editResult);
				}
				
		}
		easyUIResult.setRows(list);
		easyUIResult.setTotal((long)list.size());
		return easyUIResult;
		
	}
	
	@RequestMapping("/addList")
	public @ResponseBody Map<String,String> addList(String[] ids)throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		
		try
		{
			for (String id : ids) {
				programService.addList(Integer.parseInt(id));
				map.put("state", "200");
			}
		}catch(Exception e)
		{
			map.put("state", "400");
		}
		return map;
	}
	
	@RequestMapping("/playList")
	@ResponseBody
	public EasyUIResult playList(@RequestParam(defaultValue="1")int page,
			  @RequestParam(defaultValue="10")int rows)throws Exception{
		EasyUIResult easyUIResult = programService.findPlayList(page, rows);
		return easyUIResult;
	}
	
	@RequestMapping("/playListDelete")
	public @ResponseBody Map<String,String> playListDelete(String[] ids)throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		try
		{
			for (String id : ids) {
				programService.playListDelete(Integer.parseInt(id));	
				map.put("state", "200");
			}
		}catch(Exception e)
		{
			map.put("state", "400");
		}
		return map;
	}
	
	@RequestMapping("/check_ok")
	public @ResponseBody Map<String,String> check_ok(String[] ids,HttpServletRequest request){
		HashMap<String, String> map = new HashMap<String, String>();
		User user =(User)SecurityUtils.getSubject().getPrincipal();
		//User user = (User) request.getSession().getAttribute("user");
		try
		{
			for (String id : ids) {
				materialService.check_ok(Integer.parseInt(id),user);	
				map.put("state", "200");
			}
		}catch(Exception e)
		{
			map.put("state", "400");
		}
		return map;
	}
	
	@RequestMapping("/check_no")
	public @ResponseBody Map<String,String> check_no(String[] ids,HttpServletRequest request){
		HashMap<String, String> map = new HashMap<String, String>();
		User user =(User)SecurityUtils.getSubject().getPrincipal();
		/*User user = (User) request.getSession().getAttribute("user");*/
		try
		{
			for (String id : ids) {
				materialService.check_no(Integer.parseInt(id),user);	
				map.put("state", "200");
			}
		}catch(Exception e)
		{
			map.put("state", "400");
		}
		return map;
	}
	
	@RequestMapping("/playPlanEdit")
	public String psdedit(String[]ids) throws Exception{
		for (String strId : ids) {
			//获得每一个id与对应值的组合,包括id与时长值
			String[] split = strId.split("_");
			String name = split[0];//playplan的名称
			String value =split[1];//修改后的时长值
			String zipName = split[2];//所属节目包的名称
			Playplanlist playPlan = playPlanListService.findPlayPlanList(zipName,name);
			playPlan.setPlayduration(Integer.parseInt(value));
			playPlanListService.update(playPlan);
		}
		return "success";
		
	}
	
	
	
	@RequestMapping("/deviceDelete")
	public @ResponseBody Map<String,String> deviceDelete(String[] ids) throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			for (String id : ids) {
				deviceService.deleteById(Integer.parseInt(id));
			}
			map.put("state", "200");	
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "400");
			
		}
		return map;
		
	}
	
	
	@RequestMapping("/releaseList")
	public @ResponseBody List<Programrelease> findAllPlan(Integer param) throws Exception{
		List<Programrelease> list = releaseService.findFeleaseByDeviceId(param);
		return list;
	}
	@RequestMapping("/playplans")
	public @ResponseBody List<Playplan> playplans() throws Exception{
		List<Playplan> playplans = planService.findAllPlan();
		return playplans;
	}
	
	/**
	 * 
	 * @param ids 所有要添加的播放计划的id
	 * @param id  要添加播放计划的设备id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addToDevice")
	public @ResponseBody Map<String,String> addToDevice(int[] ids,int id,HttpServletRequest request) throws Exception{
			HashMap<String,String> map = new HashMap<String, String>();
			//设备id=-1 说明没有选择设备
			if(id == -1){
				return null;
			}
			try {
				for (int playplanId : ids) {
					Programrelease programrelease = new Programrelease();
					programrelease.setAddtime(new Date());
					User user =(User)SecurityUtils.getSubject().getPrincipal();
				//	User user = (User) request.getSession().getAttribute("user");
					programrelease.setAdduser(user.getUsername());
					programrelease.setDeviceid(id);
					programrelease.setPlayplanid(playplanId);
					List<Programrelease> list = releaseService.findFeleaseByCondition(id,playplanId);
					if(list.size()==0){
						releaseService.insert(programrelease);
						map.put("status","200");
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				map.put("status","400");
			}
				return map;
		
	}
	
	@RequestMapping("/getUser")
	public @ResponseBody String getUser(int id){
		User user = userService.findUserById(id);
		String username = user.getUsername();
		return username;
	}
	
	@RequestMapping("/checkExist")
	public int checkExist(File file){
		return 0;
		/*List<Material> list = materialService.findAllByName(file.getName());
		return list.size();*/
	}
	
	@RequestMapping("/findById")
	public @ResponseBody Material findById(int id) throws Exception{
		Material material = materialService.findById(id);
		return material;
		
	}
	
	@RequestMapping("/base")
	public @ResponseBody void base(HttpServletRequest request,HttpServletResponse response,@RequestBody byte[]bytes) throws IOException{
		BufferedOutputStream bos = null;
		FileOutputStream fos =null;
		File file= null;
		File dir = new File("D:\\ABS\\screenshot");
		if(!dir.exists()&& dir.isDirectory()){
			dir.mkdirs();
		}
		file = new File("D:\\ABS\\screenshot\\a.png");
		fos = new FileOutputStream(file); 
		bos = new BufferedOutputStream(fos);
		bos.write(bytes);
		if (bos != null) {
			try {
				bos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
		
	}
}
