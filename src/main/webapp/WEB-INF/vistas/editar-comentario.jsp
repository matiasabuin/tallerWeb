<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Comentario | ${comentario.usuario.nombre}</title>
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

				<!-- COMENTARIO -->
				<div class="comentario" style="border-bottom: none;">
					<a href="perfil?id=${comentario.review.usuario.id}"><img
						style="width: 150px; height: 150px;"
						src="images/${comentario.review.usuario.foto}"></a>

					<div class="descripcion">
						<a href="perfil?id=${comentario.review.usuario.id}"><h4>Review de ${comentario.review.usuario.nombre}</h4></a>
						<h5>Tu comentario:</h5>
						<c:if test="${usuarioActual.id == comentario.usuario.id}">
							<form:form action="editar-comentario" method="POST"
								modelAttribute="comentario">
								<form:input path="id" value="${comentario.id}" type="hidden" />
								<form:input path="usuario.id" value="${comentario.usuario.id}"
									type="hidden" />
								<form:input path="review.id" value="${comentario.review.id}"
									type="hidden" />
								<form:textarea path="descripcion" value="${comentario.descripcion}"/>
								<form:button type="submit"
									class="btn btn-primary button-agregarfavs"
									style="margin-top: 1em;">Actualizar</form:button>
							</form:form>
						</c:if>
					</div>
				</div>
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