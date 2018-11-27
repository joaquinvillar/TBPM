package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.ArrayList;
import java.util.List;


import logic.Postulacion;
import other.Comunicacion_DB;

public class agregarPostulacionesPriorizadas implements TaskListener {

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();		
		Postulacion p = (Postulacion) execution.getVariable("postulacion");						
		Postulacion[] postulacionesPriorizadas = (Postulacion[]) execution.getVariable("postulacionesPriorizadas");
		Integer prioridad = ((Long) execution.getVariable("prioridad")).intValue();		
		
		postulacionesPriorizadas[prioridad -1] = p;     	
		Comunicacion_DB.actualizarPrioridadPostulacion(p.getCedula(),p.getExpediente(),prioridad);
	}
}