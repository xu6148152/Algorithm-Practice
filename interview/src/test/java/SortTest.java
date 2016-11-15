import com.example.sort.Sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by binea on 2016/11/15.
 */

public class SortTest {

    private final long[] array = new long[10000];

    Sort sort = new Sort();

    @Before
    public void prepareData() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt();
        }
    }

    //179ms
    @Test
    public void testBubbleSort() {
        long beforeSort = System.currentTimeMillis();
        sort.bubbleSort(array);
        long afterSort = System.currentTimeMillis();
        System.out.println("time: " + (afterSort - beforeSort));
        printArray(array);
    }

    /**
     * 38ms
     */
    @Test
    public void testSelectSort() {
        long beforeSort = System.currentTimeMillis();
        sort.selectSort(array);
        long afterSort = System.currentTimeMillis();
        System.out.println("time: " + (afterSort - beforeSort));
        printArray(array);
    }

    @Test
    public void testInsertSort() {
        long beforeSort = System.currentTimeMillis();
        sort.insertSort(array);
        long afterSort = System.currentTimeMillis();
        System.out.println("time: " + (afterSort - beforeSort));
        printArray(array);
    }

    @Test
    public void testQuickSort() {
        long beforeSort = System.currentTimeMillis();
        sort.quickSort(array, 0, array.length - 1);
        long afterSort = System.currentTimeMillis();
        System.out.println("time: " + (afterSort - beforeSort));
        printArray(array);
    }

    private void printArray(long[] array) {
//        for (long i : array) {
//            System.out.print(i + ", ");
//        }
        System.out.println(Arrays.toString(array));
    }
}
