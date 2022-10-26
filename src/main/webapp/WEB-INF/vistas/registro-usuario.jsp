<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Registrarse</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/estilos.css" />
<link href="css/styles.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />

</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container">
		<div id="loginbox" class="formulario-registro rounded login mx-auto">
			<form:form action="login" method="POST" modelAttribute="usuario">
				<h3 class="form-signin-heading text-center">Registrarse</h3>
				<hr class="colorgraph">
				<br>

				<div class="form-group">
					<form:input path="nombre" id="nombre" class="form-control"
						placeholder="Nombre de usuario" />
				</div>

				<div class="form-group">
					<form:input path="email" id="email" class="form-control"
						placeholder="Correo" />
				</div>

				<div class="form-group">
					<form:input path="password" type="password" id="password"
						class="form-control" placeholder="Contraseña" />

				</div>
				<button id="btn-registrarme"
					class="btn btn-lg btn-primary btn-block button-agregarfavs" Type="Submit">
					Registrarme</button>
			</form:form>
		</div>

		<!-- ERRORES VALIDACION REGISTRO -->
		<c:if test="${not empty errorCampos}">
			<div class="error">
				<span>${errorCampos}</span>
			</div>
		</c:if>
		
		<c:if test="${not empty errorNombre}">
			<div class="error">
				<span>${errorNombre}</span>
			</div>
		</c:if>

		<c:if test="${not empty errorEmail}">
			<div class="error">
				<span>${errorEmail}</span>
			</div>
		</c:if>
	</div>

	<jsp:include page="footer.jsp" />

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