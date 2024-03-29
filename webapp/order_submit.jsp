<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>支付</title>
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
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- //头部 -->

	<div class="cart-items">
		<div class="container">
			<h2>确认收货信息</h2>
			<form class="form-horizontal" action="${pageContext.request.contextPath }/order_pay" method="post" id="payform">
				<div class="row">
					<label class="control-label col-md-1">收货人</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="name" value="${user.name }" style="height:auto;padding:10px;" placeholder="输入收货人" required="required"><br>
					</div>
				</div>
				<div class="row">
					<label class="control-label col-md-1">收货电话</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="phone" value="${user.phone }" style="height:auto;padding:10px;" placeholder="输入收货电话" required="required"><br>
					</div>
				</div>
				<div class="row">
					<label class="control-label col-md-1">收货地址</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="address" value="${user.address }" style="height:auto;padding:10px;" placeholder="输入收货地址" required="required"><br>
					</div>
				</div>
				<h3>支付金额: ${order.total }</h3><br><br>
				<div class="register-but text-center">
					<input type="submit" value="提交订单并支付">
					<div class="clearfix"> </div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>