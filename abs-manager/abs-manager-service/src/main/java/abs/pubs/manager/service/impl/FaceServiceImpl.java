package abs.pubs.manager.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import abs.pubs.domain.CallHistory;
import abs.pubs.domain.CallHistoryExample;
import abs.pubs.domain.Device;
import abs.pubs.domain.DeviceGuest;
import abs.pubs.domain.DeviceGuestExample;
import abs.pubs.domain.DeviceGuestExample.Criteria;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Excel;
import abs.pubs.manager.service.IFaceService;
import abs.pubs.mapper.CallHistoryMapper;
import abs.pubs.mapper.DeviceGuestMapper;
import abs.pubs.mapper.DeviceMapper;
@Service
public class FaceServiceImpl implements IFaceService {
	
	@Autowired
	private DeviceGuestMapper deviceGuestMapper;
	@Autowired
	private DeviceMapper deviceMapper;
	
	@Autowired
	private  CallHistoryMapper callHistoryMapper;

	@Override
	public EasyUIResult findAlldeviceGuest(int page, int rows,String qrDevice, String qrGuest, String fromDate, String toDate) throws Exception {
		DeviceGuestExample example = new DeviceGuestExample();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Criteria criteria = example.createCriteria();
		if(qrDevice != null&& qrDevice.trim().length()>3){
			criteria.andMacEqualTo(qrDevice);
		}
		if(qrGuest != null&&qrGuest.trim().length()>0){
			//criteria.andGuestidEqualTo(qrGuest);
			criteria.andGuestidLike("%"+qrGuest+"%");
		}
		if(fromDate != null&& fromDate.trim().length()>0){
			criteria.andTimeGreaterThanOrEqualTo(format.parse(fromDate));
		}
		if(toDate != null && toDate.trim().length()>0){
			criteria.andTimeLessThanOrEqualTo(format.parse(toDate));
		}
		PageHelper.startPage(page, rows);
		List<DeviceGuest> list = deviceGuestMapper.selectByExample(example);
		PageInfo<DeviceGuest> info = new PageInfo<>(list);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(info.getTotal());
		return result;
	}

	@Override
	public List<DeviceGuest> findAlldeviceGuest() {
		DeviceGuestExample example = new DeviceGuestExample();
		List<DeviceGuest> list = deviceGuestMapper.selectByExample(example);
		return list;
	}

/*	@Override
	public void insert(String param, String uid) {
		DeviceGuest deviceGuest = new DeviceGuest();
		deviceGuest.setGuestid(uid);
		deviceGuest.setMac(null);
		deviceGuest.setBtn(param);
		deviceGuest.setTime(new Date());
		deviceGuestMapper.insert(deviceGuest);
	}*/

	@Override
	public List<Excel> findExcelDate(String qrDevice, String qrGuest, String fromDate, String toDate) throws Exception {
		DeviceGuestExample example = new DeviceGuestExample();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Criteria criteria = example.createCriteria();
		if(qrDevice != null&& qrDevice.trim().length()>3){
			criteria.andMacEqualTo(qrDevice);
		}
		if(qrGuest != null&&qrGuest.trim().length()>0){
			//criteria.andGuestidEqualTo(qrGuest);
			criteria.andGuestidLike("%"+qrGuest+"%");
		}
		if(fromDate != null&& fromDate.trim().length()>0){
			criteria.andTimeGreaterThanOrEqualTo(format.parse(fromDate));
		}
		if(toDate != null && toDate.trim().length()>0){
			criteria.andTimeLessThanOrEqualTo(format.parse(toDate));
		}
		List<DeviceGuest> list = deviceGuestMapper.selectByExample(example);
		List<Excel> excelDate = new ArrayList<>();
		for (DeviceGuest deviceGuest : list) {
			String mac = deviceGuest.getMac();
			Excel excel = new Excel();
			if(mac != null){
				mac= mac.replaceAll(":", "-");
				String deviceName= deviceMapper.selectNameByMac(mac);
				if(deviceName ==null){
					excel.setDeviceName("未知设备");
				}else{
					excel.setDeviceName(deviceName);
				}
			}
			excel.setGuestName(deviceGuest.getGuestid());
			excel.setGender(deviceGuest.getGender());
			excel.setAge(deviceGuest.getAge());
			excel.setInfo(deviceGuest.getBtn());
			excel.setDate(deviceGuest.getTime().toLocaleString());
			excelDate.add(excel);
		}
		
		return excelDate;
	}

	@Override
	public void insert(String btn, String guest, String macAddress, String assembly, Integer age, String gender) {
		DeviceGuest deviceGuest = new DeviceGuest();
		deviceGuest.setGuestid(guest);
		deviceGuest.setMac(macAddress.replaceAll(":","-"));
		deviceGuest.setBtn(btn);
		deviceGuest.setAge(age);
		deviceGuest.setGender(gender);
		deviceGuest.setTime(new Date());
		deviceGuestMapper.insert(deviceGuest);
		
	}

	@Override
	public EasyUIResult findAllCallHistoryList(int page,int rows) {
		CallHistoryExample example = new CallHistoryExample();
		PageHelper.startPage(page, rows);
		List<CallHistory> list = callHistoryMapper.selectByExample(example);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult .setRows(list);
		easyUIResult .setTotal(new PageInfo<>(list).getTotal());
		return easyUIResult;
		
	}

}
