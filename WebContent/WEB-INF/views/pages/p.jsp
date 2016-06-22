<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jornal</title>

<!--  --> 	<script type="text/javascript">
 		var RecaptchaOptions = {
 			theme : 'white',
 			lang : 'pt',
 			custom_translations : {
 		instructions_visual : "Por favor, digite as palavras:"
 		}
 	};
 	</script>
</head>
<body>
<h3>Exemplo utilizando reCAPTCHA</h3>

 <form id="frmAcesso" name="frmAcesso" method="post" action="hup">

 	Usu&aacute;rio:<input type="text" id="txtUsuario" name="txtUsuario" />
 	<br />
 	Senha:<input type="password" id="txtSenha" name="txtSenha" />
 	<br />
 	<br />
 	<c:out value="${reCapchaChallenge}" escapeXml="false" ></c:out>
 	<br />
 	<%ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LekLCETAAAAAGMlBkeQoo3mtsg89gUIWKrAm8bP", "6LekLCETAAAAAOt_8ioQ3-GuJxPyBvyenR1HpE3N", false);
 	out.print(c.createRecaptchaHtml(null, null));%>
    ${erro}    
 	<input type="submit" id="btAcessar" name="btAcessar" value="ACESSAR!" />

</form>
</body>
</html>