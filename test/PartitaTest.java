import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;


public class PartitaTest{
	private Partita p;
	private Giocatore g;

	@BeforeEach 
	public void setUp() {
		p=new Partita();
		g=p.getGiocatore();
	}
	
	//Test per il metodo isFinita()
	//Test partita finita senza vittoria
	@Test
	public void testPartitaFinitaNonVintaAllInizio() {
		assertFalse(p.isFinita());
	}
	
	//Test partita finita con vittoria
	@Test
	public void testPartitaFinitaVittoria() {
		p.setStanzaCorrente(p.getLabirinto().getStanzaFinale());
		assertTrue(p.isFinita());
	}
	
	//Test partita finita per esaurimento CFU
	@Test
	public void testPartitaFinitPerEsaurimentoCFU() {
		g.setCfu(0);
		assertTrue(p.isFinita());
	}
	
	//Test per il metodo vinta()
	@Test
	public void testVittoriaDopoCreazione() {
		assertFalse(p.vinta());
	}
	
	@Test
	public void testVittoriaDopoSetStanzaCorrenteNonVincente() {
		Stanza stanza1= new Stanza("stanza 1");
		p.setStanzaCorrente(stanza1);
		assertFalse(p.vinta());
	}

	
	@Test
	public void testGetCfuInizialiCorretti() {
		assertEquals(20, p.getGiocatore().getCfu());
	}
	
}
