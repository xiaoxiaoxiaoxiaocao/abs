<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="../../js/base-loading.js"></script>	
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>
		
<body>	

		<table class="easyui-datagrid" id="rolesId" style="width:100%;height:80%"
			data-options="url:'${baseurl}/user/permissionList',fitColumns:true,pagination:true,
					striped:true,checkOnSelect:true,singleSelect:true,toolbar:toolbar">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'id',width:5">权限ID</th>
						<th data-options="field:'name',width:10">权限名称</th>
						<th data-options="field:'url',width:10">拦截路径</th>
						<th data-options="field:'pcode',width:10">PCODE</th>
						<th data-options="field:'remark',width:10">备注</th>
					</tr>											
				</thead>
		
		</table>

	


	<div id="addWin" class="easyui-window" title="新增权限"
		data-options="minimizable:false,collapsible:false"
		style="width: 40%; height: 50%; padding: 10px;" closed=true>
		<form id="ff" method="post" action="${baseurl }/user/addRole">
			<table cellpadding="5" align="center" style="width: 80%; height: 80%">
				<tr>
					<td width="20%">权限名称:</td>
					<td><input id="nameId" class="easyui-textbox" type="text" name="name"
						data-options="required:true" style="width: 60%; height: 25px"></input>
						<span style="color: red;font-size: 16px"><b>*</b></span>
					</td>
				</tr>

				<tr>
					<td>拦截路径:</td>
					<td>
					
						<input id="urlId" name="url" class="easyui-textbox"  style="width: 60%; height: 25px"></input>
					</td>
				</tr>
				<tr>
					<td>PCODE:</td>
					<td>
						<input id="pcodeId" class="easyui-textbox" data-options="required:true" style="width: 60%; height: 25px">
						<span style="color: red;font-size: 16px"><b>*</b></span>
					</td>
				</tr>
				<tr>
					<td>备   注:</td>
					<td>
						<input id="markId" class="easyui-textbox" style="width: 60%; height: 25px">
					</td>
				</tr>
				
			</table>
			
			<div style="text-align: center; padding: 10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="submitForm()">保存</a>&nbsp;<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm()">重置</a>
			</div>
		</form>
	</div>
	
	
	<div id="editWin" class="easyui-window" title="修改权限" style='width: 50%; height:80%; padding: 10px;'
		data-options="minimizable:false,collapsible:false"
		 closed=true>
		<form id="ef" method="post" action="${baseurl }/user/addRole">
			<table cellpadding="5" align="center" style="width: 80%; height: 80%">
				<tr>
					<td width="20%">权限名称:</td>
					<td><input id="reNameId" class="easyui-textbox" type="text" name="name"
						data-options="required:true" style="width: 60%; height: 25px"></input>
						<span style="color: red;font-size: 16px"><b>*</b></span>
					</td>
				</tr>

				<tr>
					<td>拦截路径:</td>
					<td>
					
						<input id="reUrlId" name="url" class="easyui-textbox" style="width: 60%; height: 25px"></input>
					</td>
				</tr>
				<tr>
					<td>PCODE:</td>
					<td>
						<input id="repcodeId" class="easyui-textbox" data-options="required:true" style="width: 60%; height: 25px">
						<span style="color: red;font-size: 16px"><b>*</b></span>
					</td>
				</tr>
				<tr>
					<td>备   注:</td>
					<td>
						<input id="remarkId" class="easyui-textbox" style="width: 60%; height: 25px">
					</td>
				</tr>
				
			</table>
			<div style="text-align: center; padding: 10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="reSubmitForm()">保存</a>&nbsp;<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="reClearForm()">重置</a>
			</div>
		</form>
	</div>
	
