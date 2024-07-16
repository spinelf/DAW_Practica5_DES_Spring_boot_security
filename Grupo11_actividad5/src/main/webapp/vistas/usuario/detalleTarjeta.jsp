<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> tarjeta</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<h1> Mis tarjetas</h1>
		<section class="default">
		
		<table class="default">
			<thead>
				<tr class="default">
					<th>Número tarjeta</th>
					<th>Titular</th>
					<th>Mes caducidad</th>
					<th>Año caducidad</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="ele" items="${ listaTarjetas }">
				<tr class="default">
					<td>${ ele.numeroTarjeta }</td>
					<td>${ ele.nombreTitular }</td>
					<td>${ ele.mesCaducidad }</td>
					<td>${ ele.annoCaducidad }</td>
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
