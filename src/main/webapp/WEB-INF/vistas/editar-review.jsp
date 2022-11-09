<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<div style="margin-top: 6em;">

				<!-- REVIEW -->
				<c:if test="${review.pelicula != null}">
					<div class="comentario" style="border-bottom: none;">
						<a href="perfil-pelicula?id=${review.pelicula.id}"><img
							style="width: 200px; height: 300px;"
							src="images/${review.pelicula.poster}"></a>

						<div class="descripcion">
							<h3>${review.pelicula.nombre}</h3>
							<h4>${review.usuario.nombre}</h4>
							<c:if test="${usuarioActual.id == review.usuario.id}">
								<form:form action="editar-review" method="POST"
									modelAttribute="review">
									<form:input path="id" value="${review.id}" type="hidden" />
									<form:input path="usuario.id" value="${review.usuario.id}"
										type="hidden" />
									<form:input path="videojuego.id" value="${review.pelicula.id}"
										type="hidden" />
									<form:textarea path="descripcion" value="${review.descripcion}" />
									<form:button type="submit"
										class="btn btn-primary button-agregarfavs"
										style="margin-top: 1em;">Actualizar</form:button>
								</form:form>
							</c:if>
						</div>
					</div>
				</c:if>

				<c:if test="${review.videojuego != null}">
					<div class="comentario" style="border-bottom: none;">
						<a href="perfil-pelicula?id=${review.videojuego.id}"><img
							style="width: 200px; height: 300px;"
							src="images/${review.videojuego.poster}"></a>

						<div class="descripcion">
							<h3>${review.videojuego.nombre}</h3>
							<h4>${review.usuario.nombre}</h4>
							<c:if test="${usuarioActual.id == review.usuario.id}">
								<form:form action="editar-review" method="POST"
									modelAttribute="review">
									<form:input path="id" value="${review.id}" type="hidden" />
									<form:input path="usuario.id" value="${review.usuario.id}"
										type="hidden" />
									<form:input path="videojuego.id"
										value="${review.videojuego.id}" type="hidden" />
									<form:textarea path="descripcion" value="${review.descripcion}" />
									<form:button type="submit"
										class="btn btn-primary button-agregarfavs"
										style="margin-top: 1em;">Actualizar</form:button>
								</form:form>
							</c:if>
						</div>
					</div>
				</c:if>

				<c:if test="${review.serie!= null}">
					<div class="comentario" style="border-bottom: none;">
						<a href="perfil-pelicula?id=${review.serie.id}"><img
							style="width: 200px; height: 300px;"
							src="images/${review.serie.poster}"></a>

						<div class="descripcion">
							<h3>${review.serie.nombre}</h3>
							<h4>${review.usuario.nombre}</h4>
							<c:if test="${usuarioActual.id == review.usuario.id}">
								<form:form action="editar-review" method="POST"
									modelAttribute="review">
									<form:input path="id" value="${review.id}" type="hidden" />
									<form:input path="usuario.id" value="${review.usuario.id}"
										type="hidden" />
									<form:input path="videojuego.id" value="${review.serie.id}"
										type="hidden" />
									<form:textarea path="descripcion" class="edit-desc"
										value="${review.descripcion}" />
									<form:button type="submit"
										class="btn btn-primary button-agregarfavs"
										style="margin-top: 1em;">Actualizar</form:button>
								</form:form>
							</c:if>
						</div>
					</div>
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