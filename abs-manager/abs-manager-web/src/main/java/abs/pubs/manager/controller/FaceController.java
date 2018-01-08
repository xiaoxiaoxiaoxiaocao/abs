package abs.pubs.manager.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import abs.pubs.domain.Device;
import abs.pubs.domain.EasyUIResult;
import abs.pubs.domain.Excel;
import abs.pubs.domain.Material;
import abs.pubs.manager.service.IDeviceService;
import abs.pubs.manager.service.IFaceService;
import abs.pubs.manager.service.IMaterialServicce;
import abs.pubs.utils.ExcelExportSXXSSF;
import abs.pubs.utils.FileUtil;

@Controller
@RequestMapping("/face")
public class FaceController {
	@Autowired
	private IFaceService faceService;
	
	@Autowired
	private IDeviceService deviceService;
	@RequestMapping("/deviceGuestList")
	public @ResponseBody EasyUIResult deviceGuestList(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="10") int rows,
															String qrDevice,String qrGuest,String fromDate,String toDate)throws Exception{
		EasyUIResult easyUIResult = faceService.findAlldeviceGuest(page,rows,qrDevice,qrGuest,fromDate,toDate);
		return easyUIResult;
		
	}
	@RequestMapping("/callHistoryList")
	public @ResponseBody EasyUIResult callHistoryList(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="10") int rows)throws Exception{
		EasyUIResult easyUIResult = faceService.findAllCallHistoryList(page,rows);
		return easyUIResult;
		
	}
	
	@RequestMapping("/faceSet")
	public @ResponseBody Map<String,String> faceSet(int[] ids){
		HashMap<String,String> map = new HashMap<String,String>();
		String src = "D:\\ABS\\xml\\PushList.xml";
		String path = "D:\\ABS\\PushList\\";
		try {
			if(!new File(path).exists())   {
			    new File(path).mkdirs();
			  }
			for (int id : ids) {
				Device device = deviceService.selectById(id);
				String mac = device.getMac().replaceAll(":","-");
				String out = path+mac+".xml";
				FileUtil.BufferInputStreamBufferOutputStream(src, out);
				
			}
			map.put("states", "200");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("states", "200");
		}
		return map;
		
	}
	
	@RequestMapping(value="statistics",produces="application/json;charset=UTF-8")
	public @ResponseBody void statistics(String btn,String guest,String macAddress,String assembly,Integer age,String gender){
		faceService.insert(btn,guest,macAddress,assembly,age,gender);
	}
	
	@RequestMapping(value="excel",produces="application/json;charset=UTF-8")
	public @ResponseBody Map<String,String> excel(String qrDevice,String qrGuest,String fromDate,String toDate){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			List<Excel> excelDate = faceService.findExcelDate(qrDevice,qrGuest,fromDate,toDate);
			List<String> fieldNames = new ArrayList<String>();
			fieldNames.add("设备名称");
			fieldNames.add("客户名称");
			fieldNames.add("性别");
			fieldNames.add("年龄");
			fieldNames.add("访问内容");
			fieldNames.add("访问时间");
			List<String> fieldCodes = new ArrayList<String>();
			fieldCodes.add("deviceName");
			fieldCodes.add("guestName");
			fieldCodes.add("gender");
			fieldCodes.add("age");
			fieldCodes.add("info");
			fieldCodes.add("date");
			File file = new File("D:/ABS/EXCEL");
			if(!file.exists()){
				file.mkdirs();
			}
			ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(file.getPath(), "/ABS/EXCEL/", "客户访问详情", fieldNames, fieldCodes, 100);			
			excelExportSXXSSF.writeDatasByObject(excelDate);
			String exportFile = excelExportSXXSSF.exportFile();//excel 文件名字
			System.out.println(excelExportSXXSSF);
			map.put("status","200");
			map.put("size",excelDate.size()+"");
			map.put("path",exportFile );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("status","400");
		}
		return map;
		
	}
	

	
}
