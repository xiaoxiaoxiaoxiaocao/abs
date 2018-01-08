<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<script type="text/javascript" src="../../js/jquery.simple-color.js"></script>
<script type="text/javascript" src="../../js/base-loading.js"></script>
<title>节目包列表</title>
<style type="text/css">
.demo{width:760px; margin:20px auto 0 auto; height:70px;}
.button {
	vertical-align:middle;
	display: inline-block; 
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 16px/100% 'Microsoft yahei',Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	text-shadow: 0 1px 1px rgba(0,0,0,.3);
	-webkit-border-radius: .5em; 
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	box-shadow: 0 1px 2px rgba(0,0,0,.2);
}


 .lotion{
  position:absolute;
  left:5%;
  top:55%;
  }
  .loca{
  position:absolute;
  left:5%;
  top:45%;
  } 

.small {
	font-size: 11px;
	padding: .2em 1em .275em;
}


/* blue */
.blue {
	color: #d9eef7;
	border: solid 1px #0076a3;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
	background: -moz-linear-gradient(top,  #00adee,  #0078a5);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee', endColorstr='#0078a5');
}
.blue:hover {
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
	background: -moz-linear-gradient(top,  #0095cc,  #00678e);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#0095cc', endColorstr='#00678e');
}
.blue:active {
	color: #80bed6;
	background: -webkit-gradient(linear, left top, left bottom, from(#0078a5), to(#00adee));
	background: -moz-linear-gradient(top,  #0078a5,  #00adee);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#0078a5', endColorstr='#00adee');
}

</style>
</head>



 <script type="text/javascript">
 
 	
 	function getSdate(value,row,index){
 		var param={
				"plsId":row.plsId
		};
		var str;
		$.post("${pageContext.request.contextPath }/arrange/findPlsSdate",param,function(data){
			str= data.stardate;
		});
			return str;
 	}
 	function getEdate(value,row,index){
 		var param={
				"plsId":row.plsId
		};
		var str;
		$.post("${pageContext.request.contextPath }/arrange/findPlsSdate",param,function(data){
			str= data.enddate;
		});
			return str;
 	}
 	function getStime(value,row,index){
 		var param={
				"plsId":row.plsId
		};
		var str;
		$.post("${pageContext.request.contextPath }/arrange/findPlsSdate",param,function(data){
			str= data.stdtime;
		});
			return str;
 	}
 	function getEtime(value,row,index){
 		var param={
				"plsId":row.plsId
		};
		var str;
		$.post("${pageContext.request.contextPath }/arrange/findPlsSdate",param,function(data){
			str= data.edtime;
		});
			return str;
 	}
</script> 

<body>
<table class="easyui-datagrid" id="programList" title=""
		   style="width: 98%; height: 400px"
	data-options="url:'${pageContext.request.contextPath }/arrange/programList',singleSelect:true,
	fitColumns:true,pagination:true,toolbar:toolbar,striped:true,checkOnSelect:true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th data-options="field:'id',width:50">id</th>
				<th data-options="field:'pkgName',width:100,align:'left'">节目包名称</th>
				<th data-options="field:'states',width:50,formatter:getStates" >状态</th>
				<th data-options="field:'pkgType',width:50,formatter:getType" >节目包类型</th>
				<th data-options="field:'updttime',width:100,formatter:getTime">更新时间</th> 
				<th data-options="field:'operator',width:100,formatter:getUsername">操作者</th>
		   </tr>
		</thead>
	</table>
	<div id="addNewPackage" class="easyui-window" closed="true" style="width:100%;height:%;">
		<div id="tabId" class="easyui-tabs" style="width:100%;height:100%" fit="true">
			<div id="proDivId" title="关联节目单" style="padding: 10px;width:100%;height:90%">
				<table class="easyui-datagrid" id="proList"
					style="width: 100%; height:90%"
					data-options="url:'${pageContext.request.contextPath }/arrange/proPls',
					fitColumns:true,pagination:true,toolbar:menuitem,striped:true,checkOnSelect:true">
					<thead>
						<tr>
							<th field="ck" checkbox="true"></th>
							<th data-options="field:'plsId',width:50,formatter:getName">节目单</th>
							<th data-options="field:'a',width:50,formatter:getSdate">开始有效期</th>
							<th data-options="field:'b',width:50,formatter:getEdate">结束有效期</th>
							<th data-options="field:'c',width:50,formatter:getStime">开始播放时间</th>
							<th data-options="field:'d',width:50,formatter:getEtime">结束播放时间</th>
							<th data-options="field:'createtime',width:50">操作时间</th>
							<th data-options="field:'id',width:30,hidden:true">id</th>
						</tr>
					</thead>
				</table>
			</div>
			
			<div id="tdlg"  title="字幕节目单" style="padding: 10px;width:100%;height:90%">
						<form id="ff" method="post" action="${pageContext.request.contextPath }/arrange/textProPls">
		
		
							<table width="90%"
								style="border-collapse: separate; border-spacing: 0px 10px; text-align: left;">
								<tbody>
									<tr>
										<td>节目单名称:</td>
										<td colspan="3"><input id="tname" class="easyui-textbox"
											type="text" name="name"></input></td>
									</tr>
									<tr>
										<td>文本内容:</td>
										<td colspan="3"><input id="message" class="easyui-textbox"
											name="message" data-options="multiline:true"
											style="width: 100%; height: 60px;"></input></td>
									</tr>
									<tr>
										<td>字体颜色:</td>
										<td><input type="text" id="cp1" value="#000000"
											class="simple_color_color_code" name="tColor"
											onfocus="if(value=='#000000'){value=''}" /></td>
										<td>背景颜色:</td>
										<td><input type="text" id="cp2" value="#000000"
											class="simple_color_color_code" name="bgColor"
											onfocus="if(value=='#000000'){value=''}" /></td>
									</tr>
									<tr>
										<td>字体大小:</td>
										<td><input id="fontSize" class="easyui-combobox"
											name="fontSize"
											data-options="editable:false,panelHeight:'auto'"></td>
										<td>播放次数:</td>
										<td><input id="ss" class="easyui-numberspinner" value="1"
											style="width: 80px;" required="required"
											data-options="min:1,max:100,editable:false"></td>
									</tr>
									<tr>
										<td width="10%">显示位置:</td>
										<td width="40%"><input id="location"
											class="easyui-combobox" name="location"
											data-options="editable:false,panelHeight:'auto'"></td>
										<td width="10%">滚动速度:</td>
										<td width="40%"><input id="speed" class="easyui-combobox"
											name="speed" data-options="editable:false,panelHeight:'auto'"></td>
									</tr>
									
		
								</tbody>
								
							</table>
		
		
						</form>
						<div style="text-align:center;padding:5px;width: 90%">
			    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">确定</a>&nbsp;&nbsp;
			    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
			    </div>
				
				
				
				
			</div>
			
			<%-- <div title="关联终端" style="padding:10px">
				<div style="width: 60%;height:95%;background:#F0FFF0;float: left">
					<table class="easyui-datagrid" id="deviceList" style="width: 100%; height: 98%" title="所有设备"
						data-options="url:'${pageContext.request.contextPath }/device/deList',fitColumns:true,singleSelect:true,pagination:true,
					checkOnSelect:true,striped:true">
						<thead>
							<tr>
								<th data-options="field:'ck',checkbox:true"></th>
								<th data-options="field:'id',width:5">id</th>
								<th data-options="field:'devicename',width:35,align:'left'">名称</th>
								<th data-options="field:'mac',width:25">mac地址</th>
								<th data-options="field:'outputresolution',width:18">分辨率</th>
								<th data-options="field:'grouping',width:30,formatter:getGroup">分组</th>
							</tr>
						</thead>


					</table>


				</div>
				<div style="width: 10%;height:100%;float: left;position: relative">
					<input class="button blue small loca"  type="button" value="关联" style="text-align:middle;width:100px" onclick="relevance()" align="middle">
					<input class="button blue small lotion"  type="button" value="取消关联" style="text-align:middle;width:100px" onclick="unRelevance()" align="middle">
				</div>
				<div style="width: 30%;height:100%;float:right">
					<table id="relevanceDevice" class="easyui-datagrid" style="width: 100%; height: 95%" title="已关联设备"
						data-options="fitColumns:true,pagination:true,striped:true,checkOnSelect:true">
					<thead>
						<tr>
							<th field="ck" checkbox="true"></th>
							<th data-options="field:'id',width:15">设备id</th>
							<th data-options="field:'devicename',width:35">设备名称</th>
							<th data-options="field:'mac',width:45">MAC地址</th>
							<!-- <th data-options="field:'grouping',width:35,formatter:getArea">所属区域</th> -->
						</tr>
					</thead>
				
				</table> 
				</div>
			</div> --%>
	</div>
	</div>
 
	<div id="addpls" class="easyui-window" closed="true"
		style="width:99%; height:80%" title="节目单列表">
		
			<!-- <div style="background: #C6E2FF; height:10%">
			<table width="100%">
				<tr style="height:50px;">
					<td>有效开始时间： <input id="stardate"
						class="easyui-datetimespinner" value=new
						Date() data-options="formatter:formatter1,parser:parser1"
						style="width: 160px;">
					</td>
					<td>有效终止时间： <input id="enddate" class="easyui-datetimespinner"
						value=new
						Date() data-options="formatter:formatter1,parser:parser1"
						style="width: 160px;">
					</td>
				</tr>
				<tr style="height:50px;">
					<td>开始播放时间：<input id="stdtime" class="easyui-timespinner"
						style="width: 80px;" required="required"
						data-options="min:'08:30',showSeconds:false"><br>
					</td>
					<td>结束播放时间：<input id="endtime" class="easyui-timespinner"
						style="width: 80px;" required="required"
						data-options="min:'08:30',showSeconds:false"><br>
					</td>
				</tr>
				<tr style="height:50px;">
					
					<td colspan="2" align="center"><a href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-save'" style="background: #C6E2FF;"
						onclick="savePropls()">保存</a></td>
				</tr>
			</table>
		</div> -->

		<div style="width: 100%; height: 100%;" >
			<table class="easyui-datagrid" id="plsList"
				style="width: 100%; height: 100%"
				data-options="url:'${pageContext.request.contextPath }/arrange/plsList',fitColumns:true,pagination:true,
					scrollbarSize:0,striped:true,checkOnSelect:true,toolbar:tool">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'id',width:5">节目单ID</th>
						<th data-options="field:'name',width:5">节目单名称</th>
						<th data-options="field:'stdtime',width:5">开始播放时间</th>
						<th data-options="field:'edtime',width:5">结束播放时间</th>
					</tr>
				</thead>
			</table>
		</div>



	</div>
	
	
	<div id="dlg" class="easyui-dialog" title="新建节目包" style="width:400px;height:200px;padding:10px" closed="true"
			data-options="
				iconCls: 'icon-save',
				toolbar: [{
					text:'保存',
					iconCls:'icon-save',
 					handler:function(){
					if($('#pkgName').val().trim().length == 0){
						 document.getElementById('pkgName').parentElement.style.border = '1px solid red';
						return;
					}else{
						 document.getElementById('pkgName').parentElement.style.border = '0';
					}
					var param={
						'name':$('#pkgName').val(),
						'type':$('#pkgType').combobox('getValue')
					};
					$.post('${pageContext.request.contextPath }/arrange/savepro',param,function(){
						$('#dlg').dialog('close');
						$('#programList').datagrid('reload');
						
					});
					}
				}]
			">
			<table width="80%" height="100%" align="center">
				<tr>
					<td>
						节目包名称：
					</td>
					<td>
						 <span style="padding-bottom: 4px; padding-top: 4px; padding-left: 0; padding-right: 0">
						<input id="pkgName" name="pkgName" required="required">
						</span>
					</td>
				</tr>
				<tr>
					<td>
						节目包类型：
					</td>
					<td>
						<input id="pkgType" class="easyui-combobox"
						name="pkgType" data-options="required:true,editable:false,valueField:'id',textField:'text',
						
						data:[{
							    'id':1,
							    'text':'普通节目'
							},{
							    'id':0,
							    'text':'紧急节目'
							}]
													
						"/>
						
					</td>
				</tr>
			</table>
	</div>
	


</body>
<script type="text/javascript">
function submitForm(){
	var message = $("#message").val();
	var params={
			"name":$("#tname").val(),
			"message":message,
			"fontSize":$("#fontSize").combobox("getValue"),
			"tColor":$("#cp1").val(),
			"bColor":$("#cp2").val(),
			"location":$("#location").combobox("getValue"),
			"speed":$("#speed").combobox("getValue"),
			"proId":$('#programList').datagrid("getSelected").id,
			"count": $('#ss').numberspinner('getValue')
	};
	if (message.replace(/(^s*)|(s*$)/g, "").trim().length ==0) 
	{ 
		$.messager.alert("警告","消息不能为空","warning");
		return;
	} 
	/* if((typeof message != "undifuned")&&(typeof message.valueOf()=="string")&& message.length>0){
		alert("ddddd");
	} */
	$.post("${baseurl}/arrange/textProPls",params,function(data){
		
		//alert($(map).staus);
		if(data.status=="200"){
			$.messager.alert("提示","字幕单创建成功！","info",function(){
				$("#ff")[0].reset();
			});
		}
	});
}
function clearForm(){
	$("#ff")[0].reset();
}
$(document).ready(function(){
		$('.simple_color_color_code').simpleColor({ displayColorCode: true });
})

var loCombobox_data=[{
	"id":"under",
	"text":"下方"
},{
	"id":"top",
	"text":"上方"
},{
	"id":"center",
	"text":"全屏"
}];

var spdCombobox_data=[{
	"id":"0",
	"text":"慢"
},{
	"id":"1",
	"text":"正常"
},{
	"id":"2",
	"text":"快"
}];
 var fszCombobox_data=[{
	 "id":"14px",
	 "text":"14px"
 },{
	 "id":"16px",
	 "text":"16px"
 },{
	 "id":"18px",
	 "text":"18px"
 },{
	 "id":"20px",
	 "text":"20px"
 }];
 
 window.onload = function() {
		$('#location').combobox({
			data :loCombobox_data,
			valueField : 'id',
			textField : 'text',
			
		});
		$('#speed').combobox({
			data :spdCombobox_data,
			valueField : 'id',
			textField : 'text',
			
		});
		$('#fontSize').combobox({
			data :fszCombobox_data,
			valueField : 'id',
			textField : 'text',
			
		});
		$(".easyui-combobox").combobox({
			onLoadSuccess : function() { //加载完成后,设置选中第一项  
				var val = $(this).combobox('getData');
				for ( var item in val[0]) {
					if (item == 'id') {
						$(this).combobox('select', val[0][item]);
					}
				}
			}
		});
		
	}


	function getTime(value) {
		var d = new Date(value).toLocaleString();
		return d;
	}
	
	function getGroup(value) {
		if(value != null){
			var param = {
					"groupId":value
				};
				var str;
				$.post("${pageContext.request.contextPath }/device/getGroupName",param,function(data){
					str=data;
				});
					return str;
				
			
		}
		
	}

$.ajaxSetup({
	  async: false
	  });
function relevance(){
	
	var params={
			"proId":$('#programList').datagrid("getSelected").id,
			"ids":getSelIds()
	};
	$.post("${pageContext.request.contextPath }/arrange/relevance",params,function(data){
		if(data.states=="200"){
			$.messager.alert("提示","关联成功！","info");
			$('#deviceList').datagrid("reload");
			/* $('#relevanceDevice').datagrid("reload"); */
			$.post("${pageContext.request.contextPath}/arrange/findRelevanceId",{'id':$('#programList').datagrid("getSelected").id},function(data){
				  $('#relevanceDevice').datagrid('options').url="${pageContext.request.contextPath}/device/device?ids="+data;
				$('#relevanceDevice').datagrid("reload");
       	    });
		}
	},"json");
}
function getUnRelevanceIds(){
	var sels=$("#relevanceDevice").datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}

function unRelevance(){
	var proId=$('#programList').datagrid("getSelected").id;
	var params={
			"proId":proId,
			"ids":getUnRelevanceIds()
	};
	$.post("${pageContext.request.contextPath }/arrange/unRelevance",params,function(data){
		if(data.states=="200"){
			$.messager.alert("提示","操作成功！","info",function(){
				$.post("${pageContext.request.contextPath}/arrange/findRelevanceId",{'id':proId},function(data){
				  $('#relevanceDevice').datagrid('options').url="${pageContext.request.contextPath}/device/device?ids="+data;
				$('#relevanceDevice').datagrid("reload");
       	    });
			});
		}
	},"json");
	
	
}
function getArea(value){
	var name;
	$.post("${pageContext.request.contextPath }/device/getGroupName",{"groupId":value},function(data){
		name=data;
	});
	return name;
}
function getArea1(value){
	var name;
	$.post("${pageContext.request.contextPath }/device/getGroupName1",{"groupId":value},function(data){
		name=data;
	});
	return name;
}
function getName(value){
	var name;
	$.post("${pageContext.request.contextPath }/arrange/getPlsNameById",{"id":value},function(data){
		name=data;
	});
	return name;	
}

function getType(value){
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
function getStates(value){
	if(value==0){
		return "未发布";
	}
	if(value==1){
		return "已发布";
	}
}
function getSelIds(){
	var sels = $("#deviceList").datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}

function getSelectionsIds(){
	var list = $("#plsList");
	var sels = list.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}
function getSelectIds(){
	var list = $('#proList');
	var sels = list.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}

function formatter1(date){
	if (!date){return '';}
	return $.fn.datebox.defaults.formatter.call(this, date);
}
function parser1(s){
	if (!s){return null;}
	return $.fn.datebox.defaults.parser.call(this, s);
}


$('.easyui-combobox').combobox({
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
	function formatOper(){
		
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
	function getTime(value){
		var d = new Date(value).toLocaleString();
		return d;
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
		},/* {
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
		} *//* {
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
		} */];
	/* , {
			text : '新建字幕单',
			iconCls : 'icon-pen',
			handler : function() {
				$("#tdlg").dialog('center').dialog('open');
				
			}

		}  */

	
	
	var menuitem = [{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中任何节目单!','warning');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除选中的节目单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("${pageContext.request.contextPath }/arrange/proplsDelete",params, function(data,textStatus,XMLHttpRequest){
            		 	if(XMLHttpRequest.status == 200){
            				$.messager.alert('提示','节目单删除成功!',undefined,function(){
            					$("#proList").datagrid("reload");
            				});
            				} 
            		},"json");
        	    }
        	});
        }
		} ,{
			 text:'添加节目单',
	         iconCls:'icon-add',
	         handler:function(){
	        	 $("#addpls").dialog('center').dialog('open');
	        	 $("#plsList").datagrid('reload');
	         }
			
		}];
		
		var tool=[{
			text:'添加',
	         iconCls:'icon-save',
	         handler:function(){
	        		var ids= getSelectionsIds();
	        		if(ids.length==0){
	        			$.messager.alert("警告","您未选择任何节目！","info");
	        			return;
	        		}
	        		var params={
	        			"ids":ids,
	        			"proId":$('#programList').datagrid("getSelected").id
	        		};
	        		$.post("${pageContext.request.contextPath }/arrange/savePropls",params,function(data){
	        			if(data.states=="200"){
	        				$.messager.alert("提示","节目单添加成功！","info");
	        	       	 $("#addpls").dialog('close');
	        	       	 $("#proList").datagrid('reload');
	        			}
	        		},"json");
	        	}
		}];
</script>




</html>