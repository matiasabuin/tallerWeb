<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${datosPelicula.nombre}</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/perfil-pelicula.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="fsv-page-wrapper">
		<div class="container contenedor">
			<section class="datos">
				<div>
					<img src="images/${datosPelicula.poster}"><br> <br>
					<c:if test="${usuarioActual != null}">
						<form:form action="guardarFavPelicula" method="POST"
							modelAttribute="datosLista">
							<form:input path="pelicula.id" type="hidden"
								value="${datosPelicula.id}" />
							<form:input path="usuario.id" type="hidden"
								value="${usuarioActual.id}" />
							<form:button type="submit" class="btn btn-primary button-agregarfavs">
								Favoritos <i class="fa fa-plus" aria-hidden="true"></i>
							</form:button>
						</form:form>
					</c:if>

				</div>
				<div style="margin-left: 2em;">
					<h2>${datosPelicula.nombre}</h2>
					<p>Dirigida por&nbsp;${datosPelicula.director}</p>
					<p>Fecha de estreno:&nbsp;${datosPelicula.fechaEstreno}</p>
					<p class="align-self-center mx-2 sinopsis">${datosPelicula.sinopsis}</p>
					<p class="col-4 text-center border rounded">Duración:&nbsp;${datosPelicula.duracion}&nbsp;Minutos</p>

					<strong class="items">Generos</strong>
					<div style="margin: 5px 0em;">
						<c:forEach var="genero" items="${datosPelicula.generos}">
							<p class="genero">${genero.descripcion}</p>
						</c:forEach>
					</div>

					<strong class="items">Plataformas</strong>
					<div style="margin: 5px 0em;">
						<c:forEach var="plataforma" items="${datosPelicula.plataformas}">
							<p class="plataforma">${plataforma.descripcion}</p>
						</c:forEach>
					</div>

				</div>
			</section>

			<section>
				<div class="reviews">
					<h3>Reviews</h3>
					<c:if test="${usuarioActual != null}">
						<form:form action="registrarReviewPelicula" method="POST"
							modelAttribute="datosReview">
							<form:textarea path="descripcion"
								placeholder="Escribe tu reseña sobre el videojuego" />
							<form:input path="pelicula.id" type="hidden"
								value="${datosPelicula.id}" />
							<form:input path="usuario.id" type="hidden"
								value="${usuarioActual.id}" />
							<form:button type="submit" class="button-reviews">Enviar</form:button>
						</form:form>
					</c:if>

					<c:if test="${listaReviews != null}">
						<c:forEach var="review" items="${listaReviews}">
							<div class="comentario">
								<img src="images/${review.usuario.foto}">
								<div>
									<h4>${review.usuario.nombre}</h4>
									<p>${review.descripcion}</p>
								</div>
							</div>
						</c:forEach>
					</c:if>

					<c:if test="${listaReviews[0] == null}">
						<h5>No hay reviews por ahora</h5>
					</c:if>
				</div>
			</section>
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