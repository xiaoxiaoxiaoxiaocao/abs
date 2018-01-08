
package abs.pubs.manager.service;

import java.util.List;

import javax.jws.WebService;

import org.joda.time.DateTime;

import abs.pubs.domain.EditResult;
import abs.pubs.domain.Guest;

/**
 * webService服务对应的service层
 * @author 曹起坤
 *
 */

@WebService(targetNamespace="http://service.manager.pubs.abs/",name="IFinalService")
public interface IFinalService {
	/**
	 * 同过mac地址返回结果集
	 */
    public List<EditResult> getPlayPlan1(String mac)throws Exception;
    public List<EditResult> getPlayPlan2(String mac)throws Exception;
    public List<EditResult> getPlayPlan3(String mac)throws Exception;
    
    /**
     * 接收device参数，更新到数据库
     */
    public boolean updateDeviceInfo(String str);
    
    /**
     * 生成节目包列表
     */
        public List<String> getPlayPlanName()throws Exception;
        /**
         * xml测试
         *
         */
        public void xmlTest(String str);
        /**
         * 通过客户id 查询该客户是否存在
         * @param GuestID
         * @return
         */
        public Guest FindGuest(String GuestID);
        
        public Boolean GuestLog (String strGuestID, String strMac, DateTime dtTime);
      /**
       * 记录大堂经理呼叫记录  
       */
      // public void saveCall(String[] str);
       public void saveCall(String mac,String time);
       
}
