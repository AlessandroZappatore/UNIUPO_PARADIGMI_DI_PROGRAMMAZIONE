
package codice;

import jbook.util.Input;


public class Punto {
	public final String NOME;
	private int x, y;

	public Punto(int x, int y, String nome) {
		this.x = x;
		this.y = y;
		this.NOME = nome;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int newX) {
		x = newX;
	}

	public void setY(int newY) {
		y = newY;
	}

	public String toString() {
		return NOME;
	}

	public boolean equals(Object obj) {
		Input.readString("INIZIO equals di Punto, this:" + this + " obj:" + obj);
		if (obj == null || obj.getClass() != this.getClass()) {
			Input.readString("     obj.getClass()=" + obj.getClass() + ", this.getClass()=" + this.getClass());
			Input.readString("FINE equals di Punto, this:" + this + " obj:" + obj + " RITORNA:" + false);
			return false;
		}
		Input.readString("     obj.getClass()=" + obj.getClass() + ", this.getClass()=" + this.getClass());
		Punto pun = (Punto) obj;
		boolean b = (this.x == pun.getX() && this.y == pun.getY());
		Input.readString("     this.x=" + this.x + ", pun.getX()=" + pun.getX() + ", this.y=" + this.y
				+ ", pun.getY()=" + pun.getY() + "\n");
		Input.readString("FINE equals di Punto, this:" + this + " obj:" + obj + " RITORNA:" + b);
		return b;
	}

	

}
