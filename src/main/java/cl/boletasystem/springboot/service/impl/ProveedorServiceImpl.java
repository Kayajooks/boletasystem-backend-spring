package cl.boletasystem.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.boletasystem.springboot.model.Proveedor;
import cl.boletasystem.springboot.repo.IProveedorRepo;
import cl.boletasystem.springboot.service.IProveedorService;


@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired	
	private IProveedorRepo repo;
	
	@Override
	public Proveedor registrar(Proveedor pac) {
		return repo.save(pac);
	}

	@Override
	public Proveedor modificar(Proveedor pac) {		
		return repo.save(pac);
	}

	@Override
	public List<Proveedor> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Proveedor> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Proveedor leerPorId(Integer id) {
		Optional<Proveedor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Proveedor();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}



}