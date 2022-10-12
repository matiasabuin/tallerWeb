<%@page import="ar.edu.unlam.tallerweb1.domain.pedidos.Genero"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registrar videojuego</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/registro-videojuego.css" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">

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

						<li class="nav-item mx-2"><a class="nav-link" href="home">Inicio
						</a></li>

						<c:if test="${usuarioActual.nombre != null}">
							<li class="nav-item mx-2 dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> ${usuarioActual.nombre} </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="perfil">Perfil</a> <a
										class="dropdown-item" href="cerrar-sesion">Cerrar sesion</a>
								</div></li>

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

					<c:if test="${usuarioActual.nombre == null}">
						<a href="registro-usuario" class="nav-link">Register</a>
						<a href="login" class="nav-link">Log In</a>
					</c:if>

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

							<form:label path="poster">Portada</form:label>
							<form:input path="poster" type="file" id="poster" name="poster" />

							<form:label path="fechaEstreno">Fecha de lanzamiento</form:label>
							<form:input path="fechaEstreno" type="date" id="fechaEstreno" />

							<form:label path="duracion">Duracion</form:label>
							<form:input path="duracion" type="number" id="duracion" min="1"
								style="width: 30%;" />
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
									<form:input path="cantidadJugadores" type="number"
										id="cantidadJugadores" min="1" />

								</div>

								<div style="margin-left: 4em;">
									<form:label path="generos">Genero</form:label>
									<form:select path="generos" multiple="multiple" items="${listaGeneros}" itemLabel="descripcion" itemValue="id"/>

									<form:label path="plataformas">Plataforma</form:label>
									<form:select path="plataformas"  multiple="multiple" items="${listaPlataformas}" itemLabel="descripcion" itemValue="id"/>
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
										placeholder="Escribe algo aqui (opcional)" />
								</div>
								<div>
									<form:label path="requisitosRecomendados">Recomendado</form:label>
									<form:textarea path="requisitosRecomendados"
										id="requisitosRecomendados"
										placeholder="Escribe algo aqui (opcional)" />
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
	<script
		src="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/js/multi-select-tag.js"></script>
	<script>
		new MultiSelectTag('generos')
	</script>
	<script>
		new MultiSelectTag('plataformas')
	</script>
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
