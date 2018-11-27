<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-language" content="es" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="WEB-INF/Templates/head.jsp"/>
</head>
<script>
window.onload = function(){
	$.ajax({
	url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/process-instances",
	type: "GET",
	datatype: "json",
	headers: {
	            'Accept':'application/json',
	            'Content-Type':'application/json',
	            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

	         },
        
	success: function(resultado) {
            if(resultado.total){         
            	var html="<ul><h2>Convocatorias</h2>";
            	for(var i=0;i<resultado.size;i++){
       				var cls = "class='list-group-item'"; 
       				html = html + "<li "+cls+"><a href=RecibirPostulaciones.jsp?id="+resultado.data[i].id+"&i="+i+">Postularse a la convocatoria: "+resultado.data[i].id+"</li>"	
            	}
            	if(resultado.size == 0){
            		html = html+"No existen convocatorias"
            	}
            	html = html + "</ul>";
            	document.getElementById("listaconvocatorias").innerHTML = html;
            	
            }
            else{
        		document.getElementById("listaconvocatorias").innerHTML = "No existen convocatorias";
            }
        },
        
        error: function() {
            alert("No se pudo conectar con el sistema");
        }
    });

}
</script>
<body>
  <div class="container">
    <div class="row">
		<jsp:include page="WEB-INF/Templates/header.jsp"/>
    </div>
    <br>
    <br>
    <div class="ajusteMargin row">
      <div class="main col-xs-5 col-sm-7 col-md-10">
    
        <ul class="list-group" id="listaconvocatorias">

    
        </ul>         
      </div>
    </div>              
  </div>
</body>
</html>