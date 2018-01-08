package abs.pubs.mapper;

import abs.pubs.domain.Usercat;
import abs.pubs.domain.UsercatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsercatMapper {
    int countByExample(UsercatExample example);

    int deleteByExample(UsercatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usercat record);

    int insertSelective(Usercat record);

    List<Usercat> selectByExample(UsercatExample example);

    Usercat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usercat record, @Param("example") UsercatExample example);

    int updateByExample(@Param("record") Usercat record, @Param("example") UsercatExample example);

    int updateByPrimaryKeySelective(Usercat record);

    int updateByPrimaryKey(Usercat record);
}