<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Contacto</title>
</head>
<body>
	<a href="/principal.jsp">Volver</a>
	<br>
	<c:set var="u" scope="request" value="${contacto}" />
	<label id="label-1">Usuario: ${u.getNombre()} ${u.getApellido()}</label>
	<br>
	<label id="label-2">Correo: ${u.getCorreo() }</label>
	<a href="mailto: ${u.getCorreo()}">Enviar correo</a>
	
	<table id="table-1">
	<br>
	<c:set var="telfns" scope="request" value="${u.getTelefonos()}"/>
	<caption>Teléfonos</caption>
		<thead>
			<tr>
				<th>N°</th>
				<th>Número</th>
				<th>Tipo</th>
				<th>Operadora</th>
			</tr>
			
		</thead>
		<tbody>
		<c:forEach var="tel" items="${telfns}">
		<tr>
			<td>${tel.codigo}</td>
			<td><a href="tel:+593 ${tel.numero}">${tel.numero}</a></td>
			<td>${tel.tipo}</td>
			<td>${tel.operadora}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>