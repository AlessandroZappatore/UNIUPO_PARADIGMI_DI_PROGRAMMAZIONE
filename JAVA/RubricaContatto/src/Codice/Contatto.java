
package Codice;

import java.util.ArrayList;

import Eccezioni.ContattoException;

public class Contatto {
	private static final String NOME_DEFAULT = " ";
	private final String email;
	private String nome;
	private ArrayList<String> tels;
	private String emailPattern=".+@.+";
	private String nomePattern = "[\\s]*[a-zA-Z]+[\\s]*[a-zA-Z]+";
	private String numeroPattern="[0-9]+";

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public Contatto(String email, String nome) throws ContattoException {
		this.email = emailValida(email);
		this.nome = nomeValida(nome);
		tels = new ArrayList<String>();
	}

	public Contatto(String email) throws ContattoException {
		this(email, NOME_DEFAULT);
	}

	public boolean inserisciNumTel(String num) throws ContattoException {
		numeroValida(num);
		if (tels.contains(num))
			return false;
		else {
			tels.add(num);
			return true;
		}
	}

	public boolean eliminaNumTel(String num) {
		if (tels.contains(num)) {
			tels.remove(num);
			return true;
		} else
			return false;
	}

	public String numTel() {
		return tels.toString();
	}

	public boolean matchNome(String str) {
		if (nome.startsWith(str))
			return true;
		else
			return false;
	}

	public boolean matchEmail(String str) {
		if (email.equals(str))
			return true;
		else
			return false;
	}

	public boolean equals(Object contatto) {
		if (contatto instanceof Contatto) {
			Contatto c = (Contatto) contatto;
			return (c.getEmail().equals(this.getEmail()));
		} else
			return false;
	}
	
	private String emailValida(String email) throws ContattoException {
		if(email.matches(emailPattern)) return email;
		else throw new ContattoException("Email non valida!");
	}
	
	private String nomeValida(String nome) throws ContattoException{
		if(nome.matches(nomePattern)) return nome;
		else throw new ContattoException("Nome non valido!");
	}
	
	private void numeroValida(String num) throws ContattoException{
		if(!num.matches(numeroPattern)) throw new ContattoException("Numero non valido!");
	}

}
