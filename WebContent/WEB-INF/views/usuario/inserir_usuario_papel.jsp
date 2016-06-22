<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario Papel</title>
</head>
<body>
	
	<form action="inserirUsuario" method="post" enctype="multipart/form-data">
		Nome: <input type="text" name="nome" />
		<br />
		<!-- IRA: <input type="text" name="IRA" /> <br /> -->
		<input type="hidden" value="1" name="papel" />
		<!-- Papel:  
			<select name="papel">
				<c:forEach var="a" items="${papeis}">
				<option value="${a.id}">${a.papel}</option>
				</c:forEach>
			</select>
			-->
		Email: <input type="text" name="email" /><br />
		Imagem: <input type="file" name="imagem" /><br />
		Login: <input type="text" name="login" /> <br />
		Senha: <input type="text" name="senha" /> <br />
		<input type="submit" value="ENVIAR" />
		
	</form>


</body>
</html>