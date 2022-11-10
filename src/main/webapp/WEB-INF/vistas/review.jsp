<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Review | ${review.usuario.nombre}</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/review-usuario.css">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>

<body>

	<!-- IMPORT HEADER -->
	<jsp:include page="header.jsp" />

	<div class="container top">
		<div>
			<h3 style="text-align: center;"></h3>
			<div>

				<!-- REVIEW PELICULA -->
				<c:if test="${review.pelicula != null}">
					<div class="comentario">
						<a href="perfil-pelicula?id=${review.pelicula.id}"><img
							style="width: 200px; height: 300px;"
							src="images/${review.pelicula.poster}"></a>

						<div class="descripcion">
							<h3>${review.pelicula.nombre}</h3>
							<div class="flex-review">
								<a href="perfil?id=${review.usuario.id}"> <img
									src="images/${review.usuario.foto}"></a>
								<div>
								<a href ="perfil?id=${review.usuario.id}">
									<h4>${review.usuario.nombre}</h4></a>
									<h4>★: ${review.calificacion} / 5.0</h4>
									<p>${review.descripcion}</p>
								</div>
							</div>
						</div>
					</div>
				</c:if>

				<!-- REVIEW VIDEOJUEGO -->
				<c:if test="${review.videojuego != null}">


					<div class="comentario">
						<a href="videojuego?id=${review.videojuego.id}"><img
							style="width: 200px; height: 300px;"
							src="images/${review.videojuego.poster}"></a>

						<div class="descripcion">
							<h3>${review.videojuego.nombre}</h3>
							<div class="flex-review">
								<a href="perfil?id=${review.usuario.id}"> <img
									src="images/${review.usuario.foto}"></a> <br>
								<div>
								<a href ="perfil?id=${review.usuario.id}">
									<h4>${review.usuario.nombre}</h4></a>
									<h4>★: ${review.calificacion} / 5.0</h4>
									<p>${review.descripcion}</p>
								</div>
							</div>
						</div>
					</div>
				</c:if>

				<!-- REVIEW SERIE -->
				<c:if test="${review.serie != null}">
					<div class="comentario">
						<a href="perfil-serie?id=${review.serie.id}"><img
							style="width: 200px; height: 300px;"
							src="images/${review.serie.poster}"></a>

						<div class="descripcion">
							<h3>${review.serie.nombre}</h3>
							<div class="flex-review">
								<a href="perfil?id=${review.usuario.id}"> <img
									src="images/${review.usuario.foto}"></a>
								<div>
								<a href ="perfil?id=${review.usuario.id}">
									<h4>${review.usuario.nombre}</h4></a>
									<h4>★: ${review.calificacion} / 5.0</h4>
									<p>${review.descripcion}</p>
								</div>
							</div>
						</div>
					</div>
				</c:if>

				<!-- FORMULARIO COMENTARIO -->
				<c:if
					test="${usuarioActual != null && usuarioActual.id != review.usuario.id}">
					<div class="container form-comentario">
						<form:form action="registrar-comentario"
							modelAttribute="comentario" method="POST">
							<form:input path="usuario.id" type="hidden"
								value="${usuarioActual.id}" />
							<form:input path="review.id" type="hidden" value="${review.id}" />
							<form:textarea path="descripcion"
								placeholder="Deja un comentario" style="margin: auto;"/>
							<form:button type="submit"
								class="btn btn-primary button-agregarfavs"
								style="margin-top: 1em;">Comentar</form:button>
						</form:form>
					</div>
				</c:if>

				<!-- LISTADO DE COMENTARIOS -->
				<c:if test="${listaComentarios != null}">
					<c:forEach var="comentario" items="${listaComentarios}">
						<div class="comentario-review">
						<a href ="perfil?id=${comentario.usuario.id}">
							<img src="images/${comentario.usuario.foto}"></a>
							<div class="datosreview">
							<a href ="perfil?id=${comentario.usuario.id}">
								<h4>${comentario.usuario.nombre}</h4></a>
								<p>${comentario.descripcion}</p>
								<c:if test="${usuarioActual.id == comentario.usuario.id}">
									<div class="botones">
										<a href="eliminar-comentario-review?id=${comentario.id}"
											class="btn btn-primary button-agregarfavs mt-4">Eliminar</a>
									</div>
								</c:if>
							</div>
						</div>
					</c:forEach>
				</c:if>

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