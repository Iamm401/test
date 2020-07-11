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
.commodity_info{
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
		<c:if test="${empty commodity.id }">
			<div class="title">
				添加商品
			</div>
		</c:if>
		<c:if test="${!empty commodity.id }">
			<div class="title">
				修改商品信息
			</div>
		</c:if>
		<div class="commodity_info">
			<form class="form-horizontal" action="<%=basePath %>employee/commodity" method="post">
				<input type="hidden" name="type" value="${empty commodity.id?'add':'upd' }">
				<input type="hidden" name="id" value="${commodity.id }">
				<div class="form-group">
					<label class="control-label col-sm-2">商品名称:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="name" class="form-control" value="${commodity.name }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">商品价格:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="price" class="form-control" value="${commodity.price }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">商品会员价:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="vip_price" class="form-control" value="${commodity.vip_price }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">商品数量:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="amount" class="form-control" value="${commodity.amount }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">商品规格:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="size" class="form-control" value="${commodity.size }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">商品详情:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="details" class="form-control" value="${commodity.details }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">商品类别:</label>
					<div class="col-sm-10">
						<select class="form-control" name="category_id">
							<c:forEach items="${freshCategoryList }" var="freshCategory">
								<option ${freshCategory.id == commodity.category_id?'selected="selected"':'' } value="${freshCategory.id }">${freshCategory.name }</option>
							</c:forEach>
						</select>
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