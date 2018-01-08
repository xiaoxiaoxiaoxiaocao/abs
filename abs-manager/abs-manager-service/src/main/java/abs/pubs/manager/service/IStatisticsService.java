package abs.pubs.manager.service;

import java.util.List;
import java.util.Map;
import abs.pubs.domain.MaterialResult;


public interface IStatisticsService {
	/**
	 * 根据类型分组查询素材的总数
	 * @return
	 */
	List<Map<String,Object>> findSumByType();

	List<MaterialResult> findStatisticsMaterial();

	List<MaterialResult> findStatisticsArea();

}
