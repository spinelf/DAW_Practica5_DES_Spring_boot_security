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
				<th>Id Rol</th>
				<th>Nombre Rol</th>
				
				
				</tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listaRoles }">
					<tr>
						
						<td>${ ele.idRol }</td>
						<td>${ ele.nombreRol }</td>
						
						</tr>
				</c:forEach>
					
			</tbody>
		</table>
		
	</body>
</html>