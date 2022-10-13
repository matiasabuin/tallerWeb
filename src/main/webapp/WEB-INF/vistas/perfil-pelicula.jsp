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
		<hr>
		<hr>
		<div class=container>
			<section class="poster-secction mx-3">
				<div class="row">
					<div class="col-2 poster-pelicula">
						<img src="images/${datosPelicula.poster}">
					</div>
					<div class="col align-self-start text-center ml-5">
						${datosPelicula.nombre}<br> <img
							src="https://t3.ftcdn.net/jpg/03/82/27/72/360_F_382277203_OnBiCfeANOzSCxvkkSdgICNMz98fHirV.jpg"
							alt="estrellitas">

					</div>
					<div class="col-5 align-self-center mx-2">${datosPelicula.sinopsis}</div>
				</div>
			</section>
			<hr>
			<section class="tags-secction mx-3">
				<div class="row">

					<div class="col-2 mx-2 text-center border rounded">
						<a href="!">${datosPelicula.genero}</a>
					</div>
					<div class="col-2 mx-2 text-center border rounded">
						<a href="!">${datosPelicula.genero}</a>
					</div>
					<div class="col-2 mx-2 text-center border rounded">
						<a href="!">${datosPelicula.genero}</a>
					</div>
					<div class="col-4 mx-5 text-center border rounded">${datosPelicula.duracion}
						mins More at IMDB TMDB</div>
				</div>
				<hr>
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
									<form:button type="submit">Enviar</form:button>
								</form:form>
							</c:if>

							<c:if test="${listaReviews != null}">
								<c:forEach var="review" items="${listaReviews}">
									<div class="comentario">
										<img src="images/${review.usuario.foto}">
										<p>${review.descripcion}</p>
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