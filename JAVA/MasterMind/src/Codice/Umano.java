package Codice;

import jbook.util.Input;

public class Umano extends Giocatore {

		
	public String generaGuess() {
		System.out.println("GENERA GUESS: ");
		return genera();
	}

	public String genTarget() {
		System.out.println("GENERA TARGET: ");
		return genera();
	}
	
	private String genera() {
		int scelta;
		String temp;
		do {
		scelta=Input.readInt("Inserire 1 se si vuole inserire manualmente\nInserire 2 se si vuole generare randomicamente\n");
		}while(scelta<1||scelta>2);
		if(scelta==1) {
			do {
				temp=Input.readString("Inserire qui: ");
			}while(!Giudice.valida(temp));
			return temp;
		}
		else 
			return genCombinazioneCasuale();
	}


	

}
