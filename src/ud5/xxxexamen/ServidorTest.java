package ud5.xxxexamen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class ServidorTest {
    @Test
    public void testServidorAddServicio() {
        Servidor s = new Servidor("lapaman", "192.168.0.9", "AA:11:22:33:44:55");
        assertTrue(s.addServicio("HTTP", 80, "TCP"));
        assertFalse(s.addServicio("Web", 80, "TCP"));
        assertTrue(s.addServicio("DNS", 53, "UDP"));
    }    
}
