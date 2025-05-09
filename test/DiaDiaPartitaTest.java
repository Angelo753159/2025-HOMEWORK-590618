import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IOSimulator;

public class DiaDiaPartitaTest {

    private IOSimulator io;

    @BeforeEach
    public void setUp() {
        io = new IOSimulator(5, "comando1", "comando2");
    }

    @Test
    public void testLeggiRigaSingola() {
        assertEquals("comando1", io.leggiRiga());
    }

    @Test
    public void testLeggiRigaMultipla() {
        io.leggiRiga(); // comando1
        assertEquals("comando2", io.leggiRiga());
    }

    @Test
    public void testLeggiRigaOltreLimite() {
        io.leggiRiga(); // comando1
        io.leggiRiga(); // comando2
        assertNull(io.leggiRiga()); // fuori range
    }

    @Test
    public void testMostraMessaggioSingolo() {
        io.mostraMessaggio("Messaggio di test");
        assertEquals("Messaggio di test", io.getMessaggi()[0]);
    }

    @Test
    public void testMostraMessaggioMultiplo() {
        io.mostraMessaggio("msg1");
        io.mostraMessaggio("msg2");
        String[] messaggi = io.getMessaggi();
        assertEquals("msg1", messaggi[0]);
        assertEquals("msg2", messaggi[1]);
    }

    @Test
    public void testMostraMessaggioOltreLimite() {
        io = new IOSimulator(2, "x");
        io.mostraMessaggio("msg1");
        io.mostraMessaggio("msg2");
        io.mostraMessaggio("msg3");

        String[] messaggi = io.getMessaggi();
        assertEquals("msg1", messaggi[0]);
        assertEquals("msg2", messaggi[1]);
        assertEquals(2, messaggi.length);
    }

}

