
import jbook.util.Input;
public class Main {

	public static void main(String[] args) {
		Mese mese=meseUtente();
		Stagione stagione=daMeseStagione(mese);

	}

	

	private static Stagione daMeseStagione(Mese mese) {
		// TODO Auto-generated method stub
		return null;
	}



	private static Mese meseUtente() {
		String inserimento=Input.readString("Inserire il mese: ");

		return switch(inserimento) {
		case GENNAIO -> "Gennaio";
		case FEBBRAIO -> "Febbraio";
		case MARZO -> "Marzo";
		case APRILE -> "Aprile";
		case MAGGIO -> "Maggio";
		case GIUGNO -> "Giugno";
		case LUGLIO -> "Luglio";
		case AGOSTO -> "Agosto";
		case SETTEMBRE -> "Settembre";
		case OTTOBRE -> "Ottobre";
		case NOVEMBRE -> "Novembre";
		case DICEMBRE -> "Dicembre";
		default -> "Mese non esistente";
		};
	}

}
