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
		<div class="fresh_category_list">
			<table class="table table-hover table-bordered table-condensed ">
				<thead class="btn-primary">
					<tr>
						<td>类别编号</td>
						<td>类别名称</td>
						<td>商品描述</td>
						<td>/</td>
						<td>/</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${freshCategoryList }" var="freshCategory">
						<tr>
							<td>${freshCategory.id }</td>
							<td>${freshCategory.name }</td>
							<td>${freshCategory.desc }</td>
							<td><a class="btn btn-info btn-sm" href="<%=basePath %>employee/fresh_category?type=upd&id=${freshCategory.id }">修改</a></td>
							<td><a class="btn btn-danger btn-sm del_fresh_category" href="<%=basePath %>employee/fresh_category?type=del&id=${freshCategory.id }">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<a class="btn" href="<%=basePath %>employee/fresh_category?type=add">添加</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$('.del_fresh_category').click(function(){
		var node = $(this).parent().parent();
		if(confirm("是否确认删除该类别?")){
			$.post($(this).attr("href"),{},function(data,status){
				if("ok" == data){
					alert("删除成功!");				
					node.remove();		
				}else{
					alert("删除失败,该类型中还有商品!");
				}
			});
		}
		return false;
	})
})
</script>
</html>