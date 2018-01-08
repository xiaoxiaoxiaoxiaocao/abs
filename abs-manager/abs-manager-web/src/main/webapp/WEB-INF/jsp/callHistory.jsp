<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户行为分析</title>
<script type="text/javascript" src="../../js/base-loading.js"></script>
</head>
		
<body>
	<div style="background-color: #87CEFA; height: 40px; width: 100%">

		<center>
			<h1 style="margin: 0">
				<b><font>大堂经理呼叫记录</font></b>
			</h1>
		</center>
		
	</div>
	<table class="easyui-datagrid" id="deviceGuestList" style="width:100%;height:320px"
		data-options="url:'${baseurl }/face/callHistoryList',fitColumns:true,pagination:true,
					striped:true,checkOnSelect:false,rownumbers:true">
	<thead>
			<tr>
				<th data-options="field:'mac',width:5,formatter:getDeviceName">设备名称</th>
				<th data-options="field:'time',width:5">呼叫时间</th>
			</tr>
	</thead>


</table>


<script type="text/javascript">
$.ajaxSetup({
	  async: false
});
var count=0;
/*function excel(){
	var qrParams={
			"qrDevice":$("#qrDevice").combobox('getValue'),
			"qrGuest":$("#qrGuest").val(),
			"fromDate":$('#fromDate').datetimebox('getValue'),
			"toDate":$('#toDate').datetimebox('getValue')
	}
	$.post("${baseurl }/face/excel",qrParams,function(data){
		if(data.status==200){
			$.messager.alert("提示","成功导出"+data.size+"条记录，<a style='cursor:pointer' href='"+data.path+"'>点此下载</a>","info");
		}
	});
}*/
$(function(){
	$.post("${baseurl}/device/findDevicesByMacs",function(data){
		data.unshift({
			'mac' : '-1',
			'devicename' : '---请选择设备---'
		});
		$('#qrDevice').combobox({
			data : data,
			editable:false,
			valueField : 'mac',
			textField : 'devicename',
			panelHeight : 'auto',
			onLoadSuccess : function() { //加载完成后,设置选中第一项  
				var val = $(this).combobox('getData');
				for ( var item in val[0]) {
					if (item == 'mac') {
						$(this).combobox('select', val[0][item]);
					}
				}
			}
		});
	});
});

$(function(){
	setInterval("qr()",1000);
	
});

function qr(){
	$.post("${baseurl}/device/infoCount",function(d){
		if(d>count && count != 0){
			
			$.messager.show({
				title:'提示',
				msg:'呼叫大堂经理，请尽快处理！',
				showType:'show',
				timeout:5000
			});
		}
		count=d;
	});
}

function fmtDate(value,row,index){
		var t= dateFtt("yyyy-MM-dd hh:mm:ss",new Date(value));
		return t;
}
function dateFtt(fmt,date)   
{ //author: meizz   
  var o = {   
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
} 
function reload(){
	var qrParams={
			"qrDevice":$("#qrDevice").combobox('getValue'),
			"qrGuest":$("#qrGuest").val(),
			"fromDate":$('#fromDate').datetimebox('getValue'),
			"toDate":$('#toDate').datetimebox('getValue')
	}
	
	$("#deviceGuestList").datagrid('load',qrParams);
	
}
function getDeviceName(value,row,index){
	var name;
	$.post("${baseurl}/device/getDeviceByMac",{"mac":value},function(data){
		name=data;
	});
	return name;
}

</script>
</body>
</html>