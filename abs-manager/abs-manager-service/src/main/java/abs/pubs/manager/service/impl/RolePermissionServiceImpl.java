package abs.pubs.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.RolePermission;
import abs.pubs.domain.RolePermissionExample;
import abs.pubs.domain.RolePermissionExample.Criteria;
import abs.pubs.manager.service.IRolePermissionService;
import abs.pubs.mapper.RolePermissionMapper;

@Service
public class RolePermissionServiceImpl implements IRolePermissionService {
	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	@Override
	public List<Integer> findPermissionsByRoleId(int id) {
		ArrayList<Integer> arr = new ArrayList<>();
		RolePermissionExample example = new RolePermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(id);
		List<RolePermission> list = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : list) {
			arr.add(rolePermission.getPermissionid());
		}
		return arr;
	}

}
