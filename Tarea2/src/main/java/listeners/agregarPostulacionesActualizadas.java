package listeners;

import java.util.List;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import logic.Postulacion;

public class agregarPostulacionesActualizadas implements ExecutionListener{
	@Override
	public void notify(DelegateExecution execution) {
		
//		DelegateExecution execution = task.getExecution();
		Postulacion p = (Postulacion) execution.getVariable("postulacion");
		List<Postulacion> postulacionesActualizadas = (List<Postulacion>) execution.getVariable("postulacionesActualizadas");
		
		postulacionesActualizadas.add(p);
	}
}


