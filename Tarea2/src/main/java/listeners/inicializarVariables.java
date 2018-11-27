package listeners;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;


import logic.*;

public class inicializarVariables implements ExecutionListener  {

		
	@Override
	public void notify(DelegateExecution execution){
		
		List<Postulacion> postulaciones = new ArrayList<Postulacion>();
		List<Postulacion> postulacionesFiltroInicial = new ArrayList<Postulacion>();
		List<Postulacion> postulacionesFiltroEntrevista = new ArrayList<Postulacion>();		
		List<Postulacion> postulacionesOrdenDGRC = new ArrayList<Postulacion>();
		List<Postulacion> postulacionesFiltroAprobada = new ArrayList<Postulacion>();
		List<Postulacion> postulacionesActualizadas = new ArrayList<Postulacion>();
		execution.setVariable("expedienteCreado",false);
		execution.setVariable("adjudicados", 0); // cantidad de postulantes adjudicados
		execution.setVariable("cupos", 2); // seteamos un valor por defecto de las becas que se aceptan
		execution.setVariable("entrevistados", 0);
		execution.setVariable("postulaciones", postulaciones);
		execution.setVariable("postulacionesFiltroInicial", postulacionesFiltroInicial);
		execution.setVariable("postulacionesFiltroEntrevista", postulacionesFiltroEntrevista);		
		execution.setVariable("postulacionesOrdenDGRC", postulacionesOrdenDGRC);
		execution.setVariable("postulacionesFiltroAprobada", postulacionesFiltroAprobada);
		execution.setVariable("postulacionesActualizadas", postulacionesActualizadas);
		
		
		execution.setVariable("nombrepostulante", "");
		execution.setVariable("apellidopostulante", "");
		execution.setVariable("cedulapostulante", "");
		execution.setVariable("carrerapostulante", "");
		execution.setVariable("creditospostulante", 0);
		execution.setVariable("universidadpostulante", "");
		
	}
	

}
