package Eccezioni;

@SuppressWarnings("serial")
public class RubricaException extends Exception{

	public RubricaException(String message) {
		super(message);
	}

	public RubricaException() {
		super("Eccezione Rubrica!");
	}
}
