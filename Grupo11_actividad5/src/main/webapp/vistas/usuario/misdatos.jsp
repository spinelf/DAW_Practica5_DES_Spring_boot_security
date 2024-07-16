<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ usuario.nombreUsuario}</title>
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
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>E-mail</th>
					<th>Fecha de nacimiento</th>
					<th>Activo</th>
					<th>Rol</th>
				</tr>
			</thead>
			<tbody>
				<tr class="default">
					<td>${ usuario.nombreUsuario }</td>
					<td>${ usuario.apellidosUsuario }</td>
					<td>${ usuario.emailUsuario }</td>
					<td>${ usuario.fechaNacimiento }</td>
					<td>${ usuario.enabled }</td>
					<td>${ usuario.role.getNombreRol() }</td>
				</tr>
			</tbody>
		</table>
		</section>
		<sec:authorize access="hasAuthority('ROLE_USUARIO')">
			<a class="btn-link" href="/user/editarUsuario/${ usuario.idUsuario }">Editar</a>
			<a class="btn-link" href="/user/altaTarjeta/">Alta Tarjeta</a>
			<a class="btn-link" href="/user/altaDireccion/">Alta Dirección</a>
			<a class="btn-link" href="/user/misTarjetas/">Mis Tarjetas</a>
			<a class="btn-link" href="/user/misDirecciones/">Mis direcciones</a>
		</sec:authorize>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>