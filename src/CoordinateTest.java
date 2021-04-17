// Unit testing Coordinate.java

package testing;
import static org.junit.Assert.*;

class CoordinateTest
{
    @Test
    public void test() {
        Coordinate c = new Coordinate();
        JunitTesting test = new JunitTesting();
        int output = test.c.x;
        assertEquals(0,output);
    }
}