<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Noticia</title>
</head>
<body>
<h2>Alterar Noticia</h2>
<script>var mydate=new Date();
alert(mydate.getHours()+":"+mydate.getMinutes()+" - "+mydate.getDate()+"/"+mydate.getMonth()+"/"+mydate.getFullYear());
</script>
<form action="alterarNoticia" method="post">
	<input type="hidden" name="noticiaId" value="${noticia.noticiaId}" />
	<input type="hidden" name="idAutor" value="${noticia.autor.id}" />
	Titulo: <input type="text" name="titulo" value="${noticia.titulo}" /><br />
	<textarea rows="" cols="" name="texto">${noticia.texto}</textarea>
	Seção:  
			<select name="seccao">
				<c:forEach var="s" items="${secoes}">
				<option value="${s.secaoId}">${s.titulo}</option>
				</c:forEach>
			</select>
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>