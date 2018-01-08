package abs.pubs.mapper;

import abs.pubs.domain.CallHistory;
import abs.pubs.domain.CallHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CallHistoryMapper {
    int countByExample(CallHistoryExample example);

    int deleteByExample(CallHistoryExample example);

    int insert(CallHistory record);

    int insertSelective(CallHistory record);

    List<CallHistory> selectByExample(CallHistoryExample example);

    int updateByExampleSelective(@Param("record") CallHistory record, @Param("example") CallHistoryExample example);

    int updateByExample(@Param("record") CallHistory record, @Param("example") CallHistoryExample example);
}