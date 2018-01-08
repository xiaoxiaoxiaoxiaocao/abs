package abs.pubs.mapper;

import abs.pubs.domain.Device;
import abs.pubs.domain.DeviceExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    int countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

	String selectMacById(Integer devId);

	List<Device> selectByGroupId(int id);

	List<String> findAllValidMac();

	Integer findIDByMac(java.lang.String mac);

	List<Device> selectByMac(java.lang.String string);

	List<Device> selectListByIds(ArrayList<Integer> list);

	String selectNameByMac(String mac);
}