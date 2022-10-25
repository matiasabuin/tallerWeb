<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>

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

	<div class="boton-container">

		<div class="boton mx-3" style="width: 350px;">
			<h2>Disfruta de tu tiempo libre</h2>
			<p>Encontra el contenido que mejor se adapte a tus tiempos</p>
		</div>

		<div class="boton mx-3 form-tiempo">
			<form action="buscar-recomendaciones" method="GET" class="time-form">
				<div class="tipos">
					<label for="horas" class="time">Cantidad de horas</label> <input
						type="number" name="horas" class="horas">
				</div>
				<button type="submit" class="empezar btn btn-primary button-agregarfavs">¡Empezar!</button>
			</form>
		</div>

	</div>

	<div class="container">
		<div class="recomendaciones-container">

			<h1>Videojuegos</h1>

			<table class="table-responsive table-borderless">
				<c:forEach items="${videojuegos}" var="videojuego">
					<td><a href="videojuego?id=${videojuego.id}"> <img
							src="images/${videojuego.poster}">
							<p class="titulo">${videojuego.nombre}</p></td>
					</a>
				</c:forEach>
			</table>
		</div>
	</div>

	<div class="container">
		<div class="recomendaciones-container">

			<h1>Peliculas</h1>
			<table class="table-responsive table-borderless">
				<c:forEach items="${peliculas}" var="pelicula">
					<td><a href="perfil-pelicula?id=${pelicula.id}"> <img
							src="images/${pelicula.poster}">
							<p class="titulo">${pelicula.nombre}</p>
					</a></td>
				</c:forEach>
			</table>

		</div>
	</div>

	<div class="container">
		<div class="recomendaciones-container">

			<h1>Series</h1>
			<table class="table-responsive table-borderless">
				<c:forEach items="${series}" var="serie">
					<td><a href="perfil-serie?id=${serie.id}"> <img
							src="images/${serie.poster}">
							<p class="titulo">${serie.nombre}</p>
					</a></td>
				</c:forEach>
			</table>

		</div>
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