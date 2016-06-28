<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Classificado</title>
<script type="text/javascript">
var now = new Date();
var dia = now.getDate() ;
var mes = now.getMonth() + 1; 
var ano = now.getYear();
var aa = dia+"/"+mes+"/"+ano;
document.getElementsByName("date").value=aa;
</script>
</head>
<body>

<form action="inserirClassifcado" method="POST">
<input type="hidden" name="data" />
<input type="hidden" name="idUsuario" value="${usuario_logado.id}${administrador_logado.id}" />
<fmt:message key="campo.titulo"/><input type="text" name="titulo" >
<fmt:message key="campo.preco"/><input type="text" name="preco" >
<fmt:message key="campo.texto"/><input type="text" name="texto" >
	
<input type="submit" value="<fmt:message key="botao.cadastrar"/>" />
</form>

</body>
</html>