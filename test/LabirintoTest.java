import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.*;



class LabirintoTest {
	private Labirinto l;
	private Stanza iniziale;
	private Stanza finale;
	
	
	@BeforeEach
	public void setUp() {
		l=new Labirinto();
		iniziale=new Stanza("Atrio");
		finale=new Stanza("Biblioteca");
		
	}
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals(iniziale.getNome(),l.getStanzaIniziale().getNome());	
	}
	
	@Test
	public void testGetStanzaFinale() {
		assertEquals(finale.getNome(),l.getStanzaFinale().getNome());
	}
	
}
