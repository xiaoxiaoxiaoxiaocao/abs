package abs.pubs.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.Programrelease;
import abs.pubs.domain.ProgramreleaseExample;
import abs.pubs.manager.service.IProgramReleaseService;
import abs.pubs.mapper.ProgramreleaseMapper;
@Service
public class ProgramReleaseServiceImpl implements IProgramReleaseService {
	
	@Autowired
	private ProgramreleaseMapper ProgramreleaseMapper;
	@Override
	public List<Programrelease> findAllPlan() {
		ProgramreleaseExample example = new ProgramreleaseExample();
		List<Programrelease> list = ProgramreleaseMapper.selectByExample(example);
		return list;
	}

}
