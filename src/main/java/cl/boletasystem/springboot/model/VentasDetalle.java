package cl.boletasystem.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ventasDetalle")
public class VentasDetalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVentaDeta;

	@ApiModelProperty(notes = "ID de la Boleta de Ventas")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_ventas", nullable = false, foreignKey = @ForeignKey(name = "FK_id_ventas"))
	private Ventas ventas;
	
	@ApiModelProperty(notes = "ID del Detalle de productos de la Boleta de Ventas")
	@ManyToOne
	@JoinColumn(name = "id_productos", nullable = false, foreignKey = @ForeignKey(name = "FK_id_productos"))
	private Productos productos;
	
	@ApiModelProperty(notes = "Cantidad de Productos en la Boleta de Ventas")
	@Column(name="cantidad", nullable = false)
	private Integer cantidad;
	
	@ApiModelProperty(notes = "Precio de Venta con IVA Incluido")
	@Column(name="precio", nullable = false)
	private Integer precio;

	public Integer getIdVentaDeta() {
		return idVentaDeta;
	}

	public void setIdVentaDeta(Integer idVentaDeta) {
		this.idVentaDeta = idVentaDeta;
	}

	public Ventas getVentas() {
		return ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	
}
