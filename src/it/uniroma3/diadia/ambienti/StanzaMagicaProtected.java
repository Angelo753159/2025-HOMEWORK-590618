package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
    final static protected int SOGLIA_MAGICA_DEFAULT = 3;
    protected int contatoreAttrezziPosati;
    protected int sogliaMagica;

    public StanzaMagicaProtected(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagicaProtected(String nome, int sogliaMagica) {
        super(nome);
        this.sogliaMagica = sogliaMagica;
        this.contatoreAttrezziPosati = 0;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.contatoreAttrezziPosati++;
        if (this.contatoreAttrezziPosati > this.sogliaMagica) {
            attrezzo = this.modificaAttrezzo(attrezzo);
        }
        return super.addAttrezzo(attrezzo);
    }

    protected Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse();
        int pesoDoppio = attrezzo.getPeso() * 2;
        return new Attrezzo(nomeInvertito.toString(), pesoDoppio);
    }

    public int getContatoreAttrezziPosati() {
        return this.contatoreAttrezziPosati;
    }
}
