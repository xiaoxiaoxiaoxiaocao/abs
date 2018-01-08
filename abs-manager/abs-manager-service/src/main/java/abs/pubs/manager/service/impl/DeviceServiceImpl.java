package abs.pubs.manager.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import abs.pubs.domain.CallHistoryExample;
import abs.pubs.domain.Device;
import abs.pubs.domain.DeviceExample;
import abs.pubs.domain.DeviceGuestExample;
import abs.pubs.domain.Devicecat;
import abs.pubs.domain.DevicecatExample;
import abs.pubs.domain.Devicetype;
import abs.pubs.domain.DevicetypeExample;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Playplan;
import abs.pubs.domain.PlayplanExample;
import abs.pubs.domain.PlayplanExample.Criteria;
import abs.pubs.domain.ProDeviceExample;
import abs.pubs.manager.service.IDeviceCatServcie;
import abs.pubs.manager.service.IDeviceService;
import abs.pubs.mapper.CallHistoryMapper;
import abs.pubs.mapper.DeviceGuestMapper;
import abs.pubs.mapper.DeviceMapper;
import abs.pubs.mapper.DevicecatMapper;
import abs.pubs.mapper.DevicetypeMapper;
import abs.pubs.mapper.PlayplanMapper;
import abs.pubs.mapper.PlayplanlistMapper;
import abs.pubs.mapper.ProDeviceMapper;

@Service
public class DeviceServiceImpl implements IDeviceService {
	@Autowired
	private DeviceMapper deviceMapper;
	@Autowired
	private DevicecatMapper deviceCatMapper;
	
	@Autowired
	private DevicetypeMapper devicetypeMapper;
	
	@Autowired
	private PlayplanMapper planMapper;
	@Autowired
	private PlayplanlistMapper playplanlistMapper;
	
	@Autowired
	private ProDeviceMapper proDeviceMapper;
	
	@Autowired
	private CallHistoryMapper callHistoryMapper;
	
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	@Override
	public EasyUIResult findAllDevice(int groupId,int fId,int page, int rows) {
		//根据groupId 查询parentid
		//int parentid = deviceCatMapper.selectPidById(groupId);
		Devicecat devicecat = deviceCatMapper.selectByPrimaryKey(groupId);
		int parentid = devicecat.getParentid();
		//Devicecat devicecat = deviceCatMapper.selectByPrimaryKey(groupId);
		//ArrayList<Device> list = new ArrayList<Device>();
		DeviceExample example = new DeviceExample();
		example.setOrderByClause("id desc");
		abs.pubs.domain.DeviceExample.Criteria criteria = example.createCriteria();
		if (fId != -1) {
			criteria.andDevicetypeidEqualTo(fId);
		}
		if(groupId == 4||parentid==0){
			PageHelper.startPage(page, rows);
			//前台过来的参数为null或者0，都要查询所有设备
			ArrayList<Device> list = (ArrayList<Device>) deviceMapper.selectByExample(example);
			PageInfo<Device> info = new PageInfo<>(list);
			EasyUIResult easyUIResult = new EasyUIResult();
			easyUIResult.setRows(list);
			easyUIResult.setTotal(info.getTotal());
			//System.out.println(list.size());
			return easyUIResult;
		}else{
					/*ArrayList<Device> list = new ArrayList<Device>();
					HashSet<Integer> ids = getIds(groupId);
					System.out.println(ids.toString());
					PageHelper.startPage(page, rows);
					for (Integer id : ids) {
						//根据分组id查询设备
						List<Device> selectByExample = deviceMapper.selectByGroupId(id);
						for (Device device : selectByExample) {
							list.add(device);
						}
					}
					if(fId != -1){
						ArrayList<Device> l = new ArrayList<Device>();
						for(Device d:list){
							if(d.getDevicetypeid()==fId){
								l.add(d);
							}
						}
						list=l;
					}*/
					HashSet<Integer> ids = getIds(groupId);
					//存放所有设备的id
					ArrayList<Integer> list = new ArrayList<>();
					ArrayList<Integer> targetList = new ArrayList<Integer>();
					for (Integer id : ids) {
						List<Device> ds = deviceMapper.selectByGroupId(id);
						if(ds != null && ds.size()>0){
							for (Device device : ds) {
								list.add(device.getId());
							}
						}
					}
					if(fId != -1&& list.size()>0){
						for(int i:list){
							if(deviceMapper.selectByPrimaryKey(i).getDevicetypeid()==fId){
								targetList.add(i);
							}
						}
						list = targetList;
					}
					
					PageHelper.startPage(page, rows);
					ArrayList<Device> list2 = new ArrayList<Device>();
					if(list.size()>0){
						list2 = (ArrayList<Device>) deviceMapper.selectListByIds(list);
					}
					
					PageInfo<Device> info = new PageInfo<>(list2);
					EasyUIResult easyUIResult = new EasyUIResult();
					easyUIResult.setRows(list2);
					easyUIResult.setTotal(info.getTotal());
					//System.out.println(list.size());
					return easyUIResult;
			}
	}
	//参数不等于默认值，说明是通过点击tree触发的，要根据节点id判断是不是父节点
	//如果不是父节点，直接查询id对应的设备
		/*criteria.andGroupingEqualTo(groupId);
		list = (ArrayList<Device>) deviceMapper.selectByExample(example);
		//如果是父节点要查询该父节点下的所有子节点的id
		if(devicecat.getIsparent()==1){
			DeviceExample example2 = new DeviceExample();
			abs.pubs.domain.DeviceExample.Criteria criteria2 = example2.createCriteria();
			if (fId != -1) {
				criteria2.andDevicetypeidEqualTo(fId);
			}*/
			/*ArrayList<Integer> ids = new ArrayList<Integer>();
			DevicecatExample devicecatExample = new DevicecatExample();
			abs.pubs.domain.DevicecatExample.Criteria crite = devicecatExample.createCriteria();
			crite.andParentidEqualTo(groupId);
			List<Devicecat> dCats = deviceCatMapper.selectByExample(devicecatExample);
			for (Devicecat de : dCats) {
				ids.add(de.getId());
				findAllDevice(de.getId(),fId,page,rows);
			}*/
	/*	List<Integer> ids = getIds(groupId);
	for (int id: ids) {
		List<Device> devices = deviceMapper.selectByGroupId(id);
		for (Device device : devices) {
			if(device.getDevicetypeid()==fId){
				list.add(device);
			}
			//arrayList.add(device.getId());
		}
	}*/
	/*for (Integer id : arrayList) {
		Device device = deviceMapper.selectByPrimaryKey(id);
		if(fId==-1){
			list.add(device);
		}else{
			if(device.getDevicetypeid()==fId){
				list.add(device);
			}
		}
	}*/
	@Override
	public void deleteById(int id) throws Exception {
		deviceMapper.deleteByPrimaryKey(id);
		//删除设备的同时，删除pro_device里面对应的内容
		ProDeviceExample example = new ProDeviceExample();
		abs.pubs.domain.ProDeviceExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceidEqualTo(id);
		proDeviceMapper.deleteByExample(example);
	}

