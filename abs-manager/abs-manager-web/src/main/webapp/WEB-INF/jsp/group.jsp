<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分组页面</title>
</head>
<body>
		<div>
			<ul id="tree" class="easyui-tree"></ul>
		</div>
		

</body>

<script type="text/javascript">


$(function () {  
    
    // 实例化树菜单  
    $("#tree").tree({  
        url:'${pageContext.request.contextPath }/device/cat',//请求路径，id为根节点的id  
        animate:true,
        method : "GET",
        onSelect: function(node){
        	alert(node.id);
        	var params = {
    				"id" : node.id,
    				"deviceId":ids
    			};
        	/* $.post("${pageContext.request.contextPath }/device/assignGroup",params, function(data,textStatus,XMLHttpRequest){
    		 	if(XMLHttpRequest.status == 200){
    				$.messager.alert('提示','节目包删除成功!',undefined,function(){
    					$("#list").datagrid("reload");
    				});
    			} 
    		},"json"); */	
           
        }
       
    });
});  

</script>
</html>