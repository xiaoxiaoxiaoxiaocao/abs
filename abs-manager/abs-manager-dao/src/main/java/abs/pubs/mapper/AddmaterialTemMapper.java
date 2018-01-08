package abs.pubs.mapper;

import abs.pubs.domain.AddmaterialTem;
import abs.pubs.domain.AddmaterialTemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddmaterialTemMapper {
    int countByExample(AddmaterialTemExample example);

    int deleteByExample(AddmaterialTemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddmaterialTem record);

    int insertSelective(AddmaterialTem record);

    List<AddmaterialTem> selectByExample(AddmaterialTemExample example);

    AddmaterialTem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddmaterialTem record, @Param("example") AddmaterialTemExample example);

    int updateByExample(@Param("record") AddmaterialTem record, @Param("example") AddmaterialTemExample example);

    int updateByPrimaryKeySelective(AddmaterialTem record);

    int updateByPrimaryKey(AddmaterialTem record);

	void updateById(Integer id);
}