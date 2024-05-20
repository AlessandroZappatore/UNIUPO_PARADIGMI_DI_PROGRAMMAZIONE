
public class Quadrato extends Figura{
	private float x, y, lunghezza;

	public Quadrato(int x, int y, int lunghezza) {
		super();
		this.x = x;
		this.y = y;
		this.lunghezza = lunghezza;
	}
	
	public float area() {
		return lunghezza*lunghezza;
	}
	
	public float perimetro() {
		return lunghezza*4;
	}
	
	public boolean contenuto(float x1, float y1) {
		return ((x<=x1&&x1<=x+lunghezza)&&(y<=y1&&y1<=y+lunghezza));
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}
	
	
}
