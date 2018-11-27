package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.ArrayList;
import java.util.List;


import logic.Postulacion;

public class asignarCantidadBecas implements TaskListener {

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();		
		Integer becas = ((Long) execution.getVariable("cantidaddebecas")).intValue();
		execution.setVariable("cupos", becas);
		
		Postulacion[] postulacionesPriorizadas = (Postulacion[]) execution.getVariable("postulacionesPriorizadas");
		List<Postulacion> postulacionesPriorizadasList = new ArrayList<Postulacion>();
		for( int i = 0; i<postulacionesPriorizadas.length; i++) {
			postulacionesPriorizadasList.add(postulacionesPriorizadas[i]);
		}
		execution.setVariable("postulacionesPriorizadasList", postulacionesPriorizadasList);
		
	}
}	