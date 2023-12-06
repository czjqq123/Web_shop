<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>客户列表</title>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
	<div class="container-fluid">

	<jsp:include page="/admin/header.jsp"></jsp:include>
	
	<div class="text-right"><a class="btn btn-warning" href="${pageContext.request.contextPath }/admin/user_add.jsp">添加客户</a></div>
	<br>
	
	<c:if test="${!empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	<c:if test="${!empty failMsg }">
		<div class="alert alert-danger">${failMsg }</div>
	</c:if>
	<br>
	
	<table class="table table-bordered table-hover">
	<tr>
		<th width="5%">ID</th>
		<th width="10%">用户名</th>
		<th width="10%">邮箱</th>
		<th width="10%">收货人</th>
		<th width="10%">收货电话</th>
		<th width="10%">收货地址</th>
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach items="${p.list }" var="user">
		<tr>
         	<td><p>${user.id }</p></td>
         	<td><p>${user.username }</p></td>
         	<td><p>${user.email }</p></td>
         	<td><p>${user.name }</p></td>
         	<td><p>${user.phone }</p></td>
         	<td><p>${user.address }</p></td>
			<td>
				<a class="btn btn-info" href="${pageContext.request.contextPath }/admin/user_reset?id=${user.id }&pageNo=${p.pageNo }">重置密码</a>
				<a class="btn btn-danger" href="${pageContext.request.contextPath }/admin/user_delete?id=${user.id }&pageNo=${p.pageNo }">删除</a>
			</td>
       	</tr>
	</c:forEach>
</table>

	<div style='text-align:center;'>
<a class='btn btn-info' <c:if test="${p.pageNo<=1 }">disabled</c:if> <c:if test="${p.pageNo!=1 }">href="${pageContext.request.contextPath }/admin/user_list?pageNo=1"</c:if>>首页</a>
<a class='btn btn-info' <c:if test="${p.pageNo<=1 }">disabled</c:if> <c:if test="${p.pageNo!=1 }">href="${pageContext.request.contextPath }/admin/user_list?pageNo=${p.pageNo-1 }"</c:if>>上一页</a>
<h3 style='display:inline;'>[${p.pageNo }/${p.totalPage }]</h3>
<h3 style='display:inline;'>[${p.totalCount }]</h3>
<a class='btn btn-info' <c:if test="${p.pageNo>=p.totalPage }">disabled</c:if> <c:if test="${p.pageNo!=p.totalPage }">href="${pageContext.request.contextPath }/admin/user_list?pageNo=${p.pageNo+1 }"</c:if>>下一页</a>
<a class='btn btn-info' <c:if test="${p.pageNo>=p.totalPage }">disabled</c:if> <c:if test="${p.pageNo!=p.totalPage }">href="${pageContext.request.contextPath }/admin/user_list?pageNo=${p.totalPage }"</c:if>>尾页</a>
<input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="${pageContext.request.contextPath }/admin/user_list?pageNo="+(this.previousSibling.value)+""'>GO</a>
	</div><br></div>
</body>
</html>