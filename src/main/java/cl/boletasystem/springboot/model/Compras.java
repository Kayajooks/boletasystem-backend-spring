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
@Table(name = "compras")
public class Compras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;

	@ApiModelProperty(notes = "Proveedor del Servicio")
	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_id_proveedor"))
	private Proveedor proveedor;

	@ApiModelProperty(notes = "Detalle de la Compra")
	@OneToMany(mappedBy = "compras", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ComprasDetalle> comprasDetalle;
	
	@ApiModelProperty(notes = "Fecha de la transacción")
	private LocalDateTime fecha;
	
	@ApiModelProperty(notes = "Base Imponible")
	@Column(name="base")
	private Integer base;
	
	@ApiModelProperty(notes = "Monto del IVA se calcuala aun 19%")
	@Column(name="iva")
	private Integer iva;
	
	@ApiModelProperty(notes = "Sumatoria de la Base mas el IVA")
	@Column(name="monto")
	private Integer monto;
	
	@ApiModelProperty(notes = "Numero de Documento")
	@Column(name="n_factura")
	private Integer n_factura;

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<ComprasDetalle> getComprasDetalle() {
		return comprasDetalle;
	}

	public void setComprasDetalle(List<ComprasDetalle> comprasDetalle) {
		this.comprasDetalle = comprasDetalle;
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

	public Integer getN_factura() {
		return n_factura;
	}

	public void setN_factura(Integer n_factura) {
		this.n_factura = n_factura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCompra == null) ? 0 : idCompra.hashCode());
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
		Compras other = (Compras) obj;
		if (idCompra == null) {
			if (other.idCompra != null)
				return false;
		} else if (!idCompra.equals(other.idCompra))
			return false;
		return true;
	}

}
