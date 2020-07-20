package cl.boletasystem.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.boletasystem.springboot.model.Productos;
import cl.boletasystem.springboot.repo.IProductosRepo;
import cl.boletasystem.springboot.service.IProductosService;

@Service
public class ProductosServiceImpl implements IProductosService{

	@Autowired	
	private IProductosRepo repo;
	
	@Override
	public Productos registrar(Productos pac) {
		return repo.save(pac);
	}

	@Override
	public Productos modificar(Productos pac) {		
		return repo.save(pac);
	}

	@Override
	public List<Productos> listar() {
		return repo.findAll();
	}
	

	@Override
	public Productos leerPorId(Integer id) {
		Optional<Productos> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Productos();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}


}