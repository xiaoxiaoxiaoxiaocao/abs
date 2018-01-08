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
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '素材统计分析'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis :{
            	
                         data : []// X轴的定义  
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: []
            }]  
        };
        myChart.showLoading({
        	 text: '正在努力加载中...'  
        });
        
        var types = [];//分类数组
        var nums=[];//数量数组
        
        
        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "${pageContext.request.contextPath }/echarts/material",
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                       for(var i=0;i<result.length;i++){       
                    	   types.push(result[i].type);    //挨个取出类别并填入类别数组
                        }
                       for(var i=0;i<result.length;i++){       
                           nums.push(result[i].num);    //挨个取出销量并填入销量数组
                         }
                       myChart.hideLoading();    //隐藏加载动画
                       myChart.setOption({        //加载数据图表
                           xAxis: {
                               data: types
                           },
                           series: [{
                               // 根据名字对应到相应的系列
                               name: '数量',
                               data: nums
                           }]
                       });
                       
                }
            
           },
            error : function(errorMsg) {
                //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
            }
       })
        
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    
</body>

</HTML>
