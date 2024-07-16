<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/mensaje.css' />" rel="stylesheet">
	</head>
	<body>
	<jsp:include page="../menu.jsp"></jsp:include>
				<h2 class="mensaje-exito">${ mensajeExito }</h2>
				<h2 class="mensaje-error">${ mensajeError }</h2>
		<table class="default">
					<sec:authorize access="hasAuthority('ROLE_ADMIN')">
						<a class="btn-link" href="/user/productos">Volver</a>
					</sec:authorize>
			</table>
		
		
	</body>
</html>