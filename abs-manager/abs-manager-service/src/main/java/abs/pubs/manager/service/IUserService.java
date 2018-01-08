package abs.pubs.manager.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import abs.pubs.domain.City;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Province;
import abs.pubs.domain.Role;
import abs.pubs.domain.User;
import abs.pubs.domain.Usercat;
/**
 * 用户相关service
 * @author 曹起坤
 *
 */
public interface IUserService {
	/**
	 * 根据用户名密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	public List<User> checkLogin(String username,String password )throws Exception;

	public User findUserById(int id);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public EasyUIResult findAllUser(int page, int rows);
	/**
	 * 查询该用户名是否存在
	 * @param username
	 * @return
	 */
	public int selectCountByUsername(String username);
	
	/**
	 * 新增用户
	 * @param username
	 * @param password
	 * @param belongName 
	 * @param role 
	 */
	public void addUser(String username, String password, int[] role, int belongName);
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void deleteById(int id);
	/**
	 * 更新用户信息
	 * @param reOrgan 
	 * @param user
	 */
	public void updateUser(int id,String username,String password,int[] reRole, int reOrgan);

	/*public EasyUIResult findAllGroup(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows);*/

	public String findGroupNameById(int groupId);

	public List<Usercat> findAllGroup();

	public void addOrgan(Integer id, String name, int city);

	public int findCountByOrganName(String name);

	public void deleteOrganById(int i);

	public void editOrgenById(int id, String name, int pId);

	public String selectOrganNameById(int id);

	public List<Province> findAllProvinces();

	public List<City> findCitiesByPcode(String code);
	public String getCodeByProvinceId(int provinceId);

	//public int getRoleById(Integer id);

	public List<Role> findAllRoles();

	public List<Integer> findRoleById(Integer id);

}
