<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--头部-->
	<div class="header">
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<h1 class="navbar-brand"><a href="${pageContext.request.contextPath }">电子商城</a></h1>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath }" <c:if test="${param.flag==1 }">class="active"</c:if> >首页</a></li>
						<li><a href="${pageContext.request.contextPath }/goods_list" <c:if test="${param.flag==2 }">class="active"</c:if> >全部商品</a></li>
						
						<c:choose><c:when test="${empty user }">
							<li><a href="${pageContext.request.contextPath }/user_register.jsp" <c:if test="${param.flag==3 }">class="active"</c:if> >注册</a></li>
							<li><a href="${pageContext.request.contextPath }/user_login.jsp" <c:if test="${param.flag==4 }">class="active"</c:if> >登录</a></li>
						</c:when><c:otherwise>
							<li><a href="${pageContext.request.contextPath }/user_center.jsp" <c:if test="${param.flag==5 }">class="active"</c:if> >个人中心</a></li>
							<li><a href="${pageContext.request.contextPath }/order_list" <c:if test="${param.flag==6 }">class="active"</c:if> >我的订单</a></li>
							<li><a href="${pageContext.request.contextPath }/user_logout">退出</a></li>
						</c:otherwise>
						</c:choose>
						
						<c:if test="${!empty user&&user.isadmin }">
							<li><a href="${pageContext.request.contextPath }/admin/admin_index.jsp" target="_blank">后台管理</a></li>
						</c:if>
					</ul> 
				</div>
			</nav>
			
			<div class="header-info">
				<div class="header-right search-box">
					<a href="javascript:;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>				
					<div class="search">
						<form class="navbar-form" action="${pageContext.request.contextPath }/goods_search">
							<input type="text" class="form-control" name="keyword" />
							<button type="submit" class="btn btn-default" aria-label="Left Align">搜索</button>
						</form>
					</div>
				</div>
				
				<div class="header-right cart">
					<a href="${pageContext.request.contextPath }/goods_cart.jsp">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span class="card_num">${order.amount }</span></span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!--//头部-->