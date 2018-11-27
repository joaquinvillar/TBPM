package listeners;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;


import logic.*;

public class inicializarPriorizados implements ExecutionListener  {

		
	@Override
	public void notify(DelegateExecution execution){
		Integer entrevistados = (Integer) execution.getVariable("entrevistados");
		System.out.println("entrevistados: "+ entrevistados);
		Postulacion[] postulacionesPriorizadas = new Postulacion[entrevistados];
		System.out.println("elementos Prio: "+ postulacionesPriorizadas.length);
		execution.setVariable("postulacionesPriorizadas", postulacionesPriorizadas);
	}
}	