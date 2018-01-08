package abs.pubs.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.Programrelease;
import abs.pubs.domain.ProgramreleaseExample;
import abs.pubs.domain.ProgramreleaseExample.Criteria;
import abs.pubs.manager.service.IReleaseService;
import abs.pubs.mapper.ProgramreleaseMapper;

@Service
public class ReleaseServiceImpl implements IReleaseService {
	@Autowired
	private ProgramreleaseMapper releaseMapper;

	@Override
	public List<Programrelease> findFeleaseByDeviceId(Integer deviceId) {
		ProgramreleaseExample example = new ProgramreleaseExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeviceidEqualTo(deviceId);
		List<Programrelease> list = releaseMapper.selectByExample(example);
		return list;
	}

	@Override
	public void insert(Programrelease programrelease) {
		releaseMapper.insert(programrelease);
		
	}

	@Override
	public List<Programrelease> findFeleaseByCondition(int id, int playplanId) {
		ProgramreleaseExample example = new ProgramreleaseExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeviceidEqualTo(id);
		criteria.andPlayplanidEqualTo(playplanId);
		List<Programrelease> list = releaseMapper.selectByExample(example);
		return list;
	}

}
