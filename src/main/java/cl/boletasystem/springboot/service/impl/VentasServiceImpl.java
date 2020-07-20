package cl.boletasystem.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.boletasystem.springboot.model.Ventas;
import cl.boletasystem.springboot.repo.IVentasRepo;
import cl.boletasystem.springboot.service.IVentasService;

@Service
public class VentasServiceImpl implements IVentasService{
	
	@Autowired
	private IVentasRepo repo;
	
	@Override
	public Ventas registrar(Ventas obj) {
		obj.getVentasDetalle().forEach(det -> {
			det.setVentas(obj);
		});
		return repo.save(obj);
	}
	
	@Override
	public Ventas modificar(Ventas obj) {		
		obj.getVentasDetalle().forEach(det -> {
			det.setVentas(obj);
		});
		return repo.save(obj);
	}

	@Override
	public List<Ventas> listar() {
		return repo.findAll();
	}

	@Override
	public Ventas leerPorId(Integer id) {
		java.util.Optional<Ventas> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Ventas();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}