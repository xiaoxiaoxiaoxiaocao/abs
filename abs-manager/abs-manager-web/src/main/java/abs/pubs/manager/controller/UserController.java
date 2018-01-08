package abs.pubs.manager.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import abs.pubs.domain.City;
import abs.pubs.domain.Devicetype;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Permission;
import abs.pubs.domain.Province;
import abs.pubs.domain.Role;
import abs.pubs.domain.User;
import abs.pubs.domain.Usercat;
import abs.pubs.manager.service.IPermissionService;
import abs.pubs.manager.service.IRolePermissionService;
import abs.pubs.manager.service.IRoleService;
import abs.pubs.manager.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;
	
	@Autowired
	private IRolePermissionService rolePermissionService;
	
	@RequestMapping("/logon")
	public String login(HttpServletRequest request,String username,String password,Model model,String txtcode,String token) throws Exception{
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(new UsernamePasswordToken(username, password));
			//request.getSession().setAttribute(name, value);
			return "index";
		} catch (Exception e) {
			model.addAttribute("msg", "用户名或密码错误");
			return "login";
		}
		
	}
	
	@RequestMapping("/userList")
	public @ResponseBody EasyUIResult userList(@RequestParam(defaultValue="1")int page,
												@RequestParam(defaultValue="10")int rows)throws Exception{
		
		EasyUIResult easyUIResult = userService.findAllUser(page,rows);
		return easyUIResult;
		
	}
	
	@RequestMapping("/checkUserName")
	public @ResponseBody int checkUserName(String username){
		//去数据库查询username为该值的用户
		int i = userService.selectCountByUsername(username);
		
		return i;
		
	}
	@RequestMapping("/addUser")
	public String addUser(String username,String password,int[] role,int belongName)throws Exception{
			userService.addUser(username,password,role,belongName);
			
		return "userList";
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Map<String,String> delete(String[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			for (String idstr : ids) {
				int id = Integer.parseInt(idstr);
				userService.deleteById(id);
				map.put("state", "200");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			map.put("state", "400");
		}
		return map;
		
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	public Map<String,Object> detail(Integer id,Model model)throws Exception{
		User user = userService.findUserById(id);
		List<Integer> ids = userService.findRoleById(id);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("user", user);
		map.put("ids", ids);
		return map;
		
	}
	
	@RequestMapping("/editUser")
	public String editUser(int id,String username,String password,int[] reRole,int reOrgan)throws Exception{
		userService.updateUser(id,username,password,reRole,reOrgan);
		return "userList";
		
	}
	
	@RequestMapping("/roleList")
	public @ResponseBody List<Role> roleList(){
		List<Role> roleList = roleService.findRoleList();
		return roleList;
	}
	@RequestMapping("/groups")
	public @ResponseBody List<Usercat> groups(){
		List<Usercat> list= userService.findAllGroup();
		return list;
	}
	@RequestMapping("/groupList")
	public @ResponseBody EasyUIResult groupList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows){
		PageHelper.startPage(page, rows);
		List<Usercat> list = userService.findAllGroup();
		EasyUIResult easyUIResult = new EasyUIResult();
		easyUIResult.setRows(list);
		PageInfo<Usercat> info = new PageInfo<>(list);
		easyUIResult.setTotal(info.getTotal());
		return easyUIResult;
	}
	@RequestMapping(value="getName",produces="text/html;charset=UTF-8")
	public @ResponseBody String getName(int groupId){
		String string = userService.findGroupNameById(groupId);
		
		return string;
	}

	@RequestMapping(value="addOrgan",produces="application/json;charset=UTF-8")
	public @ResponseBody Map<String,String> addOrgan(Integer id,String name,int city){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			userService.addOrgan(id,name,city);
			map.put("status", "200");
		} catch (Exception e) {
			map.put("status", "400");
		}
		return map;
	}
	@RequestMapping(value="checkOrganName",produces="application/json;charset=UTF-8")
	public @ResponseBody int checkOrganName(String name){
		int i = userService.findCountByOrganName(name);
		return i;
	}
	
	@RequestMapping("/deleteOrgans")
	public @ResponseBody Map<String,String> deleteOrgans(int[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			for (int i : ids) {
				userService.deleteOrganById(i);
			}
			map.put("status", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	@RequestMapping("/editOrgan")
	public @ResponseBody Map<String,String> editOrgan(int pId,String name,int id){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			userService.editOrgenById(id,name,pId);
			map.put("status", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	@RequestMapping(value="getOgName",produces="text/html;charset=UTF-8")
	public @ResponseBody String getOgName(int id){
		String name = userService.selectOrganNameById(id);
		System.out.println(name);
		return name;
	}
	@RequestMapping(value="previnces",produces="application/json;charset=UTF-8")
	public @ResponseBody List<Province> previnces(){
		List<Province> list =userService.findAllProvinces();
		return list;
	}
	@RequestMapping(value="cities",produces="application/json;charset=UTF-8")
	public @ResponseBody List<City> cities(int provinceId){
		String code = userService.getCodeByProvinceId(provinceId);
		if(code != null){
			List<City> list =userService.findCitiesByPcode(code);
			return list;
		}
		return null;
	}
	@RequestMapping(value="addPermission",produces="application/json;charset=UTF-8")
	public @ResponseBody  Map<String, String> addPermission(String name,String url,String pcode,String mark){
		Map<String, String> map = new HashMap<String, String>();
		try {
			permissionService.insert(name,url,pcode,mark);
			map.put("status", "200"); 
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "400"); 
		}
		return map;
	}
	
	@RequestMapping("/addRole")
	public @ResponseBody Map<String, String> addRole(String name,String message,int[] pids){
		Map<String, String> map = new HashMap<String, String>();
		try {
			roleService.insert(name,message,pids);
			map.put("status", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	@RequestMapping("/changeRole")
	public @ResponseBody Map<String, String> changeRole(String name,String message,Integer id,int[] pids){
		Map<String, String> map = new HashMap<String, String>();
		try {
			roleService.updateById(id,name,message,pids);
			map.put("status", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	@RequestMapping("/deleteRoleById")
	public @ResponseBody Map<String, String> deleteRoleById(int[] ids){
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (int id: ids) {
				roleService.deleteById(id);
			}
			map.put("status", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	@RequestMapping("/deletePermissionById")
	public @ResponseBody Map<String, String> deletePermissionById(int[] ids){
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (int id: ids) {
				permissionService.deleteById(id);
			}
			map.put("status", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	@RequestMapping("/changePermission")
	public @ResponseBody Map<String, String> changePermission(Integer id,String name,String url,String pcode,String mark){
		Map<String, String> map = new HashMap<String, String>();
		try {
				permissionService.updateById(id,name,url,pcode,mark);
			map.put("status", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "400");
		}
		return map;
	}
	

	
	@RequestMapping("/findAllPermission")
	public @ResponseBody List<Permission> findAllPermission(){
	List<Permission> list = permissionService.findAllPermission();
	return list;
	}
	
	@RequestMapping("/findPermissionsByRoleId")
	public @ResponseBody List<Integer> findPermissionsByRoleId(Integer roleId){
		List<Integer> list = rolePermissionService.findPermissionsByRoleId(roleId);
		return list;
	}
	@RequestMapping("/permissionList")
	public @ResponseBody EasyUIResult permissionList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows){
		EasyUIResult result = new EasyUIResult();
		PageHelper.startPage(page, rows);
		List<Permission> list = findAllPermission();
		PageInfo<Permission> info = new PageInfo<>(list);
		result.setRows(list);
		result.setTotal(info.getTotal());
		return result;
	}
	
	@RequestMapping("/findAllRoles")
	public @ResponseBody List<Role> findAllRoles(){
		List<Role> roles  = userService.findAllRoles();
		return roles;
		
	}

}	
	
/*	@RequestMapping("/findAllPermission")
	public @ResponseBody List<Permission> findAllPermission(HttpServletRequest request){
		HttpSession session = request.getSession();
		List<Permission> list = permissionService.findAllPermission();
		session.setAttribute("hello", "hello");
		return list;
	}
*
	
}	


/*String sessionToken = (String) request.getSession().getAttribute("token");
if(!sessionToken.equals(token) ){
	return "login";
}

//session中的验证码
String sessionCode = (String) request.getSession().getAttribute("code");
if(!sessionCode.toLowerCase().equals(txtcode.toLowerCase())  ){
	model.addAttribute("msg", "验证码错误");
	String refreshToken = new Date().toString();
	model.addAttribute("token",token);
	request.getSession().setAttribute("token", refreshToken);
	return "login"; 
}


List<User> list = userService.checkLogin(username, password);
if(list != null && list.size()>0){
	//model.addAttribute("user", list.get(0));
	request.getSession().setAttribute("user", list.get(0));
	return "index";
}else{
	model.addAttribute("msg", "用户名或密码错误");
	String refreshToken = new Date().toString();
	model.addAttribute("token",token);
	request.getSession().setAttribute("token", refreshToken);
	return "login";

}*/
	
	/*private int width = 90;// 定义图片的width
	private int height = 20;// 定义图片的height
	private int codeCount = 4;// 定义图片上显示验证码的个数
	private int xx = 15;
	private int fontHeight = 18;
	private int codeY = 16;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N','P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n','p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z' };
	    @RequestMapping("/yzm")
	    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	        // 定义图像buffer
	        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        Graphics gd = buffImg.getGraphics();
	        // 创建一个随机数生成器类
	        Random random = new Random();
	        // 将图像填充为白色
	        gd.setColor(Color.WHITE);
	        gd.fillRect(0, 0, width, height);
	        // 创建字体，字体的大小应该根据图片的高度来定。
	        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
	        // 设置字体。
	        gd.setFont(font);
	        // 画边框。
	        gd.setColor(Color.BLACK);
	        gd.drawRect(0, 0, width - 1, height - 1);
	        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
	        gd.setColor(Color.BLACK);
	        for (int i = 0; i < 40; i++) {
	            int x = random.nextInt(width);
	            int y = random.nextInt(height);
	            int xl = random.nextInt(12);
	            int yl = random.nextInt(12);
	            gd.drawLine(x, y, x + xl, y + yl);
	        }
	        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
	        StringBuffer randomCode = new StringBuffer();
	        int red = 0, green = 0, blue = 0;
	        // 随机产生codeCount数字的验证码。
	        for (int i = 0; i < codeCount; i++) {
	            // 得到随机产生的验证码数字。
	            String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length-1)]);
	            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
	            red = random.nextInt(255);
	            green = random.nextInt(255);
	            blue = random.nextInt(255);
	            // 用随机产生的颜色将验证码绘制到图像中。
	            gd.setColor(new Color(red, green, blue));
	            gd.drawString(code, (i + 1) * xx, codeY);
	            // 将产生的四个随机数组合在一起。
	            randomCode.append(code);
	        }
	        // 将四位数字的验证码保存到Session中。
	        HttpSession session = req.getSession();
	        session.setAttribute("code", randomCode.toString());
	        System.out.println(randomCode);
	        // 禁止图像缓存。
	        resp.setHeader("Pragma", "no-cache");
	        resp.setHeader("Cache-Control", "no-cache");
	        resp.setDateHeader("Expires", 0);
	        resp.setContentType("image/jpeg");
	        // 将图像输出到Servlet输出流中。
	        ServletOutputStream sos = resp.getOutputStream();
	        ImageIO.write(buffImg, "jpeg", sos);
	        sos.close();
	    }*/

