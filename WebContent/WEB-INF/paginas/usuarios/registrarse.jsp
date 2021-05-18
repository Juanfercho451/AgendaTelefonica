<div class="modal fade" id="registrarModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-dark text-white">
				<h5 class="modal-title">Registrarse</h5>
				<button type="button" class="btn-close btn-close-white"
					data-bs-dismiss="modal" aria-label="Close">
					<span>&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form
					action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
					method="POST" class="was-validated">
					<div class="modal-body">
						<div class="form-group">
							<label for="cedula">Cedula</label> <input type="text"
								class="form-control" name="cedula" required>
						</div>
						<div class="form-group">
							<label for="nombre">Nombre</label> <input type="text"
								class="form-control" name="nombre" required>
						</div>
						<div class="form-group">
							<label for="apellido">Apellido</label> <input type="text"
								class="form-control" name="apellido" required>
						</div>
						<div class="form-group">
							<label for="correo">Correo</label> <input type="email"
								class="form-control" name="correo" required>
						</div>
						<div class="form-group">
							<label for="contrasena">Contrasena</label> <input type="text"
								class="form-control" name="contrasena" required>
						</div>
					</div>
					
					
					<div class="modal-footer">
						<button class="btn btn-primary" type="submit"
							data-bs-dismiss="modal">Guardar</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>

