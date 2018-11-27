package logic;
import java.io.Serializable;
import java.util.*;

public class Postulacion implements Serializable{

	private String nombre;
	private String apellido; 
	private String cedula;
	private String carrera;
	private Integer creditos; 
	private Integer universidad;
	private String curriculum;
	private Integer estado;
	private String expedienteId;
	private Integer evalEntrevista; 
	private String contrato;
	
	
	public Postulacion(String nombre, String apellido, String cedula, String carrera, Integer creditos, 
			Integer universidad, String curriculum, Integer estado, String expedienteId, Integer evalEntrevista, String contrato) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.carrera = carrera;
		this.creditos = creditos;
		this.universidad = universidad;
		this.curriculum = curriculum;
		this.estado = estado;
		this.expedienteId = expedienteId;
		this.evalEntrevista = evalEntrevista;
		this.contrato = contrato;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	public Integer getCreditos() {
		return creditos;
	}
	
	public Integer getUniversidad() {
		return universidad;
	}
	
	public String getCurriculum() {
		return curriculum;
	}
	
	public Integer getEstado() {
		return estado;
	}
	
	public String getExpediente() {
		return expedienteId;
	}
	
	public Integer getEvalEntrevista() {
		return evalEntrevista;
	}
	
	public String getContrato() {
		return contrato;
	}
	
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	public void setEvalEntrevista(Integer e) {
		this.evalEntrevista = e;
	}
	

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	

}