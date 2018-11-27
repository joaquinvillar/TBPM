<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.estadoSesion"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="media/tbpm.css">
	<jsp:include page="head.jsp"/>
</head>
<body>
<header>
    <div class="container">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar1-1" aria-expanded="false">
                        <span class="sr-only">Menu</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Movilidad academica</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar1-1">
                    <ul class="nav navbar-nav">
                    <% 
                 	  	HttpSession sesion = request.getSession();                		
                		estadoSesion estado = (estadoSesion) sesion.getAttribute("session_status");                		
                	%>
                    </ul>
                  	<ul class="nav navbar-nav navbar-right">
                    <%
                  	   estado = (estadoSesion) request.getSession().getAttribute("session_status");
                    	if ((estado != null) && (estado == estadoSesion.LOGIN_CORRECTO))
	                      {%>
	                      	<li><a href='index.jsp'>Logged as: <%=request.getSession().getAttribute("usuario")%></a></li>
	                        <li><a href="login.jsp">Cerrar Sesion</a></li>
	                        
	                      <%}
	                        else{%>	                      	
	                        <li><a href="login.jsp">Iniciar Sesion</a></li>
	                        
	                        <%}%>
                    </ul>  
                   
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>
</header>
</body>
</html>