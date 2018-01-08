package abs.pubs.mapper;

import abs.pubs.domain.Programrelease;
import abs.pubs.domain.ProgramreleaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProgramreleaseMapper {
    int countByExample(ProgramreleaseExample example);

    int deleteByExample(ProgramreleaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Programrelease record);

    int insertSelective(Programrelease record);

    List<Programrelease> selectByExample(ProgramreleaseExample example);

    Programrelease selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Programrelease record, @Param("example") ProgramreleaseExample example);

    int updateByExample(@Param("record") Programrelease record, @Param("example") ProgramreleaseExample example);

    int updateByPrimaryKeySelective(Programrelease record);

    int updateByPrimaryKey(Programrelease record);

	Integer findMaxTimeId(Integer deviceId);
}