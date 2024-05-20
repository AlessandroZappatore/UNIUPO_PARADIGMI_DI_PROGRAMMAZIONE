
public class ContoConEccezioni extends Conto{
	private int maxScoperto;
	
	public ContoConEccezioni(int contenuto, int maxScoperto) {
		super(contenuto);
		this.maxScoperto=maxScoperto;
	}
	
	public ContoConEccezioni(int contenuto) {
		this(contenuto, 0);
	}
	
	public void preleva(int cifra) throws Exception {
		if(contenuto-cifra<-maxScoperto) throw new Exception("Saldo insufficiente");
		else contenuto-=cifra;
	}
	
	public String toString() {
		return "Contenuto="+contenuto+", maxScoperto="+maxScoperto;
	}
	
	public int getMaxScoperto() {
		return maxScoperto;
	}
}
