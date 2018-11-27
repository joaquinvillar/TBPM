<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="modelo.estadoSesion"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>TBPMN 06</title>
</head>
<body>
	<div class = "container">
		<div class="row">
	       <jsp:include page="WEB-INF/Templates/header.jsp"/>
	   	</div>
		<div class="ajusteMargin main col-xs-5 col-sm-7 col-md-10">
	      <br>
	      <br>
	      <div class="col-xs-offset-1">
	        <div class="jumbotron">
	          <h2>ADJUDICACION DE MOVILIDAD ACADEMICA</h2>            
	            <% 
	        	  	HttpSession sesion = request.getSession();
	        	  	estadoSesion estado = (estadoSesion) sesion.getAttribute("session_status");
		       		String rol= (String)sesion.getAttribute("rol");
		       		if (estado == null){
		       			sesion.setAttribute("session_status", estadoSesion.NO_LOGIN);
		       		}else{
		       			if (estado == estadoSesion.LOGIN_CORRECTO){
		       				if (rol.equals("decano")) {
	       		           	%>
	     		             <p><a class="btn btn-primary btn-lg"  href="index?action=VerConvocatoriasVigentes" role="button">Ver convocatorias vigentes</a></p>	               
	       		            <%}else{ 
	       		             	if (rol.equals("DGRC")){
	       		             %>
	       		             	<p><a class="btn btn-primary btn-lg" href="IngresarMovilidadDGRC.jsp" role="button">Ingresar Movilidad (DGRC)</a></p>
	       		            <%}
	       		            }
	       		         }
	       		      }
	       		      %>
	       		      <p><a class="btn btn-primary btn-lg" href="instanciasFlujo.jsp" role="button">Ver actividad actual</a></p>                  
	           		  <p><a class="btn btn-primary btn-lg" href="ListarInstanciasPostulaciones.jsp" role="button">Ingresar postulacion (Estudiante)</a></p>
		               		                            
	        </div>
	        <br>
	        <br>
	        <br>
	        <br>
	        <br>
	        <br>                     
	      </div>
	    </div>
	  </div>  
  </div>
</body>
</html>