import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;

public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;

	@BeforeEach
	public void setUp() {
		stanzaBuia = new StanzaBuia("Caverna", "lanterna");
	}

	@Test
	public void testDescrizioneConAttrezzoPerVedere() {
		stanzaBuia.addAttrezzo(new Attrezzo("lanterna", 1));
		String descrizione = stanzaBuia.getDescrizione();
		assertTrue(descrizione.contains("Caverna"));
	}

	@Test
	public void testDescrizioneSenzaAttrezzo() {
		String descrizione = stanzaBuia.getDescrizione();
		assertEquals("Qui c'è un buio pesto!", descrizione);
	}

	@Test
	public void testDescrizioneConAttrezzoSbagliato() {
		stanzaBuia.addAttrezzo(new Attrezzo("candela", 1));
		String descrizione = stanzaBuia.getDescrizione();
		assertEquals("Qui c'è un buio pesto!", descrizione);
	}
}
