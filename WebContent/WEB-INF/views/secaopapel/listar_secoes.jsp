<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Se��es</title>
</head>
<body>
<fmt:message key="campo.usuario.logado"/>  ${administrador_logado.nome}
<table border="1">
	<c:forEach var="s" items="${secoes}">
	<tr>
		<td>${s.secaoId}</td>
		<td><a href="listarNoticiaPorSecao?id=${s.secaoId}">${s.titulo}</a></td>
		<td>${s.descricao}</td>
		<td><a href="alterarAlunoFormulario?id=${a.id}"><fmt:message key="botao.alterar"/></a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>