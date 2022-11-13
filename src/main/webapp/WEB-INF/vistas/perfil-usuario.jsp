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

					<div class="col-4" style="text-align: center;">
						<img class="usuarioImagen mx-5" src="images/${usuario.foto}">
						<div class="biografia">
							<h4 class="my-2" style="margin: auto;">${usuario.nombre}</h4>
							<a href="amigos?id=${usuario.id}"><p style="margin: auto;" class="amigos">Amigos: ${cantidadAmigos}</p></a>
							<c:if
								test="${usuarioActual.id != usuario.id && solicitud.estado != 'APROBADO' && solicitud.estado != 'PENDIENTE' && usuarioActual.nombre != null}">
								<a href="enviar-solicitud?usuario=${usuario.id}"><p class="agregar">Agregar amigo</p></a>
							</c:if>
							<c:if test="${solicitud.estado == 'PENDIENTE'}">
								<p class="solicitud">Solicitud pendiente</p>
							</c:if>
							<c:if test="${solicitud.estado == 'APROBADO'}">
								<p class="solicitud">Ya son amigos</p>
							</c:if>
							<p class="my-2 mx-3">${usuario.biografia}</p>
						</div>
						<div style="display: flex; justify-content: center;">
							<c:if test="${usuarioActual.id == usuario.id}">
								<a href="editar-perfil"
									class="btn btn-primary my-2 mx-2 button-agregarfavs">Editar</a>
							</c:if>
							<c:if test="${usuario.planAdquirido.plan.descripcion != 'Free'}">
								<a href="reviews?id=${usuario.id}"
									class="btn btn-primary my-2 mx-2 button-agregarfavs">Reviews</a>
							</c:if>
							<a href="comentarios?id=${usuario.id}"
								class="btn btn-primary my-2 mx-2 button-agregarfavs">Comentarios</a>
						</div>
					</div>
					<div class="col-8 favPerfil-container">
						<c:if test="${listaFavs[0] != null}">
							<h1>
								Favoritos
								<c:if test="${listaFavs[3] != null}">
									<a href="lista-completa?id=${usuario.id}" class="verMasLista">Ver
										todos</a>
								</c:if>
							</h1>
						</c:if>
						<table class="table-responsive table-borderless imagen-fav">
							<c:if test="${listaFavs[0] == null}">
								<p class="noHayFav">&iexcl;AGREGA TU CONTENIDO FAVORITO Y
									DISFR&Uacute;TALO AC&Aacute;!</p>
							</c:if>

							<c:if test="${listaFavs[0].pelicula != null}">
								<td><a
									href="perfil-pelicula?id=${listaFavs[0].pelicula.id}"> <img
										src="images/${listaFavs[0].pelicula.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[0].pelicula.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${listaFavs[0].videojuego != null}">
								<td><a href="videojuego?id=${listaFavs[0].videojuego.id}">
										<img src="images/${listaFavs[0].videojuego.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[0].videojuego.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${listaFavs[0].serie != null}">
								<td><a href="perfil-serie?id=${listaFavs[0].serie.id}">
										<img src="images/${listaFavs[0].serie.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[0].serie.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${listaFavs[1].pelicula != null}">
								<td><a
									href="perfil-pelicula?id=${listaFavs[1].pelicula.id}"> <img
										src="images/${listaFavs[1].pelicula.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[1].pelicula.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${listaFavs[1].videojuego != null}">
								<td><a href="videojuego?id=${listaFavs[1].videojuego.id}">
										<img src="images/${listaFavs[1].videojuego.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[1].videojuego.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${listaFavs[1].serie != null}">
								<td><a href="perfil-serie?id=${listaFavs[1].serie.id}">
										<img src="images/${listaFavs[1].serie.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[1].serie.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${listaFavs[2].pelicula != null}">
								<td><a
									href="perfil-pelicula?id=${listaFavs[2].pelicula.id}"> <img
										src="images/${listaFavs[2].pelicula.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[2].pelicula.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${listaFavs[2].videojuego != null}">
								<td><a href="videojuego?id=${listaFavs[2].videojuego.id}">
										<img src="images/${listaFavs[2].videojuego.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[2].videojuego.nombre}</p>
								</a></td>
							</c:if>
							<c:if test="${listaFavs[2].serie != null}">
								<td><a href="perfil-serie?id=${listaFavs[2].serie.id}">
										<img src="images/${listaFavs[2].serie.poster}" style="height: 250px;">
										<p class="titulo">${listaFavs[2].serie.nombre}</p>
								</a></td>
							</c:if>
						</table>

					</div>
				</div>

			</div>
		</div>
	</div>



	<div class="container">
		<div class="favPerfil-container">

			<h1>Visto recientemente</h1>
			<c:if
				test="${historialPelis[0] == null && historialSeries[0]== 
			null && historialVideoJ[0] == null }">
				<p class="MSGNoHayActividad">NO HAY NADA QUE MOSTRAR POR AHORA</p>
			</c:if>
			<table class="table-responsive table-borderless imagen-fav">

				<c:forEach items="${historialPelis}" var="pelicula">
					<td><a href="perfil-pelicula?id=${pelicula.id}"> <img
							src="images/${pelicula.poster}">
							<p class="titulo">${pelicula.nombre}</p>
					</a></td>
				</c:forEach>
				<c:forEach items="${historialSeries}" var="serie">
					<td><a href="perfil-pelicula?id=${serie.id}"> <img
							src="images/${serie.poster}">
							<p class="titulo">${serie.nombre}</p>
					</a></td>
				</c:forEach>
				<c:forEach items="${historialVideoJ}" var="videojuego">
					<td><a href="perfil-pelicula?id=${videojuego.id}"> <img
							src="images/${videojuego.poster}">
							<p class="titulo">${videojuego.nombre}</p>
					</a></td>
				</c:forEach>
			</table>

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