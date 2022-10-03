<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar videojuego</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/registro-videojuego.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">
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
		
						<li class="nav-item mx-2 dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> ${usuarioActual.nombre} </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="perfil">Perfil</a> <a
									class="dropdown-item" href="login">Log Out</a>
							</div></li>
							
						<li class="nav-item mx-2 dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Registrar </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="registro-peli-serie">Pelicula</a>
								<a class="dropdown-item" href="registro-peli-serie">Serie</a> <a
									class="dropdown-item" href="registro-videojuego">VideoJuego</a>
							</div></li>
					</ul>

					<a class="navbar-brand" href="#">Logo</a>

				</div>

			</div>
		</nav>
	</header>
	<main>
		<h2>REGISTRO VIDEOJUEGO</h2>
		<section class="formulario">
			<form:form action="registrar-videojuego" method="POST"
				modelAttribute="datosVideojuego">
				<div class="container">
					<div class="left">
						<div class="detalle">
							<h3>Detalle</h3>

							<form:label path="imagen">Portada</form:label>
							<form:input path="imagen" type="file" name="file"/>

							<form:label path="fechaEstreno">Fecha de lanzamiento</form:label>
							<form:input path="fechaEstreno" type="date" id="fechaEstreno" />

							<form:label path="duracion">Duracion</form:label>
							<form:input path="duracion" type="number" id="duracion" min="1" style="width: 30%;" />
							<span style="display: inline; margin-left: 1em;">Horas</span>
						</div>
					</div>
					<div class="right">
						<div class="campos">
							<h3>Caracteristicas</h3>
							<div class="separacion">
								<div>
									<form:label path="nombre">Nombre</form:label>
									<form:input path="nombre" type="text" id="nombre" />

									<form:label path="desarrollador">Desarrollador</form:label>
									<form:input path="desarrollador" type="text" id="desarrollador" />

									<form:label path="cantidadJugadores">Cantidad de jugadores</form:label>
									<form:input path="cantidadJugadores" type="number" id="cantidadJugadores" min="1" />

								</div>

								<div style="margin-left: 4em;">
									<form:label path="generos">Genero</form:label>
									<form:select path="generos" id="generos" name="generos" multiple="multiple">
										<c:forEach var="genero" items="${listaGeneros}">
											<form:option value="${genero.id}" style="color: black;">${genero.descripcion}</form:option>
										</c:forEach>
									</form:select>
									<form:label path="plataformas">Plataforma</form:label>
									<form:select path="plataformas" id="plataformas"
										name="plataformas" multiple="multiple">
										<c:forEach var="plataforma" items="${listaPlataformas}">
											<form:option value="${plataforma.id}" style="color: black;">${plataforma.descripcion}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<div class="campos">
							<h3>Historia</h3>
							<form:label path="sinopsis">Sinopsis</form:label>
							<form:textarea path="sinopsis" id="sinopsis" style="width: 100%;"
								placeholder="Escribe algo aqui" maxlength="1000" />
						</div>

						<div class="campos ">
							<h3>Requisitos del sistema</h3>
							<div class="requisitos">
								<div>
									<form:label path="requisitosMinimos">Mínimo</form:label>
									<form:textarea path="requisitosMinimos" id="requisitosMinimos"
										placeholder="Escribe algo aqui" />
								</div>
								<div>
									<form:label path="requisitosRecomendados">Recomendado</form:label>
									<form:textarea path="requisitosRecomendados"
										id="requisitosRecomendados" placeholder="Escribe algo aqui" />
								</div>
							</div>
						</div>
						<div>
							<form:button type="submit">Registrar</form:button>
						</div>
					</div>
				</div>
			</form:form>
		</section>
	</main>
	<footer class="footer">
		<div class="container">
			<div class="column1">
				<h4 class="mx-2">Redes Sociales</h4>
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
			© 2022 Copyright: <a class="enlaceDeCopy" href="/">
				PaginaGenericaDeTaller.com</a>
		</div>
		<!-- Copyright -->
	</footer>
	<script
		src="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/js/multi-select-tag.js"></script>
	<script>
		new MultiSelectTag('generos')
	</script>
	<script>
		new MultiSelectTag('plataformas')
	</script>
</body>
</html>

<!-- Nombre: Texto de 50 caracteres máximo.
Duración en minutos: Número entero.
Desarrollador: Texto de 50 caracteres máximo.
Género:  Texto de 50 caracteres máximo.
Plataforma en la que se encuentra disponible:  Texto de 20 caracteres máximo.
Fecha de estreno: Fecha.
Sinopsis: Texto libre de máximo 240 caracteres.
Requisitos mínimos: Texto libre de máximo 240 caracteres.
Requisitos recomendados: Texto libre de máximo 240 caracteres.
Cantidad de jugadores: Número entero.-->
