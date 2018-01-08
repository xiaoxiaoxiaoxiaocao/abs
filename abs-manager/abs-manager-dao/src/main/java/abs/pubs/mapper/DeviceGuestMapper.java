package abs.pubs.mapper;

import abs.pubs.domain.DeviceGuest;
import abs.pubs.domain.DeviceGuestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceGuestMapper {
    int countByExample(DeviceGuestExample example);

    int deleteByExample(DeviceGuestExample example);

    int insert(DeviceGuest record);

    int insertSelective(DeviceGuest record);

    List<DeviceGuest> selectByExample(DeviceGuestExample example);

    int updateByExampleSelective(@Param("record") DeviceGuest record, @Param("example") DeviceGuestExample example);

    int updateByExample(@Param("record") DeviceGuest record, @Param("example") DeviceGuestExample example);
}