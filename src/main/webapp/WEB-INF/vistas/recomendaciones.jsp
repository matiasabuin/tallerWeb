<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recomendaciones</title>

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

	<c:if test="${videojuegosRecomendados.isEmpty() == true && peliculasRecomendadas.isEmpty() == true 
					&& seriesRecomendadas.isEmpty() == true}">
			<div class="container">
				<div class="comentario">	
					<h1 class="text-center">No se han encontrado resultados que duren ${horasRecomendacion} hora(s)</h1>
			</div>
		</div>
	</c:if>

	<c:if test="${videojuegosRecomendados.isEmpty() == false}">
		<div class="container">
		<div class="recomendaciones-container">
			<h1>Videojuegos que duren ${horasRecomendacion} hora(s):</h1>

			<table class="table-responsive table-borderless">
				<c:forEach items="${videojuegosRecomendados}" var="recomendado">
					<td><a href="videojuego?id=${recomendado.id}"> <img
							src="images/${recomendado.poster}">
						<p class="titulo">${recomendado.nombre}</p></td>
						</a>
				</c:forEach>
			</table>
		</div>
	</div>
	</c:if>
	
	<c:if test="${peliculasRecomendadas.isEmpty() == false}">
		<div class="container">
		<div class="recomendaciones-container">
			<h1>Peliculas que duren ${horasRecomendacion} hora(s):</h1>

			<table class="table-responsive table-borderless">
				<c:forEach items="${peliculasRecomendadas}" var="recomendado">
					<td><a href="perfil-pelicula?id=${recomendado.id}"> <img
							src="images/${recomendado.poster}">
						<p class="titulo">${recomendado.nombre}</p></td>
						</a>
				</c:forEach>
			</table>
		</div>
	</div>
	</c:if>
	
	<c:if test="${seriesRecomendadas.isEmpty() == false}">
		<div class="container">
		<div class="recomendaciones-container">
			<h1>Series que duren ${horasRecomendacion} hora(s):</h1>

			<table class="table-responsive table-borderless">
				<c:forEach items="${seriesRecomendadas}" var="recomendado">
					<td><a href="perfil-pelicula?id=${recomendado.id}"> <img
							src="images/${recomendado.poster}">
						<p class="titulo">${recomendado.nombre}</p></td>
						</a>
				</c:forEach>
			</table>
		</div>
	</div>
	</c:if>
	
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