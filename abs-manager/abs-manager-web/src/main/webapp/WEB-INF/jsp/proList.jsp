<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<TITLE>素材列表</TITLE> 
<!-- 节目包列表页面 -->
</HEAD>
<body>

<!-- 绘制数据表格 -->
	<table class="easyui-datagrid" id="proList" title="节目包列表"
		   style="width: 98%; height: 310px"
	data-options="url:'${pageContext.request.contextPath }/picture/proList',
	fitColumns:true,pagination:true,toolbar:toolbar,striped:true,checkOnSelect:true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th data-options="field:'zipid',width:50">id</th>
				<th data-options="field:'zipname',width:100,align:'left'">节目包名称</th>
				<th data-options="field:'materialcount',width:50" >素材总数</th>
				<th data-options="field:'ziptime',width:100,formatter:getTime">创建时间</th> 
				<th data-options="field:'zipuserid',width:100,formatter:getUsername">创建者</th>
				<th data-options="field:'detail',width:60,align:'center',formatter:formatOper">操作</th>
		   </tr>
		</thead>
	</table>
	
<div id="addNewPro" class="easyui-dialog" data-options="" title="素材列表" closed="true" style="width:600px;height:400px">
		<iframe id="addNewProFrame" src="${pageContext.request.contextPath }/ui/newPro" style="width:98%;height:98%" scrolling="no">
		</iframe>
</div>
	

	
	<div id="showDetailDiv" class="easyui-dialog" closed="true" style="width:800px;height:400px">
		<table class="easyui-datagrid" id="detailTab"
			style="width: 98%; height: 310px"
			data-options="url:'${pageContext.request.contextPath }/picture/detail',fitColumns:true,onDblClickCell:beginEdit,checkOnSelect:true">
			<thead>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok',plain:true" onclick="getChanges()">提交修改</a>
				<tr>
					<th data-options="field:'materialId',width:50">素材id</th>
					<th data-options="field:'playorder',width:50">播放顺序</th>
					<th data-options="field:'materialName',width:100,align:'left'">素材名称</th>
					<th data-options="field:'materialSize',width:50">素材大小</th>
					<th data-options="field:'playduration',width:70,editor:'numberbox'">播放时长(双击可修改)</th>
					<th data-options="field:'addTime',width:80,formatter:getTime">创建时间</th>
					<th data-options="field:'zipName',width:80,hidden:true">节目包名称</th>
				</tr>
			</thead>
		</table>
	</div> 
	
		<div id="programming" class="easyui-window" data-options="" title="素材编排" closed="true" style="width:600px;height:400px">
			<iframe id="programmingFrame" src="${pageContext.request.contextPath }/ui/programmingUI" style="width:98%;height:98%" scrolling="no">
			</iframe>
		</div> 
</body>
 <script type="text/javascript" src="/easyui/datagrid-cellediting.js">
 

 $("#detailTab").datagrid('hideColumn', 'materialId');
 </script>
 <script>
 $.ajaxSetup({
	  async: false
	  });
 
 function getUsername(value) {
		var param ={
			id:value	
		};
		var str;
		$.post("${pageContext.request.contextPath }/picture/getUser",param,function(data){
			str=data;
		});
		return str;
	}
 var editIndex = undefined;
 function beginEdit(index, field){
 	if (editIndex != index)
 	{
 		if (endEditing())
 		{
 			$('#detailTab').datagrid('unselectAll')
 					.datagrid('selectRow', index)
 					.datagrid('beginEdit', index);
 			var ed = $('#detailTab').datagrid('getEditor', {index:index,field:field});
 			if (ed){
 				($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
 			}
 			editIndex = index;
 		} else {
 			$('#detailTab').datagrid('selectRow', editIndex);
 		}
 	}
 }
        
    $(function(){
        var dg = $('#detailTab').datagrid({
        });
    });
    
    
    function endEditing(index){
    	if (editIndex == undefined){return true}
    	$('#detailTab').datagrid('endEdit', editIndex);	
    	editIndex = undefined;
    	return true;
    }
    	function getChanges(){
    		$('#detailTab').datagrid('endEdit', editIndex);
    	    var rows = $('#detailTab').datagrid('getChanges');
    	    var ids = [];
    	    for(var i=0;i<rows.length;i++)
    	    {
    	    	ids.push(rows[i].materialId+"_"+rows[i].playduration+"_"+rows[i].zipName);
    	    }
    	    ids = ids.join(",");
    	    if(ids.length == 0){
        		$.messager.alert('提示','没有修改的节目单!');
        		return ;
        	}
    	    var params = {"ids":ids};
        	$.post("${pageContext.request.contextPath }/picture/playPlanEdit",params);
    	}
	 
	
	function getTime(value){
	var d = new Date(value).toLocaleString();
	return d;
	}

	function formatOper(value,row,index){ 
		 return '<a style="cursor:pointer" onclick=showDetail('+JSON.stringify(row)+');>详情</a>';  
	}
	
	function showDetail(row)
	{	
		$("#detailTab").datagrid('load',{
			'id':row.zipid,
		});
		$('#showDetailDiv').dialog('open').dialog('setTitle',row.zipname).dialog("center");
	}	
	
    function getSelectionsIds(){
    	var list = $("#proList");
    	var sels = list.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].zipid);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
            text:'删除',
            iconCls:'icon-cancel',
            handler:function(){
            	var ids = getSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中节目包!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除ID为 '+ids+' 的节目包吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("${pageContext.request.contextPath }/picture/proDelete",params, function(data,textStatus,XMLHttpRequest){
                		 	if(XMLHttpRequest.status == 200){
                				$.messager.alert('提示','节目包删除成功!',undefined,function(){
                					$("#proList").datagrid("reload");
                				});
                			} 
                		},"json");
            	    }
            	});
            }
			} ,{
				 text:'新建节目',
		         iconCls:'icon-add',
		         handler:function(){
		        	 $('#addNewProFrame').attr('src', $('#addNewProFrame').attr('src'));
		        	 $("#addNewPro").dialog('center').dialog('open');
		         }
				
			}/* ,{
			 text:'节目编排',
			 iconCls:'icon-edit',
			 handler:function(){
	        	 $('#programmingFrame').attr('src', $('#programmingFrame').attr('src'));
	        	 $("#programming").dialog('center').dialog('open');
	         }
		} */
    ];
</script>

</HTML>
