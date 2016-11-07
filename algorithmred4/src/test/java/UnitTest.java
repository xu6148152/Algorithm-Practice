import com.example.string.BoyerMore;

import org.junit.Test;

/**
 * Created by binea on 2016/11/7.
 */

public class UnitTest {
    @Test
    public void testBoyerMore() {
        String text = "findinahaystackneedleina";
        String pattern = "needle";
        BoyerMore boyerMore = new BoyerMore();
        int position = boyerMore.search(text, pattern);
        System.out.print(position);
    }
}
