package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.*;

public class ComandoAiuto implements Comando{
	private String pNull;
	private final static String NOME="aiuto";
	private IOConsole io=new IOConsole();
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};

	
@Override
public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
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
