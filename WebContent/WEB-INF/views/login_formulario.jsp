<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="login.titulo"/></title>
</head>
<body>
	<h2><fmt:message key="login.titulo"/></h2>
	<form action="login" method="post">
		<fmt:message key="campo.login"/> <input type="text" name="login" value="a"/> <br />
		<fmt:message key="campo.senha"/> <input type="text" name="senha" value="a"/> <br />
		<input name="permanecer" type="checkbox" /> <fmt:message key="login.campo.checkbox"/><br />
		<input type="submit" value="<fmt:message key="botao.enviar"/>" /> 
	</form>
</body>
</html>