<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="usuarios">
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="card">
					<div class="card-header">
						<h4>Listado de Usuarios</h4>
					</div>
					<table class="table table-striped">
						<thead class="bg-dark text-white">
							<tr>
								<th>Nombre</th>
								<th>Correo</th>
								<th>Tipo</th>
								<th>Telelefono</th>
								<th>Operadora</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<!-- Iteramos la lista de los usuarios -->
							<c:forEach var="usuarios" items="${usuarios}">
								<tr>
									<td>${usuarios.nombre}${usuarios.apellido}</td>
									<td>${usuarios.correo}</td>
									<td>${usuarios.cedula}</td>
									<td>${usuarios.contrasena}</td>
									<td></td>
									<td><a
										href="${pageContext.request.contextPath}/BuscarUsuarioContactoController${usuarios.cedula}"
										class="btn btn-danger"> <i
											class="fas fa-angle-double-right"></i> Editar
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-2">
				<div class="card text-center bg-dark text-white mb-3">
					<div class="card-body">
						<h4>Total usuarios</h4>
						<h5 class="display-4">
							<i class="fas fa-users"></i> ${totalUsuarios}
						</h5>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Agregar cliente -->
<jsp:include page="/WEB-INF/paginas/usuarios/agregarCliente.jsp"></jsp:include>

