package ud5.xxxexamen;

import org.junit.Test;

public class ClienteTest {
    @Test
    public void testConstructor_ValidValues() {
        Cliente cWin1 = new Cliente("Cliente1", "192.168.1.2", "02:1A:2B:3C:4D:5E", SO.WINDOWS, "1920x1080");
    }
}
