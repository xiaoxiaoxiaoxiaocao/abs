package abs.pubs.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Material;
import abs.pubs.domain.MaterialExample;
import abs.pubs.domain.MaterialExample.Criteria;
import abs.pubs.domain.User;
import abs.pubs.manager.service.IMaterialServicce;
import abs.pubs.mapper.MaterialMapper;
import abs.pubs.mapper.UserRoleMapper;

@Service
public class MaterialServiceImpl implements IMaterialServicce {
	@Autowired
	private MaterialMapper materialMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Override
	public void savePsd(Material psd) {
		
		materialMapper.insert(psd);
		
	}

	@Override
	public Material findById(int id) {
		Material material = materialMapper.selectByPrimaryKey(id);
		return material;
	}

	@Override
	public void delete(int id) throws Exception {
		MaterialExample example = new MaterialExample();
		 Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		materialMapper.deleteByExample(example);
	}
	
	@Override
	public EasyUIResult findAllByPage(int page, int rows,int id) {
		MaterialExample example = new MaterialExample();
		Criteria criteria = example.createCriteria();
		/*
		User user =(User)SecurityUtils.getSubject().getPrincipal();
		//获取当前用户所属角色
		int roleId = userRoleMapper.selectRoleIdByUserId(user.getId());
		//如果不是系统管理员，则只能看到自己的素材
		if(roleId != 1){
			criteria.andAdduseridEqualTo(user.getId());
			criteria.andStateEqualTo((short) 2);
		}*/
		if(id != -1){
			criteria.andTypeEqualTo(id);
		}
		example.setOrderByClause("id desc");
		PageHelper.startPage(page, rows);
		List<Material> list = materialMapper.selectByExample(example);
		PageInfo<Material> info = new PageInfo<Material>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(info.getTotal());
		return easyUIResult;
	}
	
	@Override
	public EasyUIResult newProList(int page, int rows) {
		MaterialExample example = new MaterialExample();
		Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo((short) 2);
		User user =(User)SecurityUtils.getSubject().getPrincipal();
	/*	int roleId = userRoleMapper.selectRoleIdByUserId(user.getId());
		//如果不是系统管理员，则只能看到自己的素材
		if(roleId != 1){
			criteria.andAdduseridEqualTo(user.getId());
		}*/
		PageHelper.startPage(page, rows);
		List<Material> list = materialMapper.selectByExample(example);
		PageInfo<Material> info = new PageInfo<Material>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(info.getTotal());
		return easyUIResult;
	}

	@Override
	public void check_ok(int id,User user) {
		Material material = materialMapper.selectByPrimaryKey(id);
		material.setState((short)2);
		Date date = new Date(System.currentTimeMillis());
		material.setChecktime(date);
		if(user != null){
			material.setCheckuserid(user.getId());
		}
		materialMapper.updateByPrimaryKey(material);
	}

	@Override
	public void check_no(int id,User user) {
		Material material = materialMapper.selectByPrimaryKey(id);
		
		material.setState((short)1);
		Date date = new Date(System.currentTimeMillis());
		material.setChecktime(date);
		if(user != null){
			material.setCheckuserid(user.getId());
		}
		materialMapper.updateByPrimaryKey(material);
		
	}

	@Override
	public void update(String[] split) {
		Material material= materialMapper.selectByPrimaryKey(Integer.parseInt(split[0]));
		material.setTimesize(Integer.parseInt(split[1]));
		materialMapper.updateByPrimaryKeySelective(material);
		
	}

	@Override
	public void deleteFromDisk(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void countSameName(int id) {
		// TODO Auto-generated method stub	
	}

	

	@Override
	public List<Material> findAllByName(String name) {
		MaterialExample example = new MaterialExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<Material> list = materialMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Material> findAllZips() {
		MaterialExample example = new MaterialExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(2);
		criteria.andStateEqualTo((short) 2);
		List<Material> list = materialMapper.selectByExample(example);
		
		return list;
	}

	/*@Override
	public void update(Material material) {
		materialMapper.updateByPrimaryKeySelective(material);
		
	}*/

	

	

}
