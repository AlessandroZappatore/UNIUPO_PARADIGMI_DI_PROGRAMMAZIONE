public class Cerchio implements Figura{
	final double PI=3.14;
	private float r;
	
	public Cerchio(float r) {
		super();
		this.r = r;
	}

	public float area() {
		return (float) (PI*r*r);
	}
	
	public float perimetro() {
		return (float) (2*PI*r);
	}
}
