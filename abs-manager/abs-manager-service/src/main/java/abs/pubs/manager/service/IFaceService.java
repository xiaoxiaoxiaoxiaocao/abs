package abs.pubs.manager.service;

import java.util.List;

import abs.pubs.domain.DeviceGuest;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Excel;

public interface IFaceService {

	EasyUIResult findAlldeviceGuest(int page, int rows, String qrDevice, String qrGuest, String fromDate, String toDate)throws Exception;

	List<DeviceGuest> findAlldeviceGuest();

	//void insert(String param, String uid, String macAddress, String assembly, String age, String gender);

	List<Excel> findExcelDate(String qrDevice, String qrGuest, String fromDate, String toDate)throws Exception;

	void insert(String btn, String guest, String macAddress, String assembly, Integer age, String gender);

	EasyUIResult findAllCallHistoryList(int page,int rows);

	//List<DeviceGuest> findAllDeviceGuest();
	

}
