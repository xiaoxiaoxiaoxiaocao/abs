package abs.pubs.manager.service;

import java.util.List;

import abs.pubs.domain.Permission;

public interface IPermissionService {

	List<Permission> findAllPermission();

	void insert(String name, String url, String pcode, String mark);

	void deleteById(int id);

	void updateById(Integer id, String name, String url, String pcode, String mark);



}
