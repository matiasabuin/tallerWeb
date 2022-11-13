<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${datosSerie.nombre}</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/perfil-serie.css" />
<link rel="stylesheet" href="css/estrellas.css" />
<script src="https://kit.fontawesome.com/ed06e9b771.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<!-- IMPORT HEADER -->
	<jsp:include page="header.jsp" />

	<!-- PORTADA DE SERIE -->
	<div class="fsv-page-wrapper">
		<div class="container contenedor">
			<section class="datos">
				<div style="text-align: center;">
					<img src="images/${datosSerie.poster}">
<br>

					<!-- REDIRIGIR A LOGIN -->
					<c:if test="${usuarioActual == null}">
						<div class="sesion">
							<a href="login">Inicia Sesion</a><span> para interactuar con la comunidad</span>
						</div>
					</c:if>

					<!-- BOTON AGREGAR A FAVS -->
					<c:if test="${usuarioActual != null}">
						<form:form action="guardarFavSerie" method="POST"
							modelAttribute="datosLista">
							<form:input path="serie.id" type="hidden"
								value="${datosSerie.id}" />
							<form:input path="usuario.id" type="hidden"
								value="${usuarioActual.id}" />
							<c:set var="eliminar" value="NoEstaEnFavs" />
							<c:forEach var="favoritos" items="${listaFavs}">
								<c:if
									test="${favoritos.serie != null && favoritos.serie.id == datosSerie.id}">
									<a href="eliminar-Fav?id=${favoritos.id}"><button
											type="button" class="btn btn-primary button-agregarfavs">
											Eliminar <i class="fa-solid fa-heart-crack ml-1"
												aria-hidden="true"></i>
										</button> </a>
									<c:set var="eliminar" value="EstaEnFavs" />
								</c:if>

							</c:forEach>
							<c:if test="${eliminar == 'NoEstaEnFavs'}">
								<form:button type="submit"
									class="btn btn-primary button-agregarfavs">Agregar <i
										class="fa-solid fa-heart" aria-hidden="true"></i>
								</form:button>
							</c:if>
						</form:form>
					</c:if>

					<!-- BOTON VER REVIEW DEL USUARIO -->
					<c:if
						test="${usuarioActual != null && datosReview.usuario.id == usuarioActual.id}">
						<a href="review?id=${datosReview.id}"
							class="btn btn-primary button-agregarfavs">Mi review <i
							class="fa fa-comment" aria-hidden="true"></i></a>
					</c:if>
				</div>

				<!-- INFORMACION PRINCIPAL DE SERIE -->
				<div style="margin-left: 2em;">
					<h2>${datosSerie.nombre}</h2>
					
					<h4 class ="pl-0">★: 
						<c:choose>
						    <c:when test="${datosSerie.calificacion == 'NaN'}">
						        No hay calificaciones suficientes
						        <br />
						    </c:when>    
						    <c:otherwise>
						        ${datosSerie.calificacion} / 5.0
						        <br />
						    </c:otherwise>
						</c:choose>
					</h4>
					
					<p>Cantidad de Temporadas:&nbsp;${datosSerie.cantDeTemps}</p>
					<p>Fecha de estreno:&nbsp;${datosSerie.fechaEstreno}</p>
					<p class="align-self-center sinopsis">${datosSerie.sinopsis}</p>
					<p class="col-4 text-center border rounded">Cantidad de
						capitulos:&nbsp;${datosSerie.cantDeCaps}&nbsp;</p>
					<p class="col-4 text-center border rounded">Duracion por
						capitulo:&nbsp;${datosSerie.duracionPorCaps}&nbsp;minutos</p>

					<strong class="items">Generos</strong>
					<div style="margin: 5px 0em;">
						<c:forEach var="genero" items="${datosSerie.generos}">
							<p class="genero">${genero.descripcion}</p>
						</c:forEach>
					</div>

					<strong class="items">Plataformas</strong>
					<div style="margin: 5px 0em;">
						<c:forEach var="plataforma" items="${datosSerie.plataformas}">
							<p class="plataforma">${plataforma.descripcion}</p>
						</c:forEach>
					</div>
				</div>
			</section>

			<!-- GESTION DE REVIEWS -->
			<section>
				<div class="reviews">
					<h3>Reviews</h3>
					<c:if
						test="${usuarioActual != null && datosReview.usuario == null && usuarioActual.planAdquirido.plan.descripcion != 'Free'}">
						<form:form action="registrarReviewSerie" method="POST"
							modelAttribute="datosReview">
							  <p class="align-items-center mb-0">Calificacion: </p>
									
							  <div class="rate align-items-center mt-0">
							    <form:radiobutton  path="calificacion" id="star5" name="rate" value="5" />
							    <form:label path="calificacion" for="star5" title="text"></form:label>
							    <form:radiobutton  path="calificacion"  id="star4" name="rate" value="4" />
							    <form:label path="calificacion" for="star4" title="text"></form:label>
							    <form:radiobutton  path="calificacion" id="star3" name="rate" value="3" />
							    <form:label path="calificacion" for="star3" title="text"></form:label>
							    <form:radiobutton  path="calificacion" id="star2" name="rate" value="2" />
							    <form:label path="calificacion" for="star2" title="text"></form:label>
							    <form:radiobutton  path="calificacion" id="star1" name="rate" value="1" />
							    <form:label path="calificacion" for="star1" title="text"></form:label>
							  </div>
							  <br>
							<form:textarea path="descripcion"
								placeholder="Escribe tu reseña sobre la serie" />
							<form:input path="serie.id" type="hidden"
								value="${datosSerie.id}" />
							<form:input path="usuario.id" type="hidden"
								value="${usuarioActual.id}" />
							<form:button type="submit" class="btn btn-primary button-reviews">Enviar</form:button>
						</form:form>
					</c:if>

					<c:if test="${listaReviews != null}">
						<c:forEach var="review" items="${listaReviews}">
							<div class="comentario">
							<a href ="perfil?id=${review.usuario.id}">
								<img src="images/${review.usuario.foto}"></a>
								<div class="datosreview">
								<a href ="perfil?id=${review.usuario.id}">
									<h4>${review.usuario.nombre}</h4>
									</a>
									<h4 class="mb-0">★: ${review.calificacion} / 5.0</h4>
									<p class="mt-0 pt-0">${review.descripcion}</p>
							<div class="vistareview">
								<a href="review?id=${review.id}"><i
									class="fa-solid fa-comment ml-1" aria-hidden="true">&nbsp;${review.comentarios.size()}</i>
								</a>
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