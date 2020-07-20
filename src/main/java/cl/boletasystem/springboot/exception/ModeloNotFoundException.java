package cl.boletasystem.springboot.exception;

public class ModeloNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8512220264841297850L;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}

