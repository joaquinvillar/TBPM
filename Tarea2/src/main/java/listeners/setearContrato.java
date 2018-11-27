package listeners;

import java.util.List;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import logic.Postulacion;

public class setearContrato implements TaskListener{
	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
		
		Postulacion p = (Postulacion) execution.getVariable("postulacion");
		List<Postulacion> postulacionesFiltroEntrevista = (List<Postulacion>) execution.getVariable("postulacionesFiltroAprobada");
		String contrato = (String) execution.getVariable("escribircontrato");
		execution.setVariableLocal("escribircontrato", "");
		for (int i = 0; i < postulacionesFiltroEntrevista.size(); i++) {
			if(p.getCedula() == postulacionesFiltroEntrevista.get(i).getCedula() && p.getExpediente() == postulacionesFiltroEntrevista.get(i).getExpediente()) {
				postulacionesFiltroEntrevista.get(i).setContrato(contrato);
			}
		}
	}
}