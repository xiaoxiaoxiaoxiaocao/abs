package abs.pubs.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.Playplan;
import abs.pubs.domain.PlayplanExample;
import abs.pubs.domain.PlayplanExample.Criteria;
import abs.pubs.manager.service.IPlayPlanService;
import abs.pubs.mapper.PlayplanMapper;

@Service
public class PlayPlanServiceImpl implements IPlayPlanService {
	@Autowired
	private PlayplanMapper planMapper;

/*	@Override
	public void savePlayPlan(Playplan plan) throws Exception {
		planMapper.insert(plan);

	}@Override
	public Playplan findPlayPlan(String zipname, String name) {
		PlayplanExample example = new PlayplanExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		//criteria.andPropackageEqualTo(zipname);
		Playplan plan = planMapper.selectByExample(example).get(0);
		return plan;
	}	@Override
	public void update(Playplan plan) {
		planMapper.updateByPrimaryKeySelective(plan);
		
	}*/

	@Override
	public List<Playplan> findAllPlan() {
		PlayplanExample example = new PlayplanExample();
		List<Playplan> list = planMapper.selectByExample(example);
		return list;
	}

	@Override
	public void save(Playplan playplan) {
		planMapper.insert(playplan);
		
	}

	@Override
	public Integer findMaxId() {
		int maxId = planMapper.findMaxId();
		return maxId;
	}

	

	

}
