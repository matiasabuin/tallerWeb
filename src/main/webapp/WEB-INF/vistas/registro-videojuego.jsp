<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registrar videojuego</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/registro-videojuego.css" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body>

	<!-- IMPORT HEADER -->
	<jsp:include page="header.jsp" />

	<main>
		<c:if test="${not empty errorCampos}">
			<div class="error-banner">
				<span>No debe haber campos vacios</span>
			</div>
		</c:if>
		
		<h2>Registro Videojuego</h2>
		<section class="formulario">

			<form:form action="registrar-videojuego" method="POST"
				modelAttribute="datosVideojuego" enctype="multipart/form-data">
				<div class="container">

					<div class="left">
						<div class="detalle">
							<h3>Detalle</h3>

							<form:label path="poster">Portada</form:label>
							<form:input path="" type="file" id="poster" name="file"
								accept=".jpg, .jpeg" />

							<form:label path="fechaEstreno">Fecha de lanzamiento</form:label>
							<form:input path="fechaEstreno" type="date" id="fechaEstreno" />

							<form:label path="duracion">Duracion</form:label>
							<form:input path="duracion" type="number" id="duracion" min="1"
								style="width: 30%;" />
							<span style="display: inline; margin-left: 1em;">Horas</span>
						</div>
					</div>

					<div class="right">
						<div class="campos">
							<h3>Caracteristicas</h3>
							<div class="separacion">
								<div>
									<form:label path="nombre">Nombre</form:label>
									<form:input path="nombre" type="text" id="nombre" />

									<form:label path="desarrollador">Desarrollador</form:label>
									<form:input path="desarrollador" type="text" id="desarrollador" />

									<form:label path="cantidadJugadores">Cantidad de jugadores</form:label>
									<form:input path="cantidadJugadores" type="number"
										id="cantidadJugadores" min="1" />
								</div>

								<div style="margin-left: 4em;">
									<form:label path="generos">Genero</form:label>
									<form:select path="generos" multiple="multiple"
										items="${listaGeneros}" itemLabel="descripcion" itemValue="id" />

									<form:label path="plataformas">Plataforma</form:label>
									<form:select path="plataformas" multiple="multiple"
										items="${listaPlataformas}" itemLabel="descripcion"
										itemValue="id" />
								</div>
							</div>
						</div>

						<div class="campos">
							<h3>Historia</h3>
							<form:label path="sinopsis">Sinopsis</form:label>
							<form:textarea path="sinopsis" id="sinopsis" style="width: 100%;"
								placeholder="Escribe algo aqui" maxlength="1000" />
						</div>

						<div>
							<form:button type="submit" class="btn btn-primary"
								id="botonDeregistroPeliSerieVideojuego">Registrar</form:button>
						</div>
					</div>
				</div>
			</form:form>

			<c:if test="${not empty errorCampos}">
				<div class="error">
					<span>${errorCampos}</span>
				</div>
			</c:if>
		</section>
	</main>

	<!-- IMPORT FOOTER -->
	<jsp:include page="footer.jsp" />

	<!-- SCRIPT PARA SELECT MULTIPLE DESPLEGABLE -->
	<script
		src="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/js/multi-select-tag.js"></script>
	<script>
		new MultiSelectTag('generos')
	</script>
	<script>
		new MultiSelectTag('plataformas')
	</script>

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
