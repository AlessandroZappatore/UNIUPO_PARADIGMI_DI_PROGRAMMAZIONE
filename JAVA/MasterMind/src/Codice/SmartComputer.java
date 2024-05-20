package Codice;

import java.util.ArrayList;

public class SmartComputer extends Computer {

    private ArrayList<String> targetPossibili;

    public SmartComputer() {
        super(); 
        targetPossibili = Giudice.combValide(Giudice.comb(Giudice.LUNGHEZZA, Giudice.CHARS));
    }


    public int numTargetPossibili() {
        return targetPossibili.size();
    }

    public boolean isTargetPossibile(String str) {
        return targetPossibili.contains(str);
    }

    public ArrayList<String> getTargetPossibili() {
		return targetPossibili;
	}



    @Override
    public String genGuess() {
        if (targetPossibili.isEmpty()) {
            // Se non ci sono più opzioni possibili, genera un guess casuale
            return generateRandomGuess();
        }

        // Trova il guess che riduce il numero di possibili target in modo efficace
        String bestGuess = targetPossibili.get(0);
        int bestReduction = Integer.MAX_VALUE;

        for (String guess : targetPossibili) {
            int reduction = calcolaRiduzionePossibili(guess);
            if (reduction < bestReduction) {
                bestReduction = reduction;
                bestGuess = guess;
            }
        }

        // Segna il guess come già scelto, ma non lo rimuove
        targetPossibili.remove(bestGuess);
        targetPossibili.add(bestGuess + "_chosen");

        return bestGuess;
    }


    private int calcolaRiduzionePossibili(String guess) {
        int reduction = 0;

        for (String target : targetPossibili) {
            int bulls = Giudice.numBulls(guess, target);
            int maggots = Giudice.numMaggots(guess, target);

            if (bulls != Giudice.numBulls(target, guess) || maggots != Giudice.numMaggots(target, guess)) {
                reduction++;
            }
        }

        return reduction;
    }

    private String generateRandomGuess() {
        int index = (int) (Math.random() * Giudice.comb(Giudice.LUNGHEZZA, Giudice.CHARS).size());
        return Giudice.comb(Giudice.LUNGHEZZA, Giudice.CHARS).get(index);
    }

}
