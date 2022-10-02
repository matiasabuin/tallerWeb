<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/perfil-videojuego.css" />
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
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item mx-2"><a class="nav-link" href="perfil">Perfil</a></li>
						<li class="nav-item mx-2 dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> MiPerfil </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Pelis</a> <a
									class="dropdown-item" href="#">Series</a> <a
									class="dropdown-item" href="#">VideoJuegos</a>
							</div></li>
					</ul>
					<a class="navbar-brand" href="#">Logo</a>
				</div>
			</div>
		</nav>
	</header>
	<main>
		<div class="container">
			<div class="portada">
				<div style="text-align: center;">
					<img
						src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4ocq.jpg">
				</div>
			</div>
			<div class="centro">
				<h2>${datosVideojuego.nombre}</h2>
				<p class="sinopsis">${datosVideojuego.sinopsis}</p>
				<strong>Fecha de lanzamiento</strong>
				<p>${datosVideojuego.imagen}</p>
				<p>${datosVideojuego.fechaEstreno}</p>
				<strong>Duraci�n</strong>
				<p>${datosVideojuego.duracion}</p>
				<strong>Desarrollador</strong>
				<p>${datosVideojuego.desarrollador}</p>
			</div>
			<div>
				<strong>Genero</strong>
				<c:forEach var="genero" items="${datosVideojuego.generos}">
				<p>${genero.descripcion}</p>
				</c:forEach>
				<strong>Plataforma</strong>
				<!--<c:forEach var="plataforma" items="${datosVideojuego.plataformas}">
				<p>${plataforma.descripcion}</p>
				</c:forEach>-->
				<strong>Modalidad</strong>
				<p>${datosVideojuego.cantidadJugadores}</p>

			</div>
		</div>
		<div class="contenedor-requisitos">
			<h3>Requisitos del sistema</h3>
			<div class="requisitos">
				<div class="requisito">
					<h4>M�nimos</h4>
					<p>${datosVideojuego.requisitosMinimos}</p>
				</div>
				<div class="requisito">
					<h4>Recomendados</h4>
					<p>${datosVideojuego.requisitosRecomendados}</p>
				</div>
			</div>
		</div>
		<div class="reviews">
			<h3>Reviews</h3>
		</div>
	</main>
</body>
</html>