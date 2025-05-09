import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;

class ComandoVaiTest {
	private Partita partita;
	private Stanza atrio;
	private Stanza biblioteca;

	@BeforeEach
	void setUp() {
		this.atrio = new Stanza("Atrio");
		this.biblioteca = new Stanza("Biblioteca");
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		this.partita = new Partita();
		this.partita.setStanzaCorrente(atrio);
	}

	@Test
	void testDirezioneNull() {
		ComandoVai comando = new ComandoVai();
		comando.setParametro(null);
		comando.esegui(partita);
		assertEquals(atrio, partita.getStanzaCorrente());
	}

	@Test
	void testDirezioneInesistente() {
		ComandoVai comando = new ComandoVai();
		comando.setParametro("sud");
		comando.esegui(partita);
		assertEquals(atrio, partita.getStanzaCorrente());
	}

	@Test
	void testDirezioneValida() {
		int cfuIniziali = partita.getGiocatore().getCfu();
		ComandoVai comando = new ComandoVai();
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(biblioteca, partita.getStanzaCorrente());
		assertEquals(cfuIniziali - 1, partita.getGiocatore().getCfu());
	}
}
