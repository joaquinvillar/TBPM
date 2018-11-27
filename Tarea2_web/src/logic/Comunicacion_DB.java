package logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import logic.Expediente;
import java.sql.*;

public class Comunicacion_DB {
		
	private static Connection getConection(){

		Connection conexion = null;
		String driver = "org.postgresql.Driver";
		String base = "jdbc:postgresql://localhost:5432/empresarial";
		String usuario = "postgres";
		String password = "admin";

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(base, usuario , password);
		} catch (ClassNotFoundException e){ 
			e.getMessage();  
		} catch (SQLException e){ 
			e.getMessage();
		}		
		return conexion;
	}
		
	public static Usuario usuarioValido(String user, String pass){
		
		Usuario usu = new Usuario();
		Connection con = null;
		System.out.println("User :"+user);
		System.out.println("Pass :"+pass);		
		
		try{
			con = getConection();
    		String consulta = "SELECT * FROM usuario WHERE usuario='"+user+"' and password='"+pass+"'";
    		
    		Statement st=con.createStatement();
    		ResultSet rs = st.executeQuery(consulta);	        
             
            boolean more = rs.next();
			
            if (!more) 
            {
              usu.setValido(false);
            } else {
               String u = rs.getString("usuario");
               String r = rs.getString("rol");
               
               usu.setUser(u);
               usu.setRol(r);
               usu.setValido(true);
            }
            
		} catch(Exception ex) {
		  System.out.println("ERROR :"+ex.getMessage());	
		}
		return usu;
	}		

	
	public static List<Expediente> obtenerExpedientes(){
		List<Expediente> expedientes = new ArrayList<Expediente>();
		Connection con = null;	  
        try {    					
		
			con = getConection();
			String consulta = "select * from movilidad mo, universidad u, expediente e where e.estado > 1 and e.movilidadnombre = mo.movilidadnombre and mo.universidadid = u.universidadid";
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(consulta);	 
			while(rs.next()){	
		        Expediente exp = new Expediente();
                exp.setMovilidadNombre(rs.getString("movilidadNombre"));
                exp.setConvocatoriaId(rs.getString("convocatoriaId"));
                exp.setUniversidad(rs.getString("universidadnombre"));
                exp.setDocenteRef(rs.getString("docenteRefId"));
                
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
                
                exp.setFechaInicio(dateFormat.format(rs.getDate("fechaInicioPostulacion")));
                exp.setFechaFin(dateFormat.format(rs.getDate("fechaFinPostulacion")));
	    		
	    		expedientes.add(exp);
			}		
			System.out.println(consulta);	
    	} catch (SQLException e) {
    		System.out.println("ERROR :"+e.getMessage());	
    	}
		
		return expedientes;
	}
	
}
	