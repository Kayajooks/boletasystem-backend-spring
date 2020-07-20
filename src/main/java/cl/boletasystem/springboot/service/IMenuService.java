package cl.boletasystem.springboot.service;

import java.util.List;

import cl.boletasystem.springboot.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}

