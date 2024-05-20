package eccezioni;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class listaException extends Exception{
	public listaException(String msg) {
		super(msg);
	}
	
	public listaException(String msg, Exception cause) {
		super(msg, cause);
	}
}
