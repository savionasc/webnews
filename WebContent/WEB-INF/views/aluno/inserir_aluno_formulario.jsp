<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Aluno</title>
</head>
<body>
	
	<form action="inserir.jsp" method="post">
		Nome: <input type="text" name="nome" />
		<form:errors path="aluno.nome" /> 
		<br />
		IRA: <input type="text" name="IRA" /> <br />
		Login: <input type="text" name="login" /> <br />
		Senha: <input type="text" name="senha" /> <br />
		
		<%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LekLCETAAAAAGMlBkeQoo3mtsg89gUIWKrAm8bP", "6LekLCETAAAAAOt_8ioQ3-GuJxPyBvyenR1HpE3N", false);
          out.print(c.createRecaptchaHtml(null, null));
        %>
		<input type="submit" value="ENVIAR" />
		
	</form>

</body>
</html>