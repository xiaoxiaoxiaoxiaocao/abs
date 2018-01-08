package abs.pubs.mapper;

import abs.pubs.domain.Devicecat;
import abs.pubs.domain.DevicecatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevicecatMapper {
    int countByExample(DevicecatExample example);

    int deleteByExample(DevicecatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Devicecat record);

    int insertSelective(Devicecat record);

    List<Devicecat> selectByExample(DevicecatExample example);

    Devicecat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Devicecat record, @Param("example") DevicecatExample example);

    int updateByExample(@Param("record") Devicecat record, @Param("example") DevicecatExample example);

    int updateByPrimaryKeySelective(Devicecat record);

    int updateByPrimaryKey(Devicecat record);
    
    /**
     * 查询该 父节点下共有几个子节点
     * @param parentid
     */
	int selectCountByParentId(int parentid);
	/**
	 * 根据节点id获取parentid
	 * @param id
	 * @return
	 */
	int selectParentId(Integer id);

	List<Integer> selectIdsByParentId(int id);

	int selectPidById(int id);
}