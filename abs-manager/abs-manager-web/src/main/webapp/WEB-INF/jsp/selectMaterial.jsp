<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../common/easyui.jsp" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<script type="text/javascript" src="../../js/datagrid-dnd.js"></script>
<script type="text/javascript" src="../../js/base-loading.js"></script>
<title>Insert title here</title>
</head>
<body class="easyui-layout">

<!-- 绘制数据表格 -->
	<table class="easyui-datagrid" id="list" style="width:100%; height:100%"
		data-options="url:'${pageContext.request.contextPath }/arrange/selectMsterialByArea',fitColumns:true,singleSelect:true,
					toolbar:toolbar,checkOnSelect:true,striped:true,onLoadSuccess:function(){
				$(this).datagrid('enableDnd');
			}">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:10">id</th>
				<th data-options="field:'name',width:45">素材名称</th>
				<th data-options="field:'size',width:15">素材大小</th>
				<th data-options="field:'timesize',width:20">播放时长</th>
				<th data-options="field:'delete',width:10,formatter:formatDel">操作</th>
			</tr>
		</thead>
	</table>
	<div id="addMaterial" class="easyui-dialog" data-options="" title="素材列表" closed="true" style="width:100%;height:100%">
		<iframe id="addMaterialFrame" src="${pageContext.request.contextPath }/ui/addMaterial" style="width:98%;height:98%" scrolling="no">
		</iframe>
	</div>
	
</body>
<script>
	var pDocument= parent.document; 
	var areaSelect;
	$(function() {
		$('#list').datagrid({
			onClickRow : function(index, data) {
				$.post("${pageContext.request.contextPath }/picture/findById",{"id":data.id},function(dt){
					parent.window.$("#detail").show();
					pDocument.getElementById("dtForm").reset();
					
					
					pDocument.getElementById("nm").innerHTML=data.name;
					tp=data.type==0?"图片":"视频";
					pDocument.getElementById("tp").innerHTML=tp;
					pDocument.getElementById("temId").value=data.id;
					if(data.type==1){
						//该素材是视频，设置背景框隐藏
					pDocument.getElementsByTagName("li")[3].style.display = "none";
					pDocument.getElementsByTagName("li")[4].style.display = "none";
						
					}else{
					pDocument.getElementsByTagName("li")[3].style.display = "block";
					pDocument.getElementsByTagName("li")[4].style.display = "block";
					}
					
				},"json")


			}
		})
	});

	function formatDel(value, row, index) {
		return '<a style="cursor:pointer" onclick=del(' +JSON.stringify(row.id)
				+ ')>删除</a>';
	}
	function del(id) {
		var param = {
			"id" : id,
			"area" : areaSelect
		};
		$.post("${pageContext.request.contextPath }/arrange/deleteTemById",
				param, function(data, textStatus, XMLHttpRequest) {
					if (XMLHttpRequest.status == 200) {
						$.messager.alert('提示', '删除成功!', "info", function() {
							$("#list").datagrid("reload");
						});
					}

				}, "json")
	}
	var $parent = self.parent.$;
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
		text : '添加素材',
		iconCls : 'icon-add',
		handler : function() {
			areaSelect = pDocument.getElementById("tem").value;
			var temName = pDocument.getElementById("temName").value;
			var plsName = pDocument.getElementById("plsName").value;
			if (temName == "文本区") {
				alert("文本区不允许添加播放素材！");
				return;
			}
			if (plsName.length == 0) {
				alert("节目名称不能为空！");
				return;
			}
			if (areaSelect.length == 0) {
				alert("请先选择一个播放区域！");
				return;
			}

			$parent('#pwin').window({
				width : 450,
				height : 450,
				/*  fit:true, */
				content : $('#addMaterial').html(),
				title : '添加素材'
			});
		}
	} ];
</script>
</html>