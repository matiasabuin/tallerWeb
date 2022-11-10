<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Comentarios | ${usuario.nombre}</title>
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
			<h3 style="text-align: center;">Comentarios de ${usuario.nombre}</h3>
			<div>

				<!-- LISTADO DE COMENTARIOS VACIA-->
				<c:if test="${listaComentarios.isEmpty() == true}">
					<div class="comentario">
						<h1 class="text-center">No hay comentarios</h1>
					</div>
				</c:if>

				<!-- LISTADO DE COMENTARIOS -->
				<c:forEach var="comentario" items="${listaComentarios}">

					<!-- REVIEW VIDEOJUEGO -->
						<div class="comentario">
							<a href="perfil?id=${comentario.review.usuario.id}"><img
								style="width: 100px; height: 100px;" src="images/${comentario.review.usuario.foto}"></a>

							<div class="descripcion">
								<h4>Review de <a href="perfil?id=${comentario.review.usuario.id}">${comentario.review.usuario.nombre}</a></h4>
								<p>${comentario.descripcion}</p>
								<div class="botones">
									<a href="review?id=${comentario.review.id}"
										class="btn btn-primary button-agregarfavs mt-4">Ver review</a>
										<c:if test="${usuarioActual.id == comentario.usuario.id}"> 
										<a href="comentario-editar?id=${comentario.id}"
										class="btn btn-primary button-agregarfavs mt-4">Editar</a> <a
										href="eliminar-comentario?id=${comentario.id}"
										class="btn btn-primary button-agregarfavs mt-4">Eliminar</a>
										</c:if>
								</div>
							</div>
						</div>
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