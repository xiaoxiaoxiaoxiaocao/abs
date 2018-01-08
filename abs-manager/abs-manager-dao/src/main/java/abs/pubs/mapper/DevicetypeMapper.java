package abs.pubs.mapper;

import abs.pubs.domain.Devicetype;
import abs.pubs.domain.DevicetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevicetypeMapper {
    int countByExample(DevicetypeExample example);

    int deleteByExample(DevicetypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Devicetype record);

    int insertSelective(Devicetype record);

    List<Devicetype> selectByExample(DevicetypeExample example);

    Devicetype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Devicetype record, @Param("example") DevicetypeExample example);

    int updateByExample(@Param("record") Devicetype record, @Param("example") DevicetypeExample example);

    int updateByPrimaryKeySelective(Devicetype record);

    int updateByPrimaryKey(Devicetype record);
}