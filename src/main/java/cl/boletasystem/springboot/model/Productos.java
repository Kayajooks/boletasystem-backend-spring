package cl.boletasystem.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdProducto;
	
	@ApiModelProperty(notes = "Descripción del Producto 150 caracteres maximo")
	@Column(name = "descripcion", nullable = true, length = 150)
	private String descripcion;
	
	@ApiModelProperty(notes = "Costo del producto con IVA incluido")
	@Column(name="costo")
	private Integer costo;
	
	@ApiModelProperty(notes = "Precio del producto con IVA incluido")
	@Column(name="precio")
	private Integer precio;
	
	@ApiModelProperty(notes = "Monto del IVA se calcula con 19%")
	@Column(name="iva")
	private Integer iva;
	
	@ApiModelProperty(notes = "Maragen estimado no es monto es un %")
	@Column(name="margen")
	private Integer margen;
	
	@ApiModelProperty(notes = "Clasificación del producto")
	@Column(name = "categoria", nullable = true, length = 50)
	private String categoria;
	
	@ApiModelProperty(notes = "Unidades en stock del producto en tienda")
	@Column(name="stock")
	private Integer stock;

	public Integer getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(Integer idProducto) {
		IdProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public Integer getMargen() {
		return margen;
	}

	public void setMargen(Integer margen) {
		this.margen = margen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

//	public Integer getProductos() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}
