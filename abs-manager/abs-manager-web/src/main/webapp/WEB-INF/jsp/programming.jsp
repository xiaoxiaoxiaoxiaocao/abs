<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 发布页面 -->
<head>
<TITLE>添加素材</TITLE>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>

	<div id="cc" class="easyui-layout" style="width:99%;height:550px;">

		<div data-options="region:'west',title:'设备列表',split:true"
			style="width: 120px;">
			<input id="device" value="--请选择设备--" class="easyui-combobox" name="name"
			data-options="required:true,editable:false,valueField:'id',textField:'text',width:110" />
		</div>
		<div data-options="region:'center',title:'已有节目'" style="padding:2px;background:#eee;">
			
		    <table class="easyui-datagrid" id="list" style="width:98%; height:100%"
				data-options="url:'${pageContext.request.contextPath }/picture/releaseList',fitColumns:true,singleSelect:false,pagination:true,
							checkOnSelect:true,striped:true">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'id',width:15">id</th>
						<th data-options="field:'deviceid',width:15,align:'left'">设备ID</th>
						<th data-options="field:'playplanid',width:15,align:'left'">节目ID</th>
						<th data-options="field:'adduser',width:15">添加人</th>
						<th data-options="field:'addtime',width:35,formatter:getTime">添加时间</th>
					</tr>
				</thead>
			</table>
    </div>
    
    
    <div data-options="region:'east',title:'添加节目',split:true" style="width:45%;padding:2px;background:#EEE;">
	     <table class="easyui-datagrid" id="addList" style="width:98%; height:95%"
			data-options="url:'${pageContext.request.contextPath }/picture/playplans',fitColumns:true,singleSelect:true,pagination:true,
						checkOnSelect:true,striped:true">
			<thead>
				<tr>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" id="add_btn" onclick="addToDevice()">添加到此设备</a>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'id',width:15">id</th>
					<th data-options="field:'name',width:15,align:'left'">节目名称</th>
					<th data-options="field:'createuser',width:15">创建人</th>
					<th data-options="field:'createtime',width:35,formatter:getTime">创建时间</th>
				</tr>
			</thead>
		</table>
    </div>
</div>
	
</BODY>

<script type="text/javascript">

function getSelectionsIds() {
	var list = $("#addList");
	var sels = list.datagrid("getSelections");
	var ids = [];
	for ( var i in sels) {
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}

function addToDevice(){
	
		var ids = getSelectionsIds();
		if (ids.length == 0) {
			$.messager.alert('提示', '未选中任何节目!');
			return;
		}
		var id = $("#device").combobox("getValue");
		var params = {
				"ids" : ids,
				"id":id
			};
		$.post("${pageContext.request.contextPath }/picture/addToDevice",params,
				function(data, textStatus,XMLHttpRequest) {
							if (XMLHttpRequest.status == 200) {
								$.messager.alert(
												'提示',
												'添加成功!',
												undefined,
												function() {
													$("#list").datagrid("reload");
													$("#addList").datagrid("reload");
												});
							}
						}, "json");
	
}


function getTime(value) {
	var d = new Date(value).toLocaleString();
	return d;
}
function getUser(value) {
	var param =value;
	$.post("${pageContext.request.contextPath }/picture/getUser",param,date, "json");
	return date;
}


$('#device').combobox({    
    onChange : function(n,o){
    	var param = n;
    	$("#list").datagrid('reload',{param:param});
    }  
})


$.ajax({  
    url: '${pageContext.request.contextPath }/device/deviceList',  
    dataType: 'json',  
    success: function (jsonstr) {  
       jsonstr.unshift({  
            'id': '-1',
            'devicename': '--请选择设备--'  
        });//向json数组开头添加自定义数据  
        $('#device').combobox({  
            data: jsonstr,
            valueField: 'id',  
            textField: 'devicename',  
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



</script>

</HTML>
