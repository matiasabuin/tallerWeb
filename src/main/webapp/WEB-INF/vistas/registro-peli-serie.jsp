<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registrar contenido</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/estilos.css" />

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

	<div class="container">
		<form:form action="registrar-pelicula" method="POST"
			class="formulario-registro rounded" modelAttribute="datosPelicula">
			<div class="form-group row">
				<p class="col-md-6">REGISTRO</p>
				<label for="exampleFormControlSelect1"
					class="col-md-1 col-form-label tipo">TIPO</label>
				<div class="col-sm-auto">
					<select class="form-control" id="exampleFormControlSelect1">
						<option>PELICULA</option>
						<option>SERIE</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="inputNombre">NOMBRE</label>
					<form:input path="nombre" type="text" class="form-control"
						id="inputNombre" placeholder="Nombre" />
					<br> <label for="inputDuracion">DURACION</label>
					<form:input path="duracion" type="number" class="form-control"
						id="inputDuracion" placeholder="128, 90" />
					<br> <label for="inputDirector">DIRECTOR</label>
					<form:input path="director" type="text" class="form-control"
						id="inputDirector" placeholder="Martin scorsese, John Carpenter" />
					<br> <label for="inputGenero">GENERO</label>
					<form:input path="genero" type="text" class="form-control"
						id="inputGenero" placeholder="Terror, thiller, drama" />
					<br> <label for="inputPlataforma">PLATAFORMA</label>
					<form:input path="plataforma" type="text" class="form-control"
						id="inputPlataforma" placeholder="Netflix, Disney+, HBO+" />
					<br> <label for="inputDate">FECHA DE ESTRENO</label>
					<form:input path="fechaEstreno" type="date" class="form-control"
						id="inputPlataforma"/>
					<br>

				
				</div>
				<div class="col-md-6 text-center">
					<label for="registro-poster">SUBIR EL POSTER</label> <br> <input
						type="file" id="registro-poster" accept="image/png, image/jpeg">
					<br> <br>
					<div class="marco-poster-registro mx-auto"></div>

				</div>

			</div>
			<div class="form-group col-md-10 mx-auto">
				<label for="exampleFormSinopsis">SINOPSIS</label>
				<form:textarea path="sinopsis" class="form-control"
					id="exampleFormControlTextarea1" rows="3" />
				</textarea>
			</div>

			<div class="col text-center mt-2">
				<button type="submit" class="btn btn-primary" />
				REGISTRAR
				</button>
			</div>
		</form:form>


	</div>
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