package abs.pubs.manager.auth.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import abs.pubs.domain.User;
import abs.pubs.manager.service.IAuthService;

public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private IAuthService authService;
	
	@Override
	public String getName() {
		return "customRealm";
	}
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1 获得账号（用户名、身份信息）
				User principal = (User) principals.getPrimaryPrincipal();
				
				//2 通过用户名，查询用户的所有的权限，项目中采用pcode作为标识
				Set<String> pcodeSet = authService.findPermissionByUserId(principal.getId());
				SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
				authorizationInfo.setStringPermissions(pcodeSet);
				return authorizationInfo;
		
	}
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1 获得身份信息（用户名）
		String principal = (String) token.getPrincipal();
		User user =authService.findUserByName(principal);
		if(user ==null){
			//用户不存在
			return null;
		}
		//获得密码
		String password = user.getPassword();
		User sysUser = new User();
		sysUser.setId(user.getId());
		//sysUser.setLevel(user.getLevel());
		sysUser.setUsername(user.getUsername());
		return new SimpleAuthenticationInfo(sysUser, password, getName());
	}

}
