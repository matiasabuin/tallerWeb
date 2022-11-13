<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registrar Serie</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css" />
<link rel="stylesheet" href="css/registro-serie.css" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">

</head>

<body>

	<jsp:include page="header.jsp" />

	<h2>Registro Serie</h2>
	<div class="container">
		<form:form action="registrar-serie" method="POST"
			class="formulario-registro rounded" modelAttribute="datosSerie"
			enctype="multipart/form-data">
			<div class="form-serie">
				<div class="form-group col-md-6">
					<form:label path="poster">Subir el poster</form:label>
					<form:input path="" type="file" id="foto" name="file" />

					<br> <label for="inputNombre">Nombre</label>
					<form:input path="nombre" type="text" class="form-control"
						id="inputNombre" />

					<label for="inputDuracion">Cantidad de temporadas</label>
					<form:input path="cantDeTemps" type="number" class="form-control"
						min="1" id="inputDuracion" />

					<label for="inputDuracion">Cantidad de capitulos total</label>
					<form:input path="cantDeCaps" type="number" class="form-control"
						min="1" id="inputDuracion" />

					<label for="inputDuracion">Duracion por capitulo</label>
					<form:input path="duracionPorCaps" type="number"
						class="form-control" id="inputDuracion" />

					<form:label path="generos">Genero</form:label>
					<form:select path="generos" multiple="multiple"
						items="${listaGeneros}" itemLabel="descripcion" itemValue="id" />

					<form:label path="plataformas">Plataforma</form:label>
					<form:select path="plataformas" multiple="multiple"
						items="${listaPlataformas}" itemLabel="descripcion" itemValue="id" />

					<label for="inputDate">Fecha de estreno</label>
					<form:input path="fechaEstreno" type="date" class="form-control"
						id="inputPlataforma" />

					<label for="exampleFormSinopsis">Sinopsis</label>
					<form:textarea path="sinopsis" class="form-control"
						id="exampleFormControlTextarea1" rows="3" />
				</div>
			</div>

			<div class="col text-center mt-2">
				<form:button type="submit" class="btn btn-primary"
					id="botonDeregistroPeliSerieVideojuego">Registrar</form:button>
			</div>
		</form:form>


	</div>

	<jsp:include page="footer.jsp" />

	<script
		src="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/js/multi-select-tag.js"></script>
	<script>
		new MultiSelectTag('generos')
	</script>
	<script>
		new MultiSelectTag('plataformas')
	</script>

	<!-- 	<script src="js/script.js"></script> -->
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