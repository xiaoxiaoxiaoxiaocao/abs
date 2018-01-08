<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<script type="text/javascript" src="../../js/base-loading.js"></script>
</HEAD>
<body class="easyui-layout">
<!-- 绘制数据表格 -->
	<table class="easyui-datagrid" id="list" style="width:99%; height: 63%"
		data-options="url:'${pageContext.request.contextPath }/picture/list',fitColumns:true,singleSelect:false,pagination:true,
					toolbar:tb,checkOnSelect:true,striped:true">
			
		<thead>
				
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:15" >id</th>
				<th data-options="field:'name',width:45,align:'left'">素材名称</th>
				<th data-options="field:'state',width:20,formatter:getState">状态</th>
				<th data-options="field:'size',width:15">素材大小</th>
				<th data-options="field:'timesize',width:15">播放时长</th>
				<th data-options="field:'addtime',width:50,formatter:getTime">上传时间</th>
				<th data-options="field:'checktime',width:50,formatter:getTime">审核时间</th>
				<th data-options="field:'',width:100,align:'center',formatter:formatOper">预览图</th> 
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto;">    
    <div style="margin-bottom:5px">    
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="remove()">删除</a>    
        <shiro:hasPermission name="user:check">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="pass()">审核通过</a>    
        <a href="#" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onclick="noPass()">审核不通过</a>    
        </shiro:hasPermission>
        <input id="sc" class="easyui-combobox" style="width:100px"    
                valueField="id" textField="text">    
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="qq()">Search</a>    
    </div>    
</div>
</body>
<script type="text/javascript">


function startUp(){
	$("#upDiv").dialog('center').dialog('open');
}
function noPass(){
	var ids = getSelectionsIds();
	if (ids.length == 0) {
		$.messager.alert('提示', '未选中素材!','warning');
		return;
	}
	var params = {
			"ids" : ids
	};
	$.post("${pageContext.request.contextPath }/picture/check_no",params,
			function(data, textStatus,XMLHttpRequest) {
						if (XMLHttpRequest.status == 200){
							$.messager.alert(
								'提示',
								'审核完成!',
								'info',
								function() {
									$("#list").datagrid("reload");
								});
						}
					}, "json");
	
}

function pass(){
	var ids = getSelectionsIds();
	if (ids.length == 0) {
		$.messager.alert('提示', '未选中素材!','warning');
		return;
	}
	var params = {
			"ids" : ids
	};
	$.post("${pageContext.request.contextPath }/picture/check_ok",params,
			function(data, textStatus,XMLHttpRequest) {
						if (XMLHttpRequest.status == 200) {
							$.messager.alert(
								'提示',
								'审核完成!',
								undefined,
								function() {
									$("#list").datagrid("reload");
								});
						}
					}, "json");
	
}
function remove(){
	var ids = getSelectionsIds();
	if (ids.length == 0) {
		$.messager.alert('提示', '未选中素材!');
		return;
	}
	$.messager.confirm('确认','确定删除ID为 ' + ids + ' 的素材吗？',
					function(r) {
						if (r) {
							var params = {
								"ids" : ids
							};
							$.post("${pageContext.request.contextPath }/picture/delete",params,
									function(data, textStatus,XMLHttpRequest) {
												if (XMLHttpRequest.status == 200) {
													$.messager
															.alert(
																	'提示',
																	'素材删除成功!',
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
var jsonstr=[{
	"id":-1,
	"text":"--所有素材--"
},{
	"id":0,
	"text":"图片"
},{
	"id":1,
	"text":"视频"
},{
	"id":2,
	"text":"zip压缩包"
}];
$(function(){
    $('#sc').combobox({  
        data: jsonstr,
        valueField: 'id',  
        textField: 'text',
        editable:false,
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
});

function qq(){
	var id = $("#sc").combobox("getValue");
	var param = {"id":id};
	$("#list").datagrid("load", param);
	
    }
String.prototype.endWith=function(endStr){
	  var d=this.length-endStr.length;
	  return (d>=0&&this.lastIndexOf(endStr)==d)
	}
		
function formatOper(value,row,index){ 
	if(row.name.endWith("jpg")||row.name.endWith("png")||row.name.endWith("gif")||row.name.endWith("bmp")){
		return '<img style="width:60px; height:60px" alt="" src="/ABS/material/'+row.name+'">';
	}
	if(row.name.endWith("mp4")||row.name.endWith("avi")||row.name.endWith("wmv")){
		return '<img style="width:60px; height:60px" alt="" src="/images/video.png">';
		
	}
	if(row.name.endWith("zip")){
		return '<img style="width:60px; height:60px" alt="" src="/images/zip.jpg">';
		
	}
}

	function getTime(value) {
		var d = new Date(value).toLocaleString();
		return d;
	}
	
	function getState(value) {
		if(value==0){
			return "未审核";
		}
		if(value==1){
			return "审核未通过";
		}
		if(value==2){
			return "审核通过";
		}
	
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
</script>
</HTML>
