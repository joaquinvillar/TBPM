/**
*  Javascript module for processing form submits
*/

$(document).ready(function(){
  function IngresarMovilidadDGRC(){
    var nombre = document.getElementById('nombre').value;
    var convocatoriaId = document.getElementById('convocatoriaId').value;
    var fechaInicio = document.getElementById('fechaInicio').value;
    var fechaFin = document.getElementById('fechaFin').value;
    var universidadId = document.getElementById('universidadId').value;
    var duracion = document.getElementById('duracion').value;
    var bases = document.getElementById('bases').value;
    var descripcion = document.getElementById('descripcion').value;

    var electrica = document.getElementById('electrica').value;
    var civil = document.getElementById('civil').value;
    var produccion = document.getElementById('produccion').value;
    var computacion = document.getElementById('computacion').value;

    if (electrica === 'si') { electrica = true; } else { electrica = false; };;
    if (civil === 'si') { civil = true; } else { civil = false; };
    if (computacion === 'si') { computacion = true; } else { computacion = false; };
    if (produccion === 'si') { produccion = true; } else { produccion = false; };

    var emailcontacto = document.getElementById('emailcontacto').value;
    var nombrecontacto = document.getElementById('nombrecontacto').value;

    // AJAX VARIABLES
    var processId = '';
    var processTaskid = '';
    var completeTaskURI = ''
    var getTaskIdUrls = '';

    $.ajax({
        url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/process-instances",
        type: "POST",
        headers: {
          'Accept':'application/json',
          'Content-Type':'application/json',
          'authorization':'Basic a2VybWl0Omtlcm1pdA=='
        },
        data:'{"processDefinitionKey":"process",'+
        '"variables":[{"name":"nombre","value":"'+nombre+'"},' +
          '{"name":"identificacionconvocatoria","value":"'+convocatoriaId+'"},'+
          '{"name":"fechainicio","value":"'+fechaInicio+'"},' +
          '{"name":"fechafin","value":"'+fechaFin+'"},'+
          '{"name":"electrica","value":'+electrica+',"type":"boolean"},' +
          '{"name":"computacion","value":'+computacion+',"type":"boolean"},'+
          '{"name":"civil","value":'+civil+',"type":"boolean"},' +
          '{"name":"produccion","value":'+produccion+',"type":"boolean"},'+
          '{"name":"universidadid","value":"'+universidadId+'"},' +
          '{"name":"duracion","value":'+duracion+',"type":"long"},'+
          '{"name":"descripcion","value":"'+descripcion+'"},' +
          '{"name":"bases","value":"'+bases+'"},'+
          '{"name":"nombrecontacto","value":"'+nombrecontacto+'"},' +
          '{"name":"emailcontacto","value":"'+emailcontacto+'"}' +
          ']}',
        datatype: "json",
        success: function(resultado) {
          // alert('Pasa el primer Success::' + resultado.id);
          processId = resultado.id;
          getTaskIdUrls = "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks?processInstanceId=" + processId;
          $.ajax({
                url: getTaskIdUrls,
                type: "GET",
                datatype: "json",
                headers: {
                  'Accept':'application/json',
                  'Content-Type':'application/json',
                  'authorization':'Basic a2VybWl0Omtlcm1pdA=='
                },
                success: function (res2) {
                  processTaskid = res2.data[0].id;
                  // alert('El segundo success perro::' +processTaskid);
                  completeTaskURI = 'http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks/' + processTaskid;
                  $.ajax({
                      url: completeTaskURI,
                      type: "POST",
                      datatype: "json",
                      headers: {
                        'Content-Type':'application/json',
                        'authorization':'Basic a2VybWl0Omtlcm1pdA=='
                      },
                      data: '{"action":"complete"}',
                      success: function (res3) {
                        window.location.href="index.jsp";
                      },
                      error: function (error) {
                        console.log('error3');
                        alert('Error en tercer ajax');
                      }
                    })
                },
                error: function (error) {
                  console.log('error2');
                  // alert('Error en segundo ajax');
                }
              })
        },
        error: function(err) {
          console.log('error1');
          console.log(err);
          alert('error primer ajax');
          alert(err);
        }
    });

    return false;

  }

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


	function Ejecutar(id,i){
		var nombre = document.getElementById('nombre').value;
		var apellido = document.getElementById('apellido').value;
		var cedula = document.getElementById('cedula').value;
		var carrera = document.getElementById('carrera').value;
		var creditos = document.getElementById('creditos').value;
	    var universidad = document.getElementById('universidad').value;
	    var taskId = "";

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
	           					taskId = resultado.data[i].id;
	           				}
	                	}



		$.ajax({

	        url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks/"+taskId+"/variables/nombrepostulante",
	        type: "PUT",
	        datatype: "json",
	        headers: {

	        	'Accept':'application/json',
	            'Content-Type':'application/json',
	            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

	        },

	        data:'{"name":"nombrepostulante","type":"string","value":"'+nombre+'","scope":"global"}',

	        success: function(resultado) {
//	        	alert("entra al primer success");
	        	console.log('success postuno');
	        	
	        	$.ajax({

	    	        url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks/"+taskId+"/variables/apellidopostulante",
	    	        type: "PUT",
	    	        datatype: "json",
	    	        headers: {

	    	        	'Accept':'application/json',
	    	            'Content-Type':'application/json',
	    	            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

	    	        },

	    	        data:'{"name":"apellidopostulante","type":"string","value":"'+apellido+'","scope":"global"}',

	    	        success: function(resultado) {
	        	
	        	
	    	        	
	    	        	$.ajax({

	    	    	        url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks/"+taskId+"/variables/cedulapostulante",
	    	    	        type: "PUT",
	    	    	        datatype: "json",
	    	    	        headers: {

	    	    	        	'Accept':'application/json',
	    	    	            'Content-Type':'application/json',
	    	    	            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

	    	    	        },

	    	    	        data:'{"name":"cedulapostulante","type":"string","value":"'+cedula+'","scope":"global"}',

	    	    	        success: function(resultado) {
	    	        	
	    	        	
	    	    	        	$.ajax({

	    	    	    	        url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks/"+taskId+"/variables/carrerapostulante",
	    	    	    	        type: "PUT",
	    	    	    	        datatype: "json",
	    	    	    	        headers: {

	    	    	    	        	'Accept':'application/json',
	    	    	    	            'Content-Type':'application/json',
	    	    	    	            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

	    	    	    	        },

	    	    	    	        data:'{"name":"carrerapostulante","type":"string","value":"'+carrera+'","scope":"global"}',

	    	    	    	        success: function(resultado) {   	
	    	    	        	
	    	    	    	        	$.ajax({

	    	    	    	    	        url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks/"+taskId+"/variables/creditospostulante",
	    	    	    	    	        type: "PUT",
	    	    	    	    	        datatype: "json",
	    	    	    	    	        headers: {

	    	    	    	    	        	'Accept':'application/json',
	    	    	    	    	            'Content-Type':'application/json',
	    	    	    	    	            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

	    	    	    	    	        },

	    	    	    	    	        data:'{"name":"creditospostulante","type":"long","value":'+creditos+',"scope":"global"}',

	    	    	    	    	        success: function(resultado) {   
	    	        	
	    	    	    	    	        	
	    	    	    	    	        	
	    	    	    	    	        	$.ajax({

	    	    	    	    	    	        url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks/"+taskId+"/variables/universidadpostulante",
	    	    	    	    	    	        type: "PUT",
	    	    	    	    	    	        datatype: "json",
	    	    	    	    	    	        headers: {

	    	    	    	    	    	        	'Accept':'application/json',
	    	    	    	    	    	            'Content-Type':'application/json',
	    	    	    	    	    	            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

	    	    	    	    	    	        },

	    	    	    	    	    	        data:'{"name":"universidadpostulante","type":"string","value":"'+universidad+'","scope":"global"}',

	    	    	    	    	    	        success: function(resultado) {
	        	///////////////////////////
	        	$.ajax({

			        url: "http://kermit:kermit@localhost:8080/activiti-rest/service/runtime/tasks/"+taskId,
			        type: "POST",
			        datatype: "json",
			        headers: {

			        	'Accept':'application/json',
			            'Content-Type':'application/json',
			            'authorization':'Basic a2VybWl0Omtlcm1pdA=='

	      		 	},

		        	data:'{"action":"complete"}',

		        	success: function(resultado) {
//		        		alert("entra al segundo success");
		        		console.log('success postdos');

//	             window.location = "index.jsp";
			        },
			        error: function(err) {
			        	 console.log('error1');
			             console.log(err);
//			             alert('error segundo ajax');
//			             alert(err);
			        }
			    });
			///////////////////////////
	        	
	        	
	        	
	    	    	        },
	    	    	        error: function(err) {
	    	    	        	 console.log('error1');
	    	    	             console.log(err);
//	    	    	             alert('error segundo ajax');
//	    	    	             alert(err);
	    	    	        }
	    	    	    });
	        	
	    	    	    	    	        },
	    	    	    	    	        error: function(err) {
	    	    	    	    	        	 console.log('error1');
	    	    	    	    	             console.log(err);
//	    	    	    	    	             alert('error segundo ajax');
//	    	    	    	    	             alert(err);
	    	    	    	    	        }
	    	    	    	    	    });    	    	        	
	    	    	    	    	        	
	    	    	    	        },
	    	    	    	        error: function(err) {
	    	    	    	        	 console.log('error1');
	    	    	    	             console.log(err);
//	    	    	    	             alert('error segundo ajax');
//	    	    	    	             alert(err);
	    	    	    	        }
	    	    	    	    });
	    	    	        },
	    	    	        error: function(err) {
	    	    	        	 console.log('error1');
	    	    	             console.log(err);
//	    	    	             alert('error segundo ajax');
//	    	    	             alert(err);
	    	    	        }
	    	    	    });
	        	
	        	
	        },
	        error: function(err) {
	        	 console.log('error1');
	             console.log(err);
//	             alert('error segundo ajax');
//	             alert(err);
	        }
	    });
	        	

	        	
	        	
	        	
//	             window.location = "index.jsp";
	        },
	        error: function(err) {
	        	 console.log('error1');
	             console.log(err);
//	             alert('error primer ajax');
//	             alert(err);
	        }
	    });

        },

        error: function() {
//        	alert('error get ajax');
        }
    });
	}

	$("#ingresar-postulacion-form").submit(function(event) {
		event.preventDefault();
		console.log('validar');
		var id = getUrlVars().id;
		var i = getUrlVars().i;
		Ejecutar(id,i)
	});

	$("#ingresar-movilidad-form").submit(function(event) {
		event.preventDefault();
		IngresarMovilidadDGRC();
	});

});