	@Override
	public Device selectById(int id) {
		Device device = deviceMapper.selectByPrimaryKey(id);
		return device;
	}

	@Override
	public void update(Device device) {
		deviceMapper.updateByPrimaryKey(device);
		
	}

	@Override
	public List<String> findAllValidMac() throws Exception {
		List<String> macs = deviceMapper.findAllValidMac();
		return macs;
	}
	
	@Override
	public EasyUIResult findAllDevice(int page,int rows) {
		PageHelper.startPage(page, rows);
		DeviceExample example = new DeviceExample();
		abs.pubs.domain.DeviceExample.Criteria criteria = example.createCriteria();
		criteria.andGroupingIsNotNull();
		List<Device> list = deviceMapper.selectByExample(example);
		PageInfo<Device> info = new PageInfo<>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(info.getTotal());
		return easyUIResult;
	}

	@Override
	public EasyUIResult findAllDevice(int page, int rows, int[] ids) {
		PageHelper.startPage(page, rows);
		ArrayList<Device> list = new ArrayList<Device>();
		for (int id : ids) {
			Device device = deviceMapper.selectByPrimaryKey(id);
			list.add(device);
		}
		PageInfo<Device> info = new PageInfo<>(list);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(info.getTotal());
		return result;
	}

	@Override
	public void addDevice(Device device) {
		deviceMapper.insert(device);
	}

	@Override
	public List<Device> findAllDevice() {
		DeviceExample example = new DeviceExample();
		List<Device> list = deviceMapper.selectByExample(example);
		return list;
	}

	@Override
	public void cls() {
		arrayList.clear();
		ids.clear();
	}

	@Override
	public List<Devicetype> findAllTypes() {
		DevicetypeExample example = new DevicetypeExample();
		List<Devicetype> list = devicetypeMapper.selectByExample(example);
		return list;
	}

	@Override
	public String getNameByTypeId(int typeId) {
		Devicetype devicetype = devicetypeMapper.selectByPrimaryKey(typeId);
		return devicetype.getName();
	}


	//查询一个节点下所有子节点的集合
	//ArrayList<Integer> ids = new ArrayList<Integer>();
	 HashSet<Integer> ids=new HashSet<Integer>();
	@Override
	public HashSet<Integer> getIds(int id){
		
		DevicecatExample devicecatExample = new DevicecatExample();
		abs.pubs.domain.DevicecatExample.Criteria crite = devicecatExample.createCriteria();
		crite.andParentidEqualTo(id);
		List<Devicecat> dCats = deviceCatMapper.selectByExample(devicecatExample);
		for (Devicecat devicecat : dCats) {
			ids.add(devicecat.getId());
			if(devicecat.getIsparent()==1){
				getIds(devicecat.getId());
			}
		}
		ids.add(id); //
		
		
		return ids;
		
	}
	@Override
	public List<Device> getDeviceByMac(String mac) {
		DeviceExample example = new DeviceExample();
		abs.pubs.domain.DeviceExample.Criteria criteria = example.createCriteria();
		criteria.andMacEqualTo(mac);
		List<Device> list = deviceMapper.selectByExample(example);
		return list;
	}
	/*@Override
	public int getDeviceGuestInfoCount() {
		DeviceGuestExample example = new DeviceGuestExample();
		int i = deviceGuestMapper.countByExample(example);
		return i;
	}*/
	@Override
	public int getCallHistoryCount() {
		CallHistoryExample example = new CallHistoryExample();
		int i = callHistoryMapper.countByExample(example);
		return i;
	}

	

}
