import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;


public class StanzaTest {
	private Stanza s;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	
	@BeforeEach
	public void setUp() {
		s = new Stanza("stanza");
		attrezzo1=new Attrezzo("attrezzo1",1);
		attrezzo2=new Attrezzo("attrezzo2",2);
		attrezzo3=new Attrezzo("attrezzo3",3);
	}
	
	//Test per il metodo addAttrezzo()
	@Test
	public void testAggiungiAttrezzo(){
		assertTrue(s.addAttrezzo(attrezzo1));
	}
	
	@Test
	public void testAggiungiAttrezzoInStanzaPiena() {
		for(int i=0;i<10;i++) {
			s.addAttrezzo(new Attrezzo("attrezzo"+i,i));
		}
		assertFalse(s.addAttrezzo(attrezzo3));
	}
	
	@Test
	public void testAggiungiAttrezzoNull () {
		assertFalse(s.addAttrezzo(null));
	}
	
	
	//Test per il metodo hasAttrezzo()

	@Test
	public void testHasAttrezzo() {
		s.addAttrezzo(attrezzo2);
		assertTrue(s.hasAttrezzo("attrezzo2"));
	}
	
	@Test
	public void testHasAttrezzoNonEsistente() {
		assertFalse(s.hasAttrezzo("attrezzononesistente"));
	}
	
	@Test
	public void testHasAttrezzoNull() {
		assertFalse(s.hasAttrezzo(null));
	}
	
	//Test per il metodo getAttrezzo()
	@Test
	public void testGetAttrezzoStanzaVuota() {
		assertNull(new Stanza("stanza").getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzoPresenteInStanza() {
		Stanza stanza=new Stanza("stanza");
		stanza.addAttrezzo(new Attrezzo("attrezzo",1));
		assertNotNull(stanza.getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzoNonPresenteInStanza() {
		Stanza stanza=new Stanza("stanza");
		stanza.addAttrezzo(new Attrezzo("attrezzo",1));
		assertNull(stanza.getAttrezzo("attrezzononpresente"));
	}
	
	//Test per il metodo getStanzaAdiacente()
	@Test
	public void testGetStanzaAdiacenteEsistente() {
		Stanza s1=new Stanza("stanza1");
		Stanza s2=new Stanza("stanza2");
		s1.impostaStanzaAdiacente("nord", s2);
		assertEquals(s2,s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteNonEsistente() {
		Stanza s=new Stanza("stanza");
		assertNull(s.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneNull() {
		Stanza s=new Stanza("stanza");
		assertNull(s.getStanzaAdiacente(null));
	}
	
}

