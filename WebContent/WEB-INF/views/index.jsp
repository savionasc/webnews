<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  	
	<title><fmt:message key="index.titulo"/></title>
</head>
<body>

<a href="loginFormulario"> <fmt:message key="index.login"/></a> |
<a href="irJornal"> <fmt:message key="index.jornal"/></a>

<br/>
<hr>
<a href="inserirUsuarioFormulario"> <fmt:message key="index.cadastro"/></a> <br />
<c:forEach items="${cookie}" var="currentCookie">  
	<c:if test="${(currentCookie.value.name == 'Orbita') && (currentCookie.value.value != '')}">
	Cookie name as map entry key: ${currentCookie.key}<br/>
    Cookie object as map entry value: ${currentCookie.value}<br/>
    Name property of Cookie object: ${currentCookie.value.name}<br/>
    Value property of Cookie object: ${currentCookie.value.value}<br/>
	</c:if>
    
</c:forEach>
	<br />	
	<div class="container">
	  <c:if test="${noticias1 != null}">
	  <h2><fmt:message key="index.titulo.esportes"/></h2>
	  <p><fmt:message key="index.subtitulo.noticias"/></p>
	  <div class="row">
		<c:forEach var="a" items="${noticias1}">
		<div class="col-md-4">
	      <a href="listarComentarios?id=${a.noticiaId}" class="thumbnail">
	        <p>${a.titulo}</p>
	        <img src="<c:url value="/resources/images/${a.noticiaId}.png" />" alt="Pulpit Rock" style="width:150px;height:150px">
	      </a>
	    </div>
	    </c:forEach>
	  </div>
	  </c:if>
	  
	  <c:if test="${noticias2 != null}">
	  <h2><fmt:message key="index.titulo.culinaria"/></h2>
	  <p><fmt:message key="index.subtitulo.noticias"/></p>
	  <div class="row">
		<c:forEach var="a" items="${noticias2}">
		<div class="col-md-4">
	      <a href="listarComentarios?id=${a.noticiaId}" class="thumbnail">
	        <p>${a.titulo}</p>
	        <img src="<c:url value="/resources/images/${a.noticiaId}.png" />" alt="Pulpit Rock" style="width:150px;height:150px">
	      </a>
	    </div>
	    </c:forEach>
	  </div>
	  </c:if>
	  
	  <c:if test="${noticias3 != null}">
	  <h2><fmt:message key="index.titulo.politica"/></h2>
	  <p><fmt:message key="index.subtitulo.noticias"/></p>
	  <div class="row">
		<c:forEach var="a" items="${noticias3}">
		<div class="col-md-4">
	      <a href="listarComentarios?id=${a.noticiaId}" class="thumbnail">
	        <p>${a.titulo}</p>
	        <img src="<c:url value="/resources/images/${a.noticiaId}.png" />" alt="Pulpit Rock" style="width:150px;height:150px">
	      </a>
	    </div>
	    </c:forEach>
	  </div>
	  
	  </c:if>
	  <c:if test="${noticias != null}">
	  <h2><fmt:message key="index.titulo.noticias"/></h2>
	  <p><fmt:message key="index.subtitulo.noticias"/></p>
	  <div class="row">
		<c:forEach var="a" items="${noticias}">
		<div class="col-md-4">
	      <a href="listarComentarios?id=${a.noticiaId}" class="thumbnail">
	        <p>${a.titulo}</p>
	        <img src="<c:url value="/resources/images/${a.noticiaId}.png" />" alt="Pulpit Rock" style="width:150px;height:150px">
	      </a>
	    </div>
	    </c:forEach>
	  </div>
	  </c:if>
	
	</div>
	
	
	<div class="jumbotron">
	  <p>Mudar Idioma</p>
  <a href="mudaLingua.jsp?lingua=de_DE">Deutsch</a>
  <a href="mudaLingua.jsp?lingua=en_US">English</a>
  <a href="mudaLingua.jsp?lingua=pt_BR">Português</a>
	  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
	</div>
	
	
</body>
</html>