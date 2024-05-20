package Codice;

import java.util.ArrayList;
import java.util.Random;

public abstract class Giocatore {
	private String target;
	private ArrayList<Tentativo> tentativi;

	static String genCombinazioneCasuale() {
        Random random = new Random();
        int index = 0, maxNumber=(int) Math.pow(10, Giudice.LUNGHEZZA)-1 ;
        do {
            index = random.nextInt(maxNumber);
        } while (!Giudice.valida(String.valueOf(index)));
        return String.valueOf(index);
    }

	public boolean addTentativo(String guess, int bulls, int maggots) {
		Tentativo tentativo=new Tentativo(guess, bulls, maggots);
		tentativi.add(tentativo);
        return bulls == Giudice.LUNGHEZZA; 
	}

	public String stringaTentativi() {
		return tentativi.toString();
	}

	public abstract String generaGuess();
	public abstract String genTarget();

	public void inizializza() {
		target = genTarget();
		tentativi = new ArrayList<Tentativo>();
	}

	public Giocatore() {
		super();
		inizializza();
	}

	public String getTarget() {
		return target;
	}
}
