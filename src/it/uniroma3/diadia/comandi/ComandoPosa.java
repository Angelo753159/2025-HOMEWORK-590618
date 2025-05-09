package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private IOConsole io=new IOConsole();
	private String NomeAttrezzo;
	private final static String NOME="posa";
	
@Override
public void esegui(Partita partita) {
	if(partita.getGiocatore().getBorsa().getPeso()==0) {
	io.mostraMessaggio("Comando non eseguibile, borsa vuota!");
	return;
	}
	Attrezzo a=partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo);
	if(a==null) {
		io.mostraMessaggio("Non hai questo oggetto nella borsa!");
		return;
	}
		if(partita.getStanzaCorrente().addAttrezzo(a)) {
			partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);
			io.mostraMessaggio("Hai posato: " +NomeAttrezzo);
}
		else {
			io.mostraMessaggio("Non c'è spazio nella stanza per poter inserire l'oggetto!");
		}
}

@Override
public void setParametro(String parametro) {
	this.NomeAttrezzo =parametro;
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