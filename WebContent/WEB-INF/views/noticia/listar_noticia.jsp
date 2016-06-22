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

Usuario logado: ${usuario_logado.nome}
<table border="1">
	<c:forEach var="n" items="${noticias}">
	<tr>
		<td>${n.noticiaId}</td>
		<td>${n.titulo}</td>
		<td>${n.texto}</td>
		<td><img alt="${n.titulo}" src="<c:url value="/resources/images/${n.noticiaId}.png"  />" /></td>
		<td><a href="alterarNoticiaFormulario?id=${n.noticiaId}">ALTERAR</a></td>
		<td><a href="inserirComentarioFormulario?id=${n.noticiaId}">COMENTAR</a></td>
		<td><a href="listarComentarios?id=${n.noticiaId}">Ver Comentarios</a></td>
		<td><a href="apagarNoticia?id=${n.noticiaId}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>