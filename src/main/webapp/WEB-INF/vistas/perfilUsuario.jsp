<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Registrar-peli-serie</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/estilos.css" />

<link href="css/styles.css" rel="stylesheet">

<link rel="stylesheet" href="css/perfilUsuario.css">

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
						<li class="nav-item mx-2"><a class="nav-link" href="perfil"><%=session.getAttribute("usuarioActual")%></a></li>
						<li class="nav-item mx-2 dropdown"><a
							class="nav-link dropdown-toggle" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Registrar</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="registro-peli-serie">Pelicula</a> <a
									class="dropdown-item" href="registro-peli-serie">Serie</a> <a
									class="dropdown-item" href="registro-videojuego">VideoJuego</a>
							</div></li>
					</ul>

					<a class="navbar-brand" href="#">Logo</a>

					<%-- <%=session.getAttribute("usuarios")%> --%>

				</div>

			</div>
		</nav>
	</header>

	<main>
		<section class="perfil">
			<article class="usuario">
				<img
					src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4tt2.jpg"
					alt="favorito1" alt="foto-usuario" class="foto-usuario">
				<h2><%=session.getAttribute("usuarioActual")%></h2>
			</article>
			<article class="favoritos">
			<h3>FAVORITOS</h3>
				<div class="cards">
				<a><img src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4tt2.jpg" alt="favorito1"><img></a>
				<a><img src="https://images.igdb.com/igdb/image/upload/t_cover_big/co1rbu.jpg" alt="favorito2"><img></a>
				<a><img src="https://images.igdb.com/igdb/image/upload/t_cover_big/co1tmu.jpg" alt="favorito3"><img></a>
			    <a><img	src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.jpg" alt="favorito4"><img></a>
				<a><img	src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4z2i.jpg" alt="favorito5"><img></a>
				</div>
			</article>
		</section>

		<section class="reciente">
			<h3>VISTO RECIENTEMENTE</h3>
			<article class="cards">
			
				<a><img src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4tt2.jpg" alt="favorito1"><img></a>
				<a><img src="https://images.igdb.com/igdb/image/upload/t_cover_big/co1rbu.jpg" alt="favorito2"><img></a>
				<a><img src="https://images.igdb.com/igdb/image/upload/t_cover_big/co1tmu.jpg" alt="favorito3"><img></a>
			    <a><img	src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.jpg" alt="favorito4"><img></a>
				<a><img	src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4z2i.jpg" alt="favorito5"><img></a>
				
			</article>
		</section>

		<section class="comentario">
				<article class="portada">
					<img
						src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4tt2.jpg"
						alt="favorito1">
				</article>
				<article class="texto">
                    <h4>Stray</h4>
					<p>Stray ha llamado la atención por mostrarnos a un gato de protagonista, pero, más allá de su ternura, 
					es una historia convincente de cómo puede ser una sociedad sin humanos en el futuro. El pasado 19 de julio 
					llegó a mis manos uno de los juegos más esperados, por lo menos para mí, de este 2022.</p>
				</article>
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
</body>
</html>