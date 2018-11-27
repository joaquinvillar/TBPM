package listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import other.Comunicacion_DB;

import java.io.IOException;
import java.util.Date;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.text.ParseException;


public class CrearMovilidad implements TaskListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
				
		String movilidadNombre = (String) execution.getVariable("nombre");
		String convocatoriaId = (String) execution.getVariable("identificacionconvocatoria");
		
		//LocalDate fechaInicio = (LocalDate) execution.getVariable("fechainicio");
		// LocalDate fechaFin = (LocalDate) execution.getVariable("fechafin");
		String fechaIniStr = (String) execution.getVariable("fechainicio");
		String fechaFinStr = (String) execution.getVariable("fechafin");
		
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
       
        Date castedFechaInicio = new Date();
        Date castedFechaFin = new Date();
        try {
        	castedFechaInicio = formatter.parse(fechaIniStr);
        	castedFechaFin = formatter.parse(fechaFinStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

		Integer universidadId = Integer.parseInt((String) execution.getVariable("universidadid"));
		Boolean electrica = (Boolean) execution.getVariable("electrica");
		Boolean computacion = (Boolean) execution.getVariable("computacion");
		Boolean produccion = (Boolean) execution.getVariable("produccion");
		Boolean civil = (Boolean) execution.getVariable("civil");

		Integer duracion = ((Long) (execution.getVariable("duracion"))).intValue();
		String descripcion = (String) execution.getVariable("descripcion");
		String bases = (String) execution.getVariable("bases");
		String nombreContacto = (String) execution.getVariable("nombrecontacto");
		String emailContacto = (String) execution.getVariable("emailcontacto");
		
		// Date castedFechaInicio = fechaInicio.toDateTimeAtStartOfDay().toDate();
		// Date castedFechaFin = fechaFin.toDateTimeAtStartOfDay().toDate();

		Comunicacion_DB.crearMovilidad(movilidadNombre, convocatoriaId, castedFechaInicio, castedFechaFin, universidadId, electrica, computacion,
			produccion, civil, duracion, descripcion, bases, nombreContacto, emailContacto);
		
		String fechaIniMov =  castedFechaInicio.toString();
		String fechaFinMov =  castedFechaFin.toString();
		String razon = null;
		
		task.setVariable("fechaIniMov", fechaIniMov);
		task.setVariable("fechaFinMov", fechaFinMov);
		task.setVariable("razon", razon);
	}
}
