package cl.boletasystem.springboot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import cl.boletasystem.springboot.dto.FiltrarComprasDTO;
import cl.boletasystem.springboot.dto.ListarComprasDTO;
import cl.boletasystem.springboot.exception.ModeloNotFoundException;
import cl.boletasystem.springboot.model.Compras;
import cl.boletasystem.springboot.service.IComprasService;

@RestController
@RequestMapping("/compras")
public class ComprasController {
	
	@Autowired
	private IComprasService service;
	
	@GetMapping
	public ResponseEntity<List<Compras>> listar(){
		 List<Compras> lista = service.listar();
		return new ResponseEntity<List<Compras>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Compras> listarPorId(@PathVariable("id") Integer id){
		Compras compras = service.leerPorId(id);
		if(compras.getIdCompra() == null) {
			throw new ModeloNotFoundException("ID COMPRA NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Compras>(compras, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Compras compras) {
		Compras obj = service.registrar(compras);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(compras.getIdCompra()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Compras> modificar(@Valid @RequestBody Compras compras) {
		Compras cte = service.modificar(compras);
		return new ResponseEntity<Compras>(cte, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Compras compras = service.leerPorId(id);
		if(compras.getIdCompra() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	//Otra forma de hacer una lista de las compras con Hateoas
	
	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ListarComprasDTO> listarHateoas() {
		List<Compras> compras = new ArrayList<>();
		List<ListarComprasDTO> listarComprasDTO = new ArrayList<>();
		compras = service.listar();
		
		for (Compras comp : compras) {
			ListarComprasDTO listaCompDTO = new ListarComprasDTO();
			listaCompDTO.setIdCompra(comp.getIdCompra());
			listaCompDTO.setProveedor(comp.getProveedor());
			
			ControllerLinkBuilder linkTo = linkTo(methodOn(ComprasController.class).listarPorId((comp.getIdCompra())));
			listaCompDTO.add(linkTo.withSelfRel());

			ControllerLinkBuilder linkTo1 = linkTo(methodOn(ProveedorController.class).listarPorId((comp.getProveedor().getIdProveedor())));
			listaCompDTO.add(linkTo1.withSelfRel());
			listarComprasDTO.add(listaCompDTO);

		}
		return listarComprasDTO;
	}

	//Filtrar Compras DTO
	
	@PostMapping("/filtrar")
	public ResponseEntity<List<Compras>> filtrar(@RequestBody FiltrarComprasDTO filtrar) {
		List<Compras> compras = new ArrayList<>();

		if (filtrar != null) {
			if (filtrar.getFechaCompra() != null) {
				compras = service.buscarFecha(filtrar);
			} else {
				compras = service.buscar(filtrar);
			}
		}
		return new ResponseEntity<List<Compras>>(compras, HttpStatus.OK);
	}	

}