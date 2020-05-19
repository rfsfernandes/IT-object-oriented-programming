package pt.ipbeja.po2.dispenser.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    @Test
    public void testInit() {
        Register r = new Register("XYZ", "Bolhas_Company", 2006);

        assertEquals("XYZ", r.getModel());
        assertEquals("Bolhas_Company", r.getCompanyName());
        assertEquals(2006, r.getYear());

    }

}