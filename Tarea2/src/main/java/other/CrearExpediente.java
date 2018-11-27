package other;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;


import other.Comunicacion_DB;
import java.util.Date;

import org.joda.time.LocalDate;

import com.consejo.impl.SolicitarExpediente;


public class CrearExpediente implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		
		SolicitarExpediente solExp = new SolicitarExpediente();
		int expId = solExp.crearExpediente();
		
		String convocatoriaId = (String) execution.getVariable("identificacionconvocatoria");
		String expedienteid = expId + "/2018";
		execution.setVariable("expedienteid", expedienteid);
		System.out.println("expediente: "+ expedienteid);
		String movilidadNombre = (String) execution.getVariable("nombre");
		LocalDate fechaInicioPos = (LocalDate) execution.getVariable("fechainiciopostulaciones");
		LocalDate fechaFinPos = (LocalDate) execution.getVariable("fechafinpostulaciones");
		String razon = (String) execution.getVariable("razon");
		boolean expedienteCreado = (boolean) execution.getVariable("expedienteCreado"); 		
		
		Date castedFechaInicio = fechaInicioPos.toDateTimeAtStartOfDay().toDate();
		Date castedFechaFin = fechaFinPos.toDateTimeAtStartOfDay().toDate();
		System.out.println("estado expediente: "+ expedienteCreado);
		if (expedienteCreado == false) {
		   Comunicacion_DB.crearExpediente(expedienteid, movilidadNombre,convocatoriaId, castedFechaInicio, castedFechaFin);
		   //expedienteCreado = true;
		   execution.setVariable("expedienteCreado",expedienteCreado);		   
		} else {
		   Comunicacion_DB.actualizarExpediente(expedienteid, movilidadNombre,convocatoriaId, castedFechaInicio, castedFechaFin);
		   razon = null;
		}
	}
}