<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
.user_info{
	width: 70%;
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
		<c:if test="${empty user.id }">
			<div class="title">
				添加用户
			</div>
		</c:if>
		<c:if test="${!empty user.id }">
			<div class="title">
				修改用户信息
			</div>
		</c:if>
		<div class="user_info">
			<form class="form-horizontal" action="<%=basePath %>employee/user" method="post">
				<input type="hidden" name="type" value="${empty user.id?'add':'upd' }">
				<input type="hidden" name="id" value="${user.id }">
				<div class="form-group">
					<label class="control-label col-sm-2">姓名:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="name" class="form-control" value="${user.name }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">性别:</label>
					<div class="col-sm-10">
						<label class="checkbox-inline">
							<input style="" type="radio" name="sex" value="1" ${user.sex != 0?'checked="checked"':'' }/> 男
						</label>
						<label class="checkbox-inline">
							<input style="" type="radio" name="sex" value="0" ${user.sex == 0?'checked="checked"':'' }/> 女
						</label>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">账号:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="account" class="form-control" value="${user.account }" ${empty user.id?'':'readonly="readonly"'  }/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">密码:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="password" class="form-control" value="${user.password }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">手机号:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="phone" class="form-control" value="${user.phone }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">邮箱:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="email" class="form-control" value="${user.email }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">所在城市:</label>
					<div class="col-sm-10">
						<input style="" type="text" name="city" class="form-control" value="${user.city }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">是否是会员:</label>
					<div class="col-sm-10">
						<label class="checkbox-inline">
							<input id="no_vip" style="" type="radio" name="is_vip" value="0" ${user.is_vip != 1?'checked="checked"':'' }/> 否
						</label>
						<label class="checkbox-inline">
							<input id="yes_vip" style="" type="radio" name="is_vip" value="1" ${user.is_vip == 1?'checked="checked"':'' }/> 是
						</label>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">会员截止时间:</label>
					<div class="col-sm-10">
						<input style="" type="date" name="vip_deadline" class="form-control" value="<fmt:formatDate value="${user.vip_deadline }" pattern="yyyy-MM-dd" />"/>
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
<script type="text/javascript">
	$(function(){
		$('input[name="vip_deadline"]').change(function(){
			$('#yes_vip').prop('checked',true);
		})
	})
</script>
</html>