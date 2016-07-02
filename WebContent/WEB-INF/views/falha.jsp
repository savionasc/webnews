<%@page import="javax.xml.ws.Response"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <meta name="description" content="Tem de Tudo">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/bootstrap-responsive.css">
        <link rel="stylesheet" href="resources/css/style.css">

        <script src="resources/js/jquery-1.10.1.min.js"></script>
        <script src="resources/js/bootstrap.js"></script>

        <title><fmt:message key="falha.titulo"/></title>
    </head>
<body>


<div class="modal" id="myModal">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"></button>
    <h5><i class="icon-exclamation-sign"></i><fmt:message key="falha.titulo"/></h5>
  </div>
  <div class="modal-body">
    <p><fmt:message key="falha.texto"/></p>
  </div>
  <div class="modal-footer">
    
    <a href="loginFormulario" class="btn btn-primary"><fmt:message key="falha.botao"/></a>
  </div>
</div>


</body>
</html>