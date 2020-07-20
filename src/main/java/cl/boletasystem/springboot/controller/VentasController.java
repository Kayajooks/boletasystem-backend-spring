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
import cl.boletasystem.springboot.model.Ventas;
import cl.boletasystem.springboot.service.IVentasService;

@RestController
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired
	private IVentasService service;
	
	@GetMapping
	public ResponseEntity<List<Ventas>> listar(){
		 List<Ventas> lista = service.listar();
		return new ResponseEntity<List<Ventas>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Ventas> listarPorId(@PathVariable("id") Integer id){
		Ventas ventas = service.leerPorId(id);
		if(ventas.getIdVentas() == null) {
			throw new ModeloNotFoundException("ID BOLETA NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Ventas>(ventas, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Ventas ventas) {
		Ventas obj = service.registrar(ventas);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ventas.getIdVentas()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Ventas> modificar(@Valid @RequestBody Ventas ventas) {
		Ventas cte = service.modificar(ventas);
		return new ResponseEntity<Ventas>(cte, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Ventas ventas = service.leerPorId(id);
		if(ventas.getIdVentas() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
