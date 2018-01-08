<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
%>
<meta http-equiv="Expires" content="0">
<meta http-equiv="kiben" content="no-cache">
<script type="text/javascript" src="../../js/base-loading.js"></script>
</HEAD>
<style type="text/css">
.css_btn_class {
	font-size:13px;
	font-family:Arial;
	font-weight:normal;
	-moz-border-radius:8px;
	-webkit-border-radius:8px;
	border-radius:8px;
	cursor:pointer;
	outline:none;
	padding:3px 10px;
	text-decoration:none;
	background:-moz-linear-gradient( center top, #bddbfa 5%, #80b5ea 100% );
	background:-ms-linear-gradient( top, #bddbfa 5%, #80b5ea 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#bddbfa', endColorstr='#80b5ea');
	background:-webkit-gradient( linear, left top, left bottom, color-stop(5%, #bddbfa), color-stop(100%, #80b5ea) );
	background-color:#bddbfa;
	color:#ffffff;
	display:inline-block;
	text-shadow:1px 1px 0px #528ecc;
 	-webkit-box-shadow:inset 1px 1px 0px 0px #dcecfb;
 	-moz-box-shadow:inset 1px 1px 0px 0px #dcecfb;
 	box-shadow:inset 1px 1px 0px 0px #dcecfb;
}.css_btn_class:hover {
	background:-moz-linear-gradient( center top, #80b5ea 5%, #bddbfa 100% );
	background:-ms-linear-gradient( top, #80b5ea 5%, #bddbfa 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#80b5ea', endColorstr='#bddbfa');
	background:-webkit-gradient( linear, left top, left bottom, color-stop(5%, #80b5ea), color-stop(100%, #bddbfa) );
	background-color:#80b5ea;
}.css_btn_class:active {
	position:relative;
	top:1px;
}
.add{
	height:20px;
}

nav{
  margin: 0;
  padding: 0;
  border: 0;
  font: inherit;
  font-size: 100%;
  vertical-align: baseline;
  display: block;
  height: 60px;
  line-height: 60px;
  width: 100%;
  background-color: rgba(0,104,139,0.6);
}
nav a {
  color:#fff;
  display: inline-block;
  padding: 10px 15px;
  line-height: 1;
  text-decoration: none;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
}

nav a:hover {
  -moz-box-shadow: 0 0 0 1px #fff;
  -webkit-box-shadow: 0 0 0 1px #fff;
  box-shadow: 0 0 0 1px #fff;
}

</style>


<body>


<!-- 绘制数据表格 -->
	<%-- ${groupId} --%>
	<table class="easyui-datagrid" id="list" title=""
		style="width: 99%; height: 60%"
		data-options="url:'${pageContext.request.contextPath }/device/deviceList?groupId=${groupId}',queryParams:{deviceId:0},fitColumns:true,singleSelect:false,pagination:true,
					toolbar:'#tb',checkOnSelect:true,striped:true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:10">id</th>
				<th data-options="field:'devicename',width:30,align:'left'">名称</th>
				<th data-options="field:'devicetypeid',width:20,align:'left',formatter:getType">类型</th>
				<th data-options="field:'mac',width:20">mac地址</th>
				<th data-options="field:'outputresolution',width:18">分辨率</th>
				<th data-options="field:'updatetime',width:25,formatter:getTime">更新时间</th>
				<th data-options="field:'loginusername',width:15">操作用户</th>
				<th data-options="field:'grouping',width:30,formatter:getGroup">机构名称</th>
				<!-- <th data-options="field:'cz',width:10,formatter:control">操作</th> -->
				
			</tr>
		</thead>
				<!-- <th data-options="field:'ip',width:23">ip</th>
				<th data-options="field:'cpuid',width:25">CPU编码</th>
				<th data-options="field:'status',width:10">状态</th>
				<th data-options="field:'diskid',width:25">硬盘编码</th>
				<th data-options="field:'totalphysicalmemory',width:25">内存容量</th>
				<th data-options="field:'systemtype',width:23">系统类型</th>
				<th data-options="field:'firmwareversion',width:32">固件版本</th>
				<th data-options="field:'appversion',width:15">软件版本</th>
				<th data-options="field:'subnetmask',width:25">子网掩码</th>
				<th data-options="field:'defaultgateway',width:25">默认网关</th>
				<th data-options="field:'harddiskfreespace',width:25">硬盘容量</th> -->
		
	</table>

	<div id="tb" style="padding:5px; height: auto">
		<div style="margin-bottom: 1px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addDev()">新增设备</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="assign()">指定分组</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="remv()">删除</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-filter" plain="true" onclick="release()">发布节目</a>
			<a href="javascript:void(0);" id="op1" class="easyui-linkbutton ctrl" iconCls="icon-interact" plain="true" onclick="interact()">发布互动</a>
			<a href="javascript:void(0);" id="op1" class="easyui-linkbutton ctrl" iconCls="icon-man" plain="true" onclick="faceSet()">更新配置</a>
			<a href="javascript:void(0);" id="op1" class="easyui-linkbutton ctrl" iconCls="icon-led" plain="true" onclick="ledSend()">LED发布</a>
			<a href="javascript:void(0);" id="op1" class="easyui-linkbutton ctrl" iconCls="icon-startup" plain="true" onclick="startup()">开机</a>
			<a href="javascript:void(0);" id="op1" class="easyui-linkbutton ctrl" iconCls="icon-shutdown" plain="true" onclick="shutdown(1)">关机</a>
			<a href="javascript:void(0);" id="op1" class="easyui-linkbutton ctrl" iconCls="icon-reboot" plain="true" onclick="shutdown(0)">重启</a>
		</div>
		<div>
			<nav> 
				 <c:forEach items="${deviceTypes }" var="deviceType">
					<a href="#" class="filt" id=${deviceType.id }><h3>${deviceType.name }</h3></a>
				 </c:forEach>
			</nav>

		</div>
		

	</div>


	<div id="addGroup" class="easyui-dialog" data-options="" title="添加分组" closed="true" style="width:400px;height:300px">
		<ul id="tree" class="easyui-tree"></ul>
	</div>
	
	<div id="w" class="easyui-window" title="新增设备" data-options="iconCls:'icon-add'" style="width:400px;height:250px;padding:5px;" closed="true">
		<form id="addFormId" action="${pageContext.request.contextPath }/device/addDevice" method="post">
			<table cellpadding="10" align="center">
				<tr>
					<td>设备名称:</td>
					<td><input id="addName" name="addName" class="easyui-validatebox textbox add"></td>
				</tr>
				<tr>
					<td>设备类型:</td>
					<td><input id="comTpId" name="addTp" class="easyui-combobox add" data-options="editable:false" ></td>
				</tr>
				<tr>
					<td>MAC地址:</td>
					<td><input id="addMac" name="addMac" class="easyui-validatebox textbox add" ></td>
				</tr>
				
				<tr>
					<td>分辨率:</td>
					<td><input id="addAbs" name="addAbs" class="easyui-validatebox textbox add" ></td>
				</tr>
				<tr>
					<td>分组:</td>
					<td>
						<input id="comboxId" name="addGup" class="easyui-combobox add" data-options="required:true,editable:false" >
					</td>
				</tr>
				<tr>
					<td><input type="reset" class="css_btn_class"></td>
					<td><input type="button" value="确认" class="css_btn_class" onclick="sub()"></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="Layer2" align="center" style="position: absolute; z-index: 3; left:25%; top:20%; height:35%;width:35%;
         background-color:#CAE1FF; display: none;" >
                     <div style="width:100%;height:15%;background:#CAE1FF" align="right"><a href=JavaScript:; class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="Lock_CheckForm(this);"></a></div>
            
	                <div style="width:80%;height:80%">
	                	 
	               		<img id="pcImg" src="../../images/pc.png" style="width:80%;height:70%;"><br>
	               		<br><br>
		                <button id="op3" class="css_btn_class">截屏</button>
		                <button id="op2" class="css_btn_class op_btn">开机</button>
		                <button id="op1" class="css_btn_class op_btn">关机</button>
		                <button id="op0" class="css_btn_class op_btn">重启</button>
	                </div>
                
    </div>
    
	<div id="pckId" class="easyui-dialog" title="发布节目" style="width:60%;height:80%;padding:10px" closed="true">
	
		<!-- <table class="easyui-datagrid" id="pkgId" style="width:100%;height: 60%">
		</table> -->
		<table class="easyui-datagrid" id="programList" style="width: 98%; height: 90%"
			data-options="url:'${pageContext.request.contextPath }/arrange/programList',singleSelect:true,
						fitColumns:true,pagination:false,striped:true,checkOnSelect:true">
			<thead>
				<tr>
					<th field="ck" checkbox="true"></th>
					<th data-options="field:'id',width:50">id</th>
					<th data-options="field:'pkgName',width:100,align:'left'">节目包名称</th>
					<th data-options="field:'states',width:50,formatter:getStates">状态</th>
					<th data-options="field:'pkgType',width:100,formatter:getPType">节目包类型</th>
					<th data-options="field:'updttime',width:150,formatter:getTime">更新时间</th>
					<th data-options="field:'operator',width:100,formatter:getUsername">操作者</th>
				</tr>
			</thead>
		</table>





		<center><div onclick="publish()" class="easyui-linkbutton" style="width:100%;margin-top: 10px"><B>选&nbsp;择&nbsp;并&nbsp;发&nbsp;布</B></div></center>
	</div>
	<div id="interactDiv" class="easyui-dialog" title="发布互动" style="width:60%;height:80%;padding:10px" closed="true">
	
		
		<table class="easyui-datagrid" id="zipList" style="width: 98%; height: 90%"
			data-options="url:'${pageContext.request.contextPath }/picture/zips',
						fitColumns:true,pagination:false,striped:true,checkOnSelect:true">
			<thead>
				<tr>
					<th field="ck" checkbox="true"></th>
					<th data-options="field:'id',width:30">id</th>
					<th data-options="field:'name',width:120">名称</th>
					<th data-options="field:'size',width:50">大小</th>
					<th data-options="field:'addtime',width:100,formatter:getTime">上传时间</th>
					<th data-options="field:'adduserid',width:100,formatter:getUsername">操作者</th>
				</tr>
			</thead>
		</table>
		<center><div onclick="interact_publish()" class="easyui-linkbutton" style="width:100%;margin-top: 10px"><B>选&nbsp;择&nbsp;并&nbsp;发&nbsp;布</B></div></center>
	</div>
	
	<div id="ledW" class="easyui-dialog" title="led显示屏" style="width:60%;height:80%;padding:10px;position:relative;" closed="true">
		<form id="ledForm" action="" method="post">
			<fieldset id="" style="position: absolute;height: 90%;width: 90%;margin-left:5.25px; ">
				<legend>LED设置</legend>
					<table border="0"  height="98%" width="100%" >
						<tr>
							<td width="12%">引入方式：</td>
							<td width="38%">
								
								<select class="easyui-combobox" id="inmethod" name="inmethod" data-options="required:true,editable:false">
									<option value="0">随机</option>
									<option value="1">立即显示</option>
									<option value="2">左滚显示</option>
									<option value="3">上滚显示</option>
									<option value="4">右滚显示</option>
									
									<option value="5">下滚显示</option>
									<option value="6">连续左滚显示</option>
									<option value="7">连续上滚显示</option>
									<option value="8">连续右滚显示</option>
									<option value="9">连续下滚显示</option>
									
									<option value="10">中间向上下展开</option>
									<option value="11">中间向两边展开</option>
									<option value="12">中间向四周展开</option>
									<option value="13">从右向左移入</option>
									<option value="14">从左向右移入</option>
									
									<option value="15">从左向右展开</option>
									<option value="16">从右向左展开</option>
									<option value="17">从右上角移入</option>
									<option value="18">从右下角移入</option>
									<option value="19">从左上角移入</option>
									
									<option value="20">从左下角移入</option>
									<option value="21">从上向下移入</option>
									<option value="22">从下向上移入</option>
									<option value="23">横向百叶窗</option>
									<option value="24">纵向百叶窗</option>
									
									
								</select>
							</td>
							<td width="12%">引入速度：</td>
							<td width="38%"><input class="easyui-slider" name="inspeed" id="inspeed"
								style="width: 200px; height: 5px;"
								data-options="min:0,max:5,step:1,showTip:true"></td>
						</tr>
						<tr>
							<td>引出方式：</td>
							<td>
								<select class="easyui-combobox" name="outmethod" id="outmethod"
								data-options="required:true,editable:false">
									<option value="0">随机</option>
									<option value="1">不消失</option>
									<option value="2">立即消失</option>
									<option value="3">上下向中间合拢</option>
									<option value="4">两边向中间合拢</option>
		
									<option value="5">四周向中间合拢</option>
									<option value="6">从左向右移出</option>
									<option value="7">从右向左移出</option>
									<option value="8">从右向左合拢</option>
									<option value="9">从左向右合拢</option>
		
									<option value="10">从右上角移出</option>
									<option value="11">从右下角移出</option>
									<option value="12">从左上角移出</option>
									<option value="13">从左下角移出</option>
									<option value="14">从下向上移出</option>
		
									<option value="15">从上向下移出</option>
									<option value="16">横向百叶窗</option>
									<option value="17">纵向百叶窗</option>
								</select>
							</td>
							<td>引出速度：</td>
							<td>
								<input class="easyui-slider" name="outspeed" id="outspeed" 
									style="width: 200px; height: 5px;"
									data-options="min:0,max:5,step:1,showTip:true">
							</td>
						</tr>
						<tr>
							<td>对齐方式：</td>
							<td>
								<select class="easyui-combobox" name="alignMethod" id="alignMethod" style="width:100px;"
								data-options="required:true,editable:false,panelHeight:'auto'">
									<option value="0">靠左</option>
									<option value="1">居中</option>
									<option value="2">靠右</option>
								</select>
							</td>
							<td>停留方式：</td>
							<td>
								<select class="easyui-combobox" name="stopmethod" id="stopmethod"
								style="width: 100px;"
								data-options="required:true,editable:false,panelHeight:'auto'">
									<option value="0">静态显示</option>
									<option value="1">闪烁显示</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>停留时间：</td>
							<td>
								<input type="text" class="easyui-numberbox" name="stoptime" id="stoptime" value="1000" data-options="min:0,suffix:'ms'">
								<!-- <input class="easyui-textbox" name="stoptime" id="stoptime" data-options="buttonText:'ms（毫秒）'" > -->
							</td>
							<td>停留速度：</td>
							<td>
								<input class="easyui-slider" name="stopspeed" id="stopspeed"
								style="width: 200px; height: 5px;"
								data-options="min:0,max:5,step:1,showTip:true">
							</td>
						</tr>
						<tr>
							<td>字体类型：</td>
							<td>
								<select class="easyui-combobox" name="fontFamily" id="fontFamily"
								style="width: 100px;"
								data-options="required:true,editable:false,panelHeight:'auto'">
									<option value="黑体">黑体</option>
									<option value="宋体">宋体</option>
									<option value="新宋体">新宋体</option>
									<option value="仿宋">仿宋</option>
									<option value="楷体">楷体</option>
									<option value="微软雅黑">微软雅黑</option>
								</select>
							</td>
							<td>字体大小：</td>
							<td>
								<select class="easyui-combobox" name="fontSize" id="fontSize"
								style="width: 100px;"
								data-options="required:true,editable:false">
									<option value="72">初号</option>
									<option value="48">小初</option>
									<option value="36">一号</option>
									<option value="28">小一</option>
									<option value="26">二号</option>
									<option value="24">小二</option>
									<option value="22">三号</option>
									<option value="20">小三</option>
									<option value="18">四号</option>
									<option value="16">小四</option>
									<option value="14">五号</option>
									<option value="12">小五</option>
									
								
									<!-- <option value="初号">初号</option>
									<option value="小初">小初</option>
									<option value="一号">一号</option>
									<option value="小一">小一</option>
									<option value="二号">二号</option>
									<option value="小二">小二</option>
									<option value="三号">三号</option>
									<option value="小三">小三</option>
									<option value="四号">四号</option>
									<option value="小四">小四</option>
									<option value="五号">五号</option>
									<option value="小五">小五</option>
									<option value="六号">六号</option>
									<option value="小六">小六</option>
									<option value="七号">七号</option>
									<option value="八号">八号</option> -->
								</select>
							</td>
						</tr>
						<tr>
							<td>文本内容：</td>
							<td colspan="3">
								<input class="easyui-textbox" name="text" id="text" data-options="multiline:true" style="width:95%;height:100px">
							</td>
							
						</tr>
						<tr align="center">
							<td colspan="4"><button class="easyui-linkbutton"  style="width:20%;height:25px" onclick="ledSubmit()">发送</button></td>
						</tr>
					</table>
			</fieldset>
		</form>
	</div>
	
	
    
    <div id="screenshot" class="easyui-window" title="在播内容" data-options="iconCls:'icon-save'" style="height:60%;width:50%" closed=true>
		<img id="screenId" alt="正在捕捉屏幕，清稍后。。。"  style="height:100%;width:100%">
<!-- 		<img alt="截屏图片" src="ABS/screenshot/a.png" style="height:100%;width:100%"> -->
	</div>
   
</body>
<script type="text/javascript">
/* 定义变量，记录所操作的设备id */
var conMac;
$.ajax({  
    url: '${pageContext.request.contextPath }/device/catList', 
    dataType: 'json',  
    success: function (jsonstr) {
       jsonstr.unshift({  
            'id': '-1',
            'name': '----设置分组----',
        });//向json数组开头添加自定义数据  
        $('#comboxId').combobox({  
            data: jsonstr,
            valueField: 'id',  
            textField: 'name',
            panelHeight:"auto",
            onLoadSuccess: function () { //加载完成后,设置选中第一项  
                var val = $(this).combobox('getData');  
                for (var item in val[0]) {  
                    if (item == 'id') {  
                        $(this).combobox('select', val[0][item]);  
                    }  
                }  
            }
        });
    }   
});
<%-- '<%=session.getAttribute("deviceTypes")%>' --%>
$(window).load(function(){
    //要执行的方法体
    $.post("${baseurl}/device/findTypes",function(data){
    	$('#comTpId').combobox({
    		
            data:data,
            valueField: 'id',  
            textField: 'name',
            panelHeight:"auto",
            onLoadSuccess: function () { //加载完成后,设置选中第一项  
                var val = $(this).combobox('getData');  
                for (var item in val[0]) {  
                    if (item == 'id') {  
                        $(this).combobox('select', val[0][item]);  
                    }  
                }  
            }
        });
    },"json");
});


$(function(){
	$(".op_btn").click(function(){
		var opId=this.id;
		if(opId == "op1"){
			$("#pcImg").attr('src',"../../images/pcc.png"); 
		}
		if(opId == "op2"||opId == "op0"){
			$("#pcImg").attr('src',"../../images/pc.png"); 
		}
		var params={
			"deviceMac":conMac,
			"opId":opId
		};
		
		$.post("${pageContext.request.contextPath }/arrange/control",params,function(data){
		},"json");
	});
	
	
	

	
	 $('.filt').each(function(){
		    $(this).on('click',function(){
			$("#list").datagrid("load",{"id":this.id});
		    })
		  });
	
	$("#op3").on('click',function(){
			$.post("${pageContext.request.contextPath }/arrange/screenshot",{"deviceMac":conMac},function(){
			setTimeout(look, 2000);
			});
	});
	
	setInterval(updt,2000);
	
});
function interact(){
	var ids= getSelectionsIds();
	if(ids.length==0){
		$.messager.alert("提示","您没有选中任何设备！",'info');
		return;
	}
	 $("#interactDiv").dialog('center').dialog('open');
}
function interact_publish(){
	var ids= getSelectionsIds();
	var zipids = getids("zipList");
	if(zipids.length==0){
		$.messager.alert("提示","请选择要发布的节目包！","info");
		return;
	}
	$.post("${baseurl}/arrange/zip",{"deviceIds":ids,"zipIds":zipids},function(data){
		if(data.status==200){
			$.messager.alert("提示","发布成功！","info",function(){
		    	$("#interactDiv").dialog('close');
				$("#list").datagrid('reload');
			});
		}
	});
	
}

function look(){
	$("#screenshot").dialog("open");
}
function updt(){
	//定时更新img 的URL
	$("#screenId").attr("src","/ABS/screenshot/a.png?"+Date.parse(new Date())); 
}
function control(value,row,index){
	return "<a style='cursor:pointer'  onclick=contr("+JSON.stringify(row.mac)+")>操作</a>";
}
function contr(mac){
	  document.all.Layer2.style.display="block";
	  conMac=mac;
}
function Lock_CheckForm(theForm){   
	  document.all.Layer2.style.display='none';
	  return   false;   
}

function sub(){
	
	var na = $("#addName").val();
	var ma = $("#addMac").val();
	var abs = $("#addAbs").val();
	var gup = $('#comboxId').combobox('getValue');
	var tp = $('#comTpId').combobox('getValue');
	if(na.trim().length==0||ma.trim().length==0||abs.trim().length==0||gup==-1){
		$.messager.alert("错误","该页面所有字段为必填字段！","error");
		return;
	}
	
	var params={
			"addName":na,
			"addMac":ma,
			"addAbs":abs,
			"addGup":gup,
			"addTp":tp
	}; 
	$.post("${pageContext.request.contextPath }/device/addDevice",params,function(data){
		if(data.states=="200"){
			$.messager.alert('提示','设备添加成功！','info',function(){
				$("#addFormId").form('reset');
				$("#w").dialog('close');
			});
		}
		
	},"json");
}

function getSelectionsIds() {
	var list = $("#list");
	var sels = list.datagrid("getSelections");
	var ids = [];
	for ( var i in sels) {
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}
function getSelectIds() {
	var list = $("#programList");
	var sels = list.datagrid("getSelections");
	var ids = [];
	for ( var i in sels) {
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}
function getids(val){
	var list = $("#"+val);
	var sels = list.datagrid("getSelections");
	var ids = [];
	for ( var i in sels) {
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}

function release(){
	var ids= getSelectionsIds();
	if(ids.length==0){
		$.messager.alert("提示","您没有选中任何设备！",'info');
		return;
	}
	 $("#pckId").dialog('center').dialog('open');
	
}
function shutdown(d){
	var ids= getSelectionsIds();
	if(ids.length==0){
		$.messager.alert("提示","请选择要操作的设备！",'warning');
		return;
	}
	
	$.post("${pageContext.request.contextPath }/arrange/shutdown",{"ids":ids,"instruct":d},function(data){
		if(data.status==200){
			$.messager.alert("提示","操作成功","info",function(){
				$("#list").datagrid('reload');
			});
		}
	},"json");	
}

//实例化树菜单  
$("#tree").tree(
				{
					url : '${pageContext.request.contextPath }/device/cat',//请求路径，id为根节点的id  
					animate : true,
					method : "GET",
					onSelect : function(node) {
						var ids = getSelectionsIds();
						var params = {
							"id" : node.id,
							"deviceId" : ids
						};
						$
								.post(
										"${pageContext.request.contextPath }/device/assignGroup",
										params,
										function(data, textStatus,
												XMLHttpRequest) {
											if (XMLHttpRequest.status == 200) {
												$.messager
														.alert(
																'提示',
																'分组成功!',
																undefined,
																function() {
																	location
																			.reload();
																});
											}
										}, "json");

					}

				});

$.ajaxSetup({
	async : false
});

function getTime(value) {
	var d = new Date(value).toLocaleString();
	return d;
}
function getType(val){
	var name;
	$.post("${baseurl}/device/getType",{"typeId":val},function(data){
		name=data;
	});
	return name;
}

function getGroup(value) {
	if (value != null) {
		var param = {
			"groupId" : value
		};
		var str;
		$.post("${pageContext.request.contextPath }/device/getGroupName",
				param, function(data) {
					str = data;
				});
		return str;

	}

}
	function addDev(){
		$("#w").dialog('center').dialog('open');
	}
	
	function assign(){
		var ids = getSelectionsIds();
		if (ids.length == 0) {
			$.messager.alert('提示', '未选中任何设备!','warning');
			return;
		}
		$('#addGroupFrame').attr('src',
				$('#addGroupFrame').attr('src'));
		$("#addGroup").dialog('center').dialog('open');
		
	}
	
	function remv(){
		var ids = getSelectionsIds();
		if (ids.length == 0) {
			$.messager.alert('提示', '未选中任何设备!','info');
			return;
		}
		$.messager
				.confirm(
						'确认',
						'确定删除ID为 ' + ids + ' 的设备吗？',
						function(r) {
							if (r) {
								var params = {
									"ids" : ids
								};
								$.post(
												"${pageContext.request.contextPath }/picture/deviceDelete",
												params,
												function(data,
														textStatus,
														XMLHttpRequest) {
													if (XMLHttpRequest.status == 200) {
														$.messager
																.alert(
																		'提示',
																		'删除设备成功!',
																		undefined,
																		function() {
																			$(
																					"#list")
																					.datagrid(
																							"reload");
																		});
													}
												}, "json");
							}
						});
		
		
		
	}
	
	function getStates(value){
		if(value==0){
			return "未发布";
		}
		if(value==1){
			return "已发布";
		}
	}
	function getPType(value){
		if(value==0){
			return "紧急节目";
		}
		if(value==1){
			return "普通节目";
		}
		if(value==2){
			return "字幕节目";
		}
	}
	function getTime(value) {
		var d = new Date(value).toLocaleString();
		return d;
	}
	function getUsername(value) {
		var s;
		var param ={
			id:value	
		};
		$.post("${pageContext.request.contextPath }/picture/getUser",param,function(data){
			s=data;
		});
		return s;
	}
	function publish(){
		//设备ids
		var dIds = getSelectionsIds();
		//节目包ids
		var row = $("#programList").datagrid("getSelected");
		if(row == null){
			$.messager.alert('警告','您没有选中任何节目！','warning');
			return;
		}
		
		$.post("${pageContext.request.contextPath }/arrange/relevance",{"ids":dIds,"proId":row.id},function(data){
			if(data.states=="200"){
				
				$.messager.alert('提示','发布成功！','info',function(){
					
					 $('#pckId').dialog('close');
					 $('#list').datagrid("reload");
				});
			}
		},"json");
		
		
	}
	function faceSet(){
		var ids= getSelectionsIds();
		if(ids.length==0){
			$.messager.alert("提示","您没有选中任何设备！",'info');
			return;
		}
		$.post("${pageContext.request.contextPath }/face/faceSet",{"ids":ids},function(data){
			if(data.states=="200"){
				$.messager.alert('提示','更新成功！','info');
				$('#list').datagrid("reload");				
			}
		},"json");
		
	}
	function ledSend(){
		var ids= getSelectionsIds();
		if(ids.length==0){
			$.messager.alert("提示","您没有选中任何设备！",'info');
			return;
		}
		$("#ledW").dialog('center').dialog('open');
	}
	
	function ledSubmit(){
		/* var $form = $("#ledForm"),
	    action = $form.attr("action"); */
		/* var param={
	    		"inmethod":,
	    		""
	    } */
	    var inmethod=$("#inmethod").combobox('getValue');
	    var inspeed=$("#inspeed").slider('getValue');
	    var outmethod=$("#outmethod").combobox('getValue');
	    
	    var outspeed=$("#outspeed").slider('getValue');
	    var alignMethod=$("#alignMethod").combobox('getValue');
	    var stopmethod=$("#stopmethod").combobox('getValue');
	    
	    var stoptime=$("#stoptime").numberbox('getValue');
	    var stopspeed=$("#stopspeed").slider('getValue');
	    var fontFamily=$("#fontFamily").combobox('getValue');
	    
	    var fontSize=$("#fontSize").combobox('getValue');
	    var text= $("#text").val();
	    if(stoptime==''||stoptime==null){
	    	alert("停留时间无效!");
	    	return;
	    }
	    	
	    var param={
	    		"inmethod":inmethod,
	    		"inspeed":inspeed,
	    		"outmethod":outmethod,
	    		"outspeed":outspeed,
	    		"alignMethod":alignMethod,
	    		"stopmethod":stopmethod,
	    		"stoptime":stoptime,
	    		"stopspeed":stopspeed,
	    		"fontFamily":fontFamily,
	    		"fontSize":fontSize,
	    		"text":text
	    }
		/* ${pageContext.request.contextPath }/led/send */
       $.post('${pageContext.request.contextPath }/led/send',param,function(data){
        		if(data.sta==200){
	      			alert("发布成功！");
	        		$("#ledW").dialog('center').dialog('close');
	        		$('#list').datagrid("reload");		
        			/* $.messager.alert('提示','发布成功!',"info"); */
        		}
        	
        },"json");
	}
	
	function startup(){
		var ids= getSelectionsIds();
		if(ids.length==0){
			$.messager.alert("提示","请选择要操作的设备！",'warning');
			return;
		}
		
		$.post("${pageContext.request.contextPath }/arrange/startup",{"ids":ids},function(data){
			if(data.status==200){
				$.messager.alert("提示","操作成功","info",function(){
					$("#list").datagrid('reload');
				});
			}
		},"json");	
		
	}
	var toolbar = [{
		 text:'新建节目包',
        iconCls:'icon-add',
        handler:function(){
       	/*  $("#addNewPackage").dialog('center').dialog('open'); */
       	$('#dlg').dialog('open');
        }
		
	},{
       text:'删除',
       iconCls:'icon-cancel',
       handler:function(){
		    var row = $('#programList').datagrid("getSelected");
       	if(row == null){
       		$.messager.alert('提示','未选中节目包!',"warning");
       		return ;
       	}
       	$.messager.confirm('确认','确定删除ID为 '+row.id+' 的节目包吗？',function(r){
       	    if (r){
       	    	var params = {"id":row.id};
               	$.post("${pageContext.request.contextPath }/arrange/proDelete",params, function(data,textStatus,XMLHttpRequest){
           		 	if(XMLHttpRequest.status == 200){
           				$.messager.alert('提示','节目包删除成功!',undefined,function(){
           					$("#programList").datagrid("reload");
           				});
           			} 
           		},"json");
       	    }
       	});
       }
		} ,{
			 text:'节目包编排',
		     iconCls:'icon-edit',
		     handler:function (){
		    	var row = $('#programList').datagrid("getSelected");
		    	//var ids=[];
	        	if(row == null){
	        		$.messager.alert('提示','未选中节目包!',"warning");
	        		return ;
	        	}
	        	if(row.pkgType==2){
	        			$('#tabId').tabs('getTab','关联节目单').panel('options').tab.hide(); 
	        			$('#tabId').tabs('getTab','字幕节目单').panel('options').tab.show(); 
	        	 		$("#tabId").tabs("select","字幕节目单"); 
	        		//查询数据库表格数据回显
	        		$.post("${pageContext.request.contextPath}/arrange/echo",{'id':row.id},function(data){
	        			$("#tname").textbox('setValue',data.name);
	        			$("#message").textbox('setValue',data.message);
	        	
	        			$("#fontSize").combobox('select',data.fontsize);
	        			$('#ss').numberspinner('setValue',data.count);
	        			$("#location").combobox('select',data.location);
	        			$("#speed").combobox('select',data.speed);
	        		},"json");
	        		
	        	}else{
		      		    $('#proList').datagrid('load',{id:row.id});
	        			$('#tabId').tabs('getTab','字幕节目单').panel('options').tab.hide(); 
	        			$('#tabId').tabs('getTab','关联节目单').panel('options').tab.show(); 
	        		    $("#tabId").tabs("select","关联节目单"); 
	        	}
		    	$("#addNewPackage").dialog('open').dialog('setTitle',row.pkgName);
	        	$.post("${pageContext.request.contextPath}/arrange/findRelevanceId",{'id':row.id},function(data){
	        		$('#relevanceDevice').datagrid({  
					    url:"${pageContext.request.contextPath}/device/device?ids="+data
					}) 
	       	    });
		     }
		},{
		   text:'发布',
		   iconCls:'icon-filter',
		   handler:function(){
			   var row = $('#programList').datagrid("getSelected");
	        	if(row == null){
	        		$.messager.alert('提示','请先选择节目包!',"warning");
	        		return ;
	        	}
	        	$.post("${pageContext.request.contextPath}/arrange/issue",{"id":row.id},function(data){
	        		$.messager.alert("提示","发布成功！","info",function(){
	        			$('#programList').datagrid("reload");
	        		});
	        		
	        	},"json");
	        	
		   }
		},{
			text:'取消字幕',
			iconCls:'icon-remove',
			handler:function(){
				var row = $('#programList').datagrid("getSelected");
	        	if(row == null){
	        		$.messager.alert('提示','请先选择节目包!',"warning");
	        		return ;
	        	}
	        	var type = row.pkgType;
	        	if(type != 2){
	        		$.messager.alert('提示','您选择的不是字幕节目!',"warning");
	        		$("#programList").datagrid("reload");
	        		return;
	        	}
	        	
	        	$.post("${pageContext.request.contextPath}/arrange/cancelrealtimemsg",{"id":row.id},function(data){
	        		if(data.status==200){
		        		$.messager.alert("提示","字幕取消成功！","info",function(){
		        			$('#programList').datagrid("reload");
		        		});
	        		}
	        		
	        	},"json");
	        	
			}
		}];
</script>
</HTML>
