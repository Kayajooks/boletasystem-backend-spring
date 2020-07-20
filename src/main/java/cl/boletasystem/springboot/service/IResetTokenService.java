package cl.boletasystem.springboot.service;

import cl.boletasystem.springboot.model.ResetToken;

public interface IResetTokenService{

	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}
