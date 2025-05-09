package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String AttrezzoPerDescrizione;
	
	public StanzaBuia(String nome, String AttrezzoPerDescrizione) {
		super(nome);
		this.AttrezzoPerDescrizione=AttrezzoPerDescrizione;
	}
@Override
public String getDescrizione() {
	String buio=new String();
	buio ="Qui c'è un buio pesto!";
	if(!this.hasAttrezzo(AttrezzoPerDescrizione))
		return buio;
	return super.getDescrizione();
}
}
