<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="WEB-INF/Templates/head.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-language" content="es" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Ver actividad actual</title>
</head>
<script>
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}

	function SetearVariables(id,i) {
		var taskAux = "";
		var infoD="";	
		var m=0;
		var k=0;
		$.ajax({
			url : "http://kermit:kermit@localhost:8080/activiti-rest/service/history/historic-process-instances/"+id,
			type: "GET",
			datatype: "json",
			headers: {
			            'Accept':'application/json',
			            'Content-Type':'application/json',
			            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

			         },
			success : function(resultado) {
				var info="";
				if (resultado.startTime != null) {
					info = info	+ "<h2>Detalle de la convocatoria " + id + "</h2>"
								+ "<li class='list-group-item'>Fecha Inicio: "+ resultado.startTime+"</li>" 
								+ "<li class='list-group-item'>Usuario Creacion: "+resultado.startUserId+"</li>"
							
				} else {
					info = info + "<li class='list-group-item'>Fecha Inicio: Convocatoria no iniciada</li>";
				}
				if (resultado.endTime != null){
					info = info	+ "<h2>Detalle de la convocatoria" + id + "</h2>"
					+ "<li class='list-group-item'>Fecha Fin: "+ resultado.endTime+"</li>" 					
				} else {
					info = info + "<li class='list-group-item'>Fecha Fin: Convocatoria no finalizada</li>";
				}
				var actual = document.getElementById("contenedorPrincipal").innerHTML;
				document.getElementById("contenedorPrincipal").innerHTML = actual+ info;
				

				$.ajax({
			    	url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks",
			    	type: "GET",
			    	datatype: "json",
			    	headers: {
			    	            'Accept':'application/json',
			    	            'Content-Type':'application/json',
			    	            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

			    	         },
			            
			    	success: function(resultado) {       
			                
			                	for(var i=0;i<resultado.size;i++){
			           				if (resultado.data[i].processInstanceId == id){
			           					infoD = infoD
										+ "<h2>Detalles de la actividad</h2><li class='list-group-item'>Fecha Comienzo de la actividad: "
										+ resultado.data[i].createTime+"</li>" 
										+ "<li class='list-group-item'>Nombre de la tarea : "+resultado.data[i].name+"</li>";			     
			           				}
			                	}
			                	var actualDos = document.getElementById("contenedorActividad").innerHTML;
								document.getElementById("contenedorActividad").innerHTML = actualDos + infoD;
				
			        },
			        
			        error: function() {
//			        	alert('error get ajax');
			        }
			    });
				
			},
			error : function() {
				alert("error en lista de instancias");
			}
		});
// 		console.log('infoD finaal' +infoD);

	}

	window.onload = function() {
		var id = getUrlVars().id;
		var i = getUrlVars().i;
		SetearVariables(id,i)
		
	}
</script>
<body>
  <div class="container">
    <div class="row">
	<jsp:include page="WEB-INF/Templates/header.jsp"/>
    </div>
    <br>
    <br>
    <ul class="list-group" id="contenedorPrincipal">

    
    </ul>         
    <br>
    <br>
    <ul class="list-group" id="contenedorActividad">

    
    </ul>             
  </div>

</body>
</html>