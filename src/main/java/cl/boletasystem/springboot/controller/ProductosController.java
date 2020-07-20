package cl.boletasystem.springboot.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.boletasystem.springboot.exception.ModeloNotFoundException;
import cl.boletasystem.springboot.model.Productos;
import cl.boletasystem.springboot.service.IProductosService;


@RestController
@RequestMapping("/productos")
//@CrossOrigin()
public class ProductosController {
	
	@Autowired
	private IProductosService service;
	
	@GetMapping
	public ResponseEntity<List<Productos>> listar(){
		 List<Productos> lista = service.listar();
		return new ResponseEntity<List<Productos>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Productos> listarPorId(@PathVariable("id") Integer id){
		Productos pac = service.leerPorId(id);
		if(pac.getIdProducto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Productos>(pac, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Productos producto) {
		Productos pac = service.registrar(producto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(producto.getIdProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Productos> modificar(@Valid @RequestBody Productos producto) {
		Productos pac = service.modificar(producto);
		return new ResponseEntity<Productos>(pac, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Productos pac = service.leerPorId(id);
		if(pac.getIdProducto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}