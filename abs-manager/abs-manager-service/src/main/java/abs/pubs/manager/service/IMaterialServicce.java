package abs.pubs.manager.service;

import java.util.List;

import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Material;
import abs.pubs.domain.User;
/**
 * 素材相关service层
 * @author 曹起坤
 *
 */
public interface IMaterialServicce {
	/**
	 * 分页查询素材列表
	 */
	public EasyUIResult findAllByPage(int page,int rows,int id)throws Exception;
	
	/**
	 * 查询状态为审核通过的素材，用于创建节目包
	 * @param page
	 * @param rows
	 * @return
	 */
	public EasyUIResult newProList(int page, int rows)throws Exception;
	
	/**
	 * 保存素材
	 */
	public void savePsd(Material psd)throws Exception;
	
	
	
	/**
	 * 根据id 查找对应的素材
	 */
	public Material findById(int id)throws Exception;
	
	
	/**
	 * 删除指定的素材
	 */
	public void delete(int id)throws Exception;
	
	/**
	 * 审核通过
	 * @param parseInt
	 */
	public void check_ok(int parseInt,User user)throws Exception;
	
	/**
	 * 审核不通过
	 * @param parseInt
	 */
	public void check_no(int parseInt,User user)throws Exception;
	
	/**
	 * 更新素材的时长
	 * @param split
	 */
	public void update(String[] split)throws Exception;
	/**
	 * 根据实体类更新
	 * @param psd
	 */
	//public void update(Material psd);
	
	public void deleteFromDisk(int id);
	
	/**
	 * 去数据库查询该素材的个数
	 * @param id
	 */
	public void countSameName(int id);


	public List<Material> findAllByName(String name);

	public List<Material> findAllZips();
	
	
	
	
	
}
