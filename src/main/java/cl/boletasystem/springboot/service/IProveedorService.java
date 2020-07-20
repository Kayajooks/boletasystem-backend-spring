package cl.boletasystem.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.boletasystem.springboot.model.Proveedor;

public interface IProveedorService extends ICRUD<Proveedor>{

	Page<Proveedor> listarPageable(Pageable pageable);
	

}
