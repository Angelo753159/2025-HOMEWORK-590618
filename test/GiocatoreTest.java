import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.Partita;


class GiocatoreTest {
	private Giocatore g;
	private Partita p;
	
	@BeforeEach
	public void setUp() {
		g=new Giocatore();
		p=new Partita();
	}
	
	@Test
	public void testGetCfuDefiniti() {
		assertEquals(20, p.getGiocatore().getCfu());
	}
	
	@Test
	public void testSetCfu() {
		g.setCfu(3);
		assertEquals(3,g.getCfu());
	}
	
	@Test
	public void testGetBorsaDefinita() {
		assertNotNull(g.getBorsa());
	}
	
}
