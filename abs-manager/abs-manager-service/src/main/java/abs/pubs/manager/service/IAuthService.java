package abs.pubs.manager.service;

import java.util.Set;

import abs.pubs.domain.User;
/**
 * 权限相关service层
 * @author 曹起坤
 *
 */
public interface IAuthService {
	/**
	 * 根据用户名查询user对象
	 * @param principal
	 * @return
	 */
	User findUserByName(String principal);
	
	
	/**
	 * 通过用户id，查询用户的所有的权限
	 * @param id
	 * @return
	 */
	Set<String> findPermissionByUserId(Integer id);
	
}
