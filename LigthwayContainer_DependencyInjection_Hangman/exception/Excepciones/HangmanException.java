package Excepciones;

public class HangmanException extends Exception {
	public static final String EXCESO_ERROR = "El usuario no se puede equivocar mas de 25 veces";
	public static final String EXCESO_TOTAL = "lA SUMA DE ACIERTOS Y ERRORES NO PUEDE SOBREPASAR 27";
	
	public HangmanException(String message) {
		super(message);
	}
}
