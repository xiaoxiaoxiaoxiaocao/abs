package abs.pubs.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.CallHistory;
import abs.pubs.domain.Device;
import abs.pubs.domain.DeviceExample;
import abs.pubs.domain.DeviceGuest;
import abs.pubs.domain.EditResult;
import abs.pubs.domain.Guest;
import abs.pubs.domain.GuestExample;
import abs.pubs.domain.Material;
import abs.pubs.domain.Playplanlist;
import abs.pubs.domain.PlayplanlistExample;
import abs.pubs.domain.PlayplanlistExample.Criteria;
import abs.pubs.domain.Program;
import abs.pubs.domain.ProgramExample;
import abs.pubs.domain.User;
import abs.pubs.manager.service.IFinalService;
import abs.pubs.mapper.CallHistoryMapper;
import abs.pubs.mapper.DeviceGuestMapper;
import abs.pubs.mapper.DeviceMapper;
import abs.pubs.mapper.GuestMapper;
import abs.pubs.mapper.MaterialMapper;
import abs.pubs.mapper.PlayplanMapper;
import abs.pubs.mapper.PlayplanlistMapper;
import abs.pubs.mapper.ProgramMapper;
import abs.pubs.mapper.ProgramreleaseMapper;
import abs.pubs.mapper.UserMapper;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
@Service("iFinalService")
@WebService(endpointInterface="abs.pubs.manager.service.IFinalService",targetNamespace="http://service.manager.pubs.abs/",serviceName="IFinalService")
public class FinalServiceImpl implements IFinalService {
	
	private static final String String = null;
	@Autowired
	private DeviceMapper deviceMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PlayplanMapper planMapper;
	@Autowired
	private PlayplanlistMapper playPlanListMapper;
	@Autowired
	private MaterialMapper materialMapper;
	
	@Autowired
	private ProgramreleaseMapper programreleaseMapper;
	
	@Autowired
	private ProgramMapper programMapper;
	@Autowired
	private GuestMapper guestMapper;
	@Autowired
	private DeviceGuestMapper deviceGuestMapper;
	
	@Autowired
	private CallHistoryMapper callHistoryMapper;
	
	@Override
	public List<EditResult> getPlayPlan1(String mac) {
		//根据mac地址查询对应的机器id，在机器list集合中查找最后添加的对应播放计划。
		Integer deviceId = deviceMapper.findIDByMac(mac);
		//根据机器id查找播放计划中对应plan中添加时间最晚的playplan的id
		Integer maxTimeId = programreleaseMapper.findMaxTimeId(deviceId);
		/*Integer maxTimeId = planMapper.findMaxTimeId(deviceId);*/
		//根据playplanid查找对应的playplanlist，结果是list集合
		PlayplanlistExample example = new PlayplanlistExample();
		Criteria criteria = example.createCriteria();
		criteria.andPlayplanidEqualTo(maxTimeId);
		List<Playplanlist> list = playPlanListMapper.selectByExample(example);
		
		//根据每一个playplanlist对象查找对应的material，然后封装成一个PlayPlanResult对象，加入list集合中
		ArrayList<EditResult> arrayList = new ArrayList<>();
		for (Playplanlist playplanlist : list) {
			Material material = materialMapper.selectByPrimaryKey(playplanlist.getMaterialid());
			Integer id = material.getAdduserid();
			User user = userMapper.selectByPrimaryKey(id);
			EditResult editResult = new EditResult();
			editResult.setMaterialId(material.getId());
			editResult.setMaterialName(material.getName());
			editResult.setType(material.getType()==0?"图片":"视频");
			editResult.setMaterialSize(material.getSize());
			editResult.setPlayorder(playplanlist.getPlayorder());
			editResult.setPlayduration(playplanlist.getPlayduration());
			editResult.setProPackage(playplanlist.getPropackage());
			editResult.setAddTime(material.getAddtime());
			editResult.setAddUsername(user.getUsername());
			arrayList.add(editResult);
		}
		
		return arrayList;
	}
	@Override
	public List<EditResult> getPlayPlan2(String mac) {
		//根据mac地址查询对应的机器id，在机器list集合中查找最后添加的对应播放计划。
		Integer deviceId = deviceMapper.findIDByMac(mac);
		//根据机器id查找播放计划中对应plan中添加时间最晚的playplan的id
		Integer maxTimeId = programreleaseMapper.findMaxTimeId(deviceId);
		/*Integer maxTimeId = planMapper.findMaxTimeId(deviceId);*/
		//根据playplanid查找对应的playplanlist，结果是list集合
		PlayplanlistExample example = new PlayplanlistExample();
		Criteria criteria = example.createCriteria();
		criteria.andPlayplanidEqualTo(maxTimeId);
		List<Playplanlist> list = playPlanListMapper.selectByExample(example);
		
		//根据每一个playplanlist对象查找对应的material，然后封装成一个PlayPlanResult对象，加入list集合中
		ArrayList<EditResult> arrayList = new ArrayList<>();
		for (Playplanlist playplanlist : list) {
			Material material = materialMapper.selectByPrimaryKey(playplanlist.getMaterialid());
			Integer id = material.getAdduserid();
			User user = userMapper.selectByPrimaryKey(id);
			EditResult editResult = new EditResult();
			editResult.setMaterialName(material.getName());
			editResult.setType(material.getType()==0?"图片":"视频");
			editResult.setMaterialSize(material.getSize());
			editResult.setPlayorder(playplanlist.getPlayorder());
			editResult.setPlayduration(playplanlist.getPlayduration());
			editResult.setProPackage(playplanlist.getPropackage());
			editResult.setAddTime(material.getAddtime());
			editResult.setAddUsername(user.getUsername());
			arrayList.add(editResult);
		}
		
		return arrayList;
	}
	@Override
	public List<EditResult> getPlayPlan3(String mac) {
		//根据mac地址查询对应的机器id，在机器list集合中查找最后添加的对应播放计划。
		Integer deviceId = deviceMapper.findIDByMac(mac);
		//根据机器id查找播放计划中对应plan中添加时间最晚的playplan的id
		Integer maxTimeId = programreleaseMapper.findMaxTimeId(deviceId);
		/*Integer maxTimeId = planMapper.findMaxTimeId(deviceId);*/
		//根据playplanid查找对应的playplanlist，结果是list集合
		PlayplanlistExample example = new PlayplanlistExample();
		Criteria criteria = example.createCriteria();
		criteria.andPlayplanidEqualTo(maxTimeId);
		List<Playplanlist> list = playPlanListMapper.selectByExample(example);
		
		//根据每一个playplanlist对象查找对应的material，然后封装成一个PlayPlanResult对象，加入list集合中
		ArrayList<EditResult> arrayList = new ArrayList<>();
		for (Playplanlist playplanlist : list) {
			Material material = materialMapper.selectByPrimaryKey(playplanlist.getMaterialid());
			Integer id = material.getAdduserid();
			User user = userMapper.selectByPrimaryKey(id);
			EditResult editResult = new EditResult();
			editResult.setMaterialName(material.getName());
			editResult.setType(material.getType()==0?"图片":"视频");
			editResult.setMaterialSize(material.getSize());
			editResult.setPlayorder(playplanlist.getPlayorder());
			editResult.setPlayduration(playplanlist.getPlayduration());
			editResult.setProPackage(playplanlist.getPropackage());
			editResult.setAddTime(material.getAddtime());
			editResult.setAddUsername(user.getUsername());
			arrayList.add(editResult);
		}
		
		return arrayList;
	}

