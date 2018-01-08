<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<script type="text/javascript" src="../../js/base-loading.js"></script>
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机构列表</title>
</head>
		
<body>

	<div id="gWin" class="easyui-window"  style="width:50%;height:50%" closed="true">
		<form action="" method="post">
			<table  style="border-collapse:separate; border-spacing:0px 10px;" align="center">
				<tr>
					
					<td>所在省份：</td>
					<td>
						<input id="province" class="easyui-combobox">
					</td>
				</tr>
				<tr>
					
					<td>市/地区：</td>
					<td>
						<input id="city" class="easyui-combobox">
					</td>
					<td>
						<label id="tip3" style="color: red"></label>
					</td>
				</tr>
			
				<tr>
					<td width="20%">
						机构名称
					</td>
					<td width="40%">
						<input id="groupId" name="organName">
					</td>
					<td width="40%" align="center">
						<label id="tip1" style="color:red"></label>
					</td>
				</tr>
				<tr>
					<td>
						上级机构
					</td>
					<td>
						<input class="easyui-combobox eParentOrgan" id="cmb" name="parentOrgan">
					</td>
					<td width="40%" align="center">
						<label id="tip2" style="color: red"></label>
					</td>
				</tr>
				<tr>
				<td align="center" colspan="2">
					<button onclick="saveGroup()" id="save">保存</button>
					<!-- <input type="submit" value="保存"> -->
				</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="eWin" class="easyui-window" title="修改机构信息" style="width:40%;height:60%" closed="true">
		<form action="" method="post">
			<table  style="border-collapse:separate; border-spacing:0px 10px;" align="center">
				<tr>
					<td width="20%">
						机构名称
					</td>
					<td width="40%">
						<input id="eGroupId" name="organName">
					</td>
					<td width="40%" align="center">
						<label id="eTip1" style="color:red"></label>
					</td>
				</tr>
				<tr>
					<td>
						上级机构
					</td>
					<td>
						<input class="easyui-combobox eParentOrgan" id="cmb2" name="eParentOrgan">
					</td>
					<td width="40%" align="center">
						<label id="eTip2" style="color: red"></label>
					</td>
				</tr>
				<tr>
				<td align="center" colspan="2">
					<button onclick="saveEdit()" id="sav">确认修改</button>
					<input id="hd" type="hidden">
				</td>
				</tr>
				
			</table>
		</form>
	</div>
	
	
	
		<table class="easyui-datagrid" id="groups" style="width:100%;height:100%"
			data-options="url:'${pageContext.request.contextPath }/user/groupList',fitColumns:true,pagination:true,
					striped:true,checkOnSelect:true,toolbar:groupbar,singleSelect:true">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'id',width:5">机构ID</th>
						<th data-options="field:'name',width:10">机构名称</th>
						<th data-options="field:'parentid',width:10,formatter:getName">上级机构名称</th>
					</tr>											
				</thead>
		
		</table>

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
				panelWidth:'auto',
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


	


	function getSelectIds() {
		var list = $("#groups");
		var sels = list.datagrid("getSelections");
		var ids = [];
		for ( var i in sels) {
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}

	
	var groupbar = [ {
		text : '新增机构',
		iconCls : 'icon-add',
		handler : function() {
		    $("#gWin").panel("setTitle","新增机构");
			$("#gWin").window('center').window('open');
		}
	},{
		text : '删除机构',
		iconCls : 'icon-remove',
		handler : function() {
			var ids= getSelectIds();
			if (ids.length == 0) {
				$.messager.alert('错误', '未选中任何机构!','error');
				return;
			}
			$.messager.confirm(
					'确认',
					'确定删除ID为 ' + ids + ' 的机构吗？',
					function(r) {
						if(r){
							$.post("${pageContext.request.contextPath }/user/deleteOrgans",{"ids":ids},function(data){
								if(data.status==200){
									/* $.messager.alert("提示","删除成功！",info,function(){
											
									});	 */		
									$.messager.alert('提示', '删除成功!','info',function(){
										$("#groups").datagrid('reload');
									});
								}
							});
						}
					});
			
		}
	},{
		text : '修改',
		iconCls : 'icon-pen',
		handler : function() {
			var id= getSelectIds();
			if (id.length == 0) {
				$.messager.alert('错误', '请选择要修改的机构!','error');
				return;
			}
			
			var row = $("#groups").datagrid('getSelected');
			$("#eGroupId").val(row.name);
			$("#cmb2").combobox('setValue',row.parentid);
			$("#hd").val(row.id);
			$("#eWin").window('center').window('open');
			
		}
	}];
</script>
</body>
</html>