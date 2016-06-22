<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Seção</title>
</head>
<body>
	<h2>Inserir Seção</h2><br />
	<form action="inserirSecao" method="post">
		Titulo: <input type="text" name="titulo" />
		<form:errors path="aluno.nome" /> 
		<br />
		Descrição:<textarea name="descricao"></textarea> <br />
		<input type="submit" value="ENVIAR" />
		
	</form>

</body>
</html>