<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- jQuery DataTable -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.10.20/r-2.2.3/datatables.min.css" />

<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.20/r-2.2.3/datatables.min.js"></script>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/navbars/">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="plantillas/menu.jsp"></jsp:include>
	<form action="guardarNuevoAmorio" method="post">
		<div class="form-group">
			<input type="text" style="visibility: hidden" class="form-control"
				name="id" id="id" required="required" value="${amorio.id}" />
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Plebeyo</label> <select
				name="plebeyo">
				<c:forEach items="${plebeyos}" var="plebeyo">
					<option value="${plebeyo.id}">${plebeyo.nombre}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Noble</label> <select name="noble">
				<c:forEach items="${nobles}" var="noble">
					<option value="${noble.id}">${noble.nombre}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Region</label> <select name="region">
				<c:forEach items="${regiones}" var="region">
					<option value="${region.id}">${region.nombre}</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Guardar</button>
		<a href="/JuegoDeTronos/" class="btn btn-success"><span
			class="fa fa-undo"></span>Cancelar</a>
	</form>
	<jsp:include page="plantillas/footer.jsp"></jsp:include>
</html>
