package abs.pubs.mapper;

import abs.pubs.domain.Material;
import abs.pubs.domain.MaterialExample;
import abs.pubs.domain.MaterialResult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {
    int countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

	List<Map<String, Object>> findSumByType();

	List<MaterialResult> findStatisticsMaterial();

	List<MaterialResult> findStatisticsArea();
}