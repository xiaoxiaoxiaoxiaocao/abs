<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common/easyui.jsp" %>
<%@ include file="./timeOut.jsp" %>
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/cssrel=stylesheet>
<script type="text/javascript" src="../../js/base-loading.js"></script>
<title>节目单列表</title>
</head>

		
<body>



<table class="easyui-datagrid" id="plsList" style="width:99%;height:50%"
		data-options="url:'${pageContext.request.contextPath }/arrange/plsList',fitColumns:true,pagination:true,
					scrollbarSize:0,toolbar:toolbar,striped:true,checkOnSelect:true">
	<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:5">节目单ID</th>
				<th data-options="field:'name',width:5">节目单名称</th>
				<th data-options="field:'stdtime',width:5">开始播放时间</th>
				<th data-options="field:'edtime',width:5">结束播放时间</th>
				<th data-options="field:'detail',width:5,formatter:formatDt">操作</th>
			</tr>
	</thead>
</table>
<div id="pwin"></div>


<div id="detailDiv" class="easyui-window" closed="true" style="height:40%;width:55%">
	<table class="easyui-datagrid" id="detailTable" style="width:100%;height:100%"
		   data-options="url:'${pageContext.request.contextPath }/arrange/findResByPlsId',checkOnSelect:true,fitColumns:true,
		   				fitColumns:true">
		   <thead>
		   	<tr>
		   		<th data-options="field:'area'">所属区域</th>
		   		<th data-options="field:'resid'">id</th>
		   		<th data-options="field:'resname'">名称</th>
		   		<th data-options="field:'playcnt'">播放次数</th>
		   		<th data-options="field:'priority'">优先级</th>
		   		<th data-options="field:'filesize'">文件大小</th>
		   	</tr>
		   </thead>
	</table>
</div>


<div id="newPls" class="easyui-window" data-options="" title="新建节目单" fit="true" closed="true" style="width:95%;height:550px">
	
	<div id="cc" class="easyui-layout" style="width:100%;height:100%;">   
	    <div data-options="region:'east',title:'播放素材',split:true" style="width:35%;background:"white">
		   <iframe id="material" name="material" src="${pageContext.request.contextPath }/ui/selectMaterial" 
		    style="width:98%;height:98%;background-color=transparent"scrolling="no" frameborder="no" border="0">
	   </iframe>
	    </div>   
	    <div data-options="region:'west',title:'布局列表',split:true" style="width:16%;">
	    <b>节目单名称:</b><br>
	    <input id="plsName" type="text" style="width:145px;"required>&nbsp;<span style="color:red">*</span><br><br>
	    <input id="model" value="---请选择一个模版---" class="easyui-combobox" name="model"
				data-options="required:true,editable:false,width:150" /><br><br>
		
		有效开始时间：<br>
		<input id="stardate" class="easyui-datetimespinner" value=new Date() data-options="formatter:formatter1,parser:parser1" style="width:160px;"><br><br>
		有效终止时间：<br>		
		<input id="enddate" class="easyui-datetimespinner" value=new Date() data-options="formatter:formatter1,parser:parser1" style="width:160px;"><br><br>
				
				
				
		开始播放时间：<input id="stdtime" class="easyui-timespinner" style="width:80px;"
	    required="required" data-options="min:'08:30',showSeconds:false"><br><br>
		结束播放时间：<input id="endtime" class="easyui-timespinner" style="width:80px;"
	    required="required" data-options="min:'08:30',showSeconds:false">
	    <hr>
	    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
	    </div>   
	    <div data-options="region:'center',title:'场景'" style="padding:5px;background:#eee;" id="center">
	    	<div id="textDiv" class="textclass"
		style="height: 30%; width: 60%; position: absolute; left: 25%; bottom: 30%; display: none; z-index:99">
		<textarea id="text" name="text" style="height: 100%; width: 100%;"
			placeholder="请在此处输入文本内容。。。" onblur="subText()"></textarea>
	</div>
	    </div>   
	    <div data-options="region:'south',title:'素材详情',split:true" style="height:35%;">
			<div id="detail" style="height:100%;width:100%;display: none">
			
			<form action="${pageContext.request.contextPath }/arrange/detailSave" id="dtForm" method="post">
				<table style="width:500px" cellpadding="5px" border="0">
					<tr>
						<td>
							<li>素材名称：<span name="nm" id="nm"></span></li>
						</td>
						<td>
							<li>素材类型：<span id="tp" name="tp"></span></li>
						</td>
					</tr>
					<tr>
						<td>
							<li>优先级：<input id="priority" name="priority" class="easyui-numberspinner" value="1" data-options="min:1,max:99,required:true" style="width:120px;"></input>
	    					</li>
						</td>
						<td>
							<li>播放次数：<input id="playcnt" name="playcnt" class="easyui-numberspinner" value="1" data-options="min:1,max:99,required:true" style="width:120px;"></input>
	    			</li>
						</td>
					</tr>
					<tr>
						<td>
							<li>设为背景: <input type="radio" name="bgimg" value="0" checked="checked">否</input>
                						<input type="radio" name="bgimg" value="1">是</input></li>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input id="temId" name="temId" type="hidden">
							<input type="button" value="确认" align="middle" style="cursor: pointer" onclick="affirm()">
						</td>
					</tr>
				</table>
			</form>		
			</div>
	    </div>
	</div>
