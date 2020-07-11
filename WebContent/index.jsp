<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>海鲜网</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
body{
	font-family: '宋体'
}
.container{
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}
.login{
	text-align:center;
	position: fixed; 
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	border-radius: 10px; 
	padding:30px 80px;
	background: rgba(255, 255, 255,0.5555);
	transition: all 1s;
}
.login:hover{
	background: rgba(255, 255, 255,0.8888);
	transition: all 1s;
	cursor: pointer;
}
.login>form{
	display: flex;
	flex-direction: column;
	align-items: center;  
	justify-content: center;
	
}
form>div{
	padding:5px 0;
}
.title{
	padding-bottom:20px;
	font-size: 30px;
	-webkit-background-clip: text;
	color: transparent;
	background-image: linear-gradient(to right, #06263D, #34A4FD, #045D97, #06263D, #045D97, #34A4FD,
		#06263D);
}
.user_type,.user_type>input{
	cursor: pointer;
}
input{
	background: none;
	border: none;
	background: none;
	font-size: 18px;
}
#bg{
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -10;
	zoom: 1;
	background-color: #fff;
	background-repeat: no-repeat;
	background-size: cover;
	-webkit-background-size: cover;
	background-attachment: fixed;
	-o-background-size: cover;
	background-position: center 0;
	filter: blur(2.666px);
	transform: scale(1.011);
}
</style>
</head>
<body>
	<div id="bg" style="background-image: url('<%=basePath%>images/login_bg.jpg');"></div>
	<div class="container">
		<div class="login">
			<div class="title">
				海鲜网
			</div>
			<form action="<%=basePath %>login">
				<div>				
					<input type="text" class="form-control" name="account" placeholder="请输入账号">
				</div>
				<div>
					<input type="password" class="form-control" name="password" placeholder="请输入密码">
				</div>
				<div class="user_type_wrap" style="display: flex;align-items: center;justify-content: space-around;width: 100%">
					<div class="user_type"><input type="radio" name="userType" value="user" checked="checked">&nbsp;用户</div>
					 <div class="user_type"><input type="radio" name="userType" value="employee">&nbsp;员工</div>
				</div>
				<div style="display: flex;align-items: center;justify-content: space-around;width: 100%">
					<input type="button" class="btn btn-primary" style="width: 44%" value="注册">
					<input type="submit" class="btn btn-primary" style="width: 44%" value="登录">
				</div>
				<span style="text-align: center;padding-top: 6.66px;color: red">${msg }</span>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$('.user_type').click(function(){
		$(this).find('input[name="userType"]').prop("checked", true);
	})
	$('input[type="submit"]').click(function(){
		var account = $('input[name="account"]').val();
		var password = $('input[name="password"]').val();
		if($.trim(account) == '' || $.trim(password) == ''){
			alert("请输入账号密码!");
			return false;
		}
	})
})
</script>
</html>