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

<!-- Menu -->

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
	
	    <li><a href="login"><fmt:message key="menu.campo.inicio"/></a></li>
        <li><a href="inserirUsuarioFormulario"><fmt:message key="menu.campo.inserirUsuario"/></a></li>
        <li><a href="listarNoticia?l=<fmt:message key="local"/>"><fmt:message key="menu.campo.listarNoticia"/></a> </li>
        <li class="active"><a href="verFavoritos?u=${usuario_logado.id}"><fmt:message key="menu.campo.verFavoritos"/></a></li>
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="menu.campo.Classificados"/> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="listarClassificados"><fmt:message key="menu.campo.listarClassificados"/></a></li>
            <li><a href="inserirClassificadoFormulario"><fmt:message key="menu.campo.inserirClassificado"/></a> </li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search" method="post" action="buscarNoticias">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"> <fmt:message key="campo.logout"/></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<!-- Fim de menu -->



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