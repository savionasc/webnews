<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Aluno</title>
</head>
<body>

<h2>Alterar Aluno</h2>

<form action="alterarUsuario" method="post">
	<input type="hidden" name="id" value="${usuario.id}" />
	Nome: <input type="text" name="nome" value="${usuario.nome}" /><br />
	Papel:  
			<select name="papel">
				<c:forEach var="a" items="${papeis}">
				<option value="${a.id}">${a.papel}</option>
				</c:forEach>
			</select>
	Email: <input type="text" name="email" value="${usuario.email}" /> <br />
	Login: <input type="text" name="login" value="${usuario.login}" /> <br />
	Senha: <input type="text" name="senha" value="${usuario.senha}" /> <br />
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>