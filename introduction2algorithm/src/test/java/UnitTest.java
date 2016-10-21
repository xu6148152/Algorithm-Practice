import com.example.dp.Fab;
import com.example.dp.LongestSubsequence;

import org.junit.Test;


/**
 * Created by binea on 2016/10/19.
 */

public class UnitTest {

    @Test
    public void testFab() {
        System.out.print(Fab.getFab(40));
    }

    @Test
    public void testLongestSubsequence() {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        int[] a = {1, 0, 0, 1, 0, 1, 0, 1, 1, 0};
        int[] b = {0, 1, 0, 1, 1, 0, 1, 1, 0};
        int[][] result = longestSubsequence.getLongestSubsequence(a, b);
        longestSubsequence.display(result, a, a.length -1 , b.length - 1);
    }
}
