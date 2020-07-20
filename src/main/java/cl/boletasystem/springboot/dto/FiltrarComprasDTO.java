package cl.boletasystem.springboot.dto;

import java.time.LocalDateTime;

public class FiltrarComprasDTO {

	private String rut;
	private String razonSocial;
	private LocalDateTime fechaCompra;
	
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}


}