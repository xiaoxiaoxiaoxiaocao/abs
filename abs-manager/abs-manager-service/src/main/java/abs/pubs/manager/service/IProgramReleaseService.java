package abs.pubs.manager.service;

import java.util.List;

import abs.pubs.domain.Programrelease;
/**
 * 发布服务service
 * @author 曹起坤
 *
 */
public interface IProgramReleaseService {
	
	/**
	 * 查找所有的programrelease
	 * @return
	 */
	List<Programrelease> findAllPlan()throws Exception;

}
