<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>${datosVideojuego.nombre}</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
								<a class="dropdown-item" href="registro-peli-serie">Pelicula</a> <a
									class="dropdown-item" href="registro-peli-serie">Serie</a> <a
									class="dropdown-item" href="registro-videojuego">VideoJuego</a>
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
			<div class="centro" style="width: 50%;">
				<h2>${datosVideojuego.nombre}</h2>
				<p class="sinopsis">${datosVideojuego.sinopsis}</p>
				<strong>Fecha de lanzamiento</strong>
				<p>${datosVideojuego.poster}</p>
				<p>${datosVideojuego.fechaEstreno}</p>
				<strong>Duración</strong>
				<p>${datosVideojuego.duracion}</p>
				<strong>Desarrollador</strong>
				<p>${datosVideojuego.desarrollador}</p>
			</div>
			<div style="width: 25%;">
				<strong>Genero</strong>
				<c:forEach var="genero" items="${datosVideojuego.generos}">
					<p>${genero.descripcion}</p>
				</c:forEach>
				<strong>Plataforma</strong> <strong>Modalidad</strong>
				<c:if test="${datosVideojuego.cantidadJugadores > 1}">
					<span>Multijugador</span>
					<p>${datosVideojuego.cantidadJugadores}jugadores</p>
				</c:if>
				<c:if test="${datosVideojuego.cantidadJugadores == 1}">
					<span>Un jugador</span>
				</c:if>
			</div>
		</div>
		<div class="contenedor-requisitos">
			<h3>Requisitos del sistema</h3>
			<div class="requisitos">
				<div class="requisito">
					<h4>Mínimos</h4>
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