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
@Table(name = "comprasDetalle")
public class ComprasDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompraDeta;

	@ApiModelProperty(notes = "Compras BoletaSystem")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_compras", nullable = false, foreignKey = @ForeignKey(name = "FK_id_compras"))
	private Compras compras;
	
	@ApiModelProperty(notes = "ID Detalle de productos")
	@ManyToOne
	@JoinColumn(name = "id_productos", nullable = false, foreignKey = @ForeignKey(name = "FK_id_productos"))
	private Productos productos;
	
	@ApiModelProperty(notes = "Unidades del Producto")
	@Column(name="cantidad", nullable = false)
	private Integer cantidad;
	
	@ApiModelProperty(notes = "Preciod del Producto con IVA incluido")
	@Column(name="precio",nullable = false)
	private Integer precio;
	
	@ApiModelProperty(notes = "Margen de Ganancia del Producto representa %")
	@Column(name="margen")
	private Integer margen;

	public Integer getIdCompraDeta() {
		return idCompraDeta;
	}

	public void setIdCompraDeta(Integer idCompraDeta) {
		this.idCompraDeta = idCompraDeta;
	}

	public Compras getCompras() {
		return compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
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

	public Integer getMargen() {
		return margen;
	}

	public void setMargen(Integer margen) {
		this.margen = margen;
	}

	
}

