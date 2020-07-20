package cl.boletasystem.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.boletasystem.springboot.model.Productos;

public interface IProductosRepo extends JpaRepository<Productos, Integer>{

}
