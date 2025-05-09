package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoFine implements Comando{
	private IOConsole io=new IOConsole();
	private String pNull;
	private final static String NOME="fine";
	private final static String MESSAGGIO_FINE="Grazie di aver giocato!";
	
@Override
public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE);  // si desidera smettere
}
@Override
public void setParametro(String pNull) {
	this.pNull = pNull;
}

@Override
public String getParametro() {
	return this.pNull;
}
@Override
public String getNome() {
	return NOME;
}
}
