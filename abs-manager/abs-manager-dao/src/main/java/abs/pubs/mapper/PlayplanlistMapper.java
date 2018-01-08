package abs.pubs.mapper;

import abs.pubs.domain.Playplanlist;
import abs.pubs.domain.PlayplanlistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayplanlistMapper {
    int countByExample(PlayplanlistExample example);

    int deleteByExample(PlayplanlistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Playplanlist record);

    int insertSelective(Playplanlist record);

    List<Playplanlist> selectByExample(PlayplanlistExample example);

    Playplanlist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Playplanlist record, @Param("example") PlayplanlistExample example);

    int updateByExample(@Param("record") Playplanlist record, @Param("example") PlayplanlistExample example);

    int updateByPrimaryKeySelective(Playplanlist record);

    int updateByPrimaryKey(Playplanlist record);

    /**
     * 删除playplanid与planid相等的数据
     * @param planId
     */
	void deleteByPlayplanid(@Param("planId") Integer planId);
}