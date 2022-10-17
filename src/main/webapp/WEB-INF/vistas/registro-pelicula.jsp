<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registrar pelicula</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css" />
<link rel="stylesheet" href="css/registro-pelicula.css"/>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
	
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">
</head>

<body>

	<jsp:include page="header.jsp" />

	<h2>REGISTRO PELICULA</h2>
	<div class="container">
		<form:form action="registrar-pelicula" method="POST"
			class="formulario-registro rounded" modelAttribute="datosPelicula">
				
			<div class="row">
				<div class="form-group col-md-6">
				
					<form:label path="poster">Poster</form:label>
					<form:input path="poster" type="file" id="foto" name="file"/>
				
					<form:label path="nombre">Nombre</form:label>
					<form:input path="nombre" type="text" class="form-control"
						id="nombre"/>
					
					<form:label path="director">Director</form:label>
					<form:input path="director" type="text" class="form-control"
						id="director"/>
					
					<form:label path="generos">Genero</form:label>
					<form:select path="generos" multiple="multiple"
						items="${listaGeneros}" itemLabel="descripcion" itemValue="id" />
					
					<form:label path="plataformas">Plataforma</form:label>
					<form:select path="plataformas" multiple="multiple"
						items="${listaPlataformas}" itemLabel="descripcion" itemValue="id" />
						
					<form:label path="fechaEstreno">Fecha de estreno</form:label>
					<form:input path="fechaEstreno" type="date" class="form-control"
						id="fechaEstreno" />
						
					<form:label path="duracion">Duracion</form:label>
					<form:input path="duracion" type="number" class="form-control"
						id="duracion"/>
			
					<form:label path="sinopsis">Sinopsis</form:label>
					<form:textarea path="sinopsis" class="form-control"
					    id="sinopsis" rows="3" />

				</div>
			</div>
			<div class="col text-center mt-2">
				<form:button type="submit" class="btn btn-primary">REGISTRAR</form:button>
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