package logic;

import java.io.Serializable;




public class datosDT implements Serializable{
	private boolean existeExpediente;
	private boolean tieneInforme;
	private boolean informeRechazado;
	
	
	public datosDT(boolean existeExpediente, boolean tieneInforme, boolean informeRechazado) {
		this.existeExpediente = existeExpediente;
		this.tieneInforme = tieneInforme;
		this.informeRechazado = informeRechazado;		
		
	}

	public boolean isTieneInforme() {
		return tieneInforme;
	}


	public void setTieneInforme(boolean tieneInforme) {
		this.tieneInforme = tieneInforme;
	}


	public boolean isExisteExpediente() {
		return existeExpediente;
	}


	public void setExisteExpediente(boolean existeExpediente) {
		this.existeExpediente = existeExpediente;
	}


	public boolean isInformeRechazado() {
		return informeRechazado;
	}


	public void setInformeRechazado(boolean informeRechazado) {
		this.informeRechazado = informeRechazado;
	}

}