package modello;

import java.util.ArrayList;

import modello.exceptions.ContattoException;
import modello.exceptions.RubricaException;

public class Rubrica {
	// variabili di classe
	private static final int DEFAULT_MAX_DIM = 10;
	private static final String DEFAULT_NAME = "Rubrica";

	// campi
	private final int maxDim;
	private final String nome;
	private ArrayList<Contatto> rubrica;

	// costruttori
	public Rubrica(int maxDim, String nome) {
		this.maxDim = maxDim;
		this.nome = nome;
		rubrica = new ArrayList<>();
	}

	public Rubrica(int maxDim) {
		this(maxDim, DEFAULT_NAME);
	}

	public Rubrica(String nome) {
		this(DEFAULT_MAX_DIM, nome);
	}

	public Rubrica() {
		this(DEFAULT_MAX_DIM);
	}

	// getters e setters
	public static int getDefaultMaxDim() {
		return DEFAULT_MAX_DIM;
	}

	public static String getDefaultName() {
		return DEFAULT_NAME;
	}

	public int getMaxDim() {
		return maxDim;
	}

	public String getNome() {
		return nome;
	}

	// metodi
	public void svuota() {
		rubrica.clear();
	}

	public int aggiungi(String email, String nome) throws RubricaException {
		Contatto temp;
		try {
			temp = new Contatto(email, nome);
		} catch (ContattoException e) {
			System.out.println(e.getMessage());
			throw new RubricaException("Eccezione Contatto", e);
		}
		return aggiungi(temp);
	}

	public int aggiungi(String email) throws RubricaException {
		Contatto temp;
		try {
			temp = new Contatto(email);
		} catch (ContattoException e) {
			throw new RubricaException("Eccezione Contatto", e);
		}
		return aggiungi(temp);
	}

	public int aggiungi(Contatto contatto) throws RubricaException {
		if (rubrica.size() >= maxDim) {
			throw new RubricaException("Dimensione massima raggiunta");
		}
		if (rubrica.contains(contatto)) {
			throw new RubricaException("Contatto già presente");
		}
		rubrica.add(contatto);
		return 1;
	}

	public ArrayList<Contatto> cercaNome(String nome) {
		ArrayList<Contatto> res = new ArrayList<>();
		for (Contatto c : rubrica) {
			if (c.matchNome(nome)) {
				res.add(c);
			}
		}
		return res;
	}

	public ArrayList<Contatto> cercaEmail(String email) {
		ArrayList<Contatto> res = new ArrayList<>();
		for (Contatto c : rubrica) {
			if (c.matchEmail(email)) {
				res.add(c);
			}
		}
		return res;
	}

	public boolean eliminaNome(String nome) {
		return rubrica.removeAll(cercaNome(nome));
	}

	public boolean eliminaEmail(String email) {
		return rubrica.removeAll(cercaEmail(email));
	}

	public int numEl() {
		return rubrica.size();
	}

	public String[] toArray(){
		String[] res=new String[rubrica.size()];
		for(int i=0;i<rubrica.size();i++) {
			res[i]=rubrica.get(i).toString();
		}
		return res;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			if (rubrica.isEmpty()) {
			sb.append("Nessun contatto presente nella rubrica\n");
		} else {
			for (Contatto c : rubrica) {
				sb.append(c.toString()).append("\n");
			}
		}
		return sb.toString();
	}
}
