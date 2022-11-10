<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Favoritos de ${usuario.nombre}</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/listaCompleta.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
	<script src="https://kit.fontawesome.com/ed06e9b771.js"
	crossorigin="anonymous"></script>

</head>

<body>
	<jsp:include page="header.jsp" />

	<div class="container">

		<div class="row">

			<div class="col-md-8 mx-2">
				<main class="listaCompletaBody my-4">
					<div class="container"></div>
					<div class="row">
						<div class="col-12 my-4">
							<h4 class="nameList">
								<c:choose>
								    <c:when test="${usuario.id == usuarioActual.id}">
								        Mis favoritos
								        <br/>
								    </c:when>    
								    <c:otherwise>
				        				Favoritos de ${usuario.nombre}
								        <br/>
								    </c:otherwise>
								</c:choose>
							</h4>
						</div>
						<br>
						<div class="col-12">
							<ul class="list-group">
								<c:forEach var="favoritos" items="${listaFavs}">
									<c:if test="${favoritos.pelicula != null}">
										<div class="row">
											<div class="col-md-4">
											<a href="perfil-pelicula?id=${favoritos.pelicula.id}"
														class="verPefil">
												<img src="images/${favoritos.pelicula.poster}"></a>
											</div>
											<div class="col-md-8">
											<a href="perfil-pelicula?id=${favoritos.pelicula.id}"
														class="verPefil">
												<p class="titulo">${favoritos.pelicula.nombre}
													</p></a>
												<p class="descripcion">${favoritos.pelicula.sinopsis}
												</p>
											</div>
										</div>
										<br>
										<br>

									</c:if>
									<c:if test="${favoritos.videojuego != null}">
										<div class="row">
											<div class="col-md-4">
											<a href="videojuego?id=${favoritos.videojuego.id}"
														class="verPefil">
												<img src="images/${favoritos.videojuego.poster}">
												</a>
											</div>
											<div class="col-md-8">
											<a href="videojuego?id=${favoritos.videojuego.id}"
														class="verPefil">
												<p class="titulo">${favoritos.videojuego.nombre}
													</p></a>
												<p class="descripcion">${favoritos.videojuego.sinopsis}
												</p>
											</div>
										</div>
										<br>
										<br>

									</c:if>
									<c:if test="${favoritos.serie != null}">
										<div class="row">
											<div class="col-md-4">
											<a href="perfil-serie?id=${favoritos.serie.id}"
														class="verPefil">
												<img src="images/${favoritos.serie.poster}"></a>
											</div>
											<div class="col-md-8">
											<a href="perfil-serie?id=${favoritos.serie.id}" 
														class="verPefil">
												<p class="titulo">${favoritos.serie.nombre}
													</p></a>
													<p class="descripcion">${favoritos.serie.sinopsis}
													</p>
											</div>
										</div>
										<br>
										<br>

									</c:if>
								</c:forEach>
							</ul>

						</div>

					</div>
				</main>
			</div>


			<!-- ESTE DIV ES PARA LOS FULTROS	 -->
			<div class="col-md-2 my-4">
				<a href="perfil?id=${usuario.id}" class="fav-completaVolver">
			<i class="fa-solid fa-arrow-left-long"></i>	Volver atras
				</a>
			</div>
												
		</div>
	</div>
	<jsp:include page="footer.jsp" />


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