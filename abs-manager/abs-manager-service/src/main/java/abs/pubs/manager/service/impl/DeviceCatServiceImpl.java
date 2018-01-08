package abs.pubs.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import abs.pubs.domain.DeviceExample;
import abs.pubs.domain.Devicecat;
import abs.pubs.domain.DevicecatExample;
import abs.pubs.domain.DevicecatExample.Criteria;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.manager.service.IDeviceCatServcie;
import abs.pubs.mapper.DevicecatMapper;
import abs.pubs.utils.EasyUITreeNode;
import abs.pubs.utils.PubsResult;

@Service
public class DeviceCatServiceImpl implements IDeviceCatServcie{
	@Autowired
	private DevicecatMapper deviceCatMapper;

	@Override
	public List<EasyUITreeNode> findDeviceCat(Integer id) {
		//查询父id与id相等的分类
		DevicecatExample example = new DevicecatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(id);
		ArrayList<EasyUITreeNode> treeNodeList = new ArrayList<EasyUITreeNode>();
		List<Devicecat> list = deviceCatMapper.selectByExample(example);
		
		for (Devicecat devicecat : list) {
			EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
			easyUITreeNode.setId(devicecat.getId());
			easyUITreeNode.setState((devicecat.getIsparent())==0?"open":"closed");
			easyUITreeNode.setText(devicecat.getName());
			treeNodeList.add(easyUITreeNode);
		}
		return treeNodeList;
	}
	/**
	 * 当前新建父节点如果是子节点，子节点变父节点，修改节点状态
	 * 如果新建父节点已经是父节点，直接添加
	 * 判断流程：
	 * 	传递参数：新建节点的父id等于新建节点父节点的id，根据当前新建节点的父id查询父节点对象
	 * 				判断isparent的属性值
	 */

	@Override
	public PubsResult createNode(Devicecat devicecat) {
		devicecat.setState(1);
		devicecat.setIsparent(0);
		Date date = new Date();
		devicecat.setCreatetime(date);
		devicecat.setUpdatetime(date);
		//保存节点，为了更新easyui框架tree树形节点id，返回新建节点id
		deviceCatMapper.insert(devicecat);
		//根据父节点的ID 查询父节点对象
		Devicecat fuCat = deviceCatMapper.selectByPrimaryKey(devicecat.getParentid());
		//判断此节点的状态
		if(fuCat.getIsparent()==0){
			//此节点是子节点
			fuCat.setIsparent(1);
			//更新
			deviceCatMapper.updateByPrimaryKey(fuCat);
		}
		return PubsResult.ok(devicecat);
	}
	@Override
	public void update(int id, String name) {
		Devicecat devicecat = deviceCatMapper.selectByPrimaryKey(id);
		Date date = new Date();
		devicecat.setUpdatetime(date);
		devicecat.setName(name);
		deviceCatMapper.updateByPrimaryKey(devicecat);
		
	}
	
	/**
	 * 删除节点：param：要删除的节点的id
	 * 
	 */
	@Override
	public void delete(int id) {
		//根据id查询该节点的属性
		Devicecat key = deviceCatMapper.selectByPrimaryKey(id);
		Integer parentid = key.getParentid();
		Integer isparent = deviceCatMapper.selectByPrimaryKey(id).getIsparent();
		if(isparent==0){
			//该节点不是父节点
			deviceCatMapper.deleteByPrimaryKey(id);	
			
		}else{
			//该节点是父节点,要删除其下所有节点
			DevicecatExample example = new DevicecatExample();
			Criteria criteria = example.createCriteria();
			criteria.andParentidEqualTo(id);
			deviceCatMapper.deleteByExample(example);
			deviceCatMapper.deleteByPrimaryKey(id);	
		}
		
		//根据节点id，获取parentid
		//int parentid = deviceCatMapper.selectParentId(id);
		//判断该节点的父节点有几个子节点，如果子节点数大于1，则不做任何修改，
		//如父节点下只有一个子节点，则父节点的状态改为open，即isparent 改为0
		int n = deviceCatMapper.selectCountByParentId(parentid);
		if(n==0){
			//父节点下只有一个子节点
			Devicecat devicecat = deviceCatMapper.selectByPrimaryKey(parentid);
			devicecat.setIsparent(0);
			deviceCatMapper.updateByPrimaryKey(devicecat);
			
		}
	}
	@Override
	public List<Devicecat> findAll() {
		DevicecatExample example = new DevicecatExample();
		List<Devicecat> list = deviceCatMapper.selectByExample(example);
		return list;
		
		
	}
	@Override
	public Devicecat selectById(int id) {
		Devicecat devicecat = deviceCatMapper.selectByPrimaryKey(id);
		return devicecat;
	}
	@Override
	public Devicecat selectById1(Integer groupId) {
		Devicecat devicecat = deviceCatMapper.selectByPrimaryKey(groupId);
		return devicecat;
	}
	/*@Override
	public  List<Devicecat> selectCatByParentId(int groupId) {
		DevicecatExample example = new DevicecatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(groupId);
		List<Devicecat> list = deviceCatMapper.selectByExample(example);
		return list;
	}*/
	@Override
	public List<Integer> selectByParent(Integer parentId) {
		DevicecatExample example = new DevicecatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentId);
		List<Integer> list = deviceCatMapper.selectIdsByParentId(parentId);
		return list;
	}
	
	



}
