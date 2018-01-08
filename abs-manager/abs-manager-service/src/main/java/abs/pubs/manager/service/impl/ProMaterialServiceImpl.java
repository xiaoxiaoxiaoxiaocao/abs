package abs.pubs.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abs.pubs.domain.ProMaterial;
import abs.pubs.manager.service.IProMaterialService;
import abs.pubs.mapper.ProMaterialMapper;

@Service
public class ProMaterialServiceImpl implements IProMaterialService {
	@Autowired
	private ProMaterialMapper mapper;

	@Override
	public void save(ProMaterial proMaterial) {
		mapper.insert(proMaterial);	

	}

	@Override
	public String findDetailById(Integer id) {
		
		ProMaterial proMaterial= mapper.selectByPrimaryKey(id);
		if(proMaterial != null){
			String psdId = proMaterial.getMaterialId();
			return psdId;
		}else{
			return null;
		}
	}

	@Override
	public void deleteById(String[] ids) {
		for (String id : ids) {
			mapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
		
	}

}
