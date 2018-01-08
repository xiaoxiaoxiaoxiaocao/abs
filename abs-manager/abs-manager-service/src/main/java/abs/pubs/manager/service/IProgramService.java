package abs.pubs.manager.service;

import javax.jws.WebService;

import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Program;
/**
 * 节目包相关service
 * @author 曹起坤
 *
 */
@WebService()
public interface IProgramService {
	/**
	 * 分页查询节目包
	 * @return
	 */
	
	public EasyUIResult findProList(int page,int rows)throws Exception;
	
	
	/**
	 * 查询最大id
	 */
	public int findMaxId()throws Exception;
	
	/**
	 * 查询表中记录总条数
	 */
	public int findTotal()throws Exception;
	
	/**
	 * 保存program
	 */
	public void savePro(Program program)throws Exception;

	/**
	 * 删除节目包
	 * @param ids
	 */
	public void proDelete(String[] ids)throws Exception;
	
	/**
	 * 通过id查询节目包
	 */
	public Program findProById(Integer id)throws Exception;

	
	/**
	 * 把选择的节目包添加到播放单，只要把addList设置为1；
	 * @param parseInt
	 */
	public void addList(int parseInt)throws Exception;

	/**
	 * 查询加入播放单的节目包，即addList=1
	 * @param page
	 * @param rows
	 * @return
	 */
	public EasyUIResult findPlayList(int page, int rows)throws Exception;

	/**
	 * 删除播放单中的节目包
	 * @param parseInt
	 */
	public void playListDelete(int parseInt)throws Exception;

	
	
	

}
