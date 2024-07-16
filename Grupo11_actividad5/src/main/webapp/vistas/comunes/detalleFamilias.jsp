<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ familia.nombreFamilia }</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<h1>${ familia.nombreFamilia }</h1>
		<section class="default">
		
		<table class="default">
			<thead>
				<tr class="default">
					<th>Id Familia</th>
					<th>Nombre Familia</th>
					<th>Descripcion de la familia</th>
				</tr>
			</thead>
			<tbody>
				<tr class="default">
					<td>${ familia.idFamilia }</td>
					<td>${ familia.nombreFamilia }</td>
					<td>${ familia.descripcionFamilia }</td>
				</tr>
			</tbody>
		</table>
		</section>
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<a class="btn-link" href="/admin/editarFamilia${ familia.idFamilia }">Editar</a>
			<a class="btn-link" href="/admin/eliminarFamilia/${ familia.idFamilia }">Eliminar</a>
		</sec:authorize>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
