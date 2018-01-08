<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<script src="../../js/echarts.js"></script>
<script type="text/javascript" src="../../js/base-loading.js"></script>
    
<!-- 素材统计页面 -->
</HEAD>
<body>
 <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 500px;height:450px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
       var myChart = echarts.init(document.getElementById('main'));
        
  	   
      
	   var res = [];
       var names=[];
       $.ajax({
    	   type : "POST",
    	   async : false,
    	   url : '${pageContext.request.contextPath }/echarts/area',
    	   data : {},//加条件
    	   dataType : "json", //返回数据形式为json
    	   success : function(result) {
	    	   //定义需要后台传数据的数组
	    	   var a = []; //存放类型标签
	    	   for ( var i = 0; i < result.length; i++) {
	    		   names.push(result[i].type);
	    		   //获取每一个结果对象
	    		   res.push({
	    	    	   name : result[i].type,
	    	    	   value : result[i].num
	    	    	   });
	    	   }
    	 
    	  }
     })
	
    	 option = {
    		    title : {
    		        text: '终端设备地域分布图',
    		        x:'center'
    		    },
    		    tooltip : {
    		        trigger: 'item',
    		        formatter: "{a} <br/>{b} : {c} ({d}%)"
    		    },
    		    legend: {
    		        orient: 'vertical',
    		        left: 'left',
    		        data:names
    		    },
    		    series : [
    		        {
    		            name: '所属地区',
    		            type: 'pie',
    		            radius : '55%',
    		            center: ['55%', '50%'],
    		            data:res,
    		            itemStyle: {
    		                emphasis: {
    		                    shadowBlur: 10,
    		                    shadowOffsetX: 0,
    		                    shadowColor: 'rgba(0, 0, 0,0.8)'
    		                }
    		            }
    		        }
    		    ]
    		};
	  
	    	   myChart.setOption(option); 
		</script>
	<!-- myChart.showLoading({
	 	 text: '正在努力加载中...'  
	 }); -->
    
</body>

</HTML>
