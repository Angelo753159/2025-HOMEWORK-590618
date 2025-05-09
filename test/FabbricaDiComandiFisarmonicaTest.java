import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.comandi.*;

public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandi factory;

	@BeforeEach
	public void setUp() {
		this.factory = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testComandoVai() {
		Comando c = factory.costruisciComando("vai nord");
		assertEquals("vai", c.getNome());
		assertEquals("nord", c.getParametro());
	}

	@Test
	public void testComandoPrendi() {
		Comando c = factory.costruisciComando("prendi osso");
		assertEquals("prendi", c.getNome());
		assertEquals("osso", c.getParametro());
	}

	@Test
	public void testComandoPosa() {
		Comando c = factory.costruisciComando("posa chiave");
		assertEquals("posa", c.getNome());
		assertEquals("chiave", c.getParametro());
	}

	@Test
	public void testComandoSoloNome() {
		Comando c = factory.costruisciComando("fine");
		assertEquals("fine", c.getNome());
		assertNull(c.getParametro());
	}

}
