package abs.pubs.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.Role;
import abs.pubs.domain.RoleExample;
import abs.pubs.domain.RolePermission;
import abs.pubs.domain.RolePermissionExample;
import abs.pubs.domain.RolePermissionExample.Criteria;
import abs.pubs.domain.UserRoleExample;
import abs.pubs.manager.service.IRoleService;
import abs.pubs.mapper.RoleMapper;
import abs.pubs.mapper.RolePermissionMapper;
import abs.pubs.mapper.UserRoleMapper;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public List<Role> findRoleList() {
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		return list;
	}

	@Override
	public void insert(String name, String message,int[] ids) {
		Role role = new Role(name, message);
		roleMapper.insert(role);
		//向角色权限表中添加数据
		for (int id : ids) {
			RolePermission rolePermission = new RolePermission(role.getId(), id);
			rolePermissionMapper.insert(rolePermission);
		}
		
	}

	@Override
	public void deleteById(int id) {
		roleMapper.deleteByPrimaryKey(id);
		RolePermissionExample example = new RolePermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(id);
		rolePermissionMapper.deleteByExample(example);
		//操作用户角色表
		UserRoleExample userRoleExample = new UserRoleExample();
		abs.pubs.domain.UserRoleExample.Criteria userRoleCriteria = userRoleExample.createCriteria();
		userRoleCriteria.andRoleidEqualTo(id);
		userRoleMapper.deleteByExample(userRoleExample);
		
	}

	@Override
	public void updateById(Integer id, String name, String message,int[] pids) {
		Role role = roleMapper.selectByPrimaryKey(id);
		role.setComment(message);
		role.setName(name);
		roleMapper.updateByPrimaryKey(role);
		//操作角色权限表
		RolePermissionExample example = new RolePermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(id);
		rolePermissionMapper.deleteByExample(example);
		for (int pid : pids) {
			RolePermission rolePermission = new RolePermission(id, pid);
			rolePermissionMapper.insert(rolePermission);
		}
		
		
	}

}
