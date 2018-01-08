package abs.pubs.manager.service;

import java.util.HashSet;
import java.util.List;

import abs.pubs.domain.Device;
import abs.pubs.domain.Devicetype;
import abs.pubs.domain.EasyUIResult;
/**
 * 设备相关service层
 * @author 曹起坤
 *
 */
public interface IDeviceService {
	/**
	 * 查询所有已经分配分组的设备mac
	 * @return
	 * @throws Exception
	 */
	 public List<String> findAllValidMac() throws Exception ;

	/**
	 * 查询所有设备
	 * @return
	 * @throws Exception
	 */
	/*public List<Device> findAllDevice(int groupId,String id)throws Exception;*/
	public EasyUIResult findAllDevice(int groupId, int id, int page, int rows);
	
	/**
	 * 根据id删除设备
	 * @param parseInt
	 */
	public void deleteById(int parseInt)throws Exception;
	
	/**
	 * 根据id查询设备
	 * @param deviceId
	 * @return
	 */
	public Device selectById(int id);
	
	/**
	 * 将更新持久化到数据库
	 */
	//public void update(Device device);

	void update(Device device);
	
	/**
	 * 发布节目时关联设备使用
	 * @return
	 */
	public EasyUIResult findAllDevice(int page, int rows);
	
	/**
	 * 查询当前节目包已关联的设备
	 * @param page
	 * @param rows
	 * @param ids
	 * @return
	 */
	public EasyUIResult findAllDevice(int page, int rows, int[] ids);

	public void addDevice(Device device);

	public List<Device> findAllDevice();

	public void cls();

	public List<Devicetype> findAllTypes();

	public String getNameByTypeId(int typeId);
	public HashSet getIds(int id);

	public List<Device> getDeviceByMac(String mac);

	//public int getDeviceGuestInfoCount();

	public int getCallHistoryCount();

}
