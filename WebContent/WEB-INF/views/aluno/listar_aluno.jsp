<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Aluno</title>
</head>
<body>

Aluno logado: ${aluno_logado.nome}
<table border="1">
	<c:forEach var="a" items="${alunos}">
	<tr>
		<td>${a.id}</td>
		<td>${a.nome}</td>
		<td>${a.IRA}</td>
		<td>${a.login}</td>
		<td>${a.senha}</td>
		<td><a href="alterarAlunoFormulario?id=${a.id}">ALTERAR</a></td>
		<td><a href="apagarAluno?id=${a.id}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>