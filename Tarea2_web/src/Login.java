import logic.Comunicacion_DB;
import logic.Usuario;
import modelo.estadoSesion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IngresarMovilidadDGRC
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("ingreso constructor");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	System.out.println("ingreso processRequest");
    	String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String rol = request.getParameter("rol");
        String action = request.getParameter("action");
        System.out.println("USER: "+user+" pass: "+pass+" ROL: "+rol);
        //if (action.equals("Login")){
        	
	        Usuario usu = Comunicacion_DB.usuarioValido(user, pass);
	        System.out.println("Usuario" + usu.getUser()+" Rol: "+ usu.getRol());
	        if (usu.isValido()){
	        	request.getSession().setAttribute("session_status", estadoSesion.LOGIN_CORRECTO);
	   		    request.getSession().setAttribute("usuario", usu.getUser());
	   		    request.getSession().setAttribute("rol", usu.getRol() );	   		   
	   		    estadoSesion es = (estadoSesion) request.getSession().getAttribute("session_status");
	   		    System.out.println("Estado sesion: "+es.toString());
	   		    response.sendRedirect(request.getContextPath() + "/index.jsp");
	        }
	        else {
	        	System.out.println("Login failed");
	        	request.getSession().setAttribute("session_status", estadoSesion.LOGIN_INCORRECTO);
	        	response.sendRedirect(request.getContextPath() + "/index.jsp");
	        }
        //}
    }

	@Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingreso doGet");
        processRequest(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("ingreso doPost");
        processRequest(request, response);
    }

}
