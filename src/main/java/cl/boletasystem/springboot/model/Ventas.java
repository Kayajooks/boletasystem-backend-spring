package cl.boletasystem.springboot.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ventas")
public class Ventas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVentas;

	@ApiModelProperty(notes = "Cliente Boleta")
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_id_cliente"))
	private Cliente cliente;

	@ApiModelProperty(notes = "Detalle de la Boleta")
	@OneToMany(mappedBy = "ventas", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<VentasDetalle> ventasDetalle;
	
	@ApiModelProperty(notes = "Fecha de la transacción")
	private LocalDateTime fecha;
	
	@ApiModelProperty(notes = "Base Imponible")
	@Column(name="base")
	private Integer base;
	
	@ApiModelProperty(notes = "Monto del IVA se calcula aun 19%")
	@Column(name="iva")
	private Integer iva;
	
	@ApiModelProperty(notes = "Sumatoria de la Base mas el IVA")
	@Column(name="monto")
	private Integer monto;

	@ApiModelProperty(notes = "Numero de Documento")
	@Column(name="n_boleta")
	private Integer n_boleta;

	public Integer getIdVentas() {
		return idVentas;
	}

	public void setIdVentas(Integer idVentas) {
		this.idVentas = idVentas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<VentasDetalle> getVentasDetalle() {
		return ventasDetalle;
	}

	public void setVentasDetalle(List<VentasDetalle> ventasDetalle) {
		this.ventasDetalle = ventasDetalle;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Integer getN_boleta() {
		return n_boleta;
	}

	public void setN_boleta(Integer n_boleta) {
		this.n_boleta = n_boleta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVentas == null) ? 0 : idVentas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ventas other = (Ventas) obj;
		if (idVentas == null) {
			if (other.idVentas != null)
				return false;
		} else if (!idVentas.equals(other.idVentas))
			return false;
		return true;
	}

	
		
}