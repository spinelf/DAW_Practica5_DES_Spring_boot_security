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
	</head>
	<body>
	<jsp:include page="../menu.jsp"></jsp:include>
		<table>
			<thead>
				<tr>
				<th>ID usuario</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Email</th>
				<th>Fecha de nacimiento</th>
				<th>Enabled</th>
				<th>Rol</th>
				<th colspan="10">Opciones</th>
				
				</tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listaUsuarios }">
					<tr>
						
						<td>${ ele.idUsuario }</td>
						<td>${ ele.nombreUsuario }</td>
						<td>${ ele.apellidosUsuario }</td>
						<td>${ ele.emailUsuario }</td>
						<td>${ ele.fechaNacimiento }</td>
						<td>${ ele.enabled }</td>
						<td>${ ele.role.getNombreRol() }</td>
						
						
						<sec:authorize access="hasAuthority('ROLE_ADMIN')">
							<td><a href="/admin/eliminarUsuario/${ ele.idUsuario }">Eliminar</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="default">
					<sec:authorize access="hasAuthority('ROLE_ADMIN')">
						<a class="btn-link" href="/admin/altaUsuarioAdmin">Crear Usuario Administrador</a>
					</sec:authorize>
			</table>
	</body>
</html>