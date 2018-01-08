<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD id=Head1>
<TITLE>导航</TITLE>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ include file="../../common/easyui.jsp" %>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<STYLE type=text/css>
BODY {
	PADDING-RIGHT: 0px;
	PADDING-LEFT: 0px;
	PADDING-BOTTOM: 0px;
	MARGIN: 0px;
	PADDING-TOP: 0px;
	BACKGROUND-COLOR:#A4D3EE;
}

BODY {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

TD {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

DIV {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

P {
	FONT-SIZE: 11px;
	COLOR: #003366;
	FONT-FAMILY: Verdana
}

.mainMenu {
	FONT-WEIGHT: bold;
	FONT-SIZE: 14px;
	cursor: pointer;
	COLOR: #000000
}

A.style2:link {
	PADDING-LEFT: 4px;
	COLOR: #0055bb;
	TEXT-DECORATION: none
}

A.style2:visited {
	PADDING-LEFT: 4px;
	COLOR: #0055bb;
	TEXT-DECORATION: none
}

A.style2:hover {
	PADDING-LEFT: 4px;
	COLOR: #ff0000;
	TEXT-DECORATION: none
}

A.active {
	PADDING-LEFT: 4px;
	COLOR: #ff0000;
	TEXT-DECORATION: none
}

.span {
	COLOR: #ff0000;
}
</STYLE>

<SCRIPT type="text/javascript">

$(function () {  
    
    // 实例化树菜单  
    $("#tree").tree({  
        url:'${pageContext.request.contextPath }/device/cat',//请求路径，id为根节点的id  
        animate:true,
        method : "GET",
        onContextMenu: function(e,node){
           e.preventDefault();
            $(this).tree('select',node.target);
            $('#mm').menu('show',{
                left: e.pageX,
                top: e.pageY
            });
        }, //此时node是子节点
        onAfterEdit : function(node){
        	//把新建节点变成jquery对象
        	var _tree = $(this);
        	if(node.id == 0){
        		// 新增节点
        		$.post("${pageContext.request.contextPath }/device/create",{parentid:node.parentId,name:node.text},function(data){
        			if(data.status == 200){
        				_tree.tree("update",{
            				target : node.target,
            				id : data.data.id,
            				
            			});
        			}else{
        				$.messager.alert('提示','创建'+node.text+' 分类失败!');
        			}
        		});
        	}else{
        		$.post("${pageContext.request.contextPath }/device/update",{id:node.id,name:node.text});
        	}
        }
    });
});  

function menuHandler(item){
	//获取整颗树dom对象
	var tree = $("#tree");
	//获取树形节点选中节点对象：父节点
	var node = tree.tree("getSelected");
	//如果传递参数是add,表示是添加节点
	if(item.name === "add"){
		//调用EasyUI 的 append方法添加节点
		tree.tree('append', {
            parent: (node?node.target:null),
            data: [{
                text: '新建分类',
                id : 0,
                parentId : node.id
            }]
        });
		//获取新添加节点dom对象：子节点
		var _node = tree.tree('find',0);
		//开始编辑，鼠标离开，触发事件onAfterEdit
		tree.tree("select",_node.target).tree('beginEdit',_node.target);
	}else if(item.name === "rename"){
		tree.tree('beginEdit',node.target);
	}else if(item.name === "delete"){
		$.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
			if(r){
				$.post("${pageContext.request.contextPath }/device/delete",{id:node.id},function(){
					tree.tree("remove",node.target);
				});	
					$("#tree").tree("reload");
			}
		});
	}
}



    
    
	
function MenuDisplay(obj_id) {
	for (var i = 1; i <= 9; i++) {
		var obj = document.getElementById('table_' + i);
		if(obj){
			document.getElementById('table_' + i).style.display = 'none';
			document.getElementById('table_' + i + 'Span').innerText = '＋';
		}
		
	}
	var obj = document.getElementById(obj_id);
	if(obj){
		if (obj.style.display == 'none') {
			obj.style.display = 'block';
			document.getElementById(obj_id + 'Span').innerText = '－';
		} else {
			obj.style.display = 'none';
			document.getElementById(obj_id + 'Span').innerText = '＋';
		}
	}
	
}

/* function refushDatagrid()
{
	
} */
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	

	<FORM id=form1 name=form1 action=YHMenu.aspx method=post>
		<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="images/new_005.jpg" border=0></TD>
					<TD align="center" width=180 background="${pageContext.request.contextPath}/images/new_006.jpg" height=35><B></B></TD>
					<TD width=15><IMG src="images/new_007.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath}/images/new_008.jpg"></TD>
					<TD vAlign=top width=180 bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=3 width=165 align=center border=0>
							<TBODY>
								<shiro:hasPermission name="file:manager">
									<TR>
										<TD class=mainMenu onClick="MenuDisplay('table_1');">
											<SPAN class=span id=table_1Span>＋</SPAN> 素材管理
										</TD>
									</TR>
									<TR>
										<TD>
											<TABLE id=table_1 style="DISPLAY: none" cellSpacing=0 cellPadding=2 width=155 align=center border=0>
												<TBODY>
													<shiro:hasPermission name="file:upload">
													
													<TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/upload"  target=main>－ 新增素材</A>
														</TD>
													</TR>
													</shiro:hasPermission>
													<shiro:hasPermission name="file:list">
													<TR> 
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/list" target=main>－ 素材列表</A>
														</TD>
													</TR>
													</shiro:hasPermission>
												</TBODY>
											</TABLE>
										</TD>
									</TR>
									<TR>
										<TD background=images/new_027.jpg height=1></TD>
									</TR>
								</shiro:hasPermission>
								<shiro:hasPermission name="program:manager">
									<TR>
										<TD class=mainMenu onClick="MenuDisplay('table_2');">
											<SPAN class=span id=table_2Span>＋</SPAN> 节目管理
										</TD>
									</TR>
									<TR>
										<TD>
											<TABLE id=table_2 style="DISPLAY: none" cellSpacing=0
												cellPadding=2 width=155 align=center border=0>
												<TBODY>
													<%-- <TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/proList" target=main>－节目包管理</A>
														</TD>
													</TR>
													 <TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/programmingUI" target=main>－节目发布</A>
														</TD>
													</TR> --%>
													<shiro:hasPermission name="model:create">
													 <TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/templateUI" target=main>－布局模版</A>
														</TD>
													</TR>
													</shiro:hasPermission>
													<shiro:hasPermission name="program:create">
													 <TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/arrangeUI" target=main>－节目单管理</A>
														</TD>
													</TR>
													</shiro:hasPermission>
													<shiro:hasPermission name="package:create">
													<TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/programUI" target=main>－节目包管理</A>
														</TD>
													</TR>
													</shiro:hasPermission>
													
												</TBODY>
											</TABLE>
										</TD>
									</TR>
									<TR>
										<TD background="${pageContext.request.contextPath}/images/new_027.jpg" height=1></TD>
									</TR>
								</shiro:hasPermission>
								<shiro:hasPermission name="device:manager">
								
								
									<TR>
										<TD class=mainMenu onClick="MenuDisplay('table_5');">
											<SPAN class=span id=table_5Span>＋</SPAN> 终端管理
										</TD>
									</TR>
									<TR>
										<TD>
											<TABLE id=table_5 style="DISPLAY: none" cellSpacing=0
												cellPadding=2 width=155 align=center border=0>
												<TBODY>
													
													<tr>
														<td class=menuSmall>
															<div>
																<ul id="tree" class="easyui-tree"></ul>
															</div>
															<div id="mm" class="easyui-menu" style="width: 120px;"data-options="onClick:menuHandler">
																<div data-options="iconCls:'icon-add',name:'add'">添加分类</div>
																<div data-options="iconCls:'icon-edit',name:'rename'">重命名</div>
																 <div class="menu-sep"></div>
																<div data-options="iconCls:'icon-remove',name:'delete'">删除分类</div>
															</div>
														</td>
													</tr>
													<%-- <tr>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/ledUI" target=main>－LED屏管理</A>
														</TD>
													</tr> --%>
												</TBODY>
											</TABLE>
										</TD>
									</TR>
									
									<%-- <TR>
										<TD background="${pageContext.request.contextPath}/images/new_027.jpg" height=1></TD>
									</TR>
								
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_7');">
										<SPAN class=span id=table_7Span>＋</SPAN> 系统管理
									</TD>
								</TR>
								
								<TR>
									<TD>
										<TABLE id=table_7 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<tr>
												<td class=menuSmall>
													<A class=style2 href="${pageContext.request.contextPath}/ui/userList" target=main>－软件升级</A>
												</td>
												</tr>
											</TBODY>
										</TABLE>
									</TD>
								</TR>  --%>
								
								<TR>
									<TD background="${pageContext.request.contextPath}/images/new_027.jpg" height=1></TD>
								</TR>
								</shiro:hasPermission>
								<shiro:hasPermission name="user:manager">
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_3');">
										<SPAN class=span id=table_3Span>＋</SPAN> 系统管理 								</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_3 style="DISPLAY: none" cellSpacing=0 cellPadding=2 width=155 align=center border=0>
											<TBODY>
												
												<TR>
													<TD class=menuSmall>
														<A class=style2 href="${pageContext.request.contextPath}/ui/userList" target=main>－用户管理</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall>
														<A class=style2 href="${pageContext.request.contextPath}/ui/roleListUI" target=main>－角色管理</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall>
														<A class=style2 href="${pageContext.request.contextPath}/ui/permissionUI" target=main>－权限管理</A>
													</TD>
												</TR>
												
												<TR>
													<TD class=menuSmall>
														<A class=style2 href="${pageContext.request.contextPath}/ui/organList" target=main>－机构管理</A>
													</TD>
												</TR>
												
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD background="${pageContext.request.contextPath}/images/new_027.jpg" height=1></TD>
								</TR>
								</shiro:hasPermission>
								<shiro:hasPermission name="type:statistics">
									<TR>
										<TD class=mainMenu onClick="MenuDisplay('table_4');">
											<SPAN class=span id=table_4Span>＋</SPAN> 统计分析 
										</TD>
									</TR>
									<TR>
										<TD>
											<TABLE id=table_4 style="DISPLAY: none" cellSpacing=0 cellPadding=2 width=155 align=center border=0>
												<TBODY>
													<TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/statisticsMaterial" target=main>－素材统计</A>
														</TD>
													</TR>
													<TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/statisticsArea" target=main>－地区统计</A>
														</TD>
													</TR>
													<%-- <TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}/ui/statisticsTem" target=main>－天气信息</A>
														</TD>
													</TR>--%>
													<TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}ui/guestInfoUI" target=main>－访客统计</A>
														</TD>
													</TR> 
													<TR>
														<TD class=menuSmall>
															<A class=style2 href="${pageContext.request.contextPath}ui/callUI" target=main>－呼叫记录</A>
														</TD>
													</TR> 
												</TBODY>
											</TABLE>
										</TD>
									</TR>
								</shiro:hasPermission>
								<%-- <TR>
									<TD background="${pageContext.request.contextPath}/images/new_027.jpg" height=1></TD>
								</TR>
								<TR>
									<TD class=mainMenu onClick="MenuDisplay('table_6');">
										<SPAN class=span id=table_6Span>＋</SPAN> 日志管理
									</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=table_6 style="DISPLAY: none" cellSpacing=0 cellPadding=2 width=155 align=center border=0>
											<TBODY>
												<TR>
													<TD class=menuSmall>
														<A class=style2 href="${pageContext.request.contextPath}/welcome.jsp" target=main>测试</A>
													</TD>
												</TR>
												<TR>
													<TD class=menuSmall>
														<A class=style2 href="${pageContext.request.contextPath}/welcome.jsp" target=main>同步</A>
													</TD>
												</TR>
									
											</TBODY>
										</TABLE>
									</TD>
								</TR> --%>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath}/images/new_009.jpg"></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="images/new_010.jpg" border=0></TD>
					<TD align="center" width=180 background="${pageContext.request.contextPath}/images/new_011.jpg"	height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath}/images/new_012.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
	<form action="${pageContext.request.contextPath}/device/reload" id="datagridForm" target=main>
		<input type="hidden" id="groupId" name="groupId"/>
	</form>
</BODY>
<script type="text/javascript">
$(function(){
	//获取整颗数dom对象
	var tree = $("#tree");
	//获取datagrid分页列表dom对象
	tree.tree({
		onClick : function(node){
			$.post("${baseurl}/device/findTypes");
			var param = {
					"groupId":node.id
			};
			$("#groupId").val(node.id);
			$("#datagridForm").submit();
		
			/* $.post("${pageContext.request.contextPath}/device/reload",param); */
			 
		}
	});
});

</script>  


</HTML>
