<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>
<body>

	<!-- 头部 -->	
	<jsp:include page="/header.jsp">
		<jsp:param value="6" name="flag"/>
	</jsp:include>
	<!-- //头部 -->

	<!--订单-->
	<div class="cart-items">
		<div class="container">
			<h2>我的订单</h2>
				<table class="table table-bordered table-hover">
				
				<tr>
					<th width="10%">ID</th>
					<th width="10%">总价</th>
					<th width="20%">商品详情</th>
					<th width="20%">收货信息</th>
					<th width="10%">订单状态</th>
					<th width="10%">操作</th>
				</tr>
				
				<c:forEach items="${orderlist }" var="order">
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
						<td>
							<p>无操作</p>
						</td>
					</tr>
				</c:forEach>
  
			</table>
		</div>
	</div>
	<!--//订单-->	

</body>
</html>