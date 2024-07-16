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
				<th>Nombre Familia</th>
				<th>Descripción Familia</th>
				<th colspan="10">Opciones</th>
				</tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listaFamilias }">
					<tr>
						
						<td>${ ele.nombreFamilia }</td>
						<td>${ ele.descripcionFamilia }</td>
						
						<sec:authorize access="hasAnyAuthority('ROLE_ADMIN','ROLE_USUARIO')">
							<td><a href="/user/productosFamilia/${ ele.idFamilia }">Filtrar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('ROLE_ADMIN')">
							<td><a href="/admin/editarFamilia/${ ele.idFamilia }">Editar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('ROLE_ADMIN')">
							<td><a href="/admin/eliminarFamilia/${ ele.idFamilia }">Eliminar</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			<table class="default">
					<sec:authorize access="hasAuthority('ROLE_ADMIN')">
						<a class="btn-link" href="/admin/altaFamilia">Crear Familia</a>
					</sec:authorize>
			</table>
		
	</body>
</html>