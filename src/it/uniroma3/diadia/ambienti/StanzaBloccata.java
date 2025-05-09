package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaBloccata extends Stanza{
	private String DirezioneBloccata;
	private String AttrezzoSblocca;

public StanzaBloccata(String nome, String DirezioneBloccata, String AttrezzoSblocca) {
super(nome);
this.DirezioneBloccata=DirezioneBloccata;
this.AttrezzoSblocca=AttrezzoSblocca;
}

@Override
public Stanza getStanzaAdiacente(String dir) {
	if(this.hasAttrezzo(this.AttrezzoSblocca))
		return super.getStanzaAdiacente(dir);
	else if (this.DirezioneBloccata!=dir)
		return super.getStanzaAdiacente(dir);
	else
		return this;
}


@Override
public String toString() {
	StringBuilder risultato = new StringBuilder();
	risultato.append(this.getNome());
	risultato.append(""
			+ "Uscite: ");
	for (String direzione : this.getDirezioni())
		if (direzione!=null) {
			if(direzione != this.DirezioneBloccata)
				risultato.append(" " + direzione);
			else
				risultato.append("Direzione bloccata");
		}
	risultato.append(""
			+ "Attrezzi nella stanza: ");
	for (Attrezzo attrezzo : this.getAttrezzi()) {
		if (attrezzo != null) {
			risultato.append(attrezzo.toString()+" ");
		}
	}
	return risultato.toString();
}
}
