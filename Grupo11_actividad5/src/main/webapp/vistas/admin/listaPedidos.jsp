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
				<th>Id Pedido</th>
				<th>Estado Pedido</th>
				<th>Fecha Pedido</th>
				<th>Usuario Pedido</th>
				<th>Direccion Pedido</th>
				<th>Tarjeta Pedido</th>
				
				<th colspan="10">Opciones</th>
				</tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listaPedidos }">
					<tr>
						
						<td>${ ele.idPedido }</td>
						<td>${ ele.estadoPedido }</td>
						<td>${ ele.fechaPedido }</td>
						<td>${ ele.usuarioPedido }</td>
						<td>${ ele.direccionPedido }</td>
						<td>${ ele.tarjetaPedido }</td>
						
						<sec:authorize access="hasAuthority('ROLE_ADMIN')">
							<td><a href="/admin/editarPedido/${ ele.idPedido }">Editar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('ROLE_ADMIN')">
							<td><a href="/admin/eliminarPedido/${ ele.idPedido }">Eliminar</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>