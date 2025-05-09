import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {
	private Partita partita;
	private Stanza stanza;

	@BeforeEach
	void setUp() {
		partita = new Partita();
		stanza = new Stanza("Atrio");
		partita.setStanzaCorrente(stanza);
	}

	@Test
	void testPrendiAttrezzoEsistente() {
		Attrezzo osso = new Attrezzo("osso", 1);
		stanza.addAttrezzo(osso);

		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro("osso");
		comando.esegui(partita);

		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
		assertFalse(stanza.hasAttrezzo("osso"));
	}

	@Test
	void testPrendiAttrezzoInesistente() {
		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro("lanterna");
		comando.esegui(partita);

		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
	}
}
