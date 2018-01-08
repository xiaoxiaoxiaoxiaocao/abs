package abs.pubs.mapper;

import abs.pubs.domain.Playplan;
import abs.pubs.domain.PlayplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayplanMapper {
    int countByExample(PlayplanExample example);

    int deleteByExample(PlayplanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Playplan record);

    int insertSelective(Playplan record);

    List<Playplan> selectByExample(PlayplanExample example);

    Playplan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Playplan record, @Param("example") PlayplanExample example);

    int updateByExample(@Param("record") Playplan record, @Param("example") PlayplanExample example);

    int updateByPrimaryKeySelective(Playplan record);

    int updateByPrimaryKey(Playplan record);

	int findMaxId();
}