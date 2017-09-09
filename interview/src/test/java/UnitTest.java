import com.example.LongestIncreasingArray;

import org.junit.Test;

import java.util.Random;

/**
 * Created by binea on 8/9/2017.
 */

public class UnitTest {
    @Test
    public void testGetLongestSubArray() {
        int[] array = {10, 1, 3, 2, 5, 7, 8, 9, 6, 4};
        LongestIncreasingArray longestIncreasingArray = new LongestIncreasingArray();
        int[] result = longestIncreasingArray.getLongestIncreasingArrayDp(array);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
