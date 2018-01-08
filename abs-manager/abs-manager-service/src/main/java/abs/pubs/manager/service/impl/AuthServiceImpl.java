package abs.pubs.manager.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.Permission;
import abs.pubs.domain.RolePermission;
import abs.pubs.domain.RolePermissionExample;
import abs.pubs.domain.User;
import abs.pubs.domain.UserExample;
import abs.pubs.domain.UserExample.Criteria;
import abs.pubs.domain.UserRole;
import abs.pubs.domain.UserRoleExample;
import abs.pubs.manager.service.IAuthService;
import abs.pubs.mapper.PermissionMapper;
import abs.pubs.mapper.RolePermissionMapper;
import abs.pubs.mapper.UserMapper;
import abs.pubs.mapper.UserRoleMapper;

@Service
public class AuthServiceImpl implements IAuthService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	@Override
	public User findUserByName(String principal) {
		//User user = userMapper.selectByUsername(principal);
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(principal);
		List<User> list = userMapper.selectByExample(example);
		if(list!= null && list.size()==1){
			return list.get(0);	
		}
		
		return null;
	}
	@Override
	public Set<String> findPermissionByUserId(Integer id) {
		List<Integer> permList = new ArrayList<Integer>();
		HashSet<String> pcodeset = new HashSet<String>();
		//ArrayList<String> pcodeList = new ArrayList<>();
	
		//1 查询用户
		//User user = userMapper.selectByPrimaryKey(id);
		//2 获得用户所有角色id,放入list集合中
		UserRoleExample example = new UserRoleExample();
		abs.pubs.domain.UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);
		List<UserRole> list = userRoleMapper.selectByExample(example);
		
		for (UserRole userRole : list) {
			Integer roleid = userRole.getRoleid();
			permList.add(roleid);
		}
		//遍历角色id的集合，查找对应的权限集合
		for (Integer integer : permList) {
			RolePermissionExample rolePermissionExample = new RolePermissionExample();
			abs.pubs.domain.RolePermissionExample.Criteria createCriteria = rolePermissionExample.createCriteria();
			createCriteria.andRoleidEqualTo(integer);
			List<RolePermission> rolePermissionList = rolePermissionMapper.selectByExample(rolePermissionExample);
			for (RolePermission rolePermission : rolePermissionList) {
				Integer permissionid = rolePermission.getPermissionid();
				Permission permission = permissionMapper.selectByPrimaryKey(permissionid);
				String pcode = permission.getPcode();
				pcodeset.add(pcode);
			}
		}
		
		return pcodeset;
	}



}
