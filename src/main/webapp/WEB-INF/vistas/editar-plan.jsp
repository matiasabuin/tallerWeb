<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Editar Plan</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/planes.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>

<body>

<jsp:include page="header.jsp" />

	<div class="container">
		<div class="d-flex justify-content-between">

			<div class="recomendaciones-container">
			<h1>Plan Free</h1>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
			Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi 
			ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
			in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint 
			occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim 
			id est laborum.</p>
			
			<c:choose>
    			<c:when test="${usuarioActual.plan == 'Premium'}">
		        	<form action="adquirir-free" method="POST">
						<button id="btn-registrarme"
							class="btn btn-lg btn-primary btn-block" Type="Submit">
							Adquirir
						</button>
					</form>
    			</c:when> 	   
    			<c:otherwise>
			         <button 
						class="btn-lg btn-secondary btn-block">
						Plan Actual
					</button>
			    </c:otherwise>
			</c:choose>
			
			</div>
			


			<div class="recomendaciones-container">
			<h1>Plan Premium</h1>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
			Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi 
			ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
			in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint 
			occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim 
			id est laborum.</p>
			
			
			<c:choose>
    			<c:when test="${usuarioActual.plan == 'Free'}">
					<form action="adquirir-premium" method="POST">
						<button id="btn-registrarme"
							class="btn btn-lg btn-primary btn-block" Type="Submit">
							Adquirir
						</button>
					</form>
    			</c:when> 	   
    			<c:otherwise>
    				<button 
						class="btn-lg btn-secondary btn-block">
						Plan Actual
					</button>
			    </c:otherwise>
			</c:choose>
				
			</div>
		</div>
	</div>
	
<jsp:include page="footer.jsp" />

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