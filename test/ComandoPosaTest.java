import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	private Partita partita;
	private Stanza stanza;

	@BeforeEach
	void setUp() {
		partita = new Partita();
		stanza = new Stanza("Atrio");
		partita.setStanzaCorrente(stanza);

		// metto un attrezzo nella borsa
		Attrezzo osso = new Attrezzo("osso", 1);
		partita.getGiocatore().getBorsa().addAttrezzo(osso);
	}

	@Test
	void testPosaAttrezzoEsistenteInBorsa() {
		ComandoPosa comando = new ComandoPosa();
		comando.setParametro("osso");
		comando.esegui(partita);
		assertTrue(stanza.hasAttrezzo("osso"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}

	@Test
	void testPosaAttrezzoNonPresenteInBorsa() {
		ComandoPosa comando = new ComandoPosa();
		comando.setParametro("lanterna");
		comando.esegui(partita);
		assertFalse(stanza.hasAttrezzo("lanterna"));
	}
}
