package ohtu;

import static org.junit.Assert.*;
import org.junit.Test;

public class MultiplierTest {
    final int five = 5;
    final int one = 1;
    final int tF=35;
    final int seven = 7;

    @Test
    public void kertominenToimii() {
        Multiplier viisi = new Multiplier(five);

        assertEquals(five, viisi.multipliedBy(one));
        assertEquals(tF, viisi.multipliedBy(seven));
    }

}