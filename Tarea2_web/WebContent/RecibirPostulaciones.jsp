<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recibir postulaciones</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="Content-language" content="es" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <link rel="stylesheet" href="media/css/bootstrap.min.css">
  <script src="media/js/jquery-3.3.1.min.js"></script>
  <script src="media/js/customFunctions.js"></script>
  <script src="media/js/bootstrap.min.js"></script>
</head>
<body>

<div class = "container">
	<div class = "row">
		<jsp:include page="WEB-INF/Templates/header.jsp"/>
	</div>
	<div class="ajusteMargin row">
                <div class="col-lg-12">
                    <div class="jumbotron ibox float-e-margins">
                        <div class="ibox-title">
                            <h3 class="text-center">Ingresar Postulacion </h3>
                            <div class="ibox-tools">
                                
                            </div>
                        </div>
                        <div class="ibox-content">
                            <form method="post" action="" class="ingresar-postulacion-form" id="ingresar-postulacion-form">
                            
                                <div class="form-group">
                                	<label class="col-sm-2 control-label">Nombre </label>
                                    <div class="col-sm-4"><input type="text" id="nombre" name="nombre" class="form-control required"></div>
                                </div>
                                <br>
                                <br>
                                <br>
								<div class="form-group">
									<label class="col-sm-2 control-label">Apellido </label>
                                    <div class="col-sm-4"><input type="text" id="apellido" name="apellido" class="form-control required"></div>
                                </div>
								<br>
								<br>
								<div class="form-group">
									<label class="col-sm-2 control-label">Cedula </label>
                                    <div class="col-sm-4"><input type="text" id="cedula" name="cedula" class="form-control required"></div>
                                </div>
								<br>
								<br>
								<div class="form-group">
									<label class="col-sm-2 control-label">Carrera </label>
                                    <div class="col-sm-4"><input type="text" id="carrera" name="carrera" class="form-control required"></div>
                                </div>
								<br>
								<br>
								<div class="form-group"><label class="col-sm-2 control-label">Creditos </label>
                                    <div class="col-sm-4"><input type="number" id="creditos" name="creditos" class="form-control required"></div>
                                </div>
								<br>
								<br>
                                <div class="hr-line-dashed"></div>
                                
                                <div class="form-group"><label class="col-sm-2 control-label">Universidad </label>

                                    <div class="col-sm-4">
	                                    <select class="form-control m-b" name="universidad" id="universidad">
	                                        <option value="1">Universidad de Stanford</option>
	                                        <option value="2">Universidad de Toronto</option>
	                                        <option value="3">Universidad de Harvard</option>
											<option value="4">Universidad de Tokio</option>
											<option value="5">Universidad de San Pablo</option>
											<option value="6">Universidad de Lisboa</option>
											<option value="7">Facultad de Ingenieria Uruguay</option>											
	                                    </select>
                                    </div>
                                </div>
								<br>
								<br>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-2">
                                        <button class="btn btn-primary" type="submit">Registrar</button>
                                        <button class="btn btn-white" type="reset">Cancelar</button>                                        
                                    </div>
                                </div>                                
                                
                            </form>
                        </div>
                    </div>
                </div>
 	</div>
</div>
</body>
</html>