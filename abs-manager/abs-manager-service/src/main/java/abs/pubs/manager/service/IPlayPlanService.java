package abs.pubs.manager.service;

import java.util.List;
import abs.pubs.domain.Playplan;
/**
 * 播放计划相关service
 * @author 曹起坤
 *
 */
public interface IPlayPlanService {

	/**
	 * 查找所有的plan
	 * @param split
	 */
	public List<Playplan> findAllPlan()throws Exception;

	public void save(Playplan playplan);

	public Integer findMaxId();

}
