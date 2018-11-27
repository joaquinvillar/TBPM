package listeners;

import org.activiti.engine.delegate.DelegateExecution;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import logic.Postulacion;

public class cargarDatosPostulante implements TaskListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
		Postulacion pos = (Postulacion) execution.getVariable("postulacion");
		
		execution.setVariableLocal("faltainformacion","");
		execution.setVariableLocal("nombrepostulante", pos.getNombre() + ' ' + pos.getApellido());
		execution.setVariableLocal("cedulapostulante",pos.getCedula());
		execution.setVariableLocal("carrerapostulante",pos.getCarrera());
		execution.setVariableLocal("creditospostulante",pos.getCreditos().toString());
		execution.setVariableLocal("universidadpostulante",pos.getUniversidad().toString());
	}
}