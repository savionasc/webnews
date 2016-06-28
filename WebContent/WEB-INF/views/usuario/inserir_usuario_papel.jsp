<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario Papel</title>
</head>
<body>
	<form action="inserirUsuario" method="post" enctype="multipart/form-data">
		<fmt:message key="campo.nome"/><input type="text" name="nome" />
		<br />
		<input type="hidden" value="1" name="papel" />
		<!-- Papel:  
			<select name="papel">
				<c:forEach var="a" items="${papeis}">
				<option value="${a.id}">${a.papel}</option>
				</c:forEach>
			</select>
			-->
		<fmt:message key="campo.email"/> <input type="text" name="email" /><br />
		<fmt:message key="campo.imagem"/> <input type="file" name="imagem" /><br />
		<fmt:message key="campo.login"/> <input type="text" name="login" /> <br />
		<fmt:message key="campo.senha"/> <input type="text" name="senha" /> <br />
		<input type="submit" value="<fmt:message key="botao.enviar"/>" />
		
	</form>
</body>
</html>