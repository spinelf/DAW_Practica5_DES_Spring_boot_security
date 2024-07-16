<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Direccion</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<h1> Mis direcciones</h1>
		<section class="default">
		
		<table class="default">
			<thead>
				<tr class="default">
					<th>Calle</th>
					<th>numero</th>
					<th>piso</th>
					<th>letra</th>
					<th>Localidad</th>
					<th>C.P.</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="ele" items="${ listaDirecciones }">
				<tr class="default">
					<td>${ ele.calle }</td>
					<td>${ ele.numero }</td>
					<td>${ ele.piso }</td>
					<td>${ ele.letra }</td>
					<td>${ ele.localidad }</td>
					<td>${ ele.cp }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</section>
		<sec:authorize access="hasAuthority('ROLE_USUARIO')">
			<a class="btn-link" href="/user/misDatos">Mis Datos</a>
		</sec:authorize>

		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
