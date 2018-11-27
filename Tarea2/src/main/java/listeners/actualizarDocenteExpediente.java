package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import other.Comunicacion_DB;


public class actualizarDocenteExpediente implements TaskListener {



	@Override
	public void notify(DelegateTask task) {
		 
		DelegateExecution execution = task.getExecution();
		String expedienteId = (String) execution.getVariable("expedienteid");
		String docente1= (String) execution.getVariable("docenteuno");
		String docente2= (String) execution.getVariable("docentedos");
		String docente3= (String) execution.getVariable("docentetres");
		String referente = (String) execution.getVariable("referente");
		
		boolean expedienteCreado = (boolean) execution.getVariable("expedienteCreado");
		
		if (expedienteCreado) {
			Comunicacion_DB.actualizarDocenteExpediente(expedienteId, referente, docente1, docente2, docente3);
		}else {
			Comunicacion_DB.crearDocenteExpediente(expedienteId, referente, docente1, docente2, docente3);
			expedienteCreado = true;
			execution.setVariable("expedienteCreado",expedienteCreado);
		}
	}
	
}	