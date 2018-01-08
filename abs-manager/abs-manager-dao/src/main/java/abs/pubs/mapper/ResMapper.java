package abs.pubs.mapper;

import abs.pubs.domain.Res;
import abs.pubs.domain.ResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResMapper {
    int countByExample(ResExample example);

    int deleteByExample(ResExample example);

    int deleteByPrimaryKey(String resid);

    int insert(Res record);

    int insertSelective(Res record);

    List<Res> selectByExample(ResExample example);

    Res selectByPrimaryKey(String resid);

    int updateByExampleSelective(@Param("record") Res record, @Param("example") ResExample example);

    int updateByExample(@Param("record") Res record, @Param("example") ResExample example);

    int updateByPrimaryKeySelective(Res record);

    int updateByPrimaryKey(Res record);
}