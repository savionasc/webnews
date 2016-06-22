<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Usuario</title>
</head>
<script>var count = 0;</script>
<body>

Aluno logado: ${aluno_logado.nome}${administrador_logado.nome}
<br /><h2>${noticia.titulo}</h2>
<div style="width: 500px;"><h4>${noticia.texto}</h4></div>
<b>Comentarios:</b>
<table border="1">
	<c:forEach var="c" items="${comentarios}">
	<tr>
		<td>Id do comentario:${c.comentarioId	}</td>
		<td><b>${c.texto}</b></td>
		<td>Usuario: ${c.autor.nome}</td>
		<td><a href="apagarComentario?id=${c.comentarioId}">APAGAR</a></td>
	</tr>
	<script>count++;</script>
	</c:forEach>
</table>

	<p id="mensagemComentarios">Comentarios.</p>
<script>if(count == 0){
	document.getElementById("mensagemComentarios").innerHTML = "Ainda não há comentarios";
}</script>
</body>
</html>