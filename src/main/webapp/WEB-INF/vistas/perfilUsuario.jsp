<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Sitio | AgustinNava</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/perfilUsuario.css">
</head>

<body>
	<header>
		<div class="flexbox-topnav">
			<a href="home">INICIO</a> 
			<a href="perfil">PERFIL</a> 
			<a href="">VISTA3</a> 
			<a href="">VISTA4</a> 
			<a class="logo" href="home">LOGO </a>
		</div>
	</header>

	<main>
		<section class="perfil">
			<article class="usuario">
				<img
					src="https://images.igdb.com/igdb/image/upload/t_cover_big/co4tt2.jpg"
					alt="favorito1" alt="foto-usuario" class="foto-usuario">
				<h2>Agustin Nava</h2>
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

	<footer> </footer>
</body>
</html>