<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Crear Tarjeta</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Alta Tarjeta</h1>
		<a class="btn-link" href="/user/misDatos">Volver</a>
		<form action="/user/altaTarjeta" method="post">
			
			<fieldset class="full-form">
				<legend>Introduce los datos de la tarjeta</legend>
			<fieldset class="default">
				<fieldset class="default">
					<label for="numero_tarjeta">Número de la tarjeta</label>
					<input type="text" name="numeroTarjeta" id="numeroTarjeta" required /></br>
					</br>
					<label for="mes_caducidad">Mes caducidad</label>
					<input type="text" name="mesCaducidad" id="mesCaducidad" required />
					<label for="anno_caducidad">Año caducidad</label>
					<input type="text" name="annoCaducidad" id="annoCaducidad" required />	
				</fieldset>		
				<fieldset class="default">
					<label for="nombre_titular">Nombre del titular de la tarjeta</label>
					<input type="text" name="nombreTitular" id="nombreTitular" required />	
					<label for="cvv">CVV</label>
					<input type="text" name="cvv" id="cvv" required/>
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