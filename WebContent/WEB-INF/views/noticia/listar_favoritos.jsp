<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Listar Usuario</title>

</head>
<body>

Usuario logado: ${usuario_logado.nome}

<div class="container">
	  <h2>Meus Favoritos</h2>
	  <p>Lista de favoritos	:</p>
	  <div class="row">
		<c:forEach var="f" items="${favoritos}">
		<div class="col-md-4">
		<form action="removerFavorito?id=${f.id}" method="post">
			  <input type="hidden" value="${f.noticia.noticiaId}" name="noticia" />
			  <input type="hidden" value="${usuario_logado.id}" name="usuario" />
			  <a style="margin-left: 200px;" href="javascript:;" onclick="parentNode.submit();">Remover dos favoritos</a>
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