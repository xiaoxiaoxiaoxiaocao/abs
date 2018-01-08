package abs.pubs.manager.controller;

import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import abs.pubs.led.LEDSender2010;
import abs.pubs.led.MyUdpSocket;
import abs.pubs.led.ProtocolDemo;

@Controller
@RequestMapping("/led")
public class LedController {
	 public static LEDSender2010 ledsender = new LEDSender2010();
	 private static MyUdpSocket myUdpSocket;
	 static{
		 try {
			 myUdpSocket = new MyUdpSocket(8868);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	@RequestMapping("/send")
	public @ResponseBody Map<String,String> send(String inmethod,String inspeed,String outmethod,String outspeed,String alignMethod,String stopmethod,String stoptime,String stopspeed,String fontFamily,String fontSize,String text){
	        //生成节目数据
	        //ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_DOUBLE);
			HashMap<String,String> map = new HashMap<String,String>();
	    	try {
				ledsender.MakeRoot(LEDSender2010.ROOT_PLAY, LEDSender2010.COLOR_TYPE_DOUBLE);
				ledsender.AddChapter(1, 1000);
				ledsender.AddRegion(0, 0, 64, 32);
				//点阵文字（自动换行）
				ledsender.AddLeaf(1, 2000);
				ledsender.AddText(0, 0, 64, 32, text,fontFamily,Integer.parseInt(fontSize), Color.BLACK, Color.YELLOW, 0,Integer.parseInt(alignMethod), true, Integer.parseInt(inmethod),Integer.parseInt(inspeed),Integer.parseInt(outmethod), Integer.parseInt(outspeed), Integer.parseInt(stopmethod),Integer.parseInt(stopspeed),Integer.parseInt(stoptime));
//	        ledsender.AddText(0, 0, 64, 32, text, fontFamily, 12, Color.BLACK, Color.YELLOW, 0, 0, true, 6, 0, 2, 0, 0, 0, 0);
//	        ledsender.AddText(0, 0, 64, 32, text, "宋体", 12, Color.BLACK, Color.YELLOW, 0, 0, true, 6, 0, 2, 0, 0, 0, 0);
				
      
				ProtocolDemo demo = new ProtocolDemo();
				demo.my_udp=myUdpSocket;
				demo.ledhost="192.168.0.99";
				demo.send_data();
				map.put("sta", "200");
			} catch (Exception e) {
				e.printStackTrace();
				map.put("sta", "400");
			}
	     //  ProtocolDemo.send_data();
			return map;
	}
	
}
