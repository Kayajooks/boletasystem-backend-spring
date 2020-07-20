package cl.boletasystem.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.boletasystem.springboot.model.Ventas;

public interface IVentasRepo extends JpaRepository<Ventas, Integer>{

}
