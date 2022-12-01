<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Editar Perfil</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>

<body>

	<jsp:include page="header.jsp" />

	<div style="margin-top: 6em;">

		<div class="formulario-registro rounded login mx-auto">
			<form:form action="editar-usuario" method="POST"
				modelAttribute="datosPerfil" enctype="multipart/form-data">
				<c:if test="${usuarioActual.planAdquirido.plan.descripcion != 'Free'}">
					<h3 class="form-signin-heading text-center">Editar Perfil</h3>

					<div class="form-group foto-perfil">
						<img src="images/${usuarioActual.foto}" style="width: 50%;">
					</div>

					<div class="form-group">
						<form:input path="" type="file" name="file" accept=".jpg, .jpeg" />
					</div>
				</c:if>
				<c:if test="${usuarioActual.planAdquirido.plan.descripcion == 'Free'}">
					<h3 class="form-signin-heading text-center">Editar Perfil</h3>

					<div class="form-group foto-perfil">
						<img src="images/${usuarioActual.foto}" style="display:none">
					</div>

					<div class="form-group" style="display:none">
						<form:input path="" type="file" name="file" accept=".jpg, .jpeg" />
					</div>
				</c:if>
				<div class="form-group">
					<form:input path="nombre" id="nombre" class="form-control"
						placeholder="Nombre de usuario" />
				</div>
				<div class="form-group">
					<form:input path="biografia" id="biografia" class="form-control"
						placeholder="Biografia" />
				</div>

				<button id="btn-registrarme"
					class="btn btn-lg btn-primary btn-block" Type="Submit">
					Guardar</button>

			</form:form>
		</div>

		<!-- ERROR NOMBRE YA EXISTE -->
		<c:if test="${not empty errorNombre}">
			<div class="error">
				<span>${errorNombre}</span>
			</div>
		</c:if>
	</div>

	<jsp:include page="footer.jsp" />

	<script src="js/script.js"></script>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>

