<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="Content-language" content="es" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="media/css/bootstrap.min.css">
  <link rel="stylesheet" href="media/ingresar-movilidad.css">
  <script src="media/js/jquery-3.3.1.min.js"></script>
  <script src="media/js/customFunctions.js"></script>
  <script src="media/js/bootstrap.min.js"></script>
<title>Ingresar Movilidad - DGRC</title>
</head>
<body>
	<div class="ingresar-movilidad">
    <div class="ingresar-movilidad-titulo">
      <span><b>Ingresar Movilidad Academica</b></span>
    </div>

		   <form method="post" action="" class="ingresar-movilidad-form" id="ingresar-movilidad-form">

	          <div class="form-group">
	           	<label class="control-label">Nombre </label>
	           	<input type="text" id="nombre" name="nombre">
	           </div>

	           <div class="form-group">
	           	<label class="control-label">Convocatoria</label>
	           	<input type="text" id="convocatoriaId" name="convocatoriaId" placeholder="Primaria, Secundaria,...)">
	           </div>

             <div class="form-group">
	           	<label class="control-label">Fecha inicio</label>
	           	<input type="date" id="fechaInicio" name="fechaInicio" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
	           </div>

             <div class="form-group">
	           	<label class="control-label">Fecha fin</label>
	           	<input type="date" id="fechaFin" name="fechaFin" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
	           </div>


	           <div class="carreras"><label class="col-sm-2 control-label">Carreras</label>
                <div class="carreras-block">
                  <div class="form-group">
                   <label class="control-label">Ingeniería Electrica</label>
                   <input class="carreras-input" type="text" id="electrica" name="electrica" placeholder="si/no">
                  </div>
                  <div class="form-group">
                   <label class="control-label">Ingeniería en Computacion</label>
                   <input class="carreras-input" type="text" id="computacion" name="computacion" placeholder="si/no">
                  </div>
                  <div class="form-group">
                   <label class="control-label">Ingeniería en Produccion</label>
                   <input class="carreras-input" type="text" id="produccion" name="produccion" placeholder="si/no">
                  </div>
                  <div class="form-group">
                   <label class="control-label">Ingeniería Civil</label>
                   <input class="carreras-input" type="text" id="civil" name="civil" placeholder="si/no">
                  </div>
                </div>
                <%-- <div class="i-checks"><label><input type="checkbox" name="electrica" id="carrera" value="electrica"> <i></i>Ingeniería Electrica</label></div>
            		<div class="i-checks"><label> <input type="checkbox" name="computacion" id="carrera" value="computacion"> <i></i>Ingeniería en Computacion</label></div>
                <div class="i-checks"><label> <input type="checkbox" name="produccion" id="carrera" value="produccion"> <i></i>Ingeniería en Produccion</label></div>
            		<div class="i-checks"><label> <input type="checkbox" name="civil" id="carrera" value="civil"> <i></i>Ingeniería Civil</label></div> --%>
	           </div>

	           <div class="form-group">
               <label class="control-label">Duracion</label>
               <input type="text" id="duracion" name="duracion">
	           </div>

             <div class="universidades">
              <label class="control-label">Universidad</label>
               <select class="form-control m-b" name="universidadId" id="universidadId">
                   <option value="1">Universidad de Stanford</option>
                   <option value="2">Universidad de Toronto</option>
                   <option value="3">Universidad de Harvard</option>
                    <option value="4">Universidad de Tokio</option>
                    <option value="5">Universidad de San Pablo</option>
                    <option value="6">Universidad de Lisboa</option>
                    <option value="7">Facultad de Ingenieria Uruguay</option>
               </select>
             </div>

             <div class="form-group two-lines">
               <label class="control-label">Descripcion</label>
               <input type="text" id="descripcion" name="descripcion">
	           </div>

             <div class="form-group two-lines">
               <label class="control-label">Bases</label>
               <input type="text" id="bases" name="bases">
	           </div>

             <div class="form-group">
               <label class="control-label">Nombre de Contacto</label>
               <input type="text" id="nombrecontacto" name="nombrecontacto">
	           </div>

             <div class="form-group">
               <label class="control-label">Email Contacto</label>
               <input type="text" id="emailcontacto" name="emailcontacto">
	           </div>

	           <div class="form-group" style="height:40px;">
	               <div class="buttons">
	                   <button class="btn btn-white" type="reset" style="margin-right:10px;">Cancelar</button>
	                   <button class="btn btn-primary" type="submit">Complete</button>
	               </div>
	           </div>

	       </form>

	</div>
</body>
</html>
