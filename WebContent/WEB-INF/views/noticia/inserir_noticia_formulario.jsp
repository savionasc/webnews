<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Noticia</title>
</head>
<body>
	
	<form action="inserirNoticia" method="post" enctype="multipart/form-data">
		 <input type="hidden" value="${usuario_logado.id}${administrador_logado.id}" name="usuario" />
		<fmt:message key="campo.titulo"/> <input type="text" name="titulo" />
		<br />
		<fmt:message key="campo.secao"/> <select name="secaoValores" onblur="">
		<c:forEach var="s" items="${secoes}">
			<option value="${s.secaoId}">${s.titulo}</option>
		
		</c:forEach>
		</select><br /> 
		<fmt:message key="campo.texto"/> <input type="text" name="texto" /> <br />
		<fmt:message key="campo.imagem"/> <input type="file" name="imagem" /><br />		
		<input type="submit" value="<fmt:message key="botao.enviar"/>" />
		
	</form>

</body>
</html>