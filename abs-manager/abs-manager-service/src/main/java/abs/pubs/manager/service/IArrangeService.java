package abs.pubs.manager.service;

import java.util.List;

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

public interface IArrangeService {
	
	

	public List<Model> findAllModel();

	public List<Area> findAreaByModelId(String id);
	/**
	 * 保存节目单
	 * @param ids 素材的id集合
	 * @param area 指定的分区名称
	 * @param stdtime 开始播放时间
	 * @param endtime 结束播放时间
	 * @param plsName 节目单名称
	 * @param areatype 模版id
	 */
	public int inssertPls(Pls pls);

	/*public void savePls(String[] ids, String area, String stdtime, 
						 String endtime,String plsName,String areatype);*/
	
	/**
	 * 把分区和对应的素材id保存到临时数据库addMaterial_tem
	 * @param area
	 * @param id
	 */
	//public void saveTem(String area, int id);
	
	/**
	 * 根据area 的name 去addMaterial_tem表中查询对应的素材
	 * @param area
	 * @return
	 */
	public List<Integer> selectMsterialByArea(String area);
	
	/**
	 * 保存pls
	 * @param name
	 * @param model
	 * @param stdtime
	 * @param endtime
	 */
	public int savePls(String name, String model, String stdtime, String endtime);


	

	public EasyUIResult findAllPls(int page, int rows);
	
	/**
	 * 查找所有的临时表中的数据
	 * @return
	 */
	public List<AddmaterialTem> findAllAddmaterialTem();
	/**
	 * 把临时表存到数据库
	 * @param addmaterialTems
	 */

	public void saveTemToDb(List<AddmaterialTem> addmaterialTems, int plsId);
	
	/**
	 * 保存后清空临时数据库
	 * @param addmaterialTems
	 */
	public void deleteAll();
	
	/**
	 * 根据区域和素材id删除对应的tem表中的数据
	 * @param id
	 * @param area
	 */
	public void deleteTemById(int id, String area);

	
	public void deletePlsById(int id);
	
	/**
	 * 点击确认按钮时判断tem表中的数据总数
	 * @return
	 */
	public int selectCountAddmaterialTem();

	public List<AddmaterialTem> selectCountByIdAndArea(int id,String area);
	/**
	 * 通过区域和素材id保存播放详情
	 * @param temName
	 * @param temId
	 * @param bgimg
	 * @param playcnt
	 * @param priority
	 */
	public void updateTemByNameAndMaterialId (String temName, int temId, int bgimg, int playcnt, int priority);

	public List<AddmaterialTem> findByName(String temName);

	
	/**
	 * 把addmaterialTem的bgimg设置为0
	 * @param id
	 */
	public void updateById(Integer id);

	public List<Res> findResByPlsId(Integer id);

	public EasyUIResult findAllArrange(int page, int rows);

	public void saveArea(Area area, int model_id);

	public int saveModel(String modelName, String modelSize);

	public Model findModelById(String id);

	public void saveTem(AddmaterialTem addmaterialTem);

	public EasyUIResult findAllProgram(int page, int rows);

	public void inssertPro(String name, int type);

	public void deleteProById(int id);

	public EasyUIResult findproPls(int page, int rows, int id);


	public void inssertPropls(int proId, int parseInt,String format);

	public String selectPlsNameById(int id);

	public void deleteProplsById(int id);
	
	/**
	 * 节目包关联设备
	 * @param id 
	 * @param proId 
	 */
	public void relevance(int proId, int id);
	/**
	 * 根据节目包的id查询绑定的设备id，返回int数组
	 * @param id
	 * @return
	 */
	public Integer[] findProeviceById(int id);
	
	/**
	 * 取消关联
	 * @param proId
	 * @param id
	 */
	public void unRelevance(int proId, int id);
	
	/**
	 * 发布节目包
	 * @param id
	 */
	public void issue(int id);
	
	/**
	 * 向任务表中添加任务
	 * @param id
	 */
	public void addTaskitem(int id);

	public void deleteModelById(int id);

	public ProPackage findById(int id);

	public List<ProPls> findProPlsByProId(int id);

	public Pls findPlsById(Integer plsId);

	public ProPackage findPropackageById(Integer proid);

	public void setTaskInvalid(String taskId,String mac);
	
	/**
	 * 设置task可用
	 * @param taskId
	 */
	public void setTaskUsable(String string,int id);

	public void addControlTask(String deviceMac, String opId);

	public void setTaskInvalid(String mac);

	public void addScreenShotTask(String deviceMac);

	public void createModelXml();

	public void textProPls(int proId, String name, String message, String fontSize, String tColor, String bColor, String location,
			String speed, int count);

	public void addTestTask(int id);

	public ProPls selectByProid(Integer proid);

	public ProPls findproplsByProidAndPlsid(int id, int plsId);

	public List<Integer> findDevicesByProId(int id);

	public Device findDeviceById(Integer i);

	/**
	 * @param s 任务对应的mac字符串
	 */
	public void addCancelMsg(String s);

	public void clean();

	public void addTaskitem(int proId, int[] ids);

	public void addShutdownTask(int id, int d);

	public void startup(int id);
	
	/**
	 * 添加消息字幕
	 * @param name 标题
	 * @param message 消息体
	 * @param fontSize 字体大小
	 * @param tColor 字体颜色
	 * @param location 位置
	 * @param speed 滚动速度
	 */
	//public void addTextTask(String name, String message, String fontSize, String tColor, String location, String speed);


	


	
}
