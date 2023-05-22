package errores;

public class PrecioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String texto="hay un error con los precios, modifica el fichero";
	
	public PrecioException(String texto) {
		super(texto);
	}	
}