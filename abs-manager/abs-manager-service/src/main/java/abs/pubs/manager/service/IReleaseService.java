package abs.pubs.manager.service;

import java.util.List;

import abs.pubs.domain.Programrelease;
/**
 * 发布服务相关service
 * @author 曹起坤
 *
 */
public interface IReleaseService {
	public List<Programrelease> findFeleaseByDeviceId(Integer deviceId)throws Exception;
	
	/**
	 * 保存
	 * @param programrelease
	 */
	public void insert(Programrelease programrelease);

	/**
	 * 
	 * @param id
	 * @param playplanId
	 */
	public List<Programrelease> findFeleaseByCondition(int id, int playplanId);

}
