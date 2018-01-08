<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ include file="../../common/easyui.jsp" %>
<script src="${pageContext.request.contextPath }/js/jquery.slimscroll.min.js"></script> 
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<title>扁平化可伸展导航</title>
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
</head>
<style>
body, html { height: 100%; background: #F2F2F2; overflow: hidden; }
* { margin: 0; padding: 0 }
body { font: 14px "微软雅黑", "FontAwesome", "Arial Narrow", HELVETICA; -webkit-text-size-adjust: 100%; }
li { list-style: none }
a { text-decoration: none; }
/* navMenu */
.navMenubox { width: 100%; height: 100%; background:#2a8dc8; margin: 0 auto; overflow: hidden; }
.navMenu-top { padding: 10px; color: #fff; border-bottom: 1px solid rgba(255,255,255,.1) }
.navMenu> li { display: block; margin: 0; padding: 0; border: 0px; }
.navMenu>li>a { display: block; overflow: hidden; padding-left: 0px; line-height: 40px; color: #FFF; transition: all .3s; position: relative; text-decoration: none; font-size: 20px;font-weight:bold; border-top: 1px solid #222932; border-bottom: 2px solid #191e24; }
.navMenu > li:nth-of-type(1)> a { border-top: 1px solid transparent; }
.navMenu > li:last-child > a { border-bottom: 1px solid transparent; }
.navMenu>li>a>i { font-size: 20px; float: left; font-style: normal; margin: 0 5px; }
.navMenu li a .arrow:before { display: block; float: right; margin-top: 1px; margin-right: 15px; display: inline; font-size: 16px; font-family: FontAwesome; height: auto; content: "\f105"; font-weight: 300; text-shadow: none; }
.navMenu li a .arrow.open:before { float: right; margin-top: 1px; margin-right: 15px; display: inline; font-family: FontAwesome; height: auto; font-size: 16px; content: "\f107"; font-weight: 300; text-shadow: none; }
.navMenu>li>a.active, .navMenu>li>a:hover { color: #FFF; background: #12181b; }
.navMenu>li>ul.sub-menu, .navMenu>li>ul.sub-menu>li>ul.sub-menu { display: none; list-style: none; clear: both; margin: 8px 0px 0px 10px; padding-bottom: 5px; }
.navMenu>li.active > ul.sub-menu, .navMenu>li>ul.sub-menu>li.active >ul.sub-menu { }
.navMenu>li>ul.sub-menu li { background: none; margin: 0px; padding: 0px; }
.navMenu>li>ul.sub-menu li>a { display: block; font-size: 16px; line-height: 36px; padding-left: 20px; color: #FFF; clear: both; }
.navMenu>li>ul.sub-menu li>a.active, .navMenu>li>ul.sub-menu li>a:hover, .navMenu>li>ul.sub-menu>li.active >a { color: #FFF; background: #12181b; }
.icon_1:before { 
	content: "";
	padding-left:5px;
 }
.icon_2:before { content: "";padding-left:5px; }
.icon_3:before { content: "";padding-left:5px; }
/*---------------------*/
</style>
<script>
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
<body>
	<div class="navMenubox">
  <div id="slimtest1">
    <div class="navMenu-top">
      <div id="mini" style=""><i class="fa fa-bars fa-2x"></i></div>
    </div>
    <ul class="navMenu">
      <li> <a href="javascript:;" class="afinve"> <img src="${pageContext.request.contextPath}/imgs/left-1.png" style="display:inline-block;margin:0px 0 0 10px;vertical-align:middle"></img> <span class="" style='margin-left:-5px'>素材管理</span> <span class="arrow"></span> </a>
        <ul class="sub-menu">
          <li><a href="${pageContext.request.contextPath}/ui/upload"  target=main><span>新增素材</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/list" target=main><span>素材列表</span></a></li>
        </ul>
      </li>
      <li class=""> <a href="javascript:;" class="afinve"><img src="${pageContext.request.contextPath}/imgs/left-1.png" style="display:inline-block;margin:0px 0 0 10px;vertical-align:middle"></img><span  style='margin-left:5px'>节目管理</span><span class="arrow"></span></a> 
      	<ul class="sub-menu">
          <li><a href="${pageContext.request.contextPath}/ui/templateUI"  target=main><span>布局模板</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/arrangeUI" target=main><span>节目单管理</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/programUI" target=main><span>节目包管理</span></a></li>
        </ul>
      </li>
      <li > <a href="javascript:;" class="afinve"> <img src="${pageContext.request.contextPath}/imgs/left-1.png" style="display:inline-block;margin:0px 0 0 10px;vertical-align:middle"></img> <span class="nav-text"  style='margin-left:-5px'>终端管理</span> <span class="arrow"></span> </a>
        <ul class="sub-menu">
          <li id="tree" class="easyui-tree"></li>
          <li id="mm" class="easyui-menu" style="width: 120px;"data-options="onClick:menuHandler">
          	<div data-options="iconCls:'icon-add',name:'add'">添加分类</div>
			<div data-options="iconCls:'icon-edit',name:'rename'">重命名</div>
			 <div class="menu-sep"></div>
			<div data-options="iconCls:'icon-remove',name:'delete'">删除分类</div>
          </li>
        </ul>
      </li>
      <li > <a href="javascript:;" class="afinve"> <img src="${pageContext.request.contextPath}/imgs/left-1.png" style="display:inline-block;margin:0px 0 0 10px;vertical-align:middle"></img> <span class="nav-text"  style='margin-left:-5px'>系统管理</span> <span class="arrow"></span> </a>
        <ul class="sub-menu">
          <li><a href="${pageContext.request.contextPath}/ui/userListUI" target=main><span>用户管理</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/roleListUI" target=main><span>角色管理</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/permissionUI" target=main><span>权限管理</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/organList" target=main><span>机构管理</span></a></li>
        </ul>
      </li>
      <li > <a href="javascript:;" class="afinve"> <img src="${pageContext.request.contextPath}/imgs/left-1.png" style="display:inline-block;margin:0px 0 0 10px;vertical-align:middle"></img> <span class="nav-text"  style='margin-left:-5px'>统计分析</span> <span class="arrow"></span> </a>
        <ul class="sub-menu">
          <li><a href="${pageContext.request.contextPath}/ui/statisticsMaterial" target=main><span>素材统计</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/statisticsArea" target=main><span>地区统计</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/guestInfoUI" target=main><span>访客统计</span></a></li>
          <li><a href="${pageContext.request.contextPath}/ui/callUI" target=main><span>呼叫记录</span></a></li>
          
        </ul>
      </li>
    </ul>
  </div>
</div>
<form action="${pageContext.request.contextPath}/device/reload" id="datagridForm" target=main>
		<input type="hidden" id="groupId" name="groupId"/>
</form>
<script>
$(function(){
    // nav收缩展开
     $('.navMenu li a').on('click',function(){
			 var parent = $(this).parent().parent();//获取当前页签的父级的父级
			 var labeul =$(this).parent("li").find(">ul")	 
             if ($(this).parent().hasClass('open') == false) {
                //展开未展开
				   parent.find('ul').slideUp(300);
				   parent.find("li").removeClass("open")
				   parent.find('li a').removeClass("active").find(".arrow").removeClass("open")
                  $(this).parent("li").addClass("open").find(labeul).slideDown(300);
				  $(this).addClass("active").find(".arrow").addClass("open")
            }else{
				 $(this).parent("li").removeClass("open").find(labeul).slideUp(300);
				  if($(this).parent().find("ul").length>0){
					$(this).removeClass("active").find(".arrow").removeClass("open")
				  }else{
					$(this).addClass("active") 
				  }
            }
      
    });
});
</script>

</body>
</html>