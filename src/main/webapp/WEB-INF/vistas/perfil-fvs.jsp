<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Perfil-Fvs</title>

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
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item mx-2"><a class="nav-link" href="perfil">Perfil</a></li>
						<li class="nav-item mx-2 dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> MiPerfil </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="perfil-fvs">Pelis</a> <a
									class="dropdown-item" href="perfil-fvs">Series</a> <a
									class="dropdown-item" href="perfil-fvs">VideoJuegos</a>
							</div></li>
					</ul>
					<a class="navbar-brand" href="#">Logo</a>
				</div>
			</div>
		</nav>
	</header>

	<div class="fsv-page-wrapper">
		<hr>
		<hr>
		<div class=container>
			<section class="poster-secction mx-3">
				<div class="row">
					<div class="col-2">
						<img
							src="https://i.pinimg.com/originals/39/43/0d/39430d3398d67493bddc0a549b673502.jpg"
							class="rounded" alt="perfil">
					</div>
					<div class="col align-self-start text-center ml-5">
						PSYCHO<br> <img
							src="https://t3.ftcdn.net/jpg/03/82/27/72/360_F_382277203_OnBiCfeANOzSCxvkkSdgICNMz98fHirV.jpg"
							alt="estrellitas">

					</div>
					<div class="col-5 align-self-center mx-2">�UNA NUEVA Y
						DIFERENTE EMOCI�N EN LA PANTALLA! Cuando Marion Crane, una
						empleada de una inmobiliaria, se da a la fuga con un fajo de
						billetes y la esperanza de empezar una nueva vida, acaba en el
						famoso Motel Bates, donde el gerente Norman Bates cuida de su
						madre confinada en casa. El lugar parece estrafalario, pero est�
						bien... hasta que Marion decide darse una ducha.</div>
				</div>
			</section>
			<hr>
			<section class="tags-secction mx-3">
				<div class="row">

					<div class="col-2 mx-2 text-center border rounded">
						<a href="!">Drama</a>
					</div>
					<div class="col-2 mx-2 text-center border rounded">
						<a href="!">Thriller</a>
					</div>
					<div class="col-2 mx-2 text-center border rounded">
						<a href="!">Horror</a>
					</div>
					<div class="col-4 mx-5 text-center border rounded">149 mins
						More at IMDB TMDB</div>
				</div>
				<hr>
			</section>

			<section class="reviews mx-3">
				<div class="row">
					<div class="col-12 gutter-right-1 mx-2 rounded">
						<p class="text-center font-weight-bold">REVIEWS</p>
					</div>
				</div>
			</section>
		</div>
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
			� 2022 Copyright: <a class="enlaceDeCopy" href="/">
				PaginaGenericaDeTaller.com</a>
		</div>
		<!-- Copyright -->
	</footer>


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