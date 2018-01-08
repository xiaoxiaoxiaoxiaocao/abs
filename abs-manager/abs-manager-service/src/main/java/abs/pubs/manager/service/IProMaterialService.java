package abs.pubs.manager.service;

import abs.pubs.domain.ProMaterial;
/**
 * 素材相关service
 * @author kun
 *
 */
public interface IProMaterialService {
	//保存素材详情
	public void save(ProMaterial proMaterial)throws Exception;
	
	/**
	 * 通过id查询素材id
	 */
	public String findDetailById(Integer id)throws Exception;
	
	/**
	 * 通过id删除文件
	 */
	public void deleteById(String[] ids)throws Exception;
}
