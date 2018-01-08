package abs.pubs.manager.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Program;
import abs.pubs.domain.ProgramExample;
import abs.pubs.domain.ProgramExample.Criteria;
import abs.pubs.domain.User;
import abs.pubs.manager.service.IProgramService;
import abs.pubs.mapper.ProgramMapper;
import abs.pubs.mapper.UserRoleMapper;

@Service("iProgramService")
@WebService(endpointInterface="abs.pubs.manager.service.IProgramService",serviceName="syncprogram",targetNamespace="http://service.manager.pubs.abs/")  
public class ProgramServiceImpl implements IProgramService {
	@Autowired
	private ProgramMapper mapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public EasyUIResult findProList(int page, int rows) {
		ProgramExample example = new ProgramExample();
		Criteria criteria = example.createCriteria();
		//获取其当前用户
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		int roleId = userRoleMapper.selectRoleIdByUserId(user.getId());
		if(roleId != 1){
			//如果该用户所属角色不是系统管理员，则只能看到自己打包的节目包
			criteria.andZipuseridEqualTo(user.getId());
		}
		PageHelper.startPage(page, rows);
		List<Program> list = mapper.selectByExample(example);
		PageInfo<Program> info = new PageInfo<Program>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(info.getTotal());
		
		return easyUIResult;
	}

	@Override
	public int findMaxId() {
		Integer maxId = mapper.selectMaxId();
		return maxId;
	}

	@Override
	public int findTotal() {
		ProgramExample example = new ProgramExample();
		int total = mapper.countByExample(example);
		
		return total;
	}

	@Override
	public void savePro(Program program) {
		mapper.insert(program);
		
	}

	@Override
	public void proDelete(String[] ids){
		for (String id : ids) {
		 mapper.deleteByPrimaryKey(Integer.parseInt(id));	
		}
		
	}

	@Override
	public Program findProById(Integer id) {
		Program program = mapper.selectByPrimaryKey(id);	
		return program;
	}

	@Override
	public void addList(int id) {
		Program program = mapper.selectByPrimaryKey(id);
		program.setAddlist((byte)1);
		mapper.updateByPrimaryKeySelective(program);
		
	}

	@Override
	public EasyUIResult findPlayList(int page, int rows) {
		PageHelper.startPage(page, rows);
		ProgramExample example = new ProgramExample();
		Criteria criteria = example.createCriteria();
		criteria.andAddlistEqualTo((byte)1);
		List<Program> list = mapper.selectByExample(example);
		PageInfo<Program> info = new PageInfo<Program>(list);
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(info.getTotal());
		return easyUIResult;
	}

	@Override
	public void playListDelete(int id) {
		Program program = mapper.selectByPrimaryKey(id);
		program.setAddlist((byte)0);
		mapper.updateByPrimaryKeySelective(program);
	}

	

	


}
