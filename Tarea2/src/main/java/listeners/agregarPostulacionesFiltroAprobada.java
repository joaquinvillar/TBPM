package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.List;


import logic.Postulacion;
import other.Comunicacion_DB;

public class agregarPostulacionesFiltroAprobada implements TaskListener {

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
		List<Postulacion> postulacionesFiltroAprobada = (List<Postulacion>) execution.getVariable("postulacionesFiltroAprobada");
		Integer adjudicados = (Integer) execution.getVariable("adjudicados");
		Postulacion p = (Postulacion) execution.getVariable("postulacion");
		String respuesta = (String) execution.getVariable("aceptarpropuesta");
		String cedulaPostulante = p.getCedula();
		String expediente = p.getExpediente();
		Integer estado = 0;
		if (respuesta.equals("Si")) {			
			postulacionesFiltroAprobada.add(p);
			adjudicados ++;
			estado = 2;
		}
		else {
			estado = 1;
		}
		Comunicacion_DB.actualizarEstadoPostulacion(cedulaPostulante,expediente, estado);
		for (int i = 0; i < postulacionesFiltroAprobada.size(); i++) {
			System.out.println("cedula" + postulacionesFiltroAprobada.get(i).getCedula());
		};	
		execution.setVariable("adjudicados", adjudicados);
		execution.setVariable("aceptarpropuesta", "");
		System.out.println("adjudicados " + adjudicados);
	}
}	