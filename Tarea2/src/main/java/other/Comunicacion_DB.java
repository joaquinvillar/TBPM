package other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logic.datosDT;

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
	
	public static void crearMovilidad(String nombre, String convocatoriaId, Date fechaInicio, Date fechaFin, Integer universidadId, Boolean electrica,
			Boolean computacion, Boolean produccion, Boolean civil, Integer duracion, String descripcion, String bases, 
			String nombreContacto, String emailContacto){		
	
		Connection con = null;

    	try {    					
    		con = getConection();		
			String query = "INSERT INTO movilidad (movilidadNombre,convocatoriaId,fechaInicio,fechaFin,descripcion,duracion,bases,computacion,produccion,civil,electrica,nombreContacto,emailContacto,universidadId)"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";			
			
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, convocatoriaId);
			preparedStatement.setDate(3, new java.sql.Date(fechaInicio.getTime()));
			preparedStatement.setDate(4, new java.sql.Date(fechaFin.getTime()));
			preparedStatement.setString(5, descripcion); 
			preparedStatement.setInt(6, duracion);
			preparedStatement.setString(7, bases);
			preparedStatement.setBoolean(8, computacion);
			preparedStatement.setBoolean(9, produccion);
			preparedStatement.setBoolean(10, civil);
			preparedStatement.setBoolean(11, electrica);
			preparedStatement.setString(12, nombreContacto);
			preparedStatement.setString(13, emailContacto);
			preparedStatement.setInt(14, universidadId);

			
			preparedStatement.executeUpdate(); 
			System.out.println(query);
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
   }
	
	public static List<String> obtenerEstudiantes(){
		List<String> estudiantes = new ArrayList<String>();
		Connection con = null;	  
		
		try {    					
    		con = getConection();
    		String consulta = "SELECT e.estudianteid FROM estudiante e;";
    		PreparedStatement preparedStatement = con.prepareStatement(consulta);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){						
				String estudianteId = rs.getString("estudianteid");
				estudiantes.add(estudianteId);
			}		
			System.out.println(consulta);			
    	} catch (SQLException e) {
    		e.getMessage();			
		}
		
		return estudiantes;
	}
	
	public static Boolean ExisteEstudiante(String id1){
		Boolean existe = false;
		Connection con = null;	  
		
		try {    					
    		con = getConection();
    		String consulta = "SELECT e.estudianteid FROM estudiante e WHERE e.estudianteid =?;";
    		PreparedStatement preparedStatement = con.prepareStatement(consulta);
    		preparedStatement.setString(1, id1);
    		
			ResultSet rs = preparedStatement.executeQuery();
			if(rs == null)					
				existe = true;
			else
				existe = false;
			System.out.println(consulta);			
    	} catch (SQLException e) {
    		e.getMessage();			
		}
		
		return existe;
	}
	
	public static void crearEstudiante(String nombre, String apellido, String cedula, String carrera, Integer Universidad, String ExpedienteId, Integer creditos){		
		Connection con = null;
		nombre = nombre + ' ' + apellido;
    	try {    					
    		con = getConection();		
			String query = "INSERT INTO estudiante VALUES (?, ?, ?, ?, ?)";			
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, cedula);
			preparedStatement.setString(2, nombre);
			preparedStatement.setString(3, carrera);
			preparedStatement.setInt(4, creditos);
			preparedStatement.setString(5, "lalala");
			
			preparedStatement.executeUpdate(); 
			
			System.out.println(query);
			
			query = "INSERT INTO estudiante_expediente VALUES (?, ?, ?, ?, ?)";			
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, cedula);
			preparedStatement.setString(2, ExpedienteId);
			preparedStatement.setInt(3, Universidad);
			preparedStatement.setInt(4, 0);
			preparedStatement.setInt(5, 0);
			
			preparedStatement.executeUpdate(); 
			
			System.out.println(query);
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
    	
   }
	
	public static void actualizarEstudiante(String carrera, Integer creditos, String cedula, Integer Universidad, String ExpedienteId){
		Connection con = null;	  
    	try {        		
    		con = getConection();
			String consulta = "UPDATE estudiante SET carrera=?, creditosaprob=? WHERE estudianteid=?";
			PreparedStatement preparedStatement = con.prepareStatement(consulta);			
			preparedStatement.setString(1,carrera);
			preparedStatement.setInt(2, creditos);
			preparedStatement.setString(3,cedula);
			preparedStatement.executeUpdate(); 
			System.out.println(consulta);	
			
			consulta = "INSERT INTO estudiante_expediente VALUES (?, ?, ?, ?, ?)";			
			preparedStatement = con.prepareStatement(consulta);
			preparedStatement.setString(1, cedula);
			preparedStatement.setString(2, ExpedienteId);
			preparedStatement.setInt(3, Universidad);
			preparedStatement.setInt(4, 0);
			preparedStatement.setInt(5, 0);
			
			
			preparedStatement.executeUpdate(); 
			
			System.out.println(consulta);
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
	}
	
	public static void crearExpediente(String expedienteid,String movilidadNombre,String convocatoriaId,Date fechaInicioPos,Date fechaFinPos){		
		
		Connection con = null;

    	try {    					
    		con = getConection();
    		
			String queryExpediente = "INSERT INTO expediente (expedienteid,fechainiciopostulacion,fechafinpostulacion,movilidadnombre,convocatoriaid,tieneinforme,informerechazado,estado) VALUES (?,?,?,?,?,?,?,?)";			
			
			PreparedStatement expediente = con.prepareStatement(queryExpediente);
			expediente.setString(1, expedienteid);
			expediente.setDate(2, new java.sql.Date(fechaInicioPos.getTime()));
			expediente.setDate(3, new java.sql.Date(fechaFinPos.getTime()));						
			expediente.setString(4, movilidadNombre);
			expediente.setString(5,convocatoriaId);
			expediente.setBoolean(6, false); // tiene informe
			expediente.setBoolean(7, false); // informe rechazado
			expediente.setInt(8, 0);
			
			System.out.println(queryExpediente);
			
			expediente.executeUpdate();
			
			
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
   }
	public static void crearDocenteExpediente(String expedienteid,String referente,String docente,String docentedos,String docentetres){
		
		Connection con = null;

		
    	try {
    		con = getConection();

			String queryDocente_Exp = "INSERT INTO docente_expediente VALUES (?,?)";			
			
			PreparedStatement docente_exp = con.prepareStatement(queryDocente_Exp);
			docente_exp.setString(1, docente);
			docente_exp.setString(2,expedienteid);
			
			docente_exp.executeUpdate();
			
			docente_exp = con.prepareStatement(queryDocente_Exp);
			docente_exp.setString(1, docentedos);
			docente_exp.setString(2,expedienteid);
			
			docente_exp.executeUpdate();
			
			docente_exp = con.prepareStatement(queryDocente_Exp);
			docente_exp.setString(1, docentetres);
			docente_exp.setString(2,expedienteid);
			
			docente_exp.executeUpdate();
			
			String queryReferente_Exp = "UPDATE expediente set docenterefid = ? where expedienteid = ? ";
			PreparedStatement referente_exp = con.prepareStatement(queryReferente_Exp);
			referente_exp.setString(1, referente);
			referente_exp.setString(2,expedienteid);
			
			referente_exp.executeUpdate();
			
    	} catch (SQLException e) {
    		e.printStackTrace();
		}	
	}
	

    public static void actualizarDocenteExpediente(String expedienteid,String referente,String docente,String docentedos,String docentetres){
		
		Connection con = null;

    	try {    					
    		con = getConection();

			String queryDocente_Exp = "UPDATE docente_expediente SET docenteid = ? WHERE expedienteid = ?";			
			
			PreparedStatement docente_exp = con.prepareStatement(queryDocente_Exp);
			docente_exp.setString(1, docente);
			docente_exp.setString(2,expedienteid);
			
			docente_exp.executeUpdate();
			
			docente_exp = con.prepareStatement(queryDocente_Exp);
			docente_exp.setString(1, docentedos);
			docente_exp.setString(2,expedienteid);
			
			docente_exp.executeUpdate();
			
			docente_exp = con.prepareStatement(queryDocente_Exp);
			docente_exp.setString(1, docentetres);
			docente_exp.setString(2,expedienteid);
			
			docente_exp.executeUpdate();
			
			String queryReferente_Exp = "UPDATE expediente set docenterefid = ? where expedienteid = ? ";
			PreparedStatement referente_exp = con.prepareStatement(queryReferente_Exp);
			referente_exp.setString(1, referente);
			referente_exp.setString(2,expedienteid);
			
			referente_exp.executeUpdate();
			
    	} catch (SQLException e) {
    		e.printStackTrace();
		}	
	}

	
	
	public static void actualizarExpediente(String expedienteid,String movilidadNombre,String convocatoriaId,Date fechaInicioPos,Date fechaFinPos){		
		
		Connection con = null;

    	try {    					
    		con = getConection();
    		
    		String queryExpediente = "UPDATE expediente SET fechainiciopostulacion=?, fechafinpostulacion=? WHERE expedienteid=?";
    		PreparedStatement expediente = con.prepareStatement(queryExpediente);

			expediente.setDate(1, new java.sql.Date(fechaInicioPos.getTime()));
			expediente.setDate(2, new java.sql.Date(fechaFinPos.getTime()));
			expediente.setString(3, expedienteid);
			
			expediente.executeUpdate();
			
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
   }
	
   public static void actualizarEstadoExpediente(String expedienteid,Integer estadoExpediente){		
		
		Connection con = null;

    	try {    					
    		con = getConection();
    		String queryEstadoExpediente = "UPDATE expediente SET estado=? WHERE expedienteid=?";
    		PreparedStatement expediente = con.prepareStatement(queryEstadoExpediente);
    		expediente.setInt(1, estadoExpediente);
    		expediente.setString(2, expedienteid);			
			expediente.executeUpdate();
			
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
   } 	
	
	public static void actualizarDatosEstudiante(Integer creditos, String cedula, String nombre){ 
	    Connection con = null;     
	    try {             
	      con = getConection(); 
	      String consulta = "UPDATE estudiante SET nombre=?, creditosaprob=? WHERE estudianteid=?"; 
	      PreparedStatement preparedStatement = con.prepareStatement(consulta);       
	      preparedStatement.setString(1,nombre); 
	      preparedStatement.setInt(2, creditos); 
	      preparedStatement.setString(3,cedula); 
	      preparedStatement.executeUpdate();  
	      System.out.println(consulta);   
	   
	    } catch (SQLException e) { 
	      e.printStackTrace(); 
	    } 
	  } 
	public static void actualizarEstadoPostulacion(String estudianteId,String expedienteId,Integer estado) {// estado 1 significa rechazado 
	    Connection con = null; 
	 
	      try {               
	        con = getConection(); 
	        String consulta = "UPDATE estudiante_expediente SET estado=? WHERE estudianteid=? and expedienteId = ?"; 
	      PreparedStatement preparedStatement = con.prepareStatement(consulta);       
	      preparedStatement.setInt(1,estado); 
	      preparedStatement.setString(2, estudianteId); 
	      preparedStatement.setString(3,expedienteId); 
	      preparedStatement.executeUpdate();  
	      } catch (SQLException e) { 
	        e.printStackTrace(); 
	    } 
	         
	    } 
	
	public static void actualizarPrioridadPostulacion(String estudianteId,String expedienteId,Integer prioridad) {
		   Connection con = null; 
			 
		      try {               
		        con = getConection(); 
		        String consulta = "UPDATE estudiante_expediente SET prioridad=? WHERE estudianteid=? and expedienteId = ?"; 
		        PreparedStatement preparedStatement = con.prepareStatement(consulta);       
		        preparedStatement.setInt(1,prioridad); 
		        preparedStatement.setString(2, estudianteId); 
		        preparedStatement.setString(3,expedienteId); 
		        preparedStatement.executeUpdate();  
		      } catch (SQLException e) { 
		        e.printStackTrace(); 
		    }
	}
	
	public static datosDT cargarDatosDecisionTable(String movilidadNombre,String expedienteId) {
		datosDT datosDT = null ;
		Connection con = null; 				 
		try {               
	        con = getConection();
	        String consultaExiste = "SELECT count(*) as convCreadas FROM expediente WHERE movilidadnombre = ? and expedienteid <> ? "; 
	        PreparedStatement preparedStatement = con.prepareStatement(consultaExiste);  
	        preparedStatement.setString(1,movilidadNombre ); 
	        preparedStatement.setString(2,expedienteId);
	        
	        ResultSet r = preparedStatement.executeQuery();
	        Integer convocatoriasCreadas = 0;
	        boolean existeexpediente = false;
	        boolean tieneinforme = false;
	        boolean informerechazado = false;
	        while(r.next()){						
				 convocatoriasCreadas = r.getInt("convCreadas");
				
			};
	        if (convocatoriasCreadas == 0) {
	        	existeexpediente = false;
	        	tieneinforme = false;
	        	informerechazado = false;
	        }else {
	        	existeexpediente = true;
	        	String consultainforme = "SELECT tieneinforme as ti,informerechazado as ir FROM expediente WHERE movilidadnombre = ? and expedienteid <> ? ";
	        	boolean cont = true;
	        	PreparedStatement ps = con.prepareStatement(consultainforme);  
	        	ps.setString(1,movilidadNombre ); 
		        ps.setString(2,expedienteId);		        		       
		        ResultSet res = ps.executeQuery();        
		        while(cont && res.next()){						
					 tieneinforme = res.getBoolean("ti");
					 informerechazado = res.getBoolean("ir");
					 cont = (tieneinforme && !informerechazado);
					
				};

	        };
        System.out.println("existeExBD: "+existeexpediente+" tieneinfBD: "+tieneinforme+" informeRechBD: "+informerechazado);    
        datosDT = new datosDT(existeexpediente,tieneinforme,informerechazado);
          
		} catch (SQLException e) { 
		        e.printStackTrace(); 
	    } 
		return datosDT;
		
	}
	
}
	