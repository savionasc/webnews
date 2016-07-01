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
	
	<title><fmt:message key="menu.titulo"/></title>
</head>
<body>
<h2><fmt:message key="menu.mensagem"/>${usuario_logado.nome} </h2>
	<form style="margin-top: -40px; margin-left: 900px;" method="post" action="buscarNoticias">
		<input type="text" name="texto" onfocus="this.value = '';" onblur="if(this.value == '') this.value = 'Noticias';" value="Noticias"/>
		<input type="submit" value="Botao"/>
	</form>	
	
	<a href="inserirUsuarioFormulario"><fmt:message key="menu.campo.inserirUsuario"/></a> <br />
	<a href="listarNoticia"><fmt:message key="menu.campo.listarNoticia"/></a> <br />
	<a href="listarClassificados"><fmt:message key="menu.campo.listarClassificados"/></a> <br />	
	<a href="buscarFormularioNoticias"><fmt:message key="menu.campo.buscarNoticias"/></a><br />
	<a href="inserirClassificadoFormulario"><fmt:message key="menu.campo.inserirClassificado"/></a> <br />
	<a href="verFavoritos"><fmt:message key="menu.campo.verFavoritos"/></a> <br />
	Usuarios

	<c:forEach var="t" items="${listaTipos}">
		<hr>
		<c:if test="${t.id == 2}">
			<a href="inserirNoticiaFormulario"><fmt:message key="menu.campo.inserirNoticia"/></a> <br />
			<a href="listarSecoes"><fmt:message key="menu.campo.listarSecoes"/></a> <br />	
			jornalista
		</c:if>
		<c:if test="${t.id == 3}">
			Cadastrar Jornalista<br />
			<a href="inserirSecaoFormulario"><fmt:message key="menu.campo.inserirSecao"/></a> <br />
			<a href="listarUsuario"><fmt:message key="menu.campo.listarUsuario"/></a> <br />
			<a href="listarClassificadosInativos"><fmt:message key="menu.campo.listarClassificadosInativos"/></a><br />	
			<a href="inserirPapelFormulario"><fmt:message key="menu.campo.inserirPapel"/></a> <br />
			Editor
		</c:if>
	
	</c:forEach>

	<br />
	<a href="logout"> <fmt:message key="campo.logout"/></a>
	
	<hr><br />

	<div class="container">
	  <h2><fmt:message key="menu.thumb.titulo"/></h2>
	  <p><fmt:message key="menu.thumb.subtitulo"/></p>
	  <div class="row">
		<c:forEach var="a" items="${noticias}">
		<div class="col-md-4">
		<form action="adicionarFavorito" method="post">
			  <input type="hidden" value="${a.noticiaId}" name="noticia" />
			  <input type="hidden" value="${usuario_logado.id}" name="usuario" />
			  <a style="margin-left: 200px;" href="javascript:;" onclick="parentNode.submit();"><fmt:message key="menu.thumb.addfavorito"/></a>
		  </form>
	      <a href="listarComentarios?id=${a.noticiaId}" class="thumbnail">
	        <p>${a.titulo}</p>
	        <img src="<c:url value="/resources/images/${a.noticiaId}.png" />" alt="Pulpit Rock" style="width:150px;height:150px">
	      </a>
	    </div>
	    </c:forEach>
	  </div>
	</div>
</body>
</html>