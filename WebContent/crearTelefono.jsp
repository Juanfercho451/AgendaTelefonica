<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true"%>
<%@page import="ec.edu.ups.modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	HttpSession sesion = request.getSession();
Usuario usuario = new Usuario();
usuario = (Usuario) sesion.getAttribute("usuario");
%>

<!-- Elementos de Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/72ad08e112.js"
	crossorigin="anonymous"></script>
<title>Agregar telefono</title>
</head>

<body>

	<header id="main-header" class="py-2 bg-dark text-white">
		<c:set var="u" scope="request" value="${usuario}" />
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-phone-volume"></i> Telefonos de ${u.nombre}
						${u.apellido}
					</h1>
				</div>
			</div>
		</div>
	</header>
	<form id="form-1" action="/AgendaTelefonica/CrearTelefonoController"
		method="POST">
		<jsp:include
			page="/WEB-INF/paginas/comunes/botonRegistrarTelefono.jsp" />
		<section id="details">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="card">
							<div class="card-header">
								<h4>Ingrese su nuevo numero</h4>
							</div>

							<div class="card-body">
								<div class="modal-body">
									<div class="form-group">
										<input id="input-1" name="usuario" type="text" hidden="true"
											value="${usuario.getCedula()}" /> <br> <label
											for="lblnumero">Ingrese su nuevo numero</label> <input
											id="numero" name="numero" placeholder="Número" type="text"
											class="form-control" required>
									</div>
									<div class="form-group">
										<label for="lbltipo">Ingrese su tipo de numero</label> <select
											name="tipo" id="tipo" class="form-select" required>
											<option value="movil">Celular</option>
											<option value="fijo">Casa</option>
											<option value="fijo">Trabajo</option>
										</select>
									</div>
									<div class="form-group">
										<label for="lbloperadora">Ingrese su operadora</label> <input
											id="operadora" name="operadora" placeholder="Operadora"
											type="text" class="form-control" required>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</section>
	</form>
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