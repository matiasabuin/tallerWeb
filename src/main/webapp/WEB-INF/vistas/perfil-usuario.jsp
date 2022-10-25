<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${usuarioActual.nombre}</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/perfilUsuario.css">
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />

</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="usuario-container">

			<div class="container">

				<div class="row">

					<div class="col-4">
						<img class="usuarioImagen mx-5" src="images/${usuarioActual.foto}">
						<div class="biografia">
							<h4 class="my-2">${usuarioActual.nombre}</h4>
							<p class="my-2 mx-3">${usuarioActual.biografia}</p>
						</div>
						<a href="editar-perfil" class="btn btn-primary my-2 ml-4 button-agregarfavs"> Editar
							Perfil </a> <a href="reviews" class="btn btn-primary my-2 mx-2 button-agregarfavs"> Ver
							reviews </a>

					</div>
					<div class="col-8 favPerfil-container">
						<c:if test="${usuarioActual.favoritos[0] != null}">
							<h1>
								Favoritos
								<c:if test="${usuarioActual.favoritos[3] != null}">
									<a href="lista-completa" class="verMasLista">Ver todos</a>
								</c:if>
							</h1>
						</c:if>
						<table class="table-responsive table-borderless">
							<c:if test="${usuarioActual.favoritos[0] == null}">
								<p class="noHayFav"> &iexcl;AGREGA TU CONTENIDO FAVORITO Y DISFRUTALO ACA!</p>
							</c:if>

							<c:if test="${usuarioActual.favoritos[0].pelicula != null}">
								<td><a
									href="perfil-pelicula?id=${usuarioActual.favoritos[0].pelicula.id}">
										<img
										src="images/${usuarioActual.favoritos[0].pelicula.poster}">
										<p class="titulo">${usuarioActual.favoritos[0].pelicula.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${usuarioActual.favoritos[0].videojuego != null}">
								<td><a
									href="videojuego?id=${usuarioActual.favoritos[0].videojuego.id}">
										<img
										src="images/${usuarioActual.favoritos[0].videojuego.poster}">
										<p class="titulo">${usuarioActual.favoritos[0].videojuego.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${usuarioActual.favoritos[0].serie != null}">
								<td><a
									href="perfil-serie?id=${usuarioActual.favoritos[0].serie.id}">
										<img src="images/${usuarioActual.favoritos[0].serie.poster}">
										<p class="titulo">${usuarioActual.favoritos[0].serie.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${usuarioActual.favoritos[1].pelicula != null}">
								<td><a
									href="perfil-pelicula?id=${usuarioActual.favoritos[1].pelicula.id}">
										<img
										src="images/${usuarioActual.favoritos[1].pelicula.poster}">
										<p class="titulo">${usuarioActual.favoritos[1].pelicula.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${usuarioActual.favoritos[1].videojuego != null}">
								<td><a
									href="videojuego?id=${usuarioActual.favoritos[1].videojuego.id}">
										<img
										src="images/${usuarioActual.favoritos[1].videojuego.poster}">
										<p class="titulo">${usuarioActual.favoritos[1].videojuego.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${usuarioActual.favoritos[1].serie != null}">
								<td><a
									href="perfil-serie?id=${usuarioActual.favoritos[1].serie.id}">
										<img src="images/${usuarioActual.favoritos[1].serie.poster}">
										<p class="titulo">${usuarioActual.favoritos[1].serie.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${usuarioActual.favoritos[2].pelicula != null}">
								<td><a
									href="perfil-pelicula?id=${usuarioActual.favoritos[2].pelicula.id}">
										<img
										src="images/${usuarioActual.favoritos[2].pelicula.poster}">
										<p class="titulo">${usuarioActual.favoritos[2].pelicula.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${usuarioActual.favoritos[2].videojuego != null}">
								<td><a
									href="videojuego?id=${usuarioActual.favoritos[2].videojuego.id}">
										<img
										src="images/${usuarioActual.favoritos[2].videojuego.poster}">
										<p class="titulo">${usuarioActual.favoritos[2].videojuego.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${usuarioActual.favoritos[2].serie != null}">
								<td><a
									href="perfil-serie?id=${usuarioActual.favoritos[2].serie.id}">
										<img src="images/${usuarioActual.favoritos[2].serie.poster}">
										<p class="titulo">${usuarioActual.favoritos[2].serie.nombre}</p>
								</a></td>
							</c:if>
						</table>

					</div>
				</div>

			</div>
		</div>
	</div>



	<div class="container">
		<div class="recomendaciones-container">

			<h1>Actividad reciente</h1>


		</div>
	</div>



	<jsp:include page="footer.jsp" />

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