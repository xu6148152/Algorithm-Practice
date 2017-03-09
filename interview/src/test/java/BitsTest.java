import com.example.bits.Bits;

import org.junit.Test;

/**
 * Created by binea on 2016/11/12.
 */

public class BitsTest {

    @Test
    public void testPrintBinary() {
        Bits bits = new Bits();
        System.out.print(bits.printBinary(0.1));
    }
}
