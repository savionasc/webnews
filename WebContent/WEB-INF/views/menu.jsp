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
<h2>Menu, Bem-vindo ${usuario_logado.nome} </h2>
	<form style="margin-top: -40px; margin-left: 900px;" method="post" action="buscarNoticias">
		<input type="text" name="texto" onfocus="this.value = '';" onblur="if(this.value == '') this.value = 'Noticias';" value="Noticias"/>
		<input type="submit" value="Botao"/>
	</form>
	<a href="helloSpring"> Hello Spring! </a> <br />

	<a href="inserirAlunoFormulario"> Inserir Aluno </a> <br />

	<a href="listarAluno">Listar Alunos</a> <br />
	Alunos
	
	<hr>	
	
	<a href="inserirUsuarioFormulario"> Inserir Usuario </a> <br />
	<a href="listarNoticia">Listar Noticias</a> <br />
	<a href="listarClassificados">Listar Classificado</a> <br />	
	<a href="buscarFormularioNoticias">Pesquisar noticias</a><br />
	<a href="inserirClassificadoFormulario"> Inserir Classificado</a> <br />
	Usuarios

	<c:forEach var="t" items="${listaTipos}">
		<hr>
		<c:if test="${t.id == 2 || t.id == 4}">
			<a href="inserirNoticiaFormulario"> Inserir Noticia </a> <br />
			<a href="listarSecoes">Listar Seções</a> <br />	
			jornalista
		</c:if>
		<c:if test="${t.id == 3 || t.id == 4}">
			Cadastrar Jornalista<br />
			<a href="inserirSecaoFormulario"> Inserir Seção</a> <br />
			<a href="listarUsuario">Listar Usuarios</a> <br />
			<a href="listarClassificadosInativos">Listar Classificados Inativos</a> <br />	
			<a href="inserirPapelFormulario"> Inserir Papel dos usuarios</a> <br />
			Editor
		</c:if>
	
	</c:forEach>

	<br />
	<a href="logout">Logout</a>
	
	<hr><br />

	<table border="1">
		<tr> <th colspan="2"><font color="red">Noticias</font></th> </tr>
		<tr> <th>Titulo</th><th>Conteudo</th> </tr>
		<c:forEach var="a" items="${noticias}">
		<tr>
			<td>${a.titulo}</td>
			<td>${a.texto}</td> 
		</tr>
		</c:forEach>
	</table>
</body>
</html>