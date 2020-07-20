package cl.boletasystem.springboot.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import cl.boletasystem.springboot.model.Proveedor;
import cl.boletasystem.springboot.service.IProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private IProveedorService service;
	
	@GetMapping
	public ResponseEntity<List<Proveedor>> listar(){
		 List<Proveedor> lista = service.listar();
		return new ResponseEntity<List<Proveedor>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> listarPorId(@PathVariable("id") Integer id){
		Proveedor proveedor = service.leerPorId(id);
		if(proveedor.getIdProveedor() == null) {
			throw new ModeloNotFoundException("ID PROVEEDOR NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Proveedor proveedor) {
		Proveedor obj = service.registrar(proveedor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proveedor.getIdProveedor()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Proveedor> modificar(@Valid @RequestBody Proveedor proveedor) {
		Proveedor cte = service.modificar(proveedor);
		return new ResponseEntity<Proveedor>(cte, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Proveedor proveedor = service.leerPorId(id);
		if(proveedor.getIdProveedor() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}