package cl.boletasystem.springboot.dto;

import org.springframework.hateoas.ResourceSupport;

import cl.boletasystem.springboot.model.Proveedor;

public class ListarComprasDTO extends ResourceSupport{
	
	private Integer idCompra;
	private Proveedor proveedor;
	
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

}