</body>



	<script type="text/javascript">
	function clearForm(){
		$('#ff').form('clear');
	}
	function reClearForm(){
		$('#ef').form('clear');
	}
	
	$(function(){
		$.post("${baseurl}/user/findAllPermission",function(d){
			for(var i in d){
				$(".qxId").append('<input type="checkbox" name="pms" value='+d[i].id+'>'+d[i].name);
				$(".reqxId").append('<input type="checkbox" name="repms" value='+d[i].id+'>'+d[i].name);
			}
				
			
		},"json");
	});
	
	function getSelectIds() {
		var list = $("#rolesId");
		var sels = list.datagrid("getSelections");
		var ids = [];
		for ( var i in sels) {
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}

	function submitForm(){
	     
		
		
		var name=$("#nameId").val();
		var url=$("#urlId").val();
		var pcode=$("#pcodeId").val();
		var mark=$("#markId").val();
		if(name.trim().length==0 || pcode.trim().length==0){
			return false;
		}
		$.post("${baseurl }/user/addPermission",{"name":name,"url":url,"pcode":pcode,"mark":mark},function(data){
			if(data.status==200){
				$.messager.alert("提示","添加成功！","info",function(){
					$("#addWin").window('close');
					$("#rolesId").datagrid('reload');
				});
			}
		},"json");
	}
	function reSubmitForm(){
		var id = $("#rolesId").datagrid('getSelected').id;
		var name=$("#reNameId").val();
		var url=$("#reUrlId").val();
		var pcode=$("#repcodeId").val();
		var mark=$("#remarkId").val();
		if(name.trim().length==0||pcode.trim().length==0){
			return false;
		}
		var params={
				"id":id,
				"name":name,
				"url":url,
				"pcode":pcode,
				"mark":mark
		}
		$.post("${baseurl }/user/changePermission",params,function(data){
			if(data.status==200){
				$.messager.alert("提示","修改成功！","info",function(){
					$("#editWin").window('close');
					$("#rolesId").datagrid('reload');
				});
			}
		},"json");
	}
$.ajaxSetup({
	  async: false
});
/* 	


	
	
	


function getOrganName(value,row,index){
	var name;
	$.post("${pageContext.request.contextPath }/user/getOgName",{"id":value},function(d){
		name=d;
	});
	return name;
}

function saveEdit(){
	var pId = $("#cmb2").combobox('getValue');
	var n=$("#eGroupId").val();
	var id=$("#hd").val();
	if(n.trim().length==0){
		$("#sav").attr("disabled",true);
		$("#eTip1").html("机构名称无效");
		return false;
	}
	if(pId==-1){
		$("#sav").attr("disabled",true);
		$("#eTip2").html("请选择上级机构");
		return false;
	}
	 $.ajax({
	       type: "POST",
	       url:"${pageContext.request.contextPath }/user/editOrgan",
	       data:{"pId":pId,"name":n,"id":id},
	       cache: false,
	       success: function(data) {
	           if(data.status==200){
	        	 $.messager.alert("提示","机构添加成功！","info");
					}
				}
			});
	 
	
}
function saveGroup(){
	var id = $("#cmb").combobox('getValue');
	var n=$("#groupId").val();
	var city=$("#city").combobox('getValue');
	if(city ==""){
		$("#save").attr("disabled",true);
		$("#tip3").html("行政区域不能为空");
		return false;
	}
	if(n.trim().length==0){
		$("#save").attr("disabled",true);
		$("#tip1").html("机构名称无效");
		return false;
	}
	if(id==-1){
		$("#save").attr("disabled",true);
		$("#tip2").html("请选择上级机构");
		return false;
	}

   
 $.ajax({
       type: "POST",
       url:"${pageContext.request.contextPath }/user/addOrgan",
       data:{"id":id,"name":n,"city":city},
      // async: false,
       cache: false,
       success: function(data) {
           if(data.status==200){
        	 //$.messager.alert("提示","机构添加成功！","info");
				}
			}
		});
	}

	$(function() {
		$("#groupId").focus(function() {
			$("#save").attr("disabled", false);
			$("#tip1").html("");
		});
		$("#eGroupId").focus(function() {
			$("#sav").attr("disabled", false);
			$("#eTip1").html("");
		});
		$('#groupId').blur(function () {  
		    var val =  $(this).val();
		    $.post("${pageContext.request.contextPath }/user/checkOrganName",{"name":val},function(d){
		    	if(d>0){
		    		$("#tip1").html("该机构名称已被占用");
		    	}
		    	
		    });
		});
		$('#eGroupId').blur(function () {  
		    var val =  $(this).val();
		    $.post("${pageContext.request.contextPath }/user/checkOrganName",{"name":val},function(d){
		    	if(d>0){
		    		$("#eTip1").html("该机构名称已被占用");
		    	}
		    	
		    });
		});
	});
	$.ajax({
		url : '${pageContext.request.contextPath }/user/groups',
		dataType : 'json',
		success : function(jsonstr) {
			jsonstr.unshift({
				'id' : '-1',
				'name' : '---请选择机构---'
			});//向json数组开头添加自定义数据  
			$('.eParentOrgan').combobox({
				data : jsonstr,
				valueField : 'id',
				textField : 'name',
				editable : false,
				panelHeight : 'auto',
				onChange : function change() {
					$("#tip2").html("");
					$("#eTip2").html("");
					$("#save").attr("disabled", false);
					$("#sav").attr("disabled", false);
				},
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
	});


	function getName(value, row, index) {
		var gName;
		$.post("${pageContext.request.contextPath }/user/getName", {
			"groupId" : value
		}, function(data) {
			gName = data;
		});
		return gName;
	}


	


	
	*/
	
	var toolbar = [ {
		text : '新增权限',
		iconCls : 'icon-add',
		handler : function() {
			$("#addWin").window('open').window('center');
		}
	},{
		text : '删除权限',
		iconCls : 'icon-remove',
		handler:function(){
			var ids=getSelectIds();
			if(ids.length==0){
				$.messager.alert("错误","至少要选择一项权限！","error");
				return;
			}
			$.messager.confirm('确认','确定要删除吗？',function(r){
				if(r){
					$.post("${baseurl}/user/deletePermissionById",{"ids":ids},function(data){
						if(data.status==200)
							$.messager.alert('提示','删除成功！','info',function(){
								$("#rolesId").datagrid('reload');
								
							});
					});
					
				}
			})
			
		}
	},{
		text : '修改',
		iconCls : 'icon-edit',
		handler : function() {
			var id= getSelectIds();
			if (id.length == 0) {
				$.messager.alert('错误', '请选择要修改的权限!','error');
				return;
			}
			
			var row = $("#rolesId").datagrid('getSelected');
			$("#reNameId").textbox('setValue',row.name);
			$("#reUrlId").textbox('setValue',row.url); 
			$("#repcodeId").textbox('setValue',row.pcode); 
			$("#remarkId").textbox('setValue',row.remark); 
			$("#editWin").window('center').window('open');
			
		}
	}];
	
	
	
	
</script>
</html>