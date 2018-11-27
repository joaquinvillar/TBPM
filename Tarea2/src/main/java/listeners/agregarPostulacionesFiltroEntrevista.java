package listeners;

import java.util.List;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import logic.Postulacion;
import other.Comunicacion_DB;

public class agregarPostulacionesFiltroEntrevista implements TaskListener{
	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
	
		Postulacion p = (Postulacion) execution.getVariable("postulacion");
		List<Postulacion> postulacionesFiltroEntrevista = (List<Postulacion>) execution.getVariable("postulacionesFiltroEntrevista");
		String valoracionStr = (String) execution.getVariable("valoracionentrevista");
		
		execution.setVariableLocal("valoracionentrevista", null);
		execution.setVariableLocal("entrevistarealizada", "");
		
		Integer valoracion = 0;// inicializo en cero como insuficiente
		
		if (valoracionStr.equals("Excelente")) {
			valoracion = 2;
		}
		
		if (valoracionStr.equals("Aceptable")) {
			valoracion = 1;
		}
        
        p.setEvalEntrevista(valoracion);
		postulacionesFiltroEntrevista.add(p);				
		Integer ent = (Integer) execution.getVariable("entrevistados");
		ent ++;
		execution.setVariable("entrevistados", ent);
		execution.setVariable("okfechaentrevista", false);
		System.out.println("entrevistados: "+ent);
	}
}


