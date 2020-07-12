<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<style type="text/css">
	.container{
		margin-top: 20px;
	}
</style>
</head>
<body>
	<div class="container">
		<ul class="nav nav-tabs">
		  <li role="presentation" class="${nowMenuIndex==1?'active':'' }"><a href="<%=basePath %>/employee/home">商品列表</a></li>
		  <li role="presentation" class="${nowMenuIndex==2?'active':'' }"><a href="<%=basePath %>employee/fresh_category">商品类别管理</a></li>
		  <li role="presentation" class="${nowMenuIndex==3?'active':'' }"><a href="<%=basePath %>employee/user">用户管理</a></li>
		</ul>
	</div>
</body>
</html> 