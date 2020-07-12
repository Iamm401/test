<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="./header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	font-size: 12px; 
}
tr{

}
td {
text-align: center;
} 
</style>
</head>
<body>
	<div class="container">
		<div class="user_list">
			<table class="table table-hover table-bordered table-condensed ">
				<thead class="btn-primary">
					<tr>
						<td>用户编号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>账号</td>
						<td>密码</td>
						<td>手机号</td>
						<td>邮箱</td>
						<td>所在城市</td>
						<td>注册时间</td>
						<td>是否是会员</td>
						<td>会员截止时间</td>
						<td>/</td>
						<td>/</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList }" var="user">
						<tr>
							<td>${user.id }</td>
							<td>${user.name }</td>
							<td>${user.sex==0?'女':'男' }</td>
							<td>${user.account }</td>
							<td>${user.password }</td>
							<td>${user.phone }</td>
							<td>${user.email }</td>
							<td>${user.city }</td>
							<td><fmt:formatDate value="${user.reg_time }" pattern="yyyy-MM-dd"/></td>
							<td>${user.is_vip }</td>
							<td><fmt:formatDate value="${user.vip_deadline }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
							<td><a class="btn btn-info btn-sm" href="<%=basePath %>employee/user?type=upd&id=${user.id }">修改</a></td>
							<td><a class="btn btn-danger btn-sm del_user" href="<%=basePath %>employee/user?type=del&id=${user.id }">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="13">
							<a class="btn" href="<%=basePath %>employee/user?type=add">添加</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$('.del_user').click(function(){
		var node = $(this).parent().parent();
		if(confirm("是否确认删除该用户?")){
			$.post($(this).attr("href"),{},function(data,status){
				if("ok" == data){
					alert("删除成功!");				
					node.remove();		
				}else{
					alert("删除失败!");
				}
			});
		}
		return false;
	})
})
</script>
</html>