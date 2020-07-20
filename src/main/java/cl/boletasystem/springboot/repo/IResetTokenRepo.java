package cl.boletasystem.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.boletasystem.springboot.model.ResetToken;



public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {
	
	ResetToken findByToken(String token);

}
