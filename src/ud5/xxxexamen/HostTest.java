package ud5.xxxexamen;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class HostTest {
    @Test
    public void testConstructor_ValidValues() {
        Host host = new Host("Servidor1", "192.168.1.1", "00:1A:2B:3C:4D:5E");
    }

    @Test
    public void testConstructor_NombreNulo() {
        try {
            new Host(null, "192.168.1.1", "00:1A:2B:3C:4D:5E");
            fail("El nombre es nulo. Debería generar una excepción");
        } catch (Exception e) {
        }
    }

    @Test
    public void testConstructor_IPInvalida() {
        try {
            new Host("Servidor1", "999,999,999.999", "00:1A:2B:3C:4D:5E");
            fail("IP inválida. Debería generar una excepción");
        } catch (Exception e) {
        }
    }

    @Test
    public void testConstructor_IPNula() {
        new Host("Servidor1", null, "00:1A:2B:3C:4D:5E");
    }

    @Test
    public void testConstructor_MACInvalida() {
        try {
            new Host("Servidor1", null, "HH:1A:2B:3C:4D:5E");
            fail("Dirección MAC inválida. Debería generar una excepción");
        } catch (Exception e) {
        }
    }

    @Test
    public void testConstructor_MACNula() {
        try {
            new Host("Servidor1", null, null);
            fail("Dirección MAC nula. Debería generar una excepción");
        } catch (Exception e) {
        }
    }

    
    /**
     * Test para comprobar los atributos estáticos.
     * Los identificadores pueden variar.
     */
    @Test
    public void testValoresEstaticos() {
        assertEquals("255.255.0.0", Host.netmask);
        assertEquals("192.168.0.11", Host.gateway);
        assertEquals("192.168.0.9", Host.nameserver);
    }


    @Test
    public void testEquals() {
        Host h1 = new Host("h1", "0.0.0.0", "00:11:22:33:44:55");
        Host h2 = new Host("h2", "0.0.0.0", "00:11:22:33:44:55");
        Host h3 = new Host("h3", "0.0.0.0", "00-11-22-33-44-55");
        Host h4 = new Host("h4", "0.0.0.0", "00-11-22-33-44-AA");
        Host h5 = new Host("h5", "0.0.0.0", "00-11-22-33-44-aa");        

        assertTrue(h1.equals(h2));
        assertFalse(h1.equals(h4));
        assertTrue(h1.equals(h3)); // Separador
        assertTrue(h4.equals(h5)); // ignoreCase
    }


    @Test
    public void testCompareTo() {
        Host h1 = new Host("A", "0.0.0.0", "00:11:22:33:44:55");
        Host h2 = new Host("A", "0.0.0.0", "00:11:22:33:44:55");
        Host h3 = new Host("B", "0.0.0.0", "00-11-22-33-44-55");        

        assertTrue(h1.compareTo(h2) == 0);
        assertTrue(h1.compareTo(h3) < 0);
        assertTrue(h3.compareTo(h1) > 0);
    }


    @Test
    public void testToString() {
        Host h1 = new Host("A", "192.168.117.200", "00:11:22:33:44:55");

        assertEquals("A (192.168.117.200 / 00:11:22:33:44:55)", h1.toString());
    }


}
