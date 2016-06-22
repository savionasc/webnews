<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Aluno</title>
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
Titulo:<input type="text" name="titulo" >
preco:<input type="text" name="preco" >
texto:<input type="text" name="texto" >
	
<input type="submit" value="Cadastrar" />
</form>

</body>
</html>