<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Classificados</title>
</head>
<body>

<fmt:message key="campo.usuario.logado"/>${usuario_logado.nome}<br />
<h4>Classificados Inativos</h4>
<table border="1">
	<c:forEach var="c" items="${classificados}">
	<c:if test="${c.ativo == false}">
	<tr>
		<td>${c.id}</td>
		<td>${c.titulo}</td>
		<td>${c.texto}</td>
		<td><a href="alterarUsuarioFormulario?id=${c.id}">ALTERAR</a></td>
		<td><a href="ativarClassificado?id=${c.id}">ATIVAR</a></td>
		<td><a href="apagarClassificado?id=${c.id}">APAGAR</a></td>
	</tr>
	</c:if>
	</c:forEach>
</table>

</body>
</html>