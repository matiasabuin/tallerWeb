<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${datosVideojuego.nombre}</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/perfil-videojuego.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
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
		<section class="portada">
			<img src="https://cdn.akamai.steamstatic.com/steam/apps/1593500/ss_8db3de5b5d611e50945268848de2889e1ed4ba84.600x338.jpg?t=1650554420">
		</section>
		<section>
		<h2>${datosVideojuego.nombre}</h2>
		</section>
		<section class="container">
			<article class="galeria">
				<img src="https://cdn.akamai.steamstatic.com/steam/apps/1593500/ss_6eccc970b5de2943546d93d319be1b5c0618f21b.600x338.jpg?t=1650554420">
			</article>
			<article>
				<img src="https://cdn.akamai.steamstatic.com/steam/apps/1593500/header.jpg?t=1650554420">
				<p class="sinopsis">${datosVideojuego.sinopsis}</p>
				<strong>Fecha de lanzamiento</strong><p>${datosVideojuego.fechaEstreno}</p>
				<strong>Desarrollador</strong><p>${datosVideojuego.desarrollador}</p>
				<strong>Genero</strong><p>${datosVideojuego.genero}</p>
			</article>
		</section>
	</main>
</body>
</html>