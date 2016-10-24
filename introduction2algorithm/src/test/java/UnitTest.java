import com.example.dp.Fab;
import com.example.dp.LongestPalindromeSubSequence;
import com.example.dp.LongestSubsequence;
import com.example.dp.Package01Answer;

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

    @Test
    public void testPackageAnswer() {
        Package01Answer package01Answer = new Package01Answer();
        int[] values = {60, 100, 120};
        int[] result = package01Answer.getPackageAnswer(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
