package modello;

import modello.exceptions.ContattoException;

public class Contatto {
	// variabili di classe
	private static final String DEFAULT_NAME = "Default";

	// RegEx
	private final String emailRegex = "[\\w\\.]+@[\\w\\.]+\\.[\\w]{2,}";
	private final String nameRegex = "[A-Z][a-zA-Z\\s]*";
	
	// campi
	private final String email;
	
	private String nome;
	// private ArrayList<String> tels;
	
	
	// costruttori
	public Contatto(String email, String nome) throws ContattoException {
		if(!email.matches(emailRegex)) {
			throw new ContattoException("Formato email errato");
		}
		if(!nome.matches(nameRegex)) {
			throw new ContattoException("Formato nome errato");
		}
		this.email = email;
		this.nome = nome;
	//	tels = new ArrayList<String>();
	}
	
	public Contatto(String email) throws ContattoException {
		this(email, DEFAULT_NAME);
	}

	
	// getters e setters
	public static String getDefaultName() {
		return DEFAULT_NAME;
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ContattoException {
		if(!nome.matches(nameRegex)) {
			throw new ContattoException("Formato nome errato");
		}
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	
	
	// metodi

	
	public boolean matchNome(String str) {
		return nome.startsWith(str);
	}
	
	public boolean matchEmail(String str) {
		return email.equals(str);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Email: ").append(email).append("\t\t");
		sb.append("Nome: ").append(nome);
		return sb.toString();		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) { 
			return false;
		}
			return (((Contatto) obj).getEmail().equals(email));
	}	
}