	/*	JSON.parse(jsonstr); 可以将json字符串转换成json对象 
		JSON.stringify(jsonobj); 可以将json对象转换成json对符串 
	 */	
	@Override
	public boolean updateDeviceInfo(String str) {
		 try {
			JSONObject json = JSONObject.fromObject(str);
			List<Device> list=deviceMapper.selectByMac((String)json.get("mac"));
				    Device device = new Device();
				    device.setUpdatetime(new Date());
					device.setStatus("在线");
					device.setDevicename((String)json.get("deviceName"));
					device.setMac((String)json.get("mac"));
					device.setIp((String)json.get("ip"));
					device.setOutputresolution((String)json.get("outputResolution"));
					device.setFirmwareversion((String)json.get("firmwareVersion"));
					device.setAppversion((String)json.get("appVersion"));
					device.setSubnetmask((String)json.get("subnetMask"));
					device.setDefaultgateway((String)json.get("defaultGateway"));
					device.setHarddiskfreespace((String)json.get("harddiskFreespace"));
					device.setSystemtype((String)json.get("systemType"));
					device.setTotalphysicalmemory((String)json.get("totalPhysicalMemory"));
					device.setLoginusername((String)json.get("loginUserName"));
					device.setCpuid((String)json.get("cpuId"));
					device.setDiskid((String)json.get("diskId"));
			if(list.size()!=0){
				//没有该设备，直接添加
				DeviceExample example = new DeviceExample();
				abs.pubs.domain.DeviceExample.Criteria criteria = example.createCriteria();
				criteria.andMacEqualTo(device.getMac());
				deviceMapper.deleteByExample(example);
			}
			deviceMapper.insert(device);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public List<String> getPlayPlanName() {
		//获取所有压缩包的名字
		ProgramExample example = new ProgramExample();
		List<Program> list = programMapper.selectByExample(example);
		//list集合存放所有压缩包名
		ArrayList<String> listTem = new ArrayList<String>();
		for (Program program : list) {
			String zipname = program.getZipname();
			listTem.add(zipname);
		}
		//截取list集合
		List<String> subList = listTem.subList(0, 5);
		
		return subList;
	}
	@Override
	public void xmlTest(java.lang.String str) {
	System.out.println(str.toString());
		
	}
	@Override
	public Guest FindGuest(java.lang.String GuestID) {
		GuestExample example = new GuestExample();
		abs.pubs.domain.GuestExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(GuestID);
		List<Guest> list = guestMapper.selectByExample(example);
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public Boolean GuestLog(java.lang.String strGuestID, java.lang.String strMac, DateTime dtTime) {
		boolean flag;
		try {
			Date date = dtTime.toDate();
			Guest guest = FindGuest(strGuestID);
			java.lang.String dt = date.toLocaleString();
			if(guest ==null){
				Guest gst = new Guest();
				gst.setId(strGuestID);
				gst.setTime(dt);
				guestMapper.insert(gst);
			}
			DeviceGuest deviceGuest = new DeviceGuest();
			deviceGuest.setGuestid(strGuestID);
			deviceGuest.setMac(strMac);
			//deviceGuest.setTime(dt);
			deviceGuestMapper.insert(deviceGuest);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	
	
	/*@Override
	public void saveCall(String[] str) {
		CallHistory callHistory = new CallHistory();
		callHistory.setMac(str[0]);
		callHistory.setTime(str[1]);
		callHistoryMapper.insert(callHistory);
		
	}*/
	
	@Override
	public void saveCall(String mac,String time) {
		CallHistory callHistory = new CallHistory();
		callHistory.setMac(mac);
		callHistory.setTime(time);
		callHistoryMapper.insert(callHistory);
		
	}
	
	
	
	
	

}
