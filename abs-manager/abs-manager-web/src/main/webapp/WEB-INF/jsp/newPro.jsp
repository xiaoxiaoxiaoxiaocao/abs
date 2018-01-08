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
		class="easyui-datagrid" style="width: 98%; height: 350px"
		data-options="url:'${pageContext.request.contextPath }/picture/list',fitColumns:true,singleSelect:false,pagination:true,toolbar:toolbar,checkOnSelect:true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:50">id</th>
				<th data-options="field:'name',width:100,align:'left'">素材名称</th>
				<th data-options="field:'size',width:100">素材大小</th>
				<th data-options="field:'addtime',width:100,formatter:getTime">创建时间</th>
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

	var toolbar = [ {
		text : '生成节目包',
		iconCls : 'icon-save',
		handler : function() {
			var ids = getSelectionsIds();
			if (ids.length == 0) {
				$.messager.alert('提示', '未选中素材!');
				return;
			}
			$.messager
					.confirm(
							'确认',
							'确定打包ID为 ' + ids + ' 的素材吗？',
							function(r) {
								if (r) {
									var params = {
										"ids" : ids
									};
									$.post("${pageContext.request.contextPath }/picture/getValue",params,
												function(data, textStatus,
														XMLHttpRequest) {
													if (XMLHttpRequest.status == 200) {
														$.messager.alert(
																		'提示',
																		'素材打包成功!',
																		undefined,
																		function() {
																			$("#list").datagrid("reload");
																		});
													}
												}, "json");
								}
							});
		}
	} ];
</script>
</HTML>
