package abs.pubs.mapper;

import abs.pubs.domain.Pls;
import abs.pubs.domain.PlsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlsMapper {
    int countByExample(PlsExample example);

    int deleteByExample(PlsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pls record);

    int insertSelective(Pls record);

    List<Pls> selectByExample(PlsExample example);

    Pls selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pls record, @Param("example") PlsExample example);

    int updateByExample(@Param("record") Pls record, @Param("example") PlsExample example);

    int updateByPrimaryKeySelective(Pls record);

    int updateByPrimaryKey(Pls record);
}