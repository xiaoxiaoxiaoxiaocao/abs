<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <%@ include file="../../common/easyui.jsp" %> --%>


<script type="text/javascript" src="${baseurl }/js/jquery.js"></script>
<!-- 导入easyui必须的库 -->
<!--皮肤-->
<script type="text/javascript" src="${baseurl }/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="${baseurl }/easyui/themes/default/easyui.css">
<!--EasyUI各种图片样式-->
<link rel="stylesheet" type="text/css" href="${baseurl }/easyui/themes/icon.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${baseurl }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${baseurl }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${baseurl }/easyui/locale/easyui-lang-zh_CN.js"></script>



<%@ include file="./timeOut.jsp" %>
<script type="text/javascript" src="../../js/drag.js"></script>
<!-- <script type="text/javascript" src="../../js/jquery.js"></script> -->
<script src="../../js/jquery.contextmenu.js"></script>
<script type="text/javascript" src="../../js/base-loading.js"></script>
<link rel="stylesheet" href="../../css/jquery.contextmenu.css">

<script type="text/javascript" src="../../js/jquery.colorpicker.js"></script>
<title>Insert title here</title>
<style type="text/css">


.bt {
	color: blue;
	margin: 5px 0px 5px 15px;
}

.easyui-draggable {
	background-color: #FFFFFF;
	opacity: 0.8;
	/* resize:both;*/
	overflow: auto;
	text-align: center;
	cursor: pointer;
	position: absolute;
	border: 1px solid #000;
}

.oDiv {
	position: relative;
	border: 1px solid #E0FFFF;
	z-index: 1;
}

.spanClass {
	display: inline-block;
	width: 50px;
	line-height: 30px;
	text-align: center;
}

#colorpanel {
	cursor: pointer;
}

.areaTableClass{
	border-right:1px solid #000;
	border-bottom: 1px solid #000;
}
.areaTableClass td{
	border-left: 1px solid #000;
	border-top:1px solid #000;
}
</style>
</head>
<body>
	<table class="easyui-datagrid" id="templateId" style="height:340px;width:99%"
			data-options="url:'${pageContext.request.contextPath }/arrange/findAllArrange',
			fitColumns:true,pagination:true,striped:true,checkOnSelect:true,toolbar:toolbar">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id'">id</th>
				<th data-options="field:'name'">模版名称</th>
				<th data-options="field:'resolution'">屏幕分辨率</th>
			</tr>
		</thead>
	</table>
		<div id="newModelDiv" class="easyui-window"
			style="height: 100%; width: 100%" closed="true" title="新建模版">
			<div class="easyui-layout" style="width: 100%; height: 100%;">
				<div data-options="region:'east',split:true" style="width: 20%;"
					title="区域属性" id="westDiv">
					<form action="${pageContext.request.contextPath }/arrange/temSave"
						id="temForm" name="temForm">

						<span class="spanClass">类型：</span> <input id="reName"
							name="reName"><br> <span class="spanClass">X：</span>
						<input id="re_x_id" class="easyui-numberspinner"
							style="width: 80px;" required="required"
							data-options="min:0,editable:true"><br> <span
							class="spanClass">Y：</span> <input id="re_y_id"
							class="easyui-numberspinner" style="width: 80px;"
							required="required" data-options="min:0,editable:true"><br>
						<span class="spanClass">height:</span> <input type="text"
							id="reHeight" name="reHeight"><br> <span
							class="spanClass">width:</span> <input type="text" id="reWidth"
							name="reWidth"><br> <span class="spanClass">背景色</span>
						<input type="text" id="cp2" value="#FFFFFF"
							onfocus="if(value=='#FFFFFF'){value=''}" readonly="readonly" />
							<input id="reId" name="reId" type="hidden">
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="save()">保存模版</a>
					</form>
					<div id="areaTableId" title="播放区域" style="width: 100%;height:50%;position: absolute;;;bottom: 0%;background:#ccc;">
					<table id="areaTableId" class="areaTableClass" style="width: 100%;">
						<thead>
							<tr>
								<td width="20%">id</td>
								<td width="50%">类型</td>
								<td width="30%">操作</td>
							</tr>
						</thead>
					
					
					</table>
				
					
					</div>
				</div>
				<div data-options="region:'west',split:true" title="模版详情"
					style="width: 20%;">
					<div class="easyui-tabs" style="width: 100%; height: 100%">
						<div title="布局" style="padding: 1px">
							模版名称:<input type="text" id="modelName" name="modelName"
								required="required">&nbsp;<span style="color:red">*</span><br><br>
							<a onclick="createDIV()" class="easyui-linkbutton"
								data-options="iconCls:'icon-add'">添加一个空白模版</a><br><br>
							<input id="divSize" class="easyui-combobox" name="divSize"
								data-options="editable:false,panelHeight:'auto'">

						</div>
						<div title="布局背景" style="padding: 1px">
							<!-- <span class="spanClass">背景色</span>
							<input type="text" id="cp1" value="#FFFFFF"
							onfocus="if(value=='#FFFFFF'){value=''}" /> -->
							
						
						</div>
						<div title="布局元素" style="padding: 1px">
							<input id="1" type="button" class="bt" style="height:65px;width:65px;cursor:pointer" value="播放区" >
							<input id="2" type="button" class="bt" style="height:65px;width:65px;cursor:pointer" value="图片区" >
							<input id="3" type="button" class="bt" style="height:65px;width:65px;cursor:pointer" value="日期区" >
							<input id="4" type="button" class="bt" style="height:65px;width:65px;cursor:pointer" value="星期区" >
							<input id="5" type="button" class="bt" style="height:65px;width:65px;cursor:pointer" value="时间区" >
							<input id="6" type="button" class="bt" style="height:65px;width:65px;cursor:pointer" value="表格区" >
							<input id="7" type="button" class="bt" style="height:65px;width:65px;cursor:pointer" value="天气预报" >
							<input id="8" type="button" class="bt" style="height:35px;width:65px;cursor:pointer" value="文本区" >
							<input id="9" type="button" class="bt" style="height:65px;width:65px;cursor:pointer" value="新闻" >
						</div>
					</div>
				</div>
				<div id="center" data-options="region:'center',title:'模版制作',iconCls:'icon-ok'">
				
					<div id="textDiv" class="textclass" style="height: 30%;width: 55%; position: absolute;left: 26%;bottom: 30%;display: none;z-index: 5">
						<textarea id="text" name="text" style="height: 100%;width: 100%;" placeholder="请在此处输入文本内容。。。"></textarea>
					</div>
					
				</div>

			</div>
		</div>
	
