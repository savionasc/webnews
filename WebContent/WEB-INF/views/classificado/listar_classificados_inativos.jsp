<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><fmt:message key="listar.classificadoI.titulo"/></title>
	<!-- thumbnail -->
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="resources/thumbnail/bootstrap.min.css">
  	<script src="resources/thumbnail/jquery.min.js"></script>
  	<script src="resources/thumbnail/bootstrap.min.js"></script>
  
  	<!-- fim -->
</head>
<body>


	<!-- Menu -->

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="login"><fmt:message
							key="menu.campo.inicio" /> <span class="sr-only">(current)</span></a></li>
				<li><a href="inserirUsuarioFormulario"><fmt:message
							key="menu.campo.inserirUsuario" /></a></li>
				<li><a href="listarNoticia?l=<fmt:message key="local"/>"><fmt:message
							key="menu.campo.listarNoticia" /></a></li>
				<li><a href="verFavoritos?u=${usuario_logado.id}"><fmt:message
							key="menu.campo.verFavoritos" /></a></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><fmt:message
							key="menu.campo.Classificados" /> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="listarClassificados"><fmt:message
									key="menu.campo.listarClassificados" /></a></li>
						<li><a href="inserirClassificadoFormulario"><fmt:message
									key="menu.campo.inserirClassificado" /></a></li>
					</ul></li>

				<c:forEach var="t" items="${listaTipos}">
					<c:if test="${t.id == 2}">

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Jornalista <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="inserirNoticiaFormulario"><fmt:message
											key="menu.campo.inserirNoticia" /></a></li>
								<li><a href="listarSecoes"><fmt:message
											key="menu.campo.listarSecoes" /></a></li>
							</ul></li>

					</c:if>
				</c:forEach>

			</ul>
			<form class="navbar-form navbar-left" role="search" method="post"
				action="buscarNoticias">
				<div class="form-group">
					<input type="text" class="form-control" name="texto"
						placeholder="<fmt:message key="menu.campo.listarNoticia"/>">
				</div>
				<button type="submit" class="btn btn-default">
					<fmt:message key="campo.pesquisar" />
				</button>
			</form>


			<ul class="nav navbar-nav navbar-right">
				<c:forEach var="t" items="${listaTipos}">
					<c:if test="${t.id == 3}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Editor <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="inserirSecaoFormulario"><fmt:message
											key="menu.campo.inserirSecao" /></a></li>
								<li><a href="listarUsuario"><fmt:message
											key="menu.campo.listarUsuario" /></a></li>
								<li class="active"><a href="listarClassificadosInativos"><fmt:message
											key="menu.campo.listarClassificadosInativos" /></a></li>
								<li><a href="inserirPapelFormulario"><fmt:message
											key="menu.campo.inserirPapel" /></a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Cadastrar Jornalista</a></li>
							</ul></li>
					</c:if>
				</c:forEach>
				<li><a href="listarNotificacoes"><fmt:message key="menu.campo.notificacoes"/> <span class="badge">${notificacoes}</span></a></li>
				<li><a href="logout"> <fmt:message key="campo.logout" /></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<!-- Fim de menu -->


<fmt:message key="campo.usuario.logado"/>${usuario_logado.nome}<br />
<h4><fmt:message key="listar.classificadoI.titulo"/></h4>
<table border="1">
	<c:forEach var="c" items="${classificados}">
	<c:if test="${c.ativo == false}">
	<tr>
		<td>${c.id}</td>
		<td>${c.titulo}</td>
		<td>${c.texto}</td>
		<td><a href="alterarUsuarioFormulario?id=${c.id}">ALTERAR</a></td>
		<td><a href="ativarClassificado?id=${c.id}">ATIVAR</a></td>
		<td><a href="apagarClassificado?id=${c.id}">APAGAR</a></td>
	</tr>
	</c:if>
	</c:forEach>
</table>

</body>
</html>