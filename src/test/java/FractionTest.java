import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest
{
    Fraction fraction1;
    Fraction fraction2;
    Fraction fraction3;

    @Before
    public void setup()
    {
        System.out.println("Running Default Constructor Test");
        fraction1 = new Fraction();
        fraction2 = new Fraction(3, 4);
        fraction3 = new Fraction(1, 2);
    }

    @After
    public void tearDown()
    {
        System.out.println("Completed Default Constructor Test");
        fraction1 = null;
        fraction2 = null;
        fraction3 = null;
    }

    @Test
    public void testDVC()
    {
        assertEquals(fraction1.getNumerator(), 0);
        assertEquals(fraction1.getDenominator(), 1);
        System.out.println("Completed DVC test");
    }

    @Test
    public void testEVC()
    {
        assertEquals(fraction2.getNumerator(), 3);
        assertEquals(fraction2.getDenominator(), 4);
    }
}
