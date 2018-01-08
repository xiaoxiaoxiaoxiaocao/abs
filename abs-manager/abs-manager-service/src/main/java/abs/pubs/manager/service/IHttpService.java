package abs.pubs.manager.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import abs.pubs.domain.Taskitem;

/**
 * 用于处理对接方面的业务
 * @author kun
 *
 */
public interface IHttpService {

	List<Taskitem> findAllTask(String mac);

	List<Taskitem> findAllTask();

	List<Taskitem> findAllSyncTask(String mac);
	
	/**
	 * 根据mac地址和任务类型查询对应的任务集合
	 * @param mac
	 * @return
	 */
	List<Taskitem> findCustomTaskByMac(String mac,String type);


	/*List<Taskitem> findCustTask(int i);
	
	*//**
	 * 在紧急插播的集合中，查找mac包含mac地址的集合
	 * @param tasks
	 * @param mac
	 * @return
	 *//*
	List<Taskitem> findAllTask(List<Taskitem> tasks, String mac);*/

}
