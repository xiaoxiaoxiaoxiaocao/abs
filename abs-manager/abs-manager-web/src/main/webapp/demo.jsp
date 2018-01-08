<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="${baseurl }/js/jquery.js"></script>
<!-- 导入easyui必须的库 -->
<!--皮肤-->
<script type="text/javascript" src="${baseurl }/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="${baseurl }/easyui/themes/default/easyui.css">
<!--EasyUI各种图片样式-->
<link rel="stylesheet" type="text/css" href="${baseurl }/easyui/themes/icon.css">
<%-- <link rel="stylesheet" type="text/css" href="${baseurl }/easyui/easyui.css"> --%>
<script type="text/javascript" src="${baseurl }/easyui/locale/easyui-lang-zh_CN.js"></script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>

</head>
		
<body>
<table class="easyui-datagrid" id="userList" style="width:99%;height:350px"
		data-options="url:'',fitColumns:true,pagination:true,
					striped:true,toolbar:toolbar,checkOnSelect:false">
	<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:5">用户ID</th>
				<th data-options="field:'username',width:5">用户名称</th>
				<th data-options="field:'password',width:5,hidden:true">用户密码</th>
				<th data-options="field:'usercatid',width:10,formatter:getOrganName">所属机构</th>
				<th data-options="field:'change',width:5,formatter:change">操作</th>
			</tr>
	</thead>


</table>
	
	
	
	<div id="win" class="easyui-window" title="添加用户" closed="true" 
		 style="width:500px;height:300px;">
			<form  method="post" id="add" action="${pageContext.request.contextPath}/user/addUser">
					<table  align="center" style="border-collapse:separate; border-spacing:0px 10px;width: 80%" >
						<tr>
							<td width="20%">用户名：</td>
							<td width="80%"><input type="text" id="username" name="username" required="required"></td>
						</tr>
						 <tr>
							<td>密 码：</td>
							<td><input type="text" id="password" name="password" required="required"></td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td><input type="text" id="repassword" name="repassword" required="required"></td>
						</tr>
						<tr>
							<td>
								所属机构：
							</td>
							<td>
							<input class="easyui-combobox eParentOrgan" id="belongId" name="belongName"
								data-options="required:true,editable:false,width:110">
							</td>
						</tr>
						<tr>
							<td>
								角色：
							</td >
							<td>
								<div id="roleDiv" style="width: 100%"></div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td align="left">
								<input  class="easyui-linkbutton"  type="submit" value="添加" style="cursor:pointer;width: 60px;height: 25px"onclick="return checkRole()">
							</td>
						</tr> 
					</table>
			</form>
	</div>
	<div id="edit" class="easyui-window" title="编辑用户" closed="true" 
		 style="width:40%;height:50%;">
			<form method="post" id="editForm" name="editForm">

			<table align="center" style="border-spacing:0px 10px;width: 80%">
				<tr>
					<td width="20%">用户名：</td>
					<td width="80%"><input type="text" id="editName" name="username"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td >新密码：</td>
					<td ><input type="password" id="editWord"
						name="password" ></td>
					<td ><label id="newplable" style="color: red"></label></td>
				</tr>
				<tr>
					<td>所属机构：</td>
					<td><input class="easyui-combobox eParentOrgan" id="reOrgan"
						name="reOrgan"
						data-options="required:true,editable:false,width:110,valueField:'id',textField:'text'">
					</td>
					<td><label id="newpolable" style="color: red"></label></td>
				</tr>
				<tr>
					<td>角色：</td>
					<td>
						<div id="reRoleDiv" style="width: 100%"></div>
					</td>
					
				</tr>

				<tr>
					<td><input type="hidden" id="editId" name="id"></td>
					<td><input class="easyui-linkbutton"  type="submit" value="提交" id="subChange"
						style="cursor: pointer;width: 60px;height: 25px"  onclick="return saveChange()"></td>
				</tr>
			</table>
		</form>
	</div>
	

<script type="text/javascript">
$.ajaxSetup({
	  async: false
});

	var provinceId=0;

	$("#province").combobox({
		
		valueField:'id', //值字段
	    textField:'name', //显示的字段
	    url:'${baseurl}/user/previnces',
	    panelHeight:'150px',
	    required:true,
	    editable:false,//不可编辑，只能选择
	    onChange:function(){
	    	$.post("${baseurl}/user/cities",{"provinceId":$(this).combobox('getValue')},function(data){
	    		$("#city").combobox({
	    			data:data
	    		});
	    	});
	    }
	});
	$("#city").combobox({
		valueField:'id', //值字段
	    textField:'name', //显示的字段
	    url:'${baseurl}/user/cities?provinceId='+provinceId,
	    panelHeight:'150px',
	    required:true,
	    editable:false,//不可编辑，只能选择
	    onChange:function(){
	    	$("#save").attr("disabled",false);
			$("#tip3").html("");
	    }
	});
	
	$(function(){
		$.post("${baseurl}/user/findAllRoles",function(d){
			for(var i in d){
				$("#roleDiv").append('<input type="checkbox" name="role" value='+d[i].id+'>'+d[i].name);
			    $("#reRoleDiv").append('<input type="checkbox" name="reRole" value='+d[i].id+'>'+d[i].name);
			}
				
			
		},"json");
	});
	
	


