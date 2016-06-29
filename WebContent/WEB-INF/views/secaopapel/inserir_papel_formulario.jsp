<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="inserir.papel.titulo"/></title>
</head>
<body>
	<h2><fmt:message key="inserir.papel.tituloH2"/></h2><br />
	<form action="inserirPapel" method="post">
		<fmt:message key="campo.nome"/><input type="text" name="papel" />
		<form:errors path="aluno.nome" /> 
		<br />
		<input type="submit" value="<fmt:message key="botao.enviar"/>" />
		
	</form>

</body>
</html>