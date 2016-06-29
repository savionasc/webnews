<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- thumbnail -->
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="resources/thumbnail/bootstrap.min.css">
  	<script src="resources/thumbnail/jquery.min.js"></script>
  	<script src="resources/thumbnail/bootstrap.min.js"></script>
  
  	<!-- fim -->
<title><fmt:message key="menu.campo.verFavoritos"/></title>

</head>
<body>

<fmt:message key="menu.mensagem"/> ${usuario_logado.nome}

<div class="container">
	  <h2><fmt:message key="favoritos.titulo"/></h2>
	  <p><fmt:message key="favoritos.subtitulo"/></p>
	  <div class="row">
		<c:forEach var="f" items="${favoritos}">
		<div class="col-md-4">
		<form action="removerFavorito?id=${f.id}" method="post">
			  <input type="hidden" value="${f.noticia.noticiaId}" name="noticia" />
			  <input type="hidden" value="${usuario_logado.id}" name="usuario" />
			  <a style="margin-left: 200px;" href="javascript:;" onclick="parentNode.submit();"><fmt:message key="favoritos.remover"/></a>
		  </form>
	      <a href="listarComentarios?id=${f.noticia.noticiaId}" class="thumbnail">
	        <p>${f.noticia.titulo}</p>
	        <img src="<c:url value="/resources/images/${f.noticia.noticiaId}.png" />" alt="Pulpit Rock" style="width:150px;height:150px">
	      </a>
	    </div>
	    </c:forEach>
	  </div>
	</div>
</body>
</html>