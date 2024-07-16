<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ rol.nombreRol }</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<section class="default">

		<table class="default">
			<thead>
				<tr class="default">
					<th>Id Rol</th>
					<th>Nombre Rol</th>
				</tr>
			</thead>
			<tbody>
				<tr class="default">
					<td>${ rol.idRol }</td>
					<td>${ rol.nombreRol }</td>
				</tr>
			</tbody>
		</table>
		</section>
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<a class="btn-link" href="/admin/eliminarRol/${ rol.idRol }">Eliminar</a>
			<a class="btn-link" href="/admin/editarRol/${ rol.idRol }">Editar</a>
		</sec:authorize>
		
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>