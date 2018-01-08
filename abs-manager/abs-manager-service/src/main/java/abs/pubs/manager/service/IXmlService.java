package abs.pubs.manager.service;

import java.util.List;

import abs.pubs.domain.Pls;
import abs.pubs.domain.Res;

public interface IXmlService {

	List<Res> findDefaultRes();

	List<Pls> findAllPls();
	
	/**
	 * 根据areatype 查询所有符合该分屏样式的res
	 * @param id
	 * @return
	 */
	List<Res> findResByPlsId(Integer id);

}
