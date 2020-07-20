package cl.boletasystem.springboot.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.boletasystem.springboot.model.Compras;


public interface IComprasRepo extends JpaRepository<Compras, Integer>{


	@Query("from Compras c where c.proveedor.rut =:rut or LOWER(c.proveedor.razonsocial) like %:razonSocial%")
	List<Compras> buscar(@Param("rut")String rut,@Param("razonSocial") String razonSocial);

	// se usa para buscar entre dos fechas
	@Query("from Compras c where c.fecha between :fechaCompra and :fechaSgte")
	List<Compras> buscarFecha(@Param("fechaCompra") LocalDateTime fechaCompra, @Param("fechaSgte") LocalDateTime fechaSgte);

}
