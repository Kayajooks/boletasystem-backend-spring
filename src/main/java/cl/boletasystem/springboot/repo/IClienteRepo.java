package cl.boletasystem.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.boletasystem.springboot.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{

}
