package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import logic.Postulacion;

public class formEvaluacionPostulante implements TaskListener {



	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
		Postulacion p = (Postulacion) task.getVariable("postulacion");
				
		execution.setVariableLocal("cedulapostulante", p.getCedula());		
		execution.setVariableLocal("nombrepostulante", p.getNombre());
		execution.setVariableLocal("carrerapostulante", p.getCarrera());
		execution.setVariableLocal("creditospostulante", p.getCreditos());
		execution.setVariableLocal("universidadpostulante", p.getUniversidad());
			
	}
}	