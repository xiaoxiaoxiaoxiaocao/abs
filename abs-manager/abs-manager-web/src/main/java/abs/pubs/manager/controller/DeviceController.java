package abs.pubs.manager.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Array;

import abs.pubs.domain.Device;
import abs.pubs.domain.DeviceExample;
import abs.pubs.domain.DeviceGuest;
import abs.pubs.domain.Devicecat;
import abs.pubs.domain.Devicetype;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.manager.service.IDeviceCatServcie;
import abs.pubs.manager.service.IDeviceService;
import abs.pubs.manager.service.IFaceService;
import abs.pubs.utils.EasyUITreeNode;
import abs.pubs.utils.PubsResult;
/**
 * 设备servcie层，包含所有与设备相关的controller
 * @author 曹起坤
 *
 */
@Controller
@RequestMapping("/device")
public class DeviceController implements Serializable{
	@Autowired
	private IDeviceCatServcie deviceCatService;
	
	@Autowired
	private IDeviceService deviceService;
	
	@Autowired
	private IFaceService faceService;
	
	@RequestMapping(value = "/deviceList")
	public @ResponseBody EasyUIResult findAllDevice (int groupId,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="10") int rows,
			@RequestParam(defaultValue="-1") int id) throws Exception{
		deviceService.cls();
		EasyUIResult easyUIResult = deviceService.findAllDevice(groupId,id,page,rows);
		return easyUIResult;
	}
	@RequestMapping(value = "/deList")
	public @ResponseBody EasyUIResult deList(
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="10") int rows) throws Exception{
		EasyUIResult easyUIResult = deviceService.findAllDevice(page,rows);
		return easyUIResult;
	}
	
	
	
	@RequestMapping("/cat")
	public @ResponseBody List<EasyUITreeNode> deviceCat(
			@RequestParam(defaultValue="0")Integer id){
		
		List<EasyUITreeNode> list = deviceCatService.findDeviceCat(id);
		return list;
		
		
	}
	
	@RequestMapping("/create")
	public @ResponseBody PubsResult createNode(Devicecat devicecat){
		PubsResult pubsResult = deviceCatService.createNode(devicecat);
		return pubsResult;
	}
	@RequestMapping("/update")
	public void update(int id,String name){
		deviceCatService.update(id,name);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id){
		
		deviceCatService.delete(id);
	}
	@RequestMapping("/catList")
	public @ResponseBody List<Devicecat> catList(){
		List<Devicecat> list = deviceCatService.findAll();
		
		return list;
	}
	
	/**
	 * 对设备进行分组
	 * @param deviceId 设备id
	 * @param id 分组id
	 * @return
	 */
	@RequestMapping("/assignGroup")
	public @ResponseBody Map<String, String> assignGroup(int deviceId,int id){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			
			Devicecat deviceCat =deviceCatService.selectById(id);
			
			Device device = deviceService.selectById(deviceId);
			device.setGrouping(deviceCat.getId());
			deviceService.update(device);
			map.put("state", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "400");
		}
		return map;
	}
	
	
	
	@RequestMapping(value ="/getGroupName",produces="text/html;charset=UTF-8;")
	public @ResponseBody String getGroupName(@RequestParam(value="groupId") Integer groupId){
		Devicecat devicecat = deviceCatService.selectById(groupId);
		if(devicecat == null){
			return "";
		}
		String name = devicecat.getName();
		return name;
		
	}
/*	@RequestMapping(value ="/getGroupName1",produces="text/html;charset=UTF-8;")
	public @ResponseBody String getGroupName1(@RequestParam(value="groupId") Integer groupId){
		Devicecat devicecat = deviceCatService.selectById1(groupId);
		if(devicecat == null){
			return "";
		}
		String name = devicecat.getName();
		return name;
		
	}*/
	
	
	@RequestMapping("/reload")
	public ModelAndView reload(Integer groupId,HttpServletRequest request){
		HashMap<String,Object> map = new HashMap<String,Object>();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deviceList");
		request.setAttribute("groupId", groupId);
		//map.put("groupId", groupId);
		return modelAndView;
	}
	
	@RequestMapping("/devices")
	public @ResponseBody EasyUIResult devices(@RequestParam(defaultValue="1") int page,
										@RequestParam(defaultValue="10") int rows){
		EasyUIResult easyUIResult = deviceService.findAllDevice(page,rows);
		return easyUIResult;
	}
	@RequestMapping("/device")
	public @ResponseBody EasyUIResult devices(@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="10") int rows,int[]ids){
		
		EasyUIResult easyUIResult = deviceService.findAllDevice(page,rows,ids);
		return easyUIResult;
	}
	
	@RequestMapping("/addDevice")
	public @ResponseBody Map<String,String> addDevice(String addName,String addMac,String addAbs,Integer addGup,int addTp){
		
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			Device device = new Device();
			device.setDevicename(addName);
			device.setMac(addMac);
			device.setOutputresolution(addAbs);
			device.setGrouping(addGup);
			device.setDevicetypeid(addTp);
			deviceService.addDevice(device);
			map.put("states", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("states", "200");
		}
		return map;
	}
	
	@RequestMapping("/findTypes")
	public @ResponseBody List<Devicetype> findTypes(HttpServletRequest request){
	HttpSession session = request.getSession();
	List<Devicetype> deviceTypes = deviceService.findAllTypes();
	session.setAttribute("deviceTypes", deviceTypes);
	return deviceTypes;
	}
	@RequestMapping("/findDevicesByMacs")
	public @ResponseBody List<Device> findDevicesByMacs(){
		//获取deviceGuest 表中所有的mac
		List<DeviceGuest> list= faceService.findAlldeviceGuest();
		//新建set集合，存放所有的mac
		HashSet<String> set = new HashSet<String>();
		//新建list集合存放所有的device
		List<Device> devices = new ArrayList<Device>();
		if(list != null && list.size()>0){
			for (DeviceGuest deviceGuest : list) {
				set.add(deviceGuest.getMac());
			}
			if(set != null && set.size()>0){
				for (String mac : set) {
					List<Device> deviceByMac = deviceService.getDeviceByMac(mac);
					if(deviceByMac != null && deviceByMac.size()>0){
						devices.add(deviceByMac.get(0));
					}
				}
				
			}
		}
		return devices;
	}
	
	@RequestMapping(value="/getType",produces="text/html;charset=UTF-8")
	public @ResponseBody String getType(int typeId){
		String name =deviceService.getNameByTypeId(typeId);
		return name;
	}
	@RequestMapping(value="/getDeviceByMac",produces="text/html;charset=UTF-8")
	public @ResponseBody String getDeviceByMac(String mac){
		 mac = mac.replaceAll(":", "-");
		 List<Device> list=deviceService.getDeviceByMac(mac);
		 if(list != null && list.size()>0){
			 return list.get(0).getDevicename();
		 }else{
			 return "未知设备";
		 }
	}
	

	@RequestMapping("/infoCount")
	public @ResponseBody int infoCount(){
		//int i = deviceService.getDeviceGuestInfoCount();
		int i = deviceService.getCallHistoryCount();
		return i;
	}
	

}
