package Codice;

import java.util.ArrayList;
import java.util.Iterator;

import Eccezioni.ContattoException;
import Eccezioni.RubricaException;

public class Rubrica implements Iterable<Contatto>{
    private final int maxDim;
    private final String nome;
    private static int numRubriche = 0;
    private static final int MAX_DIM = 6;

    ArrayList<Contatto> rubrica;

    public Rubrica(int maxDim, String nome) {
        this.maxDim = maxDim;
        this.nome = nome;
        rubrica = new ArrayList<>();
        numRubriche++;
    }

    public int getMaxDim() {
        return maxDim;
    }

    public String getNome() {
        return nome;
    }

    public static int getNumRubriche() {
        return numRubriche;
    }

    public static void setNumRubriche(int numRubriche) {
        Rubrica.numRubriche = numRubriche;
    }

    public int numEl() {
        return rubrica.size();
    }

    public Rubrica(int maxDim) {
        this(maxDim, "rubrica:" + numRubriche);
    }

    public Rubrica(String nome) {
        this(MAX_DIM, nome);
    }

    public Rubrica() {
        this(MAX_DIM);
    }

    public int aggiungi(String email, String nome) throws RubricaException, ContattoException {
        return aggiungi(new Contatto(email, nome));
    }

    public int aggiungi(String email) throws RubricaException, ContattoException {
        return aggiungi(new Contatto(email));
    }

    public int aggiungi(Contatto c) throws RubricaException {
        if (!rubrica.contains(c) && rubrica.size() < maxDim) {
            rubrica.add(c);
            return 1;
        } else if (rubrica.contains(c)) {
            throw new RubricaException("Contatto gia' presente!");
        } else {
        	throw new RubricaException("Dimensione eccessiva!");
        }
    }

    public ArrayList<Contatto> ricercaPerNome(String prefisso) {
        ArrayList<Contatto> risultato = new ArrayList<>();
        for (Contatto next : rubrica)
            if (next.matchNome(prefisso))
                risultato.add(next);
        return risultato;
    }

    public ArrayList<Contatto> ricercaPerEmail(String prefisso) {
        ArrayList<Contatto> risultato = new ArrayList<>();
        for (Contatto next : rubrica)
            if (next.matchEmail(prefisso))
                risultato.add(next);
        return risultato;
    }

    public boolean eliminaPerNome(String nome) {
        return rubrica.removeAll(ricercaPerNome(nome));
    }

    public boolean eliminaPerEmail(String email) {
        return rubrica.removeAll(ricercaPerEmail(email));
    }
    
    public Iterator<Contatto> iterator() {
        return rubrica.iterator();
    }
    
    public static boolean ripetuti ( Rubrica rubrica ) {
    	for ( Contatto c : rubrica ) {
    	ArrayList <Contatto> res = rubrica.ricercaPerEmail (c.getEmail());
    	if (res.size() > 1) return true;
    	}
    	return false;
    	}
}
