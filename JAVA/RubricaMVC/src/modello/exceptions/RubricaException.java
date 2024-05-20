package modello.exceptions;

@SuppressWarnings("serial")
public class RubricaException extends Exception{

	public RubricaException(String msg) {
		super(msg);
	}
	
	public RubricaException(String msg, Exception cause) {
		super(msg,cause);
	}
	
}