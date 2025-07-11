package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private IOConsole io=new IOConsole();
	private String NomeAttrezzo;
	private final static String NOME="prendi";

@Override
public void esegui(Partita partita) {
	Attrezzo a=partita.getStanzaCorrente().getAttrezzo(NomeAttrezzo);
		if(partita.getGiocatore().getBorsa().addAttrezzo(a)) {
			partita.getStanzaCorrente().removeAttrezzo(a);
		}
		else {
			io.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
		}
}

@Override
public void setParametro(String parametro) {
	this.NomeAttrezzo = parametro;
}

@Override
public String getParametro() {
	return this.NomeAttrezzo;
}
@Override
public String getNome() {
	return NOME;
}



}