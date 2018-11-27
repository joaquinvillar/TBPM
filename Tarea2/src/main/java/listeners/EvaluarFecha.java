package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.Date;

import org.joda.time.LocalDate;

public class EvaluarFecha implements TaskListener {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask task) {
		

		DelegateExecution execution = task.getExecution();
		
		LocalDate fechaInicioPos = (LocalDate) execution.getVariable("fechainiciopostulaciones");
		LocalDate fechaFinPos = (LocalDate) execution.getVariable("fechafinpostulaciones");
		
		Date castedFechaInicio = fechaInicioPos.toDateTimeAtStartOfDay().toDate();
		Date castedFechaFin = fechaFinPos.toDateTimeAtStartOfDay().toDate();
		
		String fechaIniPostulacion =  castedFechaInicio.toString();
		String fechaFinPostulacion =  castedFechaFin.toString();
		
		task.setVariable("fechaIniPostulacion", fechaIniPostulacion);
		task.setVariable("fechaFinPostulacion", fechaFinPostulacion);
			
	}
}