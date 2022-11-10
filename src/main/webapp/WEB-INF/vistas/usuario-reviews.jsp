<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Reviews | ${usuario.nombre}</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/perfilUsuario.css">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>

<body>

	<!-- IMPORT HEADER -->
	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="usuario-container">
		
			<h3 style="text-align: center;">	
				<c:choose>
				    <c:when test="${usuario.id == usuarioActual.id}">
				        Mis reviews
				        <br />
				    </c:when>    
				    <c:otherwise>
				        Reviews de ${usuario.nombre}
				        <br />
				    </c:otherwise>
				</c:choose>
			</h3>
						
			<div>

				<!-- LISTADO DE REVIEWS VACIA-->

				<c:if test="${listaReviews.isEmpty() == true}">
					<div class="comentario">
						<h1 class="text-center">Todavía no hay reviews</h1>
					</div>
				</c:if>

				<!-- LISTADO DE REVIEWS -->
				<c:forEach var="review" items="${listaReviews}">

					<!-- REVIEW PELICULA -->
					<c:if test="${review.pelicula != null}">
						<div class="comentario">
							<a href="perfil-pelicula?id=${review.pelicula.id}"><img
								style="width: 160px" src="images/${review.pelicula.poster}"></a>

							<div class="descripcion">
							<a class="tituloReview" href="perfil-pelicula?id=${review.pelicula.id}">
								<h4>${review.pelicula.nombre}</h4></a>
								<h4>★: ${review.calificacion} / 5.0</h4>
								<p>${review.descripcion}</p>
								<div class="botones">
									<a href="review?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Ver</a>
										<c:if test="${usuarioActual.id == review.usuario.id}"> 
										<a href="review-editar?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Editar</a> <a
										href="eliminar-review?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Eliminar</a>
										</c:if>
								</div>
							</div>
						</div>
					</c:if>

					<!-- REVIEW VIDEOJUEGO -->
					<c:if test="${review.videojuego != null}">
						<div class="comentario">
							<a href="videojuego?id=${review.videojuego.id}"><img
								style="width: 160px" src="images/${review.videojuego.poster}"></a>
							<div class="descripcion">
							<a class="tituloReview" href="perfil-videojuego?id=${review.videojuego.id}">
								<h4>${review.videojuego.nombre}</h4></a>
								<h4>★: ${review.calificacion} / 5.0</h4>
								<p>${review.descripcion}</p>
								<div class="botones">
									<a href="review?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Ver</a>
										<c:if test="${usuarioActual.id == review.usuario.id}"> 
										<a href="review-editar?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Editar</a> <a
										href="eliminar-review?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Eliminar</a>
										</c:if>
								</div>
							</div>
						</div>
					</c:if>

					<!-- REVIEW SERIE -->
					<c:if test="${review.serie != null}">
						<div class="comentario">
							<a href="perfil-serie?id=${review.serie.id}"><img
								style="width: 160px" src="images/${review.serie.poster}"></a>
							<div class="descripcion">
							<a class="tituloReview" href="perfil-serie?id=${review.serie.id}">
								<h4>${review.serie.nombre}</h4></a>
								<h4>★: ${review.calificacion} / 5.0</h4>
								<p>${review.descripcion}</p>
								<div class="botones">
									<a href="review?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Ver</a>
										<c:if test="${usuarioActual.id == review.usuario.id}"> 
										<a href="review-editar?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Editar</a> <a
										href="eliminar-review?id=${review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Eliminar</a>
										</c:if>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- IMPORT FOOTER -->
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