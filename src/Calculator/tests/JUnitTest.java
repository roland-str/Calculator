package Calculator.tests;

import org.junit.Test;

import static Calculator.Calculator.checkZero;
import static Calculator.Calculator.symbolCheck;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by evgen on 26.07.2017.*/


public class JUnitTest {

    @Test
    public void check1() {
        assertFalse(symbolCheck("542s12"));
    }

    @Test
    public void check2() {
        assertTrue(symbolCheck("153.3"));
    }

    @Test
    public void check3() {
        assertFalse(symbolCheck("12,3"));
    }

    @Test
    public void check4() {
        assertFalse(checkZero(0.0));
    }
}
