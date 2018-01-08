package abs.pubs.mapper;

import abs.pubs.domain.ProDevice;
import abs.pubs.domain.ProDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProDeviceMapper {
    int countByExample(ProDeviceExample example);

    int deleteByExample(ProDeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProDevice record);

    int insertSelective(ProDevice record);

    List<ProDevice> selectByExample(ProDeviceExample example);

    ProDevice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProDevice record, @Param("example") ProDeviceExample example);

    int updateByExample(@Param("record") ProDevice record, @Param("example") ProDeviceExample example);

    int updateByPrimaryKeySelective(ProDevice record);

    int updateByPrimaryKey(ProDevice record);

	List<Integer> selectDivids(int id);
}