<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

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

					<li class="nav-item mx-2">
						<a class="nav-link" href="home">Inicio</a>
					</li>

					<c:if test="${usuarioActual.nombre != null}">
						<li class="nav-item mx-2 dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> ${usuarioActual.nombre} </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="perfil">Perfil</a> 
								<a class="dropdown-item" href="editar-plan">Suscripciones</a>
								<a class="dropdown-item" href="cerrar-sesion">Cerrar sesion</a>
							</div>
						</li>
					</c:if>
								
					<c:if test="${usuarioActual.plan == 'Premium'}">
						<li class="nav-item mx-2 dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> Registrar </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="registro-pelicula">Pelicula</a>
								<a class="dropdown-item" href="registro-serie">Serie</a> 
								<a class="dropdown-item" href="registro-videojuego">VideoJuego</a>
							</div>
						</li>
					</c:if>		
						
				</ul>

				<form action="buscar" method="GET">
					<input type="text" placeholder="Buscar contenido" class="search">
				</form>

				<c:if test="${usuarioActual.nombre == null}">
					<a href="registro-usuario" class="nav-link">Register</a>
					<a href="login" class="nav-link">Log In</a>
				</c:if>

			</div>
		</div>
	</nav>
</header>