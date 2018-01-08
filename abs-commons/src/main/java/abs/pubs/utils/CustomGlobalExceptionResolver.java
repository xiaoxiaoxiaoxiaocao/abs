package abs.pubs.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//自定义全局异常处理器, 用于处理所有异常
public class CustomGlobalExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception exc) {
		
		String msg = "";
		if(exc instanceof CustomException){
			//自定义异常
			msg = ((CustomException)exc).getMessage();
		} else {
			//运行时异常
			msg = "对不起, 系统繁忙, 请联系管理员!";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
