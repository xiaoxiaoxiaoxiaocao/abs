package abs.pubs.mapper;

import abs.pubs.domain.UserRole;
import abs.pubs.domain.UserRoleExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int countByExample(UserRoleExample example);

    int deleteByExample(UserRoleExample example);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * 查找角色id
     * @param userId
     * @return
     */
	int selectRoleIdByUserId(Integer userid);
	
	/**
	 * 根据用户id 修改对应角色
	 * @param id
	 */

	//void updateByUserId(HashMap<String, Integer> hashMap);
}