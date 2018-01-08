package abs.pubs.manager.service.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.MaterialResult;
import abs.pubs.manager.service.IStatisticsService;
import abs.pubs.mapper.MaterialMapper;
@Service
public class StatisticsServiceImpl implements IStatisticsService {
	@Autowired
	private MaterialMapper materialMapper;

	@Override
	public List<Map<String, Object>> findSumByType() {
		List<Map<String, Object>> list=materialMapper.findSumByType();
		return list;
	}

	@Override
	public List<MaterialResult> findStatisticsMaterial() {
		List<MaterialResult> list = materialMapper.findStatisticsMaterial();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<MaterialResult> findStatisticsArea() {
		List<MaterialResult> list=materialMapper.findStatisticsArea();
		return list;
	}

}
