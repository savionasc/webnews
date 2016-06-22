<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Usuario</title>
</head>
<body>

Aluno logado: ${aluno_logado.nome}
<table border="1">
	<c:forEach var="u" items="${usuarios}">
	<tr>
		<td>${u.id}</td>
		<td>${u.nome}</td>
		<td>${u.login}</td>
		<td>${u.senha}</td>
		<td><img alt="${n.titulo}" src="<c:url value="/resources/images/${n.id}.png"  />" /></td>
		<td><a href="alterarUsuarioFormulario?id=${u.id}">ALTERAR</a></td>
		<td><a href="apagarUsuario?id=${u.id}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>