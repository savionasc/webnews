<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jornal</title>

 	<script type="text/javascript">
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

 <form id="frmAcesso" name="frmAcesso" method="post" action="ValidaAcessoServlet">

 	Usu&aacute;rio:<input type="text" id="txtUsuario" name="txtUsuario" />
 	<br />
 	Senha:<input type="password" id="txtSenha" name="txtSenha" />
 	<br />
 	<br />
 	<c:out value="${requestScope.reCapchaChallenge}" escapeXml="false" />
 	<br />
 	<input type="submit" id="btAcessar" name="btAcessar" value="ACESSAR!" />

 </form>
</body>
</html>