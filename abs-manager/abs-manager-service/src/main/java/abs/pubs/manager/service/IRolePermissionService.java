package abs.pubs.manager.service;

import java.util.List;


public interface IRolePermissionService {

	List<Integer> findPermissionsByRoleId(int id);

}
