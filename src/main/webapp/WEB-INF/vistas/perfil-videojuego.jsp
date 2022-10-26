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
<script src="https://kit.fontawesome.com/ed06e9b771.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<!-- IMPORT HEADER -->
	<jsp:include page="header.jsp" />

	<main>

		<!-- PORTADA DE VIDEOJUEGO -->
		<div class="container">
			<div class="portada">
				<div style="text-align: center;">
					<img src="images/${datosVideojuego.poster}"><br>

					<!-- REDIRIGIR A LOGIN -->
					<c:if test="${usuarioActual == null}">
						<div class="sesion">
							<a href="login">Inicia Sesion</a><span> para dejar una
								rese&ntilde;a</span>
						</div>
					</c:if>

					<!-- BOTON AGREGAR A FAVS -->
					<c:if test="${usuarioActual != null}">
						<form:form action="guardarFavVideojuego" method="POST"
							modelAttribute="datosLista">
							<form:input path="videojuego.id" type="hidden"
								value="${datosVideojuego.id}" />
							<form:input path="usuario.id" type="hidden"
								value="${usuarioActual.id}" />
							<c:set var="eliminar" value="NoEstaEnFavs" />
							<c:forEach var="favoritos" items="${listaFavs}">
								<c:if
									test="${favoritos.videojuego != null && favoritos.videojuego.id == datosVideojuego.id}">
									<a href="eliminar-Fav?id=${favoritos.id}"><button
											type="button" class="btn btn-primary button-agregarfavs mt-4">
											Eliminar <i class="fa-solid fa-heart-crack ml-1"
												aria-hidden="true"></i>
										</button> </a>
									<c:set var="eliminar" value="EstaEnFavs" />
								</c:if>
							</c:forEach>
							<c:if test="${eliminar == 'NoEstaEnFavs'}">
								<form:button type="submit"
									class="btn btn-primary button-agregarfavs mt-4">Agregar <i
										class="fa-solid fa-heart" aria-hidden="true"></i>
								</form:button>
							</c:if>
						</form:form>
					</c:if>

					<!-- BOTON VER REVIEW DEL USUARIO -->
					<c:if
						test="${usuarioActual != null && datosReview.usuario.id == usuarioActual.id}">
						<a href="review?id=${datosReview.id}"
							class="btn btn-primary button-agregarfavs mt-4">Mi review <i
							class="fa fa-comment" aria-hidden="true"></i></a>
					</c:if>
				</div>
			</div>

			<!-- INFORMACION PRINCIPAL DE VIDEOJUEGO -->
			<div class="centro" style="width: 50%;">
				<h2>${datosVideojuego.nombre}</h2>
				<strong>Fecha de lanzamiento</strong>
				<p>${datosVideojuego.fechaEstreno}</p>
				<p class="sinopsis">${datosVideojuego.sinopsis}</p>
			</div>

			<!-- INFORMACION ADICIONAL DE VIDEOJUEGO -->
			<div>
				<strong>Generos</strong>
				<c:forEach var="genero" items="${datosVideojuego.generos}">
					<p class="genero">${genero.descripcion}</p>
				</c:forEach>
				<strong>Plataformas</strong>
				<c:forEach var="plataforma" items="${datosVideojuego.plataformas}">
					<p class="plataforma">${plataforma.descripcion}</p>
				</c:forEach>
				<strong>Modalidad</strong>
				<c:if test="${datosVideojuego.cantidadJugadores > 1}">
					<span>Multijugador</span>
					<p>${datosVideojuego.cantidadJugadores}&nbsp;jugadores</p>
				</c:if>
				<c:if test="${datosVideojuego.cantidadJugadores == 1}">
					<p>Un jugador</p>
				</c:if>
				<strong>Desarrollador</strong>
				<p>${datosVideojuego.desarrollador}</p>
				<strong>Duración</strong>
				<p>${datosVideojuego.duracion}&nbsp;Horas</p>
			</div>
		</div>

		<!-- REQUISITOS DE VIDEOJUEGO PARA PC -->
		<!--<c:if test="${datosVideojuego.requisitosMinimos != null && datosVideojuego.requisitosRecomendados != null}">
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
		</c:if>-->

		<!-- GESTION DE REVIEWS -->
		<div class="reviews">
			<h3>Reviews</h3>

			<c:if test="${usuarioActual != null && datosReview.usuario == null}">
				<form:form action="registrarReviewVideojuego" method="POST"
					modelAttribute="datosReview">
					<form:textarea path="descripcion"
						placeholder="Escribe tu reseña sobre el videojuego" />
					<form:input path="videojuego.id" type="hidden"
						value="${datosVideojuego.id}" />
					<form:input path="usuario.id" type="hidden"
						value="${usuarioActual.id}" />
					<form:button type="submit" class="btn btn-primary button-reviews">Enviar</form:button>
				</form:form>
			</c:if>

			<c:if test="${listaReviews != null}">
				<c:forEach var="review" items="${listaReviews}">
					<div class="comentario">
						<img src="images/${review.usuario.foto}">
						<div class="datosreview">
							<h4>${review.usuario.nombre}</h4>
							<p>${review.descripcion}</p>
							<div class="vistareview">
								<c:if
									test="${usuarioActual != null && usuarioActual.id != review.usuario.id}">
									<a href="review?id=${review.id}">Responder</a>
								</c:if>
								<a href="review?id=${review.id}">Ver review</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>

			<c:if test="${listaReviews[0] == null}">
				<h5>No hay reviews por ahora</h5>
			</c:if>
		</div>
	</main>

	<!-- IMPORT DE FOOTER -->
	<jsp:include page="footer.jsp" />

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