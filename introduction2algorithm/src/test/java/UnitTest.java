import com.example.dp.Fab;
import com.example.dp.LongestPalindromeSubSequence;
import com.example.dp.LongestSubsequence;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;


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

    @Test
    public void testLongestAscendSubsequence() {
        int[] a= {2, 1, 4, 3, 1, 2, 1, 5, 3};
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        TreeSet<Integer> treeSet = longestSubsequence.longestAscendSubsequence(a);
        if(treeSet == null) {
            return;
        }

        for(Integer num : treeSet) {
            System.out.printf("%d ", num);
        }
    }


    @Test
    public void testLongestPalindromeSubSequence() {
        LongestPalindromeSubSequence longestPalindromeSubSequence = new LongestPalindromeSubSequence();
        String result = longestPalindromeSubSequence.longestPalindrome("character");
        System.out.print(result);
    }
}
