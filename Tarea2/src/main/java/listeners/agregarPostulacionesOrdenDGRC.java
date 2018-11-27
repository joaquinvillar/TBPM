package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.List;


import logic.Postulacion;

public class agregarPostulacionesOrdenDGRC implements TaskListener {

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();		
		Postulacion p = (Postulacion) execution.getVariable("postulacion");
		Integer prioridadDGRC = ((Long) execution.getVariable("prioridaddgrc")).intValue();
		List<Postulacion> postulacionesOrdenDGRC = (List<Postulacion>) execution.getVariable("postulacionesOrdenDGRC");
		
		postulacionesOrdenDGRC.add((prioridadDGRC -1), p);        
			
		for (int i = 0; i < postulacionesOrdenDGRC.size(); i++) {
			System.out.println("cedula" + postulacionesOrdenDGRC.get(i).getCedula());
			System.out.println("prioridad" + i);
		};	

		
		
	}
}