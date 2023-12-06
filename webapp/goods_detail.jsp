<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>商品详情</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/flexslider.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
	<script>
		$(function() {
		  $('.flexslider').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
		  });
		});
	</script>
</head>
<body>
	 
	<!-- 头部 -->	
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- //头部 -->
	
	<!--商品详情-->
	<div class="single">
		<div class="container">
			<div class="single-grids">				
				<div class="col-md-4 single-grid">
					<div class="flexslider">
						
						<ul class="slides">
							<li data-thumb="${pageContext.request.contextPath }${g.cover }">
								<div class="thumb-image"> <img src="${pageContext.request.contextPath }${g.cover }" data-imagezoom="true" class="img-responsive"> </div>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="col-md-4 single-grid simpleCart_shelfItem">
					<h2>${g.name }</h2>
					<p>介绍: ${g.intro }</p>
					<div class="galry">
						<div class="prices">
							<h5 class="item_price">¥ ${g.price }</h5>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="btn_form">
						<a href="javascript:;" class="add-cart item_add" onclick="buy(${g.id })">加入购物车</a>	
					</div>
				</div>
				
				<div class="col-md-4 single-grid1">
					<ul>
							<li><a>广告位招租</a></li>
							<li><a>广告位招租</a></li>
							<li><a>广告位招租</a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>
	<!--//商品详情-->
	
</body>
</html>