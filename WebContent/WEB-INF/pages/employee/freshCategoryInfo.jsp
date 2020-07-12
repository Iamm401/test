<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	font-family: '宋体'
}
.container{
	display: flex;
	flex-direction: column;;
	align-items: center;
	margin-bottom: 100px;
}
.freshCategory_info{
	width: 60%;
}
.title{
	font-size: 26.66px;
	padding: 40px; 
	padding-bottom:10px;
	border-bottom: 1px solid #ccc;
	width: 100%;
	margin-bottom: 46px;
}
</style> 
</head>
<body>
	<div class="container"> 
		<c:if test="${empty freshCategory.id }">
			<div class="title">
				添加分类
			</div>
		</c:if>
		<c:if test="${!empty freshCategory.id }">
			<div class="title">
				修改分类信息
			</div>
		</c:if>
		<div class="freshCategory_info">
			<form class="form-horizontal" action="<%=basePath %>employee/fresh_category" method="post">
				<input type="hidden" name="type" value="${empty freshCategory.id?'add':'upd' }">
				<input type="hidden" name="id" value="${freshCategory.id }">
				<div class="form-group">
					<label class="control-label col-sm-2">分类名称:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="name" class="form-control" value="${freshCategory.name }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">分类描述:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="desc" class="form-control" value="${freshCategory.desc }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"></label>
					<div class="col-sm-10">
						<input type="submit" value="提交" class="btn btn-primary form-control">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>