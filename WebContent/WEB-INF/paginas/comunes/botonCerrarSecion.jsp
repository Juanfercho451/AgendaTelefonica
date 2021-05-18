<section id="actions" class="py-4 mb-4 bg-light ">
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<a href="/AgendaTelefonica/LoginUsuarioController?logout"
					class="btn btn-ligth btn-block"> <i class="fas fa-arrow-left"></i>
					Cerrar Secion
				</a>
			</div>
			<div class="col-md-2">
				<a href="/AgendaTelefonica/crearTelefono.jsp" type="submit"
					class="btn btn-success btn-block"> <i
					class="fas fa-phone-volume"></i> Agregar Telefono
				</a>
			</div>
			<div class="col-md-2">
				<a href="/AgendaTelefonica/buscarTelefono.jsp" type="submit"
					class="btn btn-success btn-block"> <i class="fas fa-search-plus"></i> Buscar Telefono
				</a>
			</div>

			<div class="col-md-2">
				<button
					href="${pageContext.request.contextPath}/EliminarUsuarioController"
					type="submit" class="btn btn-danger btn-block">
					<i class="fas fa-trash"></i> Eliminar
				</button>
			</div>


		</div>
	</div>
</section>