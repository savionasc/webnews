<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><fmt:message key="site.titulo"/></title>
</head>
<body>
  <h1><fmt:message key="site.titulo"/></h1>
  <p><fmt:message key="saudacao"/></p>
 
  <form>
    <fmt:message key="campo.nome"/>
    <input type="text" name="nome" /><br/>
 
    <fmt:message key="campo.email"/>
    <input type="text" name="email" /><br/>
 
    <fmt:message key="campo.rua"/>
    <input type="text" name="rua" /><br/>
 
    <fmt:message key="campo.cidade"/>
    <input type="text" name="cidade" />
    <p><input type="submit"
              value='<fmt:message key="botao.enviar"/>'></p>
  </form>
  
  <br />
  <p>Mudar Idioma</p>
  <a href="mudaLingua.jsp?lingua=de_DE">Deutsch</a>
  <a href="mudaLingua.jsp?lingua=en_US">English</a>
  <a href="mudaLingua.jsp?lingua=pt_BR">Português</a>
</body>
</html>