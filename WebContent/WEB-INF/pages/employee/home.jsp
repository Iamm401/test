<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="commodity_list">
			<table class="table table-hover table-bordered table-condensed ">
				<thead class="btn-primary">
					<tr>
						<td>商品编号</td>
						<td>商品名称</td>
						<td>商品类别</td>
						<td>商品价格</td>
						<td>商品会员价格</td>
						<td>商品数量</td>
						<td>商品规格</td>
						<td>商品详情</td>
						<td>/</td>
						<td>/</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${commodityList }" var="commodity">
						<tr>
							<td>${commodity.id }</td>
							<td>${commodity.name }</td>
							<td>${commodity.category.name }</td>
							<td>${commodity.price }</td>
							<td>${commodity.vip_price }</td>
							<td>${commodity.amount }</td>
							<td>${commodity.size }</td>
							<td style="max-width: 200px;">${commodity.details }</td>
							<td><a class="btn btn-info btn-sm" href="<%=basePath %>employee/commodity?type=upd&id=${commodity.id }">修改</a></td>
							<td><a class="btn btn-danger btn-sm del_commodity" href="<%=basePath %>employee/commodity?type=del&id=${commodity.id }">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
				</tfoot>
			</table>
		</div>
		<div style="display: flex; align-items: center; justify-content:space-between;margin-bottom: 100px;">		
			<div class="add_commodity">
				<a class="btn btn-primary" href="<%=basePath %>employee/commodity?type=add">添加</a>
			</div>
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<c:if test="${pageNum != 1 }">
						<li><a href="<%=basePath %>employee/home?pageNum=${pageNum - 1 }&pageSize=10"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach begin="${begin }" end="${end }" var="p">
						<li class="${p==pageNum?'active':'' }"><a href="<%=basePath %>employee/home?pageNum=${p }&pageSize=10">${p }</a></li>
					</c:forEach>
					<c:if test="${pageNum != totalPage }">				
						<li><a href="<%=basePath %>employee/home?pageNum=${pageNum + 1 }&pageSize=10" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$('.del_commodity').click(function(){
		return confirm("是否确认删除该商品?");
	})
})
</script>
</html>