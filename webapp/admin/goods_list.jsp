<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>商品列表</title>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<jsp:include page="/admin/header.jsp"></jsp:include>

	<div class="text-right"><a class="btn btn-warning" href="${pageContext.request.contextPath }/admin/goods_add.jsp">添加商品</a></div>
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
		<th width="10%">图片</th>
		<th width="10%">名称</th>
		<th width="20%">介绍</th>
		<th width="10%">价格</th>
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach items="${p.list }" var="g">
         <tr>
         	<td><p>${g.id }</p></td>
         	<td><p><a href="${pageContext.request.contextPath }/goods_detail?id=${g.id }" target="_blank"><img src="${pageContext.request.contextPath }${g.cover }" width="100px" height="100px"></a></p></td>
         	<td><p><a href="${pageContext.request.contextPath }/goods_detail?id=${g.id }" target="_blank">${g.name }</a></p></td>
         	<td><p>${g.intro }</p></td>
         	<td><p>￥ ${g.price }</p></td>
			<td>
				<a class="btn btn-danger" href="${pageContext.request.contextPath }/admin/goods_delete?id=${g.id }&pageNo=${p.pageNo }">删除</a>
			</td>
       	</tr>
	</c:forEach>
	</table>

	<br><div style='text-align:center;'>
<a class='btn btn-info' <c:if test="${p.pageNo<=1 }">disabled</c:if> <c:if test="${p.pageNo!=1 }">href="${pageContext.request.contextPath }/admin/goods_list?pageNo=1"</c:if>>首页</a>
<a class='btn btn-info' <c:if test="${p.pageNo<=1 }">disabled</c:if> <c:if test="${p.pageNo!=1 }">href="${pageContext.request.contextPath }/admin/goods_list?pageNo=${p.pageNo-1 }"</c:if>>上一页</a>
<h3 style='display:inline;'>[${p.pageNo }/${p.totalPage }]</h3>
<h3 style='display:inline;'>[${p.totalCount }]</h3>
<a class='btn btn-info' <c:if test="${p.pageNo>=p.totalPage }">disabled</c:if> <c:if test="${p.pageNo!=p.totalPage }">href="${pageContext.request.contextPath }/admin/goods_list?pageNo=${p.pageNo+1 }"</c:if>>下一页</a>
<a class='btn btn-info' <c:if test="${p.pageNo>=p.totalPage }">disabled</c:if> <c:if test="${p.pageNo!=p.totalPage }">href="${pageContext.request.contextPath }/admin/goods_list?pageNo=${p.totalPage }"</c:if>>尾页</a>
<input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="${pageContext.request.contextPath }/admin/goods_list?pageNo="+(this.previousSibling.value)+""'>GO</a>
	</div><br></div>
</body>
</html>