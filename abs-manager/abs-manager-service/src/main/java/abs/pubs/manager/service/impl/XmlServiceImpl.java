package abs.pubs.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.Pls;
import abs.pubs.domain.PlsExample;
import abs.pubs.domain.Res;
import abs.pubs.domain.ResExample;
import abs.pubs.domain.ResExample.Criteria;
import abs.pubs.manager.service.IXmlService;
import abs.pubs.mapper.PlsMapper;
import abs.pubs.mapper.ResMapper;

@Service
public class XmlServiceImpl implements IXmlService {
	@Autowired
	private ResMapper resMapper;
	@Autowired
	private PlsMapper plsMapper;

	@Override
	public List<Res> findDefaultRes(){
		ResExample example = new ResExample();
		Criteria criteria = example.createCriteria();
		criteria.andDefauEqualTo((byte)1);
		List<Res> list = resMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public List<Pls> findAllPls() {
		PlsExample example = new PlsExample();
		List<Pls> list = plsMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public List<Res> findResByPlsId(Integer id) {
		ResExample example = new ResExample();
		Criteria criteria = example.createCriteria();
		criteria.andPlsIdEqualTo(id);
		List<Res> list = resMapper.selectByExample(example);
		return list;
	}

}
