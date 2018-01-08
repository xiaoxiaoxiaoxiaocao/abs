<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
	    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
		<style>
        *{
            margin: 0;
            padding: 0;

        }
        .layout{
            width: 100%;
            background: url(${pageContext.request.contextPath }/imgs/bg1.png) no-repeat center;
            height: 100vh;
            background-size: cover
        }
        .login {
            width: 37.5%;
            height: 500px;
            position: absolute;
            top: 10.5%;
            left: 44.5%;
            padding-top:6%;
            text-align: center
        }
        .login h2{
            font-size: 30px;
        }
        .login ul {
            list-style: none;
            padding-top: 10%;
        }
       li{
           margin-bottom: 40px;
          
       }
        li:nth-of-type(1) input{
            width: 340px;
            height: 40px;
            padding-left: 30px;
            box-sizing: border-box;
        }
        li:nth-of-type(1){
            position: relative
        }
        li:nth-of-type(1)::before{
                content: "";
                width: 20px;
                height: 20px;
                position: absolute;
                background:url(${pageContext.request.contextPath }/imgs/user.png) no-repeat center;
                background-size: cover;
                top: 10px;
                left: 92px;
        }
        li:nth-of-type(2){
            position: relative;
        }
        li:nth-of-type(2)::before{
                content: "";
                width: 20px;
                height: 20px;
                position: absolute;
                background:url(${pageContext.request.contextPath }/imgs/pwd.png) no-repeat center;
                background-size: contain;
                top: 10px;
                left: 92px;
        }
        li:nth-of-type(2) input {
            width: 340px;
            height: 40px;
            padding-left: 30px;
            box-sizing: border-box;
        }
        li:nth-of-type(3){
            width: 338px;
            height: 45px;
            background: url(${pageContext.request.contextPath }/imgs/denglu.png) no-repeat center;
            background-size: cover;
            margin: 0 auto;
            cursor: pointer;
        }
        
    </style>
	
	</HEAD>
	<BODY>
		<div class="layout">

		    <div class="login">
		         <h2>管控平台</h2>
		         <form id="form1" name=form1 action="${pageContext.request.contextPath }/user/logon" method="post">
		         
			         <ul>
			             <li><input id="username" name="username" class="required" type="text" value="" placeholder="请输入用户名"></li>
			             
			             <li><input id="password" name="password" class="required" type="password" value='' placeholder="请输入密码" ></li>
			             <li onclick="login()"> </li>
			             <li><SPAN  id="RequiredFieldValidator3" style="FONT-WEIGHT: bold;  COLOR: red"></SPAN></li>
			         </ul>
		       			 <label id="msg" style="margin-left:80px;color:red">${msg }</label>
		         </form>
		        
		        
		    </div>
    
		</div>
	</BODY>
	<script type="text/javascript">

function login(){ 
	var username = $("#username").val(); 
	var password =$("#password").val();
		if(username==''){
			$("#RequiredFieldValidator3").html("请输入账号");
			return false;
		}
		if
			(password==''){
			$("#RequiredFieldValidator3").html("请输入密码");
			return false;
		}
	$("#form1").submit();
}
	
</script>
</HTML>
