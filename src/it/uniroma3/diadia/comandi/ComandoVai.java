package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;


public class ComandoVai implements Comando{
	private String direzione;
	private final static String NOME="vai";
	private IOConsole io=new IOConsole();
	
@Override
public void esegui(Partita partita) {
	Stanza stanzaCorrente=partita.getStanzaCorrente();
	Stanza prossimaStanza=null;	
	if(this.direzione==null) {
		io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		return;
	}
	prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
	if(prossimaStanza==null) {
		io.mostraMessaggio("Direzione inestistente");
		return;
	}
	partita.setStanzaCorrente(prossimaStanza);
	io.mostraMessaggio(partita.getStanzaCorrente().getNome());
	partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
}
@Override
public void setParametro (String parametro) {
	this.direzione=parametro;
}

@Override
public String getParametro() {
	return this.direzione;
}
@Override
public String getNome() {
	return NOME;
}
}
