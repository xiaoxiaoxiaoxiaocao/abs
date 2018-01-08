package abs.pubs.mapper;

import abs.pubs.domain.ProPls;
import abs.pubs.domain.ProPlsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProPlsMapper {
    int countByExample(ProPlsExample example);

    int deleteByExample(ProPlsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProPls record);

    int insertSelective(ProPls record);

    List<ProPls> selectByExample(ProPlsExample example);

    ProPls selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProPls record, @Param("example") ProPlsExample example);

    int updateByExample(@Param("record") ProPls record, @Param("example") ProPlsExample example);

    int updateByPrimaryKeySelective(ProPls record);

    int updateByPrimaryKey(ProPls record);

	List<Integer> selectProidByPlsId(int id);

	List<Integer> selectPlsidsByProId(int id);
}