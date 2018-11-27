package listeners;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import logic.Postulacion;
import other.Comunicacion_DB;

public class ActualizarDatosPostulante implements TaskListener {

	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
		Postulacion p = (Postulacion) execution.getVariable("postulacion");
		List<Postulacion> postulacionesActualizadas = (List<Postulacion>) execution.getVariable("postulacionesActualizadas");
		String nombre = (String) execution.getVariable("nombreactualizado");
		Integer creditos = ((Long) execution.getVariable("creditosactualizados")).intValue();
		
		p.setCreditos(creditos);
		p.setNombre(nombre);
		postulacionesActualizadas.add(p);
		
		execution.setVariableLocal("nombreactualizado", "");
		execution.setVariableLocal("creditosactualizados", null);
		Comunicacion_DB.actualizarDatosEstudiante(creditos, p.getCedula(), nombre);
		
		

	}
}