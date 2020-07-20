package cl.boletasystem.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.boletasystem.springboot.model.Proveedor;

public interface IProveedorRepo extends JpaRepository<Proveedor, Integer>{

}
