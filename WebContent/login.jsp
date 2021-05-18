<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/72ad08e112.js"
	crossorigin="anonymous"></script>
<body>
	<header id="main-header" class="py-2 bg-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-user-friends"></i> Ingresar Secion
					</h1>
				</div>
			</div>
		</div>
	</header>

	<form
		action="${pageContext.request.contextPath}/LoginUsuarioController"
		method="POST" class="was-validated">
		<!-- Botones de navegacion -->
		<jsp:include
			page="/WEB-INF/paginas/comunes/botonesNavegacionIngresar.jsp" />
		<section id="details">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="card">
							<div class="card-header">
								<h4>Ingrese sus credenciales</h4>
							</div>
							<div class="card-body">
								<div class="modal-body">
									<div class="form-group">
										<label for="cedula">Ingrese su correo electronio</label> <input
											type="text" name="mail" id=mail placeholder="Correo"
											class="form-control" required>

									</div>
									<div class="form-group">
										<label for="nombre">Ingrese su contraseña</label> <input
											type="password" name="pass" placeholder="password"
											class="form-control" required>
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