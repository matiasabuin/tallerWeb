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
	<header>

		<nav class="navbar navbar-expand-lg bg-primary">
			<div class="container">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">

						<li class="nav-item mx-2"><a class="nav-link" href="home">Inicio
						</a></li>

						<c:if test="${usuarioActual.nombre != null}">
							<li class="nav-item mx-2 dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> ${usuarioActual.nombre} </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="perfil">Perfil</a> <a
										class="dropdown-item" href="cerrar-sesion">Cerrar sesion</a>
								</div></li>

							<li class="nav-item mx-2 dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> Registrar </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="registro-pelicula">Pelicula</a>
									<a class="dropdown-item" href="registro-serie">Serie</a> <a
										class="dropdown-item" href="registro-videojuego">VideoJuego</a>
								</div></li>
						</c:if>
					</ul>

					<form action="buscar" method="GET">
						<input type="text" placeholder="Buscar contenido" class="search">
					</form>

					<c:if test="${usuarioActual.nombre == null}">
						<a href="registro-usuario" class="nav-link">Register</a>
						<a href="login" class="nav-link">Log In</a>
					</c:if>

				</div>
			</div>
		</nav>
	</header>

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



	<footer class="footer">
		<div class="container">
			<div class="column1">
				<h4 class="mx-2" style="text-align: center; margin: 1em;">Redes
					Sociales</h4>
				<div class="social">
					<div class="item mx-2">
						<a href="https://www.facebook.com/" target="_blank"> <i
							class="fa fa-facebook-square" aria-hidden="true"></i>
						</a>
					</div>
					<div class="item mx-2">
						<a href="https://www.instagram.com/" target="_blank"> <i
							class="fa fa-instagram" aria-hidden="true"></i>
						</a>
					</div>
					<div class="item">
						<a href="https://www.twitter.com/" target="_blank"> <i
							class="fa fa-twitter-square" aria-hidden="true"></i>
						</a>
					</div>
				</div>
			</div>

		</div>
		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			<a class="enlaceDeCopy" href="/">PaginaGenericaDeTaller.com</a>
		</div>
		<!-- Copyright -->
	</footer>


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