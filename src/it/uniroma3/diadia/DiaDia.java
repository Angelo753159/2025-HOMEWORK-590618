package it.uniroma3.diadia;

//import java.util.Scanner;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.IOConsole;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu-1);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	/**
	 * Prende un oggetto
	 *
	 */
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Attrezzo inesistente");
		Stanza s=this.partita.getStanzaCorrente();
		Attrezzo attrezzoDaPrendere=s.getAttrezzo(nomeAttrezzo);
		if(attrezzoDaPrendere==null)
			io.mostraMessaggio("L'oggetto "+nomeAttrezzo+"non è presente");
		else if(this.partita.getGiocatore().getBorsa().getPeso()==this.partita.getGiocatore().getBorsa().getPesoMax()) {
			io.mostraMessaggio("Non puoi prendere l'attrezzo, hai superato il peso massimo della borsa!");
		}
		else {
			if(this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) {
				s.removeAttrezzo(attrezzoDaPrendere);
				io.mostraMessaggio("Hai preso: " +nomeAttrezzo);
		}
			else {
				io.mostraMessaggio("Errore! Non puoi prendere l'oggetto");
			}
		}
		
		}
	
	/**
	 * Posa un oggetto
	 *
	 */
	private void posa(String nomeAttrezzo) {
		if(partita.getGiocatore().getBorsa().getPeso()==0)
			io.mostraMessaggio("Comando non eseguibile, borsa vuota!");
	 Attrezzo attrezzo=this.partita.getGiocatore().posareAttrezzo(nomeAttrezzo);
	 if(attrezzo==null)
		 io.mostraMessaggio("Non hai questo oggetto nella borsa");
	 else {
		 if(this.partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
			 io.mostraMessaggio("Hai posato: "+attrezzo.getNome());
		 }
		 else {
			 io.mostraMessaggio("Non puoi posare l'oggetto, la stanza è piena!");
		 }
	 }
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] args) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}