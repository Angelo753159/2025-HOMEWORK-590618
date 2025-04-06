import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Stanza;

class BorsaTest {
	private Borsa b;
	private Attrezzo a;
	private Attrezzo c;
	private Stanza s;
	private Giocatore g;
	
	@BeforeEach
	public void setUp() {
		b=new Borsa();
		a=new Attrezzo("attrezzoA",6);
		c=new Attrezzo("attrezzoC",12);
		s=new Stanza("stanza");
		g=new Giocatore();
		
	}
	
	//Test per il metodo addAttrezzo()
	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(a));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(b.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzoOltrePesoMax() {
		assertFalse(b.addAttrezzo(c));
	}
	
	
	//Test per il metodo PesoMax()
	@Test
	public void testPesoMax() {
		assertFalse(b.getPesoMax()==2);
	}
	
	//Test per verificare peso aggiornato
	@Test
	public void testAggiornaPesoDopoAverPresoUnOggetto() {
		s.addAttrezzo(a);
		g.prendereAttrezzo(a);
		assertEquals(6,g.getBorsa().getPeso());
	}
	
}
