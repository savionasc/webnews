<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Início</title>
</head>
<body>
<a href="loginFormulario"> Administração</a> |
<a href="irJornal"> Ir para jornal</a>

<br/>
<hr>
<a href="inserirUsuarioFormulario"> Cadastre-se </a> <br />
<c:forEach items="${cookie}" var="currentCookie">  
	<c:if test="${(currentCookie.value.name == 'Orbita') && (currentCookie.value.value != '')}">
	Cookie name as map entry key: ${currentCookie.key}<br/>
    Cookie object as map entry value: ${currentCookie.value}<br/>
    Name property of Cookie object: ${currentCookie.value.name}<br/>
    Value property of Cookie object: ${currentCookie.value.value}<br/>
    <c:redirect url="login"/>
	</c:if>
    
</c:forEach>
	<br />Esportes <br />
	Classificados <br />
	Novidades <br />
	Moda <br />
	Politica <br />
	Variedades <br />
	
</body>
</html>