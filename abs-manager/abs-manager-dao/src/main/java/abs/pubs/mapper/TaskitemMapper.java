package abs.pubs.mapper;

import abs.pubs.domain.Taskitem;
import abs.pubs.domain.TaskitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskitemMapper {
    int countByExample(TaskitemExample example);

    int deleteByExample(TaskitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Taskitem record);

    int insertSelective(Taskitem record);

    List<Taskitem> selectByExample(TaskitemExample example);

    Taskitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Taskitem record, @Param("example") TaskitemExample example);

    int updateByExample(@Param("record") Taskitem record, @Param("example") TaskitemExample example);

    int updateByPrimaryKeySelective(Taskitem record);

    int updateByPrimaryKey(Taskitem record);
}