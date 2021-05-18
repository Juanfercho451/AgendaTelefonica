<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- Elementos de Bootstrap CSS -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/72ad08e112.js"
	crossorigin="anonymous"></script>

<title>Persona Encontrada</title>
</head>
<body>

	<header id="main-header" class="py-2 bg-dark text-white">
		<c:set var="u" scope="request" value="${usuario}" />
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-user"></i> Bienvenido ${u.nombre} ${u.apellido}
					</h1>
				</div>
			</div>
		</div>
	</header>
<body>

	<!-- Botones de navegacion -->
	<jsp:include page="WEB-INF/paginas/comunes/botonCerrarSecion.jsp"></jsp:include>

	<section id="usuarios">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="card">
						<div class="card-header">
							<c:set var="telfns" scope="request" value="${telefonos}" />
							<label id="label-1">Usuario: ${u.getNombre()}
								${u.getApellido()}</label><br>
							<label id="label-2">Correo: ${u.getCorreo() }
								<td><a href="mailto:${u.getCorreo()}"
									class="btn btn-success"> <i
										class="fas fa-envelope-open-text"></i>
								</a></td>
							</label>
						</div>
						<table class="table table-striped" id="table-1">
							<thead class="bg-dark text-white">
								<tr>

									
									<th>Número</th>
									<th>Tipo</th>
									<th>Operadora</th>
									<th></th>
									<th></th>
									<th></th>
									<th></th>

								</tr>
							</thead>
							<tbody>

								<c:forEach var="t" items="${telfns}">
									<tr>
										
										<td>${t.numero}</td>
										<td>${t.tipo}</td>
										<td>${t.operadora}</td>
										<td><a href="tel:${t.numero}" class="btn btn-secondary">
												<i class="fas fa-phone-volume"></i>
										</a></td>

										<td><a href="editarUsuario.jsp" class="btn btn-danger">
												<i class="fas fa-user-edit"></i>
										</a></td>

										<td><a href="/AgendaTelefonica/EditarTelefonoController?codigo=${t.codigo }" class="btn btn-danger">
												<i class="fas fa-edit"></i><i class="fas fa-phone"></i>
										</a></td>

										<td><a
											href="/AgendaTelefonica/EliminarTelefonoController?codigo=${t.codigo }"
											class="btn btn-danger"> <i class="fas fa-trash"></i>
										</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</section>

</body>
<!-- Pie de pagina -->
<jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"></jsp:include>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-lpyLfhYuitXl2zRZ5Bn2fqnhNAKOAaM/0Kr9laMspuaMiZfGmfwRNFh8HlMy49eQ"
	crossorigin="anonymous"></script>
</html>