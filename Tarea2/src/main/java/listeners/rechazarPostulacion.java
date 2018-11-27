package listeners;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import other.Comunicacion_DB;
import logic.Postulacion;

public class rechazarPostulacion implements ExecutionListener  {
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		Postulacion postulacion = (Postulacion) execution.getVariable("postulacion");
		System.out.println("exediente" + postulacion.getExpediente() + "Cedula Estudiante: " + postulacion.getCedula());
	
		Comunicacion_DB.actualizarEstadoPostulacion(postulacion.getCedula(), postulacion.getExpediente(), 1);
	}
}