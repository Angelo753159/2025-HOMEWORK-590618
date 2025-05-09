import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaNord;
	private Stanza stanzaSud;

	@BeforeEach
	public void setUp() {
		stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "nord", "chiave");
		stanzaNord = new Stanza("Stanza Nord");
		stanzaSud = new Stanza("Stanza Sud");
		stanzaBloccata.impostaStanzaAdiacente("nord", stanzaNord);
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaSud);
	}

	@Test
	public void testStanzaAdiacenteDirezioneBloccataSenzaAttrezzo() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	public void testStanzaAdiacenteDirezioneBloccataConAttrezzo() {
		stanzaBloccata.addAttrezzo(new Attrezzo("chiave", 1));
		assertEquals(stanzaNord, stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	public void testStanzaAdiacenteDirezioneDiversa() {
		assertEquals(stanzaSud, stanzaBloccata.getStanzaAdiacente("sud"));
	}

	@Test
	public void testToStringConDirezioneBloccata() {
		String output = stanzaBloccata.toString();
		assertTrue(output.contains("Direzione bloccata"));
	}
}
