<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Notificações</title>
</head>
<body>
	<form method="post" action="inserirNotificacao">
		<fmt:message key="campo.secao"/> <select name="usuarios">
		<c:forEach var="u" items="${usuarios}">
			<option value="${u.id}">${u.nome}</option>
		</c:forEach>
		</select><br /> 
		<fmt:message key="campo.texto"/> <input type="text" name="texto" /> <br />
		<input type="submit">
	</form>
</body>
</html>