package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.List;


import logic.Postulacion;
import other.Comunicacion_DB;

public class agregarPostulacionesFiltroInicial implements TaskListener {

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
		List<Postulacion> postulacionesFiltroInicial = (List<Postulacion>) execution.getVariable("postulacionesFiltroInicial");
		Boolean postulacionAprobada = ((Boolean) (execution.getVariable("aprobado")));
		Postulacion p = (Postulacion) execution.getVariable("postulacion");
		if (postulacionAprobada) {					
			
			System.out.println(p.getCedula());
			System.out.println(p.getNombre());
			
			postulacionesFiltroInicial.add(p);				
			
		}
		else {
			Comunicacion_DB.actualizarEstadoPostulacion(p.getCedula(),p.getExpediente(), 1);
		}
			
		execution.setVariableLocal("aprobado", false);
		System.out.println(postulacionesFiltroInicial.size());
		for (int i = 0; i < postulacionesFiltroInicial.size(); i++) {
			System.out.println(postulacionesFiltroInicial.get(i).getCedula());

		};	
	}
}
		