package listeners;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import other.Comunicacion_DB;



public class actualizarEstadoExpediente implements ExecutionListener  {

	private static final long serialVersionUID = 200222L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		Integer estado = 0;
		boolean aprueba = (boolean) execution.getVariable("aprueba");
		String expedienteid = (String) execution.getVariable("expedienteid");
		if (aprueba) {
			estado = 2;
		}
		else {
			estado = 1;
		}
		Comunicacion_DB.actualizarEstadoExpediente(expedienteid, estado);	
		
	
	}
}	