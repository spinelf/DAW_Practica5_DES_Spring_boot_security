<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registrarse</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Editar usuario</h1>
		<a class="btn-link" href="/user/misDatos">Volver</a>
		<form action="/admin/editarUsuario" method="post">
			
			<fieldset class="full-form">
				<legend>Editar datos del usuario</legend>
			<fieldset class="default">
				<fieldset class="default">
					<label for="id_usuario">Id del Usuario</label>
					<input type="number" name="idUsuario" id="id_usuario" required placeholder="${ usuario.idUsuario }"/>		
				</fieldset>
				<fieldset class="default">
					<label for="emailUsuario">Email</label>
					<input type="text" name="emailUsuario" id="email_usuario" required placeholder="${ usuario.emailUsuario }"/>		
				</fieldset>		
				<fieldset class="default">
					<label for="nombre_usuario">Nombre</label>
					<input type="text" name="nombreUsuario" id="nombre_usuario" required placeholder="${ usuario.nombreUsuario }"/>
					<label for="apellido_usuario">Apellido</label>
					<input type="text" name="apellidosUsuario" id="apellidos_usuario" required placeholder="${ usuario.apellidosUsuario }" />
					<label for="fecha_nacimiento">Fecha Nacimiento</label>
					<input type="date" name="fechaNacimiento" id="fecha_nacimiento" required/>
				</fieldset>	
				<button type="submit" class="btn-link">Editar</button>
			</fieldset>
		</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>