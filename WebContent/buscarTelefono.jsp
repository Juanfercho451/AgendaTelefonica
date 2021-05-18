<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Elementos de Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/72ad08e112.js"
	crossorigin="anonymous"></script>

<title>Buscar Telefono</title>
</head>
<body>
	<header id="main-header" class="py-2 bg-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-phone-alt"></i> Buscar Telefono
					</h1>
				</div>
			</div>
		</div>
	</header>
	<!-- Botones de navegacion -->
	<section id="actions" class="py-4 mb-4 bg-light ">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<a href="/AgendaTelefonica/RegresarControler"
						class="btn btn-ligth btn-block"> <i class="fas fa-arrow-left"></i>
						Regresar
					</a>
				</div>
			</div>
		</div>
	</section>
	<!-- Seccion de Listar Usuarios -->
	<section id="actions" class="py-4 mb-4 bg-light ">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<form id="form-1"
						action="${pageContext.request.contextPath}/BuscarUsuarioContactoController1"
						method="get">
						<legend>Buscar Telefono</legend>
						<div class="mb-3">
							<input type="text" id="identificacion" name="identificacion"
								placeholder="cedula o correo" />
							<h1>
								<input id="cedula" name="cedula" placeholder="Text" type="text"
									hidden="true" value="${u.cedula}" />
							</h1>
						</div>
						<button type="submit" class="btn btn-warning" id="button-1">Buscar</button>
					</form>
				</div>
			</div>
		</div>

	</section>
	<section id="usuarios">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="card">
						<div class="card-header">
							<c:set var="u" scope="request" value="${contacto}" />
							<label id="label-1">Usuario: ${u.getNombre()}
								${u.getApellido()} </label><br> <label id="label-2">Correo:
								${u.getCorreo() }
								<td><a href="mailto:${u.getCorreo()}"
									class="btn btn-success"> <i
										class="fas fa-envelope-open-text"></i>
								</a></td>
							</label>
						</div>
						<table class="table table-striped" id="table-1">

							<thead class="bg-dark text-white">
								<tr>
									<th>Tipo</th>
									<th>Telelefono</th>
									<th>Operadora</th>
									<th></th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="t" items="${u.telefonos}">
									<tr>
										<td>${t.tipo}</td>
										<td>${t.numero}</td>
										<td>${t.operadora}</td>

										<td><a href="tel:${t.numero}" class="btn btn-secondary">
												<i class="fas fa-phone-volume"></i>
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

</body>
</html>