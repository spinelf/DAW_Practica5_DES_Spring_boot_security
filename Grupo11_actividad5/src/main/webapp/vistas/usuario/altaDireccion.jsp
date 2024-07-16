<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Crear Dirección</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Alta Dirección</h1>
		<a class="btn-link" href="/user/misDatos">Volver</a>
		<form action="/user/altaDireccion" method="post">
			
			<fieldset class="full-form">
				<legend>Introduce los datos de la dirección</legend>
			<fieldset class="default">
				<fieldset class="default">
					<label for="calle">Calle</label>
					<input type="text" name="calle" id="calle" required />
					<label for="numero">Número</label>
					<input type="number" name="numero" id="numero" required />	
					<label for="localidad">Localidad</label>
					<input type="text" name="localidad" id="localidad" required />	
				</fieldset>		
				<fieldset class="default">
					<label for="piso">Piso</label>
					<input type="text" min=0 name="piso" id="piso"/>
					<label for="letra">letra</label>
					<input type="text" name="letra" id="letra"/>
					<label for="cp">Código de postal</label>
					<input type="text" name="cp" id="cp" required/>
				</fieldset>	
				<button type="submit" class="btn-link">Alta</button>
			</fieldset>
		</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>