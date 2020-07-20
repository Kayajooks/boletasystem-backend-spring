package cl.boletasystem.springboot.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.boletasystem.springboot.dto.FiltrarComprasDTO;
import cl.boletasystem.springboot.model.Compras;
import cl.boletasystem.springboot.repo.IComprasRepo;
import cl.boletasystem.springboot.service.IComprasService;

@Service
public class ComprasServiceImpl implements IComprasService{
	
	@Autowired
	private IComprasRepo repo;
	
	@Override
	public Compras registrar(Compras obj) {
		obj.getComprasDetalle().forEach(det -> {
			det.setCompras(obj);
		});
		return repo.save(obj);
	}
		
	@Override
	public Compras modificar(Compras obj) {		
		obj.getComprasDetalle().forEach(det -> {
			det.setCompras(obj);
		});
		return repo.save(obj);
	}

	@Override
	public List<Compras> listar() {
		return repo.findAll();
	}

	@Override
	public Compras leerPorId(Integer id) {
		java.util.Optional<Compras> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Compras();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
	
	//Metodos para el FiltrarComprasDTO
	
	@Override
	public List<Compras> buscar(FiltrarComprasDTO filtrar) {		
		return repo.buscar(filtrar.getRut(), filtrar.getRazonSocial());
	}

	@Override
	public List<Compras> buscarFecha(FiltrarComprasDTO filtrar) {
		LocalDateTime fechaSgte = filtrar.getFechaCompra().plusDays(1);
		return repo.buscarFecha(filtrar.getFechaCompra(), fechaSgte);
	}

}