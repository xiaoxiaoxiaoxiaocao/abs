package abs.pubs.manager.service;

import java.util.List;

import abs.pubs.domain.Devicecat;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.utils.EasyUITreeNode;
import abs.pubs.utils.PubsResult;
/**
 * tree相关service层
 * @author 曹起坤
 *
 */
public interface IDeviceCatServcie {
	/**
	 * 加载素材类目
	 * 根据父id查询子节点
	 * 返回值是list<EasyUITreeNode>
	 */
	public List<EasyUITreeNode> findDeviceCat(Integer id);
	
	/**
	 * 创建新节点
	 * @param devicecat
	 * @return
	 */
	public PubsResult createNode(Devicecat devicecat);
	
	/**
	 * 更新节点
	 * @param devicecat
	 */

	public void update(int id, String name);

	/**
	 * 删除节点
	 * @param parentid
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 查询所有的分类
	 */
	public List<Devicecat> findAll();
	
	/**
	 * 查询分组对象
	 * @param id
	 * @return
	 */
	public Devicecat selectById(int id);

	public Devicecat selectById1(Integer groupId);
	
	/**
	 * 查询父节点下的所有子节点
	 */
	public List<Integer> selectByParent(Integer parentId); 

	

}
