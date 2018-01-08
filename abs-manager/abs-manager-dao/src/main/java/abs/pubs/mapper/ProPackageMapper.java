package abs.pubs.mapper;

import abs.pubs.domain.ProPackage;
import abs.pubs.domain.ProPackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProPackageMapper {
    int countByExample(ProPackageExample example);

    int deleteByExample(ProPackageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProPackage record);

    int insertSelective(ProPackage record);

    List<ProPackage> selectByExample(ProPackageExample example);

    ProPackage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProPackage record, @Param("example") ProPackageExample example);

    int updateByExample(@Param("record") ProPackage record, @Param("example") ProPackageExample example);

    int updateByPrimaryKeySelective(ProPackage record);

    int updateByPrimaryKey(ProPackage record);

	void updateIssue(int id);
}