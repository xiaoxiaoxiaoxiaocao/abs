package abs.pubs.manager.service;

import java.util.List;

import abs.pubs.domain.Role;

public interface IRoleService {

	List<Role> findRoleList();

	void insert(String name, String message, int[] pids);

	void deleteById(int id);

	void updateById(Integer id, String name, String message, int[] pids);
	

}
