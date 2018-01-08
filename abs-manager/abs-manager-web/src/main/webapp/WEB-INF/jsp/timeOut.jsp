<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
		
<body>


</body>
<script type="text/javascript">

var  time; 
var  n = 1000*60*10;//定义十分钟超时


time = setTimeout(function() {
	top.location = "${baseurl}/login";
$.messager.alert("警告","登录超时，请重新登录！", "info", function() {
    
});
}, n);



	$(function() {
		var i = 0;
		document.onmousedown = function(event) {
			clearTimeout(time);
			time = setTimeout(function() {
					top.location = "${baseurl}/login";
				$.messager.alert("警告", "登录超时，请重新登录！", "info", function() {

				});
			}, n);
		};
		document.onkeydown = function(event) {
			clearTimeout(time);
			time = setTimeout(function() {
					top.location = "${baseurl}/login";
				$.messager.alert("警告", "登录超时，请重新登录！", "info", function() {

				});
			}, n);
		};
	});
</script>
</html>