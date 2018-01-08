package abs.pubs.manager.controller;
/**
 * 专门用于跳转页面的controller层
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class UIController {
	
	/**
	 * 跳转上传素材页面
	 * @return
	 */
	@RequestMapping("/upload")
	public String uploadUI(){
		return "upload";
	}
	
	
	/**
	 * 跳转首页
	 */
	@RequestMapping("/indexUI")
	public String indexUI(){
		
		return "index";
	}
	
	/**
	 * 跳转list.jsp页面
	 */
	@RequestMapping("/list")
	public String listUI(){
		
		return "list";
	}
	
	/**
	 * 跳转新增节目列表
	 */
	@RequestMapping("/proList")
	public String proList(){
		return "proList";
	}
	
	/**
	 * 跳转选择素材打包页面
	 */
	@RequestMapping("/newPro")
	public String newPro(){
		return "newPro";
	}
	
	/**
	 * 跳转到节目包的素材详情也
	 */
	@RequestMapping("/detail")
	public String detail(){
		return "detail";
	}
	
	/**
	 * 显示图片详情
	 */
	@RequestMapping("/picture")
	public String picture(){
		return "picture";
	}
	
	/**
	 * 显示终端列表
	 */
	@RequestMapping("/deviceList")
	public String deviceList(){
		return "deviceList";
	}
	/**
	 * 显示节目发布页面
	 */
	@RequestMapping("/programmingUI")
	public String programmingUI(){
		return "programming";
	}
	/**
	 * 跳转到节目编排页面
	 */
	
	@RequestMapping("/arrangeUI")
	public String arrangeUI(){
		return "arrange";
	}
	
	/**
	 * 跳转到分组页面
	 */
	@RequestMapping("/groupUI")
	public String groupUI(){
		return "group";
	}
	/**
	 * 跳转到用户查询页面
	 */
	@RequestMapping("/userListUI")
	public String userList(){
		return "userList";
		
	}
	/**
	 * 跳转到用户查询页面
	 */
	@RequestMapping("/organList")
	public String organ(){
		return "organList";
		
	}
	
	/**
	 * 跳转到素材统计页面
	 */
	
	@RequestMapping("/statisticsMaterial")
	public String material(){
		return "statisticsMaterial";
	}
	/**
	 * 跳转到素材统计页面
	 */
	
	@RequestMapping("/statisticsArea")
	public String area(){
		return "statisticsArea";
	}
	
	/**
	 * 跳转到创建播放列表已选择素材页面，通过iframe 引用
	 * @return
	 */
	@RequestMapping("/selectMaterial")
	public String selectMaterial(){
		return "selectMaterial";
	}
	/**
	 * 跳转到创建播放列表选择素材页面，通过iframe 引用
	 * @return
	 */
	@RequestMapping("/addMaterial")
	public String addMaterial(){
		return "addMaterial";
	}
	
	
	
	/**
	 * 天气，测试
	 * @return
	 */
	@RequestMapping("/statisticsTem")
	public String statisticsTem(){
		return "statisticsTem";
	}
	/**
	 * 布局模版页面
	 * @return
	 */
	@RequestMapping("/templateUI")
	public String template(){
		return "template";
		//return "color";
	}
	
	/**
	 * 节目发布页面
	 */
	@RequestMapping("/programUI")
	public String programUI(){
		return "program";
	}
	/**
	 * 节目发布页面
	 */
	@RequestMapping("/ledUI")
	public String ledUI(){
		return "led";
	}
	/**
	 * 角色管理页面
	 */
	@RequestMapping("/roleListUI")
	public String roleListUI(){
		return "roleList";
	}
	/**
	 * 权限管理页面
	 */
	@RequestMapping("/permissionUI")
	public String permissionUI(){
		return "permissionList";
	}
	
	/**
	 * 访客记录
	 */
	@RequestMapping("/guestInfoUI")
	public String guestInfoUI(){
		return "guestInfo";
	}
	/**
	 * 访客记录
	 */
	@RequestMapping("/callUI")
	public String callUI(){
		return "callHistory";
	}
	
	
	

	
	
}
