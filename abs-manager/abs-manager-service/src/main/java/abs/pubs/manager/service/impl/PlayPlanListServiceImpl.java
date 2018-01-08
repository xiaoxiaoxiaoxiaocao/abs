package abs.pubs.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.Playplanlist;
import abs.pubs.domain.PlayplanlistExample;
import abs.pubs.domain.PlayplanlistExample.Criteria;
import abs.pubs.domain.Program;
import abs.pubs.manager.service.IPlayPlanListService;
import abs.pubs.mapper.PlayplanlistMapper;
import abs.pubs.mapper.ProgramMapper;

@Service
public class PlayPlanListServiceImpl implements IPlayPlanListService {
	@Autowired
	private PlayplanlistMapper playplanlistMapper;
	
	@Autowired
	private ProgramMapper programMapper;

	@Override
	public void savePlayPlanList(Playplanlist playplanlist) throws Exception {
		playplanlistMapper.insert(playplanlist);

	}

	@Override
	public Playplanlist findPlayPlanList(String zipname, String name) {
		PlayplanlistExample example = new PlayplanlistExample();
		Criteria criteria = example.createCriteria();
		//criteria.andNameEqualTo(name);
		criteria.andPropackageEqualTo(zipname);
		Playplanlist playplanList = playplanlistMapper.selectByExample(example).get(0);
		return playplanList;
	}

	@Override
	public void update(Playplanlist playplanList) {
		playplanlistMapper.updateByPrimaryKeySelective(playplanList);
		
	}

	@Override
	public void deleteByids(String[] ids) {
		//遍历ids，获取每一个program的id，通过id查询节目包名
		for (String id : ids) {
			Program program = programMapper.selectByPrimaryKey(Integer.parseInt(id));
			String zipname = program.getZipname();
			PlayplanlistExample example = new PlayplanlistExample();
			Criteria criteria = example.createCriteria();
			criteria.andPropackageEqualTo(zipname);
			playplanlistMapper.deleteByExample(example);
		}
		
	}

	

	

	

	

}
