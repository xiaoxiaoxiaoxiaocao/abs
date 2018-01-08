package abs.pubs.manager.service;

import abs.pubs.domain.Playplanlist;
/**
 * 播放计划相关service 层
 * @author kun
 *
 */
public interface IPlayPlanListService {
	/**
	 * 保存播放计划
	 * @param playplanList
	 * @throws Exception
	 */
	public void savePlayPlanList(Playplanlist playplanList)throws Exception;
	
	
	/**
	 * 根据计划名称和节目包名查询对应素材,第一个参数为节目包名称，第二个参数为playplanList名称
	 */
	Playplanlist findPlayPlanList(String zipname, String name)throws Exception;

	/**
	 * 修改时长，更新到数据库
	 * @param playplanList
	 */
	public void update(Playplanlist playplanList)throws Exception;


	public void deleteByids(String[] ids)throws Exception;


	
	
	/**
	 * 修改playplanList中的时长三个参数分别为名称，新的计划时长,节目包的名称
	 * @param split
	 */


}
