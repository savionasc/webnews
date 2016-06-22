<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/Tzeeter.css" />
<script type="text/javascript" src="resources/js/script.js"></script>
<title>Noticia</title>
</head>
<body>
	<div id="content">
		<div id="column_1" class="block">
			<div id="cover_usr">
				<div id="img_usr">
					<c:if test="${noticia.autor.imgEstado == false}">
					<img alt="Yuuki Makoto" height="64" width="64"  src="<c:url value="/resources/usr_imgs/${noticia.autor.imgEstado}.png" />" />
					</c:if>
					<c:if test="${noticia.autor.imgEstado == true}">
					<img alt="Yuuki Makoto" height="64" width="64"  src="<c:url value="/resources/usr_imgs/${noticia.autor.id}.png" />" />
					</c:if>
				</div>
			</div>
			<br /> <a class="nome_usr" name="nome_usuario" href="#nome_usuario">
				${administrador_logado.nome} </a> <br />
				<a class="perf_usr"	name="perfil_usuario" href="#perfil_usuario">
				@yuukimakotoofficial </a>

			<ul>
				<li><a href="#zeets" name="zeets"> Zeets 200 </a></li>
				<li><a href="#seguindo" name="seguindo"> Seguindo 50 </a></li>
				<li><a href="#seguidores" name="seguidores"> Seguidores 130
				</a></li>
			</ul>
		</div>
		<div id="column_2">
			<!-- Inicio da Noticia -->
			<p class="block">
				<a class="nome_usr" href="#seguindo_1" name="seguindo_1"> ${noticia.titulo} </a><br />
				<img alt="Takeba Yukari" height="300" src="<c:url value="/resources/images/${noticia.noticiaId}.png" />" />
				<a class="perf_usr" href="#perfil_seguindo_1" name="perfil_seguindo_1">	@MeuUsuario </a> <br />
				${noticia.texto}
			</p>
			<!-- Fim da Noticia -->

			<div id="tzeet">
				<form action="inserirComentario" method="get">
					<p class="block">
						<input type="hidden" name="idNoticia" value="${noticia.noticiaId}" />
						<input type="hidden" name="idUsuario" value="${usuario_logado.id}" />
						<textarea rows="5" cols="" name="texto"></textarea>
						<button id="submit">Enviar</button>
						<span id="count"> 140 </span>
					</p>
				</form>
			</div>
			<c:forEach var="c" items="${comentarios}">
				<form method="post" action="apagarComentario">
				<p class="block">
					<c:if test="${c.autor.imgEstado == false}">
					<img alt="Takeba Yukari" height="100" src="<c:url value="/resources/usr_imgs/${c.autor.imgEstado}.png"  />" />
					</c:if>
					<c:if test="${c.autor.imgEstado == true}">
					<img alt="Takeba Yukari" height="100" src="<c:url value="/resources/usr_imgs/${c.autor.id}.png"  />" />
					</c:if>
					 <a	class="nome_usr" href="#seguindo_1" name="seguindo_1">${c.autor.nome}${c.comentarioId}</a> 
					 <a class="perf_usr" href="#perfil_seguindo_1"	name="perfil_seguindo_1"> @${c.autor.email} </a> <br />
						${c.texto}
					<br />
					<input type="hidden" name="idUsuario" value="${usuario_logado.id}${administrador_logado.id}" />
					<input type="hidden" value="${c.comentarioId}" name="id"/>
					<c:if test="${(c.autor.id == usuario_logado.id)  || (noticia.autor.id == usuario_logado.id)}">
						<input id="apagar" type="submit" value="APAGAR COMENTARIO" style="margin-left: 375px; margin-bottom: 5px;" />
					</c:if>
				</p>
				</form>
				<script>count++;</script>
			</c:forEach>
		</div>
		<div id = "column_3">
			<div id="trends" class="block">
				<p>Seções</p>
				<ol>
					<c:forEach var="s" items="${secoes}">
						<li> <a href="#trending_${s.secaoId}" name="trending_${s.secaoId}"> ${s.titulo} </a> </li>	
					</c:forEach>
				</ol>
			</div>

			<p id="footnote" class="block">
				<a href="#copyright" name="copyright"> Todos os direitos resevados.</a>		
			    <a href="http://validator.w3.org/check?uri=referer"> <br /> <img src="resources/img/valid-xhtml10.png" alt="Valid XHTML 1.0 Strict" height="31" width="88" /></a> 
			    <a href="http://jigsaw.w3.org/css-validator/check/referer"> <img style="border:0;width:88px;height:31px" src="resources/img/vcss.gif" alt="CSS válido!" /></a>
			    <br />
			    Tzeeter &copy; 2016
			</p>
		</div>

	</div>
</body>
</html>