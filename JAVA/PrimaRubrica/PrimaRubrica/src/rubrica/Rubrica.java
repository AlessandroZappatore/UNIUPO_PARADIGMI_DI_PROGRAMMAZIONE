package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private static ArrayList<String> rubrica;
	public static final int MAX_DIM = 3;

	public static void crea() {
		rubrica = new ArrayList<String>();
	}

	public static void svuota() {
		rubrica.clear();
	}

	public static int numEl() {
		return rubrica.size();
	}

	public static int aggiungi(String contatto) {
		if (rubrica.contains(contatto))
			return 0;
		if (rubrica.size() >= MAX_DIM)
			return -1;
		rubrica.add(contatto);
		return 1;
	}

	public static ArrayList<String> ricerca(String prefisso) {
		ArrayList<String> risultato = new ArrayList<>();
		for (String s : rubrica) {
			String[] parti = s.split("=");
			if (parti.length == 2 && parti[1].startsWith(prefisso)) {
				risultato.add(s);
			}
		}
		return risultato;
	}

	public static boolean elimina(String s) {
		boolean almenoUnoRimosso = false;
		ArrayList<String> daRimuovere = new ArrayList<>();

		for (String a : rubrica) {
			if (a.startsWith(s)) {
				daRimuovere.add(a);
				almenoUnoRimosso = true;
			}
		}

		rubrica.removeAll(daRimuovere);

		return almenoUnoRimosso;
	}
}
