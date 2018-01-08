package abs.pubs.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import abs.pubs.domain.City;
import abs.pubs.domain.CityExample;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Province;
import abs.pubs.domain.ProvinceExample;
import abs.pubs.domain.Role;
import abs.pubs.domain.RoleExample;
import abs.pubs.domain.User;
import abs.pubs.domain.UserExample;
import abs.pubs.domain.UserRole;
import abs.pubs.domain.UserRoleExample;
import abs.pubs.domain.Usercat;
import abs.pubs.domain.UsercatExample;
import abs.pubs.domain.UserExample.Criteria;
import abs.pubs.manager.service.IUserService;
import abs.pubs.mapper.CityMapper;
import abs.pubs.mapper.ProvinceMapper;
import abs.pubs.mapper.RoleMapper;
import abs.pubs.mapper.UserMapper;
import abs.pubs.mapper.UserRoleMapper;
import abs.pubs.mapper.UsercatMapper;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private UsercatMapper userCatMapper;
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Autowired
	private CityMapper cityMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	public List<User> checkLogin(String username,String password ) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		return list;
	}
	@Override
	public User findUserById(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	
	@Override
	public EasyUIResult findAllUser(int page, int rows) {
		UserExample example = new UserExample();
		example.setOrderByClause("id desc");
		PageHelper.startPage(page, rows);
		List<User> list = userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(pageInfo.getTotal());
		return easyUIResult;
	}
	@Override
	public int selectCountByUsername(String username) {
		//int i = userMapper.selectCountByUsername(username);
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		int i = userMapper.countByExample(example);
		return i;
	}
	@Override
	public void addUser(String username, String password, int[] role, int belongId) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUsercatid(belongId);
		userMapper.insert(user);
		//设置用户角色
		for (int id : role) {
			UserRole userRole = new UserRole();
			userRole.setUserid(user.getId());
			userRole.setRoleid(id);
			userRoleMapper.insert(userRole);
		}
		
	}
	@Override
	public void deleteById(int id) {
		userMapper.deleteByPrimaryKey(id);
		UserRoleExample example = new UserRoleExample();
		abs.pubs.domain.UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);
		userRoleMapper.deleteByExample(example);
		
	}
	
	@Override
	public void updateUser(int id,String username,String password,int[] role,int reOrgan) {
		//User user = new User();
		//user.setId(id);
		User user = userMapper.selectByPrimaryKey(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setUsercatid(reOrgan);
		userMapper.updateByPrimaryKey(user);
		//更改用户角色
		UserRoleExample example = new UserRoleExample();
		abs.pubs.domain.UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);
		userRoleMapper.deleteByExample(example);
		if(role != null && role.length>0){
			for (int roleid : role) {
				UserRole userRole = new UserRole();
				userRole.setRoleid(roleid);
				userRole.setUserid(id);
				userRoleMapper.insert(userRole);
			}
		}
		
	}
	/*@Override
	public EasyUIResult findAllGroup(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		UsercatExample example = new UsercatExample();
		PageHelper.startPage(page, rows);
		List<Usercat> list = userCatMapper.selectByExample(example);
		EasyUIResult easyUIResult = new EasyUIResult();
		PageInfo<Usercat> info = new PageInfo<>(list);
		easyUIResult.setRows(list);
		easyUIResult.setTotal(info.getTotal());
		return easyUIResult;
	}*/
	@Override
	public String findGroupNameById(int groupId) {
		String name="";
		Usercat usercat = userCatMapper.selectByPrimaryKey(groupId);
		ProvinceExample example = new ProvinceExample();
		if(usercat != null){
			Integer cId = usercat.getCityid();
			City city= cityMapper.selectByPrimaryKey(cId);
			abs.pubs.domain.ProvinceExample.Criteria criteria = example.createCriteria();
			criteria.andCodeEqualTo(city.getProvincecode());
			List<Province> list = provinceMapper.selectByExample(example);
			name=list.get(0).getName()+city.getName()+usercat.getName();
		}
		return name;
	}
	@Override
	public List<Usercat> findAllGroup() {
		UsercatExample example = new UsercatExample();
		example.setOrderByClause("id desc");
		List<Usercat> list = userCatMapper.selectByExample(example);
		return list;
	}
	@Override
	public void addOrgan(Integer id, String name,int city) {
		Usercat usercat = new Usercat(id,city, name, 0);
		userCatMapper.insert(usercat);
		//设置父机构为1
		Usercat pUsercat = userCatMapper.selectByPrimaryKey(id);
		if(pUsercat.getIsparent()==0){
			pUsercat.setIsparent(1);
			userCatMapper.updateByPrimaryKey(pUsercat);
		}
		
	}
	@Override
	public int findCountByOrganName(String name) {
		UsercatExample example = new UsercatExample();
		abs.pubs.domain.UsercatExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		int i = userCatMapper.countByExample(example);
		return i;
	}
	
	@Override
	public void deleteOrganById(int i) {
		userCatMapper.deleteByPrimaryKey(i);
	}
	@Override
	public void editOrgenById(int id, String name, int pId) {
		Usercat usercat = userCatMapper.selectByPrimaryKey(id);
		if(usercat != null){
			usercat.setName(name);
			usercat.setParentid(pId);
		}
		userCatMapper.updateByPrimaryKey(usercat);
	}
	@Override
	public String selectOrganNameById(int id) {
		Usercat usercat = userCatMapper.selectByPrimaryKey(id);
		if(usercat != null){
			return usercat.getName();
		}else{
			return null;
		}
	}
	@Override
	public List<Province> findAllProvinces() {
		ProvinceExample example = new ProvinceExample();
		List<Province> list = provinceMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public List<City> findCitiesByPcode(String code) {
		CityExample example = new CityExample();
		abs.pubs.domain.CityExample.Criteria criteria = example.createCriteria();
		criteria.andProvincecodeEqualTo(code);
		List<City> list = cityMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public String getCodeByProvinceId(int provinceId) {
		Province province = provinceMapper.selectByPrimaryKey(provinceId);
		if(province != null){
			return province.getCode();
		}
		return null;
	}
	
	@Override
	public List<Role> findAllRoles() {
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		return list;
	}
/*	@Override
	public int getRoleById(Integer id) {
		UserRoleExample example = new UserRoleExample();
		abs.pubs.domain.UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);
		List<UserRole> list = userRoleMapper.selectByExample(example);
		if(list != null && list.size()>0){
			return list.get(0).getRoleid();
		}
		int roleId = userRoleMapper.selectRoleIdByUserId(id);
		return roleId;
		return 0;
	}*/

	@Override
	public List<Integer> findRoleById(Integer id) {
		UserRoleExample example = new UserRoleExample();
		abs.pubs.domain.UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);
		List<UserRole> list = userRoleMapper.selectByExample(example);
		ArrayList<Integer> ids = new ArrayList<Integer>();
		if(list != null && list.size()>0){
			for (UserRole userRole : list) {
				ids.add(userRole.getRoleid());
			}
		}
		return ids;
	}

}
