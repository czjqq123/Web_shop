<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>个人中心</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/simpleCart.min.js"></script>
</head>
<body>

	<!-- 头部 -->	
	<jsp:include page="/header.jsp">
		<jsp:param value="5" name="flag"/>
	</jsp:include>
	<!-- //头部 -->

	<div class="account">
		<div class="container">
			<div class="register">
				
				<c:if test="${!empty msg }">
					<div class="alert alert-success">${msg }</div>
				</c:if>
				<c:if test="${!empty successMsg }">
					<div class="alert alert-success">${successMsg }</div>
				</c:if>
				<c:if test="${!empty failMsg }">
					<div class="alert alert-danger">${failMsg }</div>
				</c:if>
				
				<form action="${pageContext.request.contextPath }/user_change" method="post"> 
					<div class="register-top-grid">
						<h3>个人中心</h3>
						
						<h4>收货信息</h4>
						<div class="input">
							<span>收货人<label></label></span>
							<input type="text" name="name" value="${user.name }" placeholder="请输入收货人"> 
						</div>
						<div class="input">
							<span>收货电话</span>
							<input type="text" name="phone" value="${user.phone }" placeholder="请输入收货电话"> 
						</div>
						<div class="input">
							<span>收货地址</span>
							<input type="text" name="address" value="${user.address }" placeholder="请输入收货地址"> 
						</div>
						
						<h4>安全信息</h4>
						<div class="input">
							<span>原密码</span>
							<input type="text" name="password" placeholder="请输入原密码"> 
						</div>
						<div class="input">
							<span>新密码</span>
							<input type="text" name="passwordNew" placeholder="请输入新密码"> 
						</div>
						<div class="clearfix"> </div>
						<div class="register-but text-center">
						   <input type="submit" value="提交">
						</div>	
					</div>
				</form>
				
				<div class="clearfix"> </div>
			</div>
	    </div>
	</div>

</body>
</html>