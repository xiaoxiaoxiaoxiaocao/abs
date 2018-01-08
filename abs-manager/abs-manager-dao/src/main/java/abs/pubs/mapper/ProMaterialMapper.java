package abs.pubs.mapper;

import abs.pubs.domain.ProMaterial;
import abs.pubs.domain.ProMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProMaterialMapper {
    int countByExample(ProMaterialExample example);

    int deleteByExample(ProMaterialExample example);

    int deleteByPrimaryKey(Integer proId);

    int insert(ProMaterial record);

    int insertSelective(ProMaterial record);

    List<ProMaterial> selectByExample(ProMaterialExample example);

    ProMaterial selectByPrimaryKey(Integer proId);

    int updateByExampleSelective(@Param("record") ProMaterial record, @Param("example") ProMaterialExample example);

    int updateByExample(@Param("record") ProMaterial record, @Param("example") ProMaterialExample example);

    int updateByPrimaryKeySelective(ProMaterial record);

    int updateByPrimaryKey(ProMaterial record);
}