package cl.boletasystem.springboot.service;

import java.util.List;

import cl.boletasystem.springboot.dto.FiltrarComprasDTO;
import cl.boletasystem.springboot.model.Compras;

public interface IComprasService extends ICRUD<Compras>{

	List<Compras> buscarFecha(FiltrarComprasDTO filtrar);

	List<Compras> buscar(FiltrarComprasDTO filtrar);


	
}
