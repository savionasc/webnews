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

<form action="alterarAluno" method="post">
	<input type="hidden" name="id" value="${aluno.id}" />
	Nome: <input type="text" name="nome" value="${aluno.nome}" /><br />
	IRA: <input type="text" name="IRA" value="${aluno.IRA}" /><br />
	Login: <input type="text" name="login" value="${aluno.login}" /> <br />
	Senha: <input type="text" name="senha" value="${aluno.senha}" /> <br />
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>