<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<TITLE>素材列表</TITLE> 
<!-- 新建节目包页面 -->
</HEAD>
<body>
<!-- 绘制数据表格 -->
	<table class="easyui-datagrid" id="list" 
		class="easyui-datagrid" style="width: 99%; height:99%"
		data-options="url:'${pageContext.request.contextPath }/picture/listButCheckOk',fit:true,singleSelect:false,
					scrollbarSize:0,pagination:true,toolbar:toolbar,checkOnSelect:true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:50">id</th>
				<th data-options="field:'name',width:150,align:'left'">素材名称</th>
				<th data-options="field:'size',width:50">素材大小</th>
				<th data-options="field:'addtime',width:140,formatter:getTime">创建时间</th>
			</tr>
		</thead>
	</table>
</body>
<script>
	function getTime(value) {
		var d = new Date(value).toLocaleString();
		return d;
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





	var areaSelect= $("#tem", window.parent.document).val();
	
	
	var toolbar = [ {
		text : '确认添加',
		iconCls : 'icon-save',
		handler : function(){
			var ids = getSelectionsIds();
			if (ids.length == 0) {
				$.messager.alert('提示', '未选中素材!');
				return;
			}
			
			var params = {
								"ids" : ids,
								"area":areaSelect	
							}; 
			$.post("${pageContext.request.contextPath }/arrange/addMaterial",params,
						
					function(data, textStatus,XMLHttpRequest) {
				var iframeWindow =parent.document.getElementById('material').contentWindow;
						if (data.status == 200) {
							var t=window.parent.document.getElementById("list");
							$.messager.alert(
											'提示',
											'素材添加成功!',
											undefined,
											function() {
												$("#list").datagrid("reload");
												/* 刷新父页面的datagrid */
												 iframeWindow.$('#list').datagrid("load");
											});
						}
						if(data.status == 300){
							$.messager.alert(
									'确认',
									'该素材已存在，请勿重复添加!',
									"error",
									function() {
										$("#list").datagrid("reload");
									});
							
						}
					}, "json");
			
			
		}
	} ];
</script>
</HTML>
