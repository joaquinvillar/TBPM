package listeners;

import java.util.Arrays;
import java.util.*;

import org.activiti.engine.delegate.DelegateExecution;
import logic.Postulacion;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import other.Comunicacion_DB;


public class CrearPostulacion implements TaskListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
		
		String nombreP = (String) execution.getVariable("nombrepostulante");
		String apellidoP = (String) execution.getVariable("apellidopostulante");
		String cedulaP = (String) execution.getVariable("cedulapostulante");
		String carreraP = (String) execution.getVariable("carrerapostulante");
		Integer creditosP = ((Long) execution.getVariable("creditospostulante")).intValue();
		Integer universidad = Integer.parseInt((String) execution.getVariable("universidadpostulante"));
		String expedienteId = (String) execution.getVariable("expedienteid");
		
		execution.setVariableLocal("nombrepostulante", "");
		execution.setVariableLocal("apellidopostulante", "");
		execution.setVariableLocal("cedulapostulante", "");
		execution.setVariableLocal("carrerapostulante", "");
		execution.setVariableLocal("creditospostulante", null);
		execution.setVariableLocal("universidadpostulante", null);

		
		List<Postulacion> postulaciones = (List<Postulacion>) execution.getVariable("postulaciones");

		Boolean existe = Comunicacion_DB.ExisteEstudiante(cedulaP);		
		if(existe) {
			Comunicacion_DB.actualizarEstudiante(carreraP, creditosP, cedulaP, universidad, expedienteId);			
		}else {	
			System.out.println("ExpedienteId: " + expedienteId);
			Comunicacion_DB.crearEstudiante(nombreP, apellidoP, cedulaP, carreraP, universidad, expedienteId, creditosP);
		}	
			
		Postulacion postulacion = new Postulacion(nombreP, apellidoP, cedulaP, carreraP,creditosP, universidad, "", (Integer) 0, expedienteId,0,"");		
		postulaciones.add(postulacion);		
		System.out.println(postulaciones.size());
		
//		Collections.sort(postulaciones, new Comparator<Postulacion>() {
//	        @Override
//	        public int compare(Postulacion p1, Postulacion p2)
//	        {
//
//	            return  p1.getEvalEntrevista().compareTo(p2.getEvalEntrevista());
//	        }
//	    });
//		for (int i = 0; i < postulaciones.size(); i++) {
//			System.out.println(postulaciones.get(i).getEvalEntrevista());
//
//		}
		
	}
}