</div>


	<!-- <div id="dlg" class="easyui-dialog" title="Basic Dialog" data-options="iconCls:'icon-save'" style="width:400px;height:200px;padding:10px;" closed='true'>
		The dialog content.
	</div> -->
	

<!-- 	<div id="mm" class="easyui-menu" data-options="onClick:menuHandler" style="width:120px;">
		<div data-options="name:'edit',iconCls:'icon-edit'">编辑文本</div>
		<div data-options="name:'exit',iconCls:'icon-back'">退出</div>
</div> -->
	
	<input type="hidden" id="areatype">
	<input type="hidden" id="playMode">
	<input type="hidden" id="tem" name="tem">
	<input type="hidden" id="temName" name="tem">
</body>
<script type="text/javascript">
	var ar;
	
	
	
	window.onload = function() {
		$(".easyui-combobox").combobox({
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
	
	
	
	function Lock_CheckForm(theForm) {
		document.all.Layer2.style.display = 'none';
		return false;
	}
	function onLoadSuccess(data) {
		if (data.rows.length > 0) {
			//调用mergeCellsByField()合并单元格
			mergeCellsByField("detailTable", "area");
		}
	}

	function mergeCellsByField(tableID, colList) {
		var ColArray = colList.split(",");
		var tTable = $("#" + tableID);
		var TableRowCnts = tTable.datagrid("getRows").length;
		var tmpA;
		var tmpB;
		var PerTxt = "";
		var CurTxt = "";
		var alertStr = "";
		for (j = ColArray.length - 1; j >= 0; j--) {
			PerTxt = "";
			tmpA = 1;
			tmpB = 0;

			for (i = 0; i <= TableRowCnts; i++) {
				if (i == TableRowCnts) {
					CurTxt = "";
				} else {
					CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
				}
				if (PerTxt == CurTxt) {
					tmpA += 1;
				} else {
					tmpB += tmpA;

					tTable.datagrid("mergeCells", {
						index : i - tmpA,
						field : ColArray[j],//合并字段
						rowspan : tmpA,
						colspan : null
					});
					tTable.datagrid("mergeCells", { //根据ColArray[j]进行合并
						index : i - tmpA,
						field : "Ideparture",
						rowspan : tmpA,
						colspan : null
					});

					tmpA = 1;
				}
				PerTxt = CurTxt;
			}
		}
	}

	function formatDt(value, row, index) {
		return '<a style="cursor:pointer" onclick=showDetail('
				+ JSON.stringify(row) + ');>详情</a>';
	}

	function showDetail(d) {
		$("#detailTable").datagrid('load', {
			'id' : d.id,
		});
		$('#detailDiv').dialog('open').dialog('setTitle', d.name).dialog(
				"center");
	}

	function affirm() {
		var params = {
			"priority" : document.getElementById("priority").value,
			"playcnt" : document.getElementById("playcnt").value,
			"bgimg" : $('input:radio:checked').val(),
			"temName" : ar,
			"temId" : document.getElementById("temId").value
		};
		$.post("${pageContext.request.contextPath }/arrange/detailSave",
				params, function(data, XMLHttpRequest) {
					if (data.status == 200) {
						$.messager.alert("提示", "操作成功！", "alert");
						$('#dtForm').form('clear');

					}

				}, "json")
	}

	function formatter1(date) {
		if (!date) {
			return '';
		}
		return $.fn.datebox.defaults.formatter.call(this, date);
	}
	function parser1(s) {
		if (!s) {
			return null;
		}
		return $.fn.datebox.defaults.parser.call(this, s);
	}

	function getSelectionsIds() {
		var list = $("#plsList");
		var sels = list.datagrid("getSelections");
		var ids = [];
		for ( var i in sels) {
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}

	$(function() {
		$('#btn')
				.bind(
						'click',
						function() {
							$
									.post(
											"${pageContext.request.contextPath }/arrange/selectCountAddmaterialTem",
											function(data) {
												if (data == 0) {
													$.messager.alert("警告",
															"至少添加一个播放资源！",
															"error");
													return;
												}

												var model = document
														.getElementById("areatype").value;
												var name = document
														.getElementById("plsName").value;
												var stdtime = document
														.getElementById("stdtime").value
														+ "";
												var endtime = document
														.getElementById("endtime").value
														+ "";
												var stardate = document
														.getElementById("stardate").value
														+ "";
												var enddate = document
														.getElementById("enddate").value
														+ "";
												/* var playmode = document
														.getElementById("playMode").value; */

												var params = {
													"model" : model,
													"name" : name,
													"stdtime" : stdtime,
													"endtime" : endtime,
													"stardate" : stardate,
													"enddate" : enddate
												};
												$
														.post(
																"${pageContext.request.contextPath }/arrange/arrangeSave",
																params,
																function(
																		XMLHttpRequest) {
																	if (XMLHttpRequest.status == 200) {
																		$.messager
																				.alert(
																						'确认',
																						'操作成功!',
																						undefined,
																						function() {
																							/* 刷新父div */
																							location
																									.reload()
																						});
																	}

																}, "json")

											}, "json")

						});
	});
	var toolbar = [
			{
				text : '删除',
				iconCls : 'icon-cancel',
				handler : function() {
					var ids = getSelectionsIds();
					if (ids.length == 0) {
						$.messager.alert('提示', '未选中任何节目单!');
						return;
					}
					$.messager
							.confirm(
									'确认',
									'此操作会同时删除包含此节目单的节目包，确定要删除吗？',
									function(r) {
										if (r) {
											var params = {
												"ids" : ids
											};
											$
													.post(
															"${pageContext.request.contextPath }/arrange/deletePlsById",
															params,
															function(
																	XMLHttpRequest) {
																if (XMLHttpRequest.status == 200) {
																	$.messager
																			.alert(
																					'提示',
																					'节目单删除成功!',
																					undefined,
																					function() {
																						$(
																								"#plsList")
																								.datagrid(
																										"reload");
																					});
																}
															}, "json");
										}
									});
				}
			}, {
				text : '新建节目单',
				iconCls : 'icon-add',
				handler : function() {
					$("#newPls").dialog('center').dialog('open');
				}

			}];
	var playjson = [ {
		"id" : 1,
		"text" : "正常播放"
	}, {
		"id" : 0,
		"text" : "立即插播"
	} ]
	/* $('#playmode').combobox({
		data : playjson,
		valueField : 'id',
		textField : 'text',
		panelHeight : "auto",
		onChange : function(n, o) {
			document.getElementById("playMode").value = n;

		},
		onLoadSuccess : function() { //加载完成后,设置选中第一项  
			var val = $(this).combobox('getData');
			for ( var item in val[0]) {
				if (item == 'id') {
					$(this).combobox('select', val[0][item]);
				}
			}
		}
	}); */

	$.ajax({
				url : '${pageContext.request.contextPath }/arrange/modelList',
				dataType : 'json',
				success : function(jsonstr) {
					/* jsonstr.unshift({  
					     'id': '-1',
					     'name': '---请选择一个模版---'  
					 });//向json数组开头添加自定义数据   */
					$('#model')
							.combobox(
									{
										data : jsonstr,
										valueField : 'id',
										textField : 'name',
										panelHeight : "auto",
										onChange : function(n, o) {
											ar = null;
											$("#tem").val("");
											$("#temName").val("");
											document.getElementById("areatype").value = n;
											/* 根据id去查询model对象 */
											$.post("${pageContext.request.contextPath }/arrange/findModelById",
															{
																id : n
															},
															function(data) {

																/* center 即父div */
																var div = document
																		.getElementById("center");
																var content = document
																		.getElementById("content");
																if (content != null) {

																	$("#center")
																			.children(
																					"#content")
																			.remove();

																}

																var content = document
																		.createElement('div');
																content.id = "content";
																/* content.innerHTML="模拟屏幕"; */
																content.style.position = "relative";
																var strs = new Array(); //定义一数组 
																strs = data.resolution
																		.split("*"); //字符分割
																/* 设置该模版div的宽高，创建模版时等比缩小3倍 */
																content.style.width = strs[0]
																		/ 3
																		+ "px";
																content.style.height = strs[1]
																		/ 3
																		+ "px";

																content.style.background = "#C2C2C2";
																div
																		.appendChild(content);

															}, "json");

											$
													.post(
															"${pageContext.request.contextPath }/arrange/findAreaByModelId",
															{
																id : n
															},
															function(data) {

																/* center 即父div */
																var content = document
																		.getElementById("content");
																/* content.innerHTML="模拟屏幕"; */

																if (data.length > 0) {
																	for ( var i in data) {
																		/* 新生成的div */
																		var oDiv = document
																				.createElement('span');
																		oDiv.className = "span";
																		oDiv.id = "o"
																				+ data[i].id;
																		oDiv.innerHTML = data[i].areatype;
																		oDiv.style.position = "absolute";
																		oDiv.style.display = "block";

																		var x = data[i].x;
																		var y = data[i].y;
																		var width = data[i].width;
																		var height = data[i].height;

																		oDiv.style.left = x
																				+ "px";
																		oDiv.style.top = y
																				+ "px";
																		oDiv.style.width = width
																				+ "px";
																		oDiv.style.height = height
																				+ "px";
																		oDiv.style.background = data[i].bgcolor;
																		content
																				.appendChild(oDiv);

																	}

																}
															}, "json");

										}

									});
				}
			});
	

	$("body").on(
					'click',
					".span",
					function() {
						ar = this.id;
						ar = ar.substring(1);
						document.getElementById("tem").value = ar;
						document.getElementById("temName").value = this.innerHTML;
						$(this).css("background-color", "#149BDF").siblings()
								.css("background-color", "#E0FFFF");
						$(this).css("cursor", "pointer");
						/* if(this.innerHTML=="文本区"){
						} */

						var iframeWindow = document.getElementById('material').contentWindow;

						iframeWindow.$('#list').datagrid("load", {
							area : ar
						});
					});

	window.onbeforeunload = onbeforeunload_handler;
	function onbeforeunload_handler() {
		/* $.post("${pageContext.request.contextPath }/arrange/cl") */

		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/arrange/cl"

		});
	}

	var editAreaId;
	$(function() {
		$("body").on('contextmenu', ".span", function(e) {
			if (this.innerHTML == "文本区") {
				editAreaId = this.id;
				e.preventDefault();
				$('#mm').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	});
	function menuHandler(item) {
		if (item.name == "edit") {
			$(".textclass").show();
		}
	}

	function subText() {
		if ($("#text").val().trim().length == 0) {
			$.messager.alert("提示", "您未添加任何文本！", "info");
			$(".textclass").hide();
			return;
		}
		var param = {
			"text" : $("#text").val(),
			"areaId" : editAreaId
		};
		$.post("${pageContext.request.contextPath }/arrange/saveText", param,
				function(data) {
					if (data.states == "200") {
						$.messager.alert("提示", "添加文本成功！", "info", function() {
							$(".textclass").hide();
						});
					}

				}, "json");

	}
</script>


</html>