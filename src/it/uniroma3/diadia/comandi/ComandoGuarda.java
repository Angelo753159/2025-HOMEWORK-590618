package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoGuarda implements Comando{
	private String pNull;
	private IOConsole io=new IOConsole();
	private final static String NOME="guarda";
	
@Override
public void esegui(Partita partita) {
	io.mostraMessaggio(partita.getStanzaCorrente().toString());
}

@Override
public void setParametro(String parametro) {
	this.pNull = parametro;
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
