<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>${datosVideojuego.nombre}</title>
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css" />
<link rel="stylesheet" href="css/perfil-videojuego.css" />
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

						<li class="nav-item mx-2"><a class="nav-link" href="home">Inicio</a>
						</li>

						<c:if test="${usuarioActual.nombre != null}">
							<li class="nav-item mx-2 dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> ${usuarioActual.nombre} </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="perfil">Perfil</a> <a
										class="dropdown-item" href="cerrar-sesion">Cerrar sesion</a>
								</div></li>
						</c:if>

						<c:if test="${usuarioActual.plan == 'Premium'}">
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

					<c:if test="${usuarioActual == null}">
						<a href="registro-usuario" class="nav-link">Register</a>
						<a href="login" class="nav-link">Log In</a>
					</c:if>
				</div>

			</div>
		</nav>
	</header>
	<main>
		<div class="container">
			<div class="portada">
				<div style="text-align: center;">
					<img src="images/${datosVideojuego.poster}"><br>
				</div>
			</div>
			<div class="centro" style="width: 50%;">
				<h2>${datosVideojuego.nombre}</h2>
				<strong>Fecha de lanzamiento</strong>
				<p>${datosVideojuego.fechaEstreno}</p>
				<p class="sinopsis">${datosVideojuego.sinopsis}</p>
			</div>
			<div>
				<strong>Genero</strong>
				<c:forEach var="genero" items="${datosVideojuego.generos}">
					<p>${genero.descripcion}</p>
				</c:forEach>
				<strong>Plataforma</strong>
				<c:forEach var="plataforma" items="${datosVideojuego.plataformas}">
					<p>${plataforma.descripcion}</p>
				</c:forEach>
				<strong>Modalidad</strong>
				<c:if test="${datosVideojuego.cantidadJugadores > 1}">
					<span>Multijugador</span>
					<p>${datosVideojuego.cantidadJugadores}jugadores</p>
				</c:if>
				<c:if test="${datosVideojuego.cantidadJugadores == 1}">
					<span>Un jugador</span>
				</c:if>
				<strong>Desarrollador</strong>
				<p>${datosVideojuego.desarrollador}</p>
				<strong>Duración</strong>
				<p>${datosVideojuego.duracion}Horas</p>
			</div>
		</div>
		<c:if
			test="${datosVideojuego.requisitosMinimos != null && datosVideojuego.requisitosRecomendados != null}">
			<div class="contenedor-requisitos">
				<h3>Requisitos del sistema</h3>
				<div class="requisitos">
					<div class="requisito">
						<h4>Mínimos</h4>
						<p>${datosVideojuego.requisitosMinimos}</p>
					</div>
					<div class="requisito">
						<h4>Recomendados</h4>
						<p>${datosVideojuego.requisitosRecomendados}</p>
					</div>
				</div>
			</div>
		</c:if>
		<div class="reviews">
			<h3>Reviews</h3>
			<c:if test="${usuarioActual != null}">
				<form:form action="registrarReviewVideojuego" method="POST"
					modelAttribute="datosReview">
					<form:textarea path="descripcion"
						placeholder="Escribe tu reseña sobre el videojuego" />
					<form:input path="videojuego.id" type="hidden"
						value="${datosVideojuego.id}" />
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
	</main>
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