﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
       
        
        option = {
        	    title: {
        	        text: '未来一周气温变化',
        	        subtext: '纯属虚构'
        	    },
        	    tooltip: {
        	        trigger: 'axis'
        	    },
        	    legend: {
        	        data:['最高气温','最低气温']
        	    },
        	    toolbox: {
        	        show: true,
        	        feature: {
        	            dataZoom: {
        	                yAxisIndex: 'none'
        	            },
        	            dataView: {readOnly: false},
        	            magicType: {type: ['line', 'bar']},
        	            restore: {},
        	            saveAsImage: {}
        	        }
        	    },
        	    xAxis:  {
        	        type: 'category',
        	        boundaryGap: false,
        	        data: ['周一','周二','周三','周四','周五','周六','周日']
        	    },
        	    yAxis: {
        	        type: 'value',
        	        axisLabel: {
        	            formatter: '{value} °C'
        	        }
        	    },
        	    series: [
        	        {
        	            name:'最高气温',
        	            type:'line',
        	            data:[11, 11, 15, 13, 12, 13, 10],
        	            markPoint: {
        	                data: [
        	                    {type: 'max', name: '最大值'},
        	                    {type: 'min', name: '最小值'}
        	                ]
        	            },
        	            markLine: {
        	                data: [
        	                    {type: 'average', name: '平均值'}
        	                ]
        	            }
        	        },
        	        {
        	            name:'最低气温',
        	            type:'line',
        	            data:[1, -2, 2, 5, 3, 2, 0],
        	            markPoint: {
        	                data: [
        	                    {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
        	                ]
        	            },
        	            markLine: {
        	                data: [
        	                    {type: 'average', name: '平均值'},
        	                    [{
        	                        symbol: 'none',
        	                        x: '90%',
        	                        yAxis: 'max'
        	                    }, {
        	                        symbol: 'circle',
        	                        label: {
        	                            normal: {
        	                                position: 'start',
        	                                formatter: '最大值'
        	                            }
        	                        },
        	                        type: 'max',
        	                        name: '最高点'
        	                    }]
        	                ]
        	            }
        	        }
        	    ]
        	};
        
        
        
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    
</body>


</HTML>