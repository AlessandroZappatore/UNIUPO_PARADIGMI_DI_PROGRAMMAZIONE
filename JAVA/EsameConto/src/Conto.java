public class Conto {
	protected int contenuto;
	
	public Conto(int contenuto) {
		this.contenuto=contenuto;
	}
	
	public int saldo() {
		return contenuto;
	}
	
	public void deposita(int cifra) {
		contenuto+=cifra;
	}
	
	public void preleva(int cifra) throws Exception {
		if(contenuto-cifra>=0) contenuto-=cifra;
	}
	
	public String toString() {
		return "Contenuto="+contenuto;
	}
}
