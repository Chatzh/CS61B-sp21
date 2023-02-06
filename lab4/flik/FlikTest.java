package flik;

import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void flikTest() {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            boolean isEuqal = Flik.isSameNumber(i, j);
            assertTrue(isEuqal);
        }
    }
}
