import gui.RubricaGui;
import modello.Rubrica;
import modello.exceptions.RubricaException;

public class Main {
	private static Rubrica rubrica;
	private static Rubrica rubrica1;

	public static void main(String[] args) {

		rubrica = new Rubrica(10, "Amici");
		try {
			rubrica.aggiungi("anna@uniupo.it", "Antoci Anna");
			rubrica.aggiungi("giuliana@uniupo.it", "Cavallari Giuliana");
			rubrica.aggiungi("pietro@uniupo.it", "Neri Pietro");
			rubrica.aggiungi("marco@gmail.com", "Rossi Marco");
			rubrica.aggiungi("giovanni@hotmail.com", "Verdi Giovanni");
			} catch (RubricaException e) {
			System.out.println("RubricaException" + e.getMessage());
		}

		interfacciaGrafica();
		interfacciaRigaComando();
	}

	private static void interfacciaRigaComando() {
		System.out.println("Salve\n");
	}

	private static void interfacciaGrafica() {
		new RubricaGui(rubrica);
	}

}