</body>


<script type="text/javascript">	
	var divId=1;
	
	 $("#text").blur(function(){
		 /* 失去焦点提交form 表单 */
		 var str = document.getElementById("text").value;
		 var param={
				 "text":str,
				 "reId":$("#reId").val()
		 };
		$.post("${pageContext.request.contextPath }/arrange/saveText",param);
         
   });
	
	
	function save(){
		if($("#modelName").val()==""){
			$.messager.alert("错误","模版名称不能为空","error");
			return;
		}
		var params={
				"modelName":$("#modelName").val(),
				"modelSize":$("#divSize").combobox('getText').trim()
				/* "bgcolor": */
		}
		$.post("${pageContext.request.contextPath }/arrange/saveModel",params,function(data){
			if(data.status=="200"){
				$.messager.alert("确认","模版创建成功！","info",function(){
					window.location.href="${pageContext.request.contextPath}/ui/templateUI";
					
				});	
			}
			
		},"json");
	}
	
	
	
	$(function(){
		$("#cp2").colorpicker({
		   fillcolor:true,
		   success : function(obj, color) {
				if ($("#reId").val() != null) {
					var i=$("#reId").val();
					var params = {
						"id" : i,
						"color" : color
					};
			$.post("${pageContext.request.contextPath }/arrange/updateColor",
					params,function(){
				/* document.getElementById(i+"").style.backgroundColor = color; */
				$("#"+i).css("background-color",color);
			});
				}
			}//选择颜色后的成功回调	 
		});
	});
	
	
	


	$(".bt").on('click', function() {
		//获取父容器
		var vessel = document.getElementById("oDiv");
		if (vessel == null) {
			$.messager.alert("错误", "必须先添加一个模版", "error");
		}
		var sDiv = document.createElement('div');
		sDiv.id = "s"+divId;

		sDiv.style.width = this.scrollWidth + "px";
		sDiv.setAttribute("class", "easyui-draggable");
		sDiv.style.height = this.scrollHeight + "px";
		sDiv.innerHTML = this.value + "";
		$("thead").append("<tr><td width:'20%'>"+divId+"</td><td width:'50%'>"+this.value+"</td><td width:'30%'>"+
		"<a onclick='delDiv(this)' style='cursor:pointer'>删除</a>"+
		"</td></tr>");
		divId++;
		vessel.appendChild(sDiv);
		$('.easyui-draggable').each(function() {
			$(this).dragging({
				move : 'both',
				randomPosition : false,
			});
			$(this).resizable();
			$(this).bind("mouseup", mouseUp);
			

		});
	});

	function delDiv(node){
		 
		var tr1 = node.parentNode.parentNode;
		//删除所在的表格中的数据
		 tr1.remove();
		//所在行tr的id 
		var rId = tr1.children[0].innerHTML;
		//删除模版制作区域对应的div，对应的id为's'+rId
		// var child =document.getElementById("s"+rId);
		var child =$("#s"+rId);
		child.remove();
		//删除session中对应的数据
		$.post("${pageContext.request.contextPath }/arrange/delDiv", {
			"id" : rId
		});
	}
	

	function hex(x) {
		return ("0" + parseInt(x).toString(16)).slice(-2);
	}
	function trans(rgb) {
		rgb = rgb.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
		rgb = "#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]);
		return rgb;
	}

	function mouseUp() {
		var selColor = $(this).css("background-color");
		selColor = trans(selColor);
		var x = this.offsetLeft;
		var y = this.offsetTop;
		$("#reName").val(this.innerText);
		$('#re_x_id').numberspinner('setValue', x);
		$('#re_y_id').numberspinner('setValue', y);
		$("#reHeight").val(this.scrollHeight + "px");
		$("#reWidth").val(this.scrollWidth + "px");
		$("#reId").val(this.id);
		$("#cp1").val(selColor);
		var params = {
			"type" : this.innerText,
			"x" : x,
			"y" : y,
			"height" : this.scrollHeight,
			"width" : this.scrollWidth,
			"color" : selColor,
			"divId" : this.id
		};
		$.post("${pageContext.request.contextPath }/arrange/temSave", params);
	}

	var combobox_data = [ {
		"id" : "640*360",
		"text" : "1920*1080"
	}, {
		"id" : "341*256",
		"text" : "1024*768"
	}, {
		"id" : "107*80",
		"text" : "480*720"
	},{
		"id" : "360*640",
		"text" : "1080*1920"
		
	},{
		"id" : "455*256",
		"text" : "1366*768"
		
	} ];

	var arr = new Array();

	window.onload = function() {
		$('#divSize').combobox({
			data : combobox_data,
			valueField : 'id',
			textField : 'text',
			onLoadSuccess : function() { //加载完成后,设置选中第一项  
				var val = $(this).combobox('getData');
				for ( var item in val[0]) {
					if (item == 'id') {
						$(this).combobox('select', val[0][item]);
					}
				}
			},
			onChange : function(n, o) {
				// n就是选择项的value值 
				arr = n.split("*"); //字符分割 
				var tDiv = document.getElementById("oDiv");
				if (tDiv != null) {
					tDiv.style.width = arr[0] + "px";
					tDiv.style.height = arr[1] + "px";
				}

			}

		});
	}
	
	 
	function createDIV() {
		//创建div，默认大小1920*1080，等比缩小3倍
		//center 即父div
		var content = document.getElementById("center");
		//content.innerHTML = "";
		var b = document.getElementById("oDiv");
		if (b == null) {

			//创建div
			var oDiv = document.createElement('div');
			//获取下拉框的值

			oDiv.id = "oDiv";
			oDiv.setAttribute("class", "oDiv");
			oDiv.style.width = arr[0] + "px";
			oDiv.style.height = arr[1] + "px";
			oDiv.style.background = "#EBEBEB";
			content.appendChild(oDiv);
			//向区域属性写入数据
			$("#reName").val("空白模版");
			$('#re_x_id').numberspinner('setValue', 0);
			$('#re_y_id').numberspinner('setValue', 0);
			$("#reHeight").val(arr[1] + "px");
			$("#reWidth").val(arr[0] + "px");
		} else {
			$.messager.alert("错误", "您已添加过模版，不能重复添加!", "error");
		}

	}
	
	function getSelectIds(){
		var list = $("#templateId");
		var sels = list.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}

	var toolbar = [ {
		text : '新建模版',
		iconCls : 'icon-add',
		handler : function() {
			$("#newModelDiv").dialog("center").dialog("open");

		}
	},{
		text:'删除模版',
		iconCls:'icon-cancel',
		handler:function(){
			var ids= getSelectIds();
			if(ids.length==0){
				$.messager.alert("警告","请先选择模版！","info");
				return;
			}
			$.post("${pageContext.request.contextPath }/arrange/deleteModel",{"ids":ids},function(data){
				if(data.states=="200"){
					$.messager.alert("提示","删除成功！","info",function(){
						$("#templateId").datagrid("reload");
					});
				}
			},"json");
		}
	}]
</script>
</html>