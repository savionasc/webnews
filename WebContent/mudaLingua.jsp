<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Refresh" content="3;url=linguas.jsp">
<title>Idioma alterado</title>
</head>
<body>
<c:if test="${not empty param.lingua}">
  <fmt:setLocale value="${param.lingua}" scope="session"/>
  Language changed. Please, wait 3 seconds.
</c:if>
</body>
</html>