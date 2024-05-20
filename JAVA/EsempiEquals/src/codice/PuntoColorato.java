

package codice;

import jbook.util.Input;

public class PuntoColorato extends Punto {

	private String colore;

	public PuntoColorato(int x, int y, String nome) {
		this(x, y, "nero", nome);
	}

	public PuntoColorato(int x, int y, String colore, String nome) {
		super(x, y, nome);
		this.colore = colore;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public boolean equals(Object obj) {
		Input.readString("INIZIO equals di PuntoColorato, this:" + this + " obj:" + obj);
		if (!super.equals(obj)) {
			Input.readString("FINE equals di PuntoColorato, this:" + this + " obj:" + obj + " RITORNA:" + false);
			return false;
		}
		PuntoColorato punC = (PuntoColorato) obj;
		boolean b = this.colore.equals(punC.getColore());
		Input.readString("     this.colore=" + this.colore + ", punC.getColore()=" + punC.getColore());
		Input.readString("FINE equals di PuntoColorato, this:" + this + " obj:" + obj + " RITORNA:" + b);
		return (b);
	}
	
	

}
