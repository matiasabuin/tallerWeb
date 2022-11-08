<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Plan</title>
<!-- Bootstrap core CSS -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/planes.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<script src="https://sdk.mercadopago.com/js/v2"></script>
</head>

<body>

	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="d-flex justify-content-between">

			<div class="recomendaciones-container plan-free">
				<h1>Plan Gratuito</h1>
				<p>
					&iexcl;Tienes acceso a la <strong>visualizaci�n </strong> de:
				</p>
				<ul>
					<li>Videojuegos</li>
					<li>Pel�culas</li>
					<li>Series</li>
				</ul>
				<p>
					Como as� tambien comentar y ver todas las <strong>Reviews</strong>
					de usuarios, y la funci�n de <strong>&iexcl;Mi Tiempo
						Libre!</strong>, donde podr�s ver una lista de pel�culas, series y
					videojuegos recomendados seg�n tu cantidad de horas libre!.
				</p>
				<br>
				<c:if
					test="${usuarioActual.planAdquirido.plan.descripcion == 'Free'}">
					<button class="activo-free">Plan activo</button>
				</c:if>
			</div>

			<div class="recomendaciones-container">
				<h1>Plan B�sico</h1>
				<p>
					&iexcl;<strong>Comenta</strong> tu opini�n sobre lo que viste!
				</p>
				<ul>
					<li>Registra una review de una pelicula, serie o videojuego
						que quieras y compartelo con los demas.</li>
				</ul>
				<p>
					Elige una <strong>foto de perfil</strong> que m�s te guste y
					s�bela.
				</p>

				<c:if
					test="${usuarioActual.planAdquirido.plan.descripcion != 'Basico' && usuarioActual.planAdquirido.plan.descripcion != 'Premium'}">
					<div class="text-center"><a href="${preferenceBasico.initPoint}" class="plan">Adquirir basico</a></div>
				</c:if>

				<c:if
					test="${usuarioActual.planAdquirido.plan.descripcion == 'Basico'}">
					<h2 class="activo">Plan activo</h2>
					<p class="vencimiento">
						<strong>Vence:</strong>
						${usuarioActual.planAdquirido.fechaVencimiento}
					</p>
				</c:if>
			</div>

			<div class="recomendaciones-container">
				<h1>Plan Premium</h1>
				<p>
					<strong>Registra</strong> a nuestra pagina:
				</p>
				<ul>
					<li>Videojuegos</li>
					<li>Pel�culas</li>
					<li>Series</li>
				</ul>
				<p>&iexcl;Haz que los usuarios puedan disfrutar comentando y
					conociendo todo el contenido nuevo que agregaste!</p>

				<c:if
					test="${usuarioActual.planAdquirido.plan.descripcion != 'Basico' && usuarioActual.planAdquirido.plan.descripcion != 'Premium'}">
					<div class="text-center"><a href="${preferencePremium.initPoint}" class="plan">Adquirir premium</a></div>
				</c:if>

				<c:if
					test="${usuarioActual.planAdquirido.plan.descripcion == 'Premium'}">
					<h2 class="activo">Plan activo</h2>
					<p class="vencimiento">
						<strong>Vence:</strong>
						${usuarioActual.planAdquirido.fechaVencimiento}
					</p>
				</c:if>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

	<script src="js/script.js"></script>
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