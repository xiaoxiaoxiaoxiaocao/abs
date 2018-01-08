package abs.pubs.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.ProPackage;
import abs.pubs.domain.Taskitem;
import abs.pubs.domain.TaskitemExample;
import abs.pubs.domain.TaskitemExample.Criteria;
import abs.pubs.manager.service.IHttpService;
import abs.pubs.mapper.ProPackageMapper;
import abs.pubs.mapper.TaskitemMapper;

@Service
public class HttpServiceImpl implements IHttpService {
	@Autowired
	private TaskitemMapper taskItemMapper;
	
	@Autowired
	private ProPackageMapper proPackageMapper;

	@Override
	public List<Taskitem> findAllTask() {
		TaskitemExample example = new TaskitemExample();
		Criteria criteria = example.createCriteria();
		List<Taskitem> list = taskItemMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Taskitem> findAllTask(String string) {
		
		//创建集合用于存放有该mac地址的设备
		ArrayList<Taskitem> list = new ArrayList<Taskitem>();
		TaskitemExample example = new TaskitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(0);
		List<Taskitem> taskitems = taskItemMapper.selectByExample(example);
		if(taskitems != null && taskitems.size()>0){
			for (Taskitem taskitem : taskitems) {
				//ProPackage proPackage = proPackageMapper.selectByPrimaryKey(taskitem.getProid());
				
				if(taskitem.getMacs()!=null&&taskitem.getMacs().contains(string)){
					list.add(taskitem);
				}
			}
		}
		System.out.println("baohan");
		return list;
	}

	@Override
	public List<Taskitem> findAllSyncTask(String mac) {
		//创建集合用于存放有该mac地址的设备
				ArrayList<Taskitem> list = new ArrayList<Taskitem>();
				TaskitemExample example = new TaskitemExample();
				List<Taskitem> taskitems = taskItemMapper.selectByExample(example);
				for (Taskitem taskitem : taskitems) {
					if(taskitem.getTasktype().equals("program")||taskitem.getTasktype().equals("downloadres")){
						
						if(taskitem.getMacs()!=null&&taskitem.getMacs().contains(mac)){
							list.add(taskitem);
						}
					}
				}
				return list;
			}

	@Override
	public List<Taskitem> findCustomTaskByMac(String mac,String type) {
		TaskitemExample example = new TaskitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andTasktypeEqualTo(type);
		criteria.andMacsEqualTo(mac);
		List<Taskitem> taskitems = taskItemMapper.selectByExample(example);
		return taskitems;
	}

	/*@Override
	public List<Taskitem> findAllMonitorreportTask(String mac) {
		//查询所有该mac且任务类型是monitorreport 的任务
		
		return null;
	}*/

	

	

}
