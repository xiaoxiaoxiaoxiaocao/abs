package abs.pubs.mapper;

import abs.pubs.domain.Guest;
import abs.pubs.domain.GuestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuestMapper {
    int countByExample(GuestExample example);

    int deleteByExample(GuestExample example);

    int insert(Guest record);

    int insertSelective(Guest record);

    List<Guest> selectByExample(GuestExample example);

    int updateByExampleSelective(@Param("record") Guest record, @Param("example") GuestExample example);

    int updateByExample(@Param("record") Guest record, @Param("example") GuestExample example);
}