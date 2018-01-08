package abs.pubs.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import abs.pubs.domain.MaterialResult;
import abs.pubs.manager.service.IStatisticsService;

@Controller
@RequestMapping("/echarts")
public class StatisticsController {
	@Autowired
	private IStatisticsService statisticsService;
	
	@RequestMapping("/material")
	 public @ResponseBody List<MaterialResult> materialData(){  
		List<MaterialResult> list =  statisticsService.findStatisticsMaterial();
		
        return list;  
	}
	@RequestMapping("/area")
	public @ResponseBody List<MaterialResult> areaData(){  
		List<MaterialResult> list =  statisticsService.findStatisticsArea();
		
		return list;  
	}
	
	

}