function getOrganName(value,row,index){
	var name;
	$.post("${pageContext.request.contextPath }/user/getOgName",{"id":value},function(d){
		name=d;
	});
	return name;
}
function checkRole(){
	var organ = $("#belongId").combobox('getValue');
	if(organ==-1){
		  $.messager.alert("错误","请选择一个机构！","error");
		return false;
	}
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
		
		
		$("#editWord").focus(function(){
				$("#newplable").html("");
		}); 
		
		
	/* 	$("#reRole").combobox({
			onChange:function(){
				$("#newrlable").html('');
			}
		}); */
		$("#reOrgan").combobox({
			onChange:function(){
				$("#newpolable").html('');
			}
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
				panelWidth : 'auto',
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

	$.ajax({
		url : '${pageContext.request.contextPath }/user/roleList',
		dataType : 'json',
		success : function(jsonstr) {
			jsonstr.unshift({
				'id' : '-1',
				'name' : '--请选择角色--'
			});//向json数组开头添加自定义数据  
			$('#role').combobox({
				data : jsonstr,
				valueField : 'id',
				textField : 'name',
				panelHeight : 'auto',
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
	$.ajax({
		url : '${pageContext.request.contextPath }/user/roleList',
		dataType : 'json',
		success : function(jsonstr) {
			jsonstr.unshift({
				'id' : '-1',
				'name' : '--请选择角色--'
			});//向json数组开头添加自定义数据  
			$('#reRole').combobox({
				data : jsonstr,
				valueField : 'id',
				textField : 'name',
				panelHeight : 'auto',
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

	//当焦点移出用户名输入框时
	$("#repassword").blur(function() {
		var repassword = $("#repassword").val();
		var password = $("#password").val();
		// 判断是否为空及空格
		if (repassword != password) {
			$.messager.alert('提示', '两次输入的密码不一致！！！', "warning", function() {
				$('#add').form('clear');
			})
		}

	});
	$("#username").blur(function() {
		// 判断是否为空及空格
		var userName = $("#username").val();
		if (userName == "") {
			return;
		}
		$.post("${pageContext.request.contextPath}/user/checkUserName", {
			username : userName
		}, function(data) {
			if (data > 0) {
				$.messager.alert('提示', '该用户名已存在！！！', "warning", function() {
					$('#add').form('clear');
				});
			}
		}, "json");
	});

	function getSelectionsIds() {
		var list = $("#userList");
		var sels = list.datagrid("getSelections");
		var ids = [];
		for ( var i in sels) {
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}
	

	function change(value, row, index) {
		return '<span><a style="cursor:pointer" onclick=showDetail('
				+ JSON.stringify(row) + ')>修改</a></span>';
	}

	function showDetail(row) {
		$('[name=reRole]').removeAttr('checked');
		var id = row.id;
		$.post("${pageContext.request.contextPath }/user/detail", {
			"id" : id
		}, function(data) {
			var ids=data.ids;
			/* $("[name=reRole]").each(function(){
					$(this).attr("checked", false);
			}); */
		 	$("[name=reRole]").each(function(){
				 for (var i = 0; i < ids.length; i++) {
				        if (ids[i] ==$(this).val()) {
							$(this).prop("checked", true);
			            }
			        }
			});
			var da = $('#reOrgan').combobox('getData');
			var str=[];
		
			$.each(da,function(n,value){
				str.push(value.id);
			});
			str.join(",");
			//rodastr.join(",");
			
			var index = $.inArray(row.usercatid,str);
			if(index==-1){
			$('#reOrgan').combobox('select',-1);
			}else{
			$('#reOrgan').combobox('select',str[index]);
			}
				/* if($.inArray(data.roleId ,rodastr)>0){
					$("#reRole").combobox('setValue',data.roleId);
				}else{
					$("#reRole").combobox('setValue',-1);
				} */
			$("#edit").window('center').window('open');
			$("#editName").val(data.user.username);
			$("#editWord").val(data.user.password);
			$("#editId").val(data.user.id);

		}, "json");
	}

	function saveChange() {
		
		if($("#editWord").val().trim().length == 0){
			$("#newplable").html("新密码无效！");
			return false;
		}
		/* if($("#reRole").combobox('getValue') == -1){
			$("#newrlable").html("请指定一个角色！");
			return false;
		} */
		if($("#reOrgan").combobox('getValue') == -1){
			$("#newpolable").html("请选择机构！");
			return false;
		}
		
		
		
		$.post("${pageContext.request.contextPath}/user/editUser", $(
				"#editForm").serialize(), function(data) {
			alert("用户信息更新成功！");
			window.location.reload();
		}, "json");

	}

	var toolbar = [
			{
				text : '添加用户',
				iconCls : 'icon-add',
				handler : function() {
					$("#win").window('center').window('open');
				}
			},
			{
				text : '删除用户',
				iconCls : 'icon-cancel',
				handler : function() {
					var ids = getSelectionsIds();
					if (ids.length == 0) {
						$.messager.alert('提示', '未选中任何用户!');
						return;
					}
					$.messager
							.confirm(
									'确认',
									'确定删除ID为 ' + ids + ' 的用户吗？',
									function(r) {
										if (r) {
											var params = {
												"ids" : ids
											};
											$
													.post(
															"${pageContext.request.contextPath }/user/delete",
															params,
															function(data,
																	textStatus,
																	XMLHttpRequest) {
																if (XMLHttpRequest.status == 200) {
																	$.messager
																			.alert(
																					'提示',
																					'用户删除成功!',
																					'info',
																					function() {
																						$(
																								"#userList")
																								.datagrid(
																										"reload");
																					});
																}
															}, "json");
										}
									});
				}
			}];
</script>
</body>
</html>