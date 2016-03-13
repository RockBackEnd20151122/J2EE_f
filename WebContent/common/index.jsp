<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	首页
	<table>
		<tr>
			<td><img alt="图片" src="/struts_crud/upload/${headImage}" height="40"
				width="40"></td>
			<td colspan="4">${userName}您好：,您的登陆时间是${loginTime}</td>
		</tr>
		<tr>
			<td><a href="../user/resetPassword.jsp">修改密码</a></td>
			<td>修改信息</td>
			<td><a href="../shop/shopping.jsp">购物页面</a></td>
			<td><a href="../product/queryProduct.jsp">商品维护页面</a></td>
		</tr>
		<tr>
			<td>我的订单</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>

</body>
</html>