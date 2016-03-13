<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="addUserAction" method="post" package="/user"
		enctype="multipart/form-data">
		<s:textfield name="userDto.userName" label="用户名" />
		<s:textfield name="userDto.realName" label="真实名字" />
		<s:password name="userDto.password" label="密码"></s:password>
		<s:radio label="性别" list="#{'M':'男','F':'女','O':'其他' }"
			name="userDto.gender"></s:radio>
		<s:textfield name="userDto.birthday" label="生日"></s:textfield>
		<s:file name="files" label="头像"></s:file>
		<s:submit value="注册"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
</body>
</html>