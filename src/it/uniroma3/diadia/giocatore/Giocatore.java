package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private int CFUgiocatore;
	private Borsa borsa;
	
	
	public Giocatore() {
		this.borsa=new Borsa();
	}
	
	public int getCfu() {
		return CFUgiocatore;
	}
	
	public void setCfu(int cfu) {
		this.CFUgiocatore=cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa=borsa;
	}
	
	public boolean prendereAttrezzo(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}
	
	public Attrezzo posareAttrezzo(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);
	}
}
