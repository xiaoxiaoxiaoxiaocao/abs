package abs.pubs.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.Permission;
import abs.pubs.domain.PermissionExample;
import abs.pubs.manager.service.IPermissionService;
import abs.pubs.mapper.PermissionMapper;
@Service
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> findAllPermission() {
		PermissionExample example = new PermissionExample();
		List<Permission> list = permissionMapper.selectByExample(example);
		return list;
	}

	@Override
	public void insert(String name, String url, String pcode, String mark) {
		Permission permission = new Permission();
		permission.setName(name);
		permission.setPcode(pcode);
		permission.setUrl(url);
		if(mark != null && mark.trim().length()>0){
			permission.setRemark(mark);
		}
		permissionMapper.insert(permission);
	}

	@Override
	public void deleteById(int id) {
		permissionMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void updateById(Integer id, String name, String url, String pcode, String mark) {
		Permission permission = permissionMapper.selectByPrimaryKey(id);
		permission.setName(name);
		permission.setPcode(pcode);
		permission.setRemark(mark);
		permission.setUrl(url);
		permissionMapper.updateByPrimaryKey(permission);
		
	}

	

}
