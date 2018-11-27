<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<link rel="stylesheet" href="media/tbpm.css">  
<title>Convocatorias</title>
</head>
<body>
<div class="row">
	<jsp:include page="WEB-INF/Templates/header.jsp"/>
</div>
<div class="ajusteMargin container">
	<h2>Convocatorias vigentes</h2>
	<table class="table table-bordered">
		<thead>
		 <th>Movilidad</th>
		 <th>Convocatoria</th>
		 <th>Universidad</th>
		 <th>Docente</th>
		 <th>Fecha Inicio</th>
		 <th>Fecha Fin</th>
		</thead>
		<c:forEach var="expediente" items="${lista}">
			<tr>
				<td><c:out value="${expediente.movilidadNombre}"/></td>
				<td><c:out value="${expediente.convocatoriaId}"/></td>
				<td><c:out value="${expediente.universidad}"/></td>
				<td><c:out value="${expediente.docenteRef}"/></td>
				<td><c:out value="${expediente.fechaInicio}"/></td>
				<td><c:out value="${expediente.fechaFin}"/></td>
			</tr>
		</c:forEach>
	</table>
		<table>
		<tr>
			<td><a href="index.jsp" >Volver</a> </td>
		</tr>
	</table>
</div>	
</body>
</html>