package abs.pubs.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 项目的入口，用于进入登录页面
 * @author 曹起坤
 *
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpServletRequest req){
		HttpSession session = req.getSession();
		//session.invalidate();
		return "login";
	}
}
