<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>
 <%
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("your_private_key");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {
          out.print("Answer was entered correctly!");
        } else {
          out.print("Answer is wrong");
        }
%>
	<input id="tipo" type="hidden" value="${Tipo}" />
	<h2>Menu, Bem-vindo ${usuario_logado.nome} </h2>
	<a href="helloSpring"> Hello Spring! </a> <br />

	<a href="inserirAlunoFormulario"> Inserir Aluno </a> <br />

	<a href="listarAluno">Listar Alunos</a> <br />

	<a id="1" href="inserirUsuarioFormulario"> Inserir Usuario </a> <br />

	<a id="2" href="listarUsuario">Listar Usuarios</a> <br />
	
	<a id="3" href="inserirNoticiaFormulario"> Inserir Noticia </a> <br />
	
	<a id="4" href="listarNoticia">Listar Noticias</a> <br />
	
	<a id="5" href="inserirPapelFormulario"> Inserir Papel dos usuarios</a> <br />
	
	<a id="6" href="inserirSecaoFormulario"> Inserir Seção</a> <br />
	
	<a id="7" href="inserirComentarioFormulario"> Inserir Comentario</a> <br />
	
	<a id="8" href="inserirClassificadoFormulario"> Inserir Classificado</a> <br />
		
		
		
	<a href="logout">Logout</a>
	
<!-- 	Usuario logado: ${usuario_logado.nome}
<table border="0">
	<c:forEach var="a" items="${noticias}">
	<tr>
		<td>${a.titulo}</td>
		<td>${a.texto}</td> 
	</tr>
	</c:forEach>
	</table>-->
<script type= text/javascript>
//function recuperarTipo() {
	//var x = document.getElementById("nome").innerHTML;
	var x = document.getElementById("tipo").value;
	if(x == 1){
		document.getElementById("1").innerHTML = "";
		document.getElementById("2").innerHTML = "";
		document.getElementById("5").innerHTML = "";
		document.getElementById("6").innerHTML = "";
		document.getElementById("8").innerHTML = "";
		document.getElementById("3").innerHTML = "";
	}else if(x==2){
		document.getElementById("1").innerHTML = "";
		document.getElementById("2").innerHTML = "";
		document.getElementById("5").innerHTML = "";
		document.getElementById("6").innerHTML = "";
		document.getElementById("7").innerHTML = "";
		document.getElementById("8").innerHTML = "";
	}
	else if(x==3){
		document.getElementById("1").innerHTML = "";
		document.getElementById("2").innerHTML = "";
		document.getElementById("3").innerHTML = "";
		document.getElementById("5").innerHTML = "";
		document.getElementById("7").innerHTML = "";
		
	}
	//document.getElementById("formulario").action = x;
//}
</script>
</body>
</html>