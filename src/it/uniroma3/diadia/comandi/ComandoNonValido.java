package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoNonValido implements Comando{
	private IOConsole io=new IOConsole();
	private String ParametroNull;
	private final static String NOME="Comando non valido";
	
@Override
public void esegui(Partita partita) {
	io.mostraMessaggio("Hai inserito un comando non valido! \n");
}
@Override
public void setParametro(String parametro) {
	this.ParametroNull=parametro;
}

@Override
public String getParametro() {
	return this.ParametroNull;
}
@Override
public String getNome() {
	return NOME;
}
}
