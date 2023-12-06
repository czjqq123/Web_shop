<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>订单列表</title>
	<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
	<div class="container-fluid">

	<jsp:include page="/admin/header.jsp"></jsp:include>
	
	<table class="table table-bordered table-hover">
	<tr>
		<th width="5%">ID</th>
		<th width="5%">总价</th>
		<th width="15%">商品详情</th>
		<th width="20%">收货信息</th>
		<th width="10%">订单状态</th>
		<th width="10%">下单用户</th>
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach items="${p.list }" var="order">
		<tr>
         	<td><p>${order.id }</p></td>
         	<td><p>${order.total }</p></td>
         	<td>
	         	<c:forEach items="${order.itemList }" var="item">
					<p>${item.goodsname }(${item.price }) x ${item.amount }</p>
				</c:forEach>
         	</td>
         	<td>
         		<p>收货人：${order.name }</p>
         		<p>手机号码：${order.phone }</p>
         		<p>收货地址：${order.address }</p>
         	</td>
			<td>
				<p><span style="color:red;">已付款</span></p>
			</td>
			<td><p>${order.user.username }</p></td>
			<td>
				<a class="btn btn-danger" href="${pageContext.request.contextPath }/admin/order_delete?id=${order.id }&pageNo=${p.pageNo }">删除</a>
			</td>
       	</tr>
	</c:forEach>
	</table>

	<div style='text-align:center;'>
<a class='btn btn-info' <c:if test="${p.pageNo<=1 }">disabled</c:if> <c:if test="${p.pageNo!=1 }">href="${pageContext.request.contextPath }/admin/order_list?pageNo=1"</c:if>>首页</a>
<a class='btn btn-info' <c:if test="${p.pageNo<=1 }">disabled</c:if> <c:if test="${p.pageNo!=1 }">href="${pageContext.request.contextPath }/admin/order_list?pageNo=${p.pageNo-1 }"</c:if>>上一页</a>
<h3 style='display:inline;'>[${p.pageNo }/${p.totalPage }]</h3>
<h3 style='display:inline;'>[${p.totalCount }]</h3>
<a class='btn btn-info' <c:if test="${p.pageNo>=p.totalPage }">disabled</c:if> <c:if test="${p.pageNo!=p.totalPage }">href="${pageContext.request.contextPath }/admin/order_list?pageNo=${p.pageNo+1 }"</c:if>>下一页</a>
<a class='btn btn-info' <c:if test="${p.pageNo>=p.totalPage }">disabled</c:if> <c:if test="${p.pageNo!=p.totalPage }">href="${pageContext.request.contextPath }/admin/order_list?pageNo=${p.totalPage }"</c:if>>尾页</a>
<input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="${pageContext.request.contextPath }/admin/order_list?pageNo="+(this.previousSibling.value)+""'>GO</a>
	</div><br></div>
</body>
</html>