package listeners;

import org.activiti.engine.delegate.DelegateExecution;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import other.Comunicacion_DB;
import logic.datosDT;


public class cargarDatosDT implements TaskListener {
	@Override
	public void notify(DelegateTask task) {
		DelegateExecution execution = task.getExecution();
		String movilidadNombre = (String) execution.getVariable("nombre");
		String expedienteId = (String) execution.getVariable("expedienteid");
		datosDT datosDT = Comunicacion_DB.cargarDatosDecisionTable(movilidadNombre,expedienteId);
		System.out.println("MovilidadNombre: "+ movilidadNombre + " expId: "+ expedienteId );
		execution.setVariable("existeexpediente", datosDT.isExisteExpediente());
		execution.setVariable("tieneinforme", datosDT.isTieneInforme());
		execution.setVariable("informerechazado", datosDT.isInformeRechazado());
		System.out.println("ExisteExp" + datosDT.isExisteExpediente()+" tieneInforme: "+ datosDT.isTieneInforme()+" informeRechazado: "+datosDT.isInformeRechazado());
	}	
}