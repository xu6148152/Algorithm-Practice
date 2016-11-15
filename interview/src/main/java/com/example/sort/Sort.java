package com.example.sort;

/**
 * Created by binea on 2016/11/15.
 */

public class Sort {

    /**
     * stable
     * bubble sort
     *
     * @param array
     */
    public void bubbleSort(long[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap1(array, i, j);
                }
            }
        }
    }

    /**
     * not stable
     *
     * @param array
     */
    public void selectSort(long[] array) {
        assert array != null;
        for (int i = 0; i < array.length; i++) {
            int k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[k] > array[j]) {
                    k = j;
                }
            }
            swap1(array, i, k);
        }
    }

    public void insertSort(long[] array) {
        assert array != null;
        for (int i = 1; i < array.length; i++) {
            long tmp = array[i];
            int k = i;
            for (int j = i - 1; j >= 0; j--) {
                if (tmp < array[j]) {
                    array[j++] = array[j];
                    k--;
                } else {
                    break;
                }
            }
            array[k] = tmp;
        }
    }

    public void quickSort(long[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int part = partial(array, start, end);

        quickSort(array, start, part - 1);
        quickSort(array, part + 1, end);

    }

    public int partial(long[] array, int start, int end) {
        int mid = start + (end - start) >> 2;
        if (array[start] > array[mid]) {
            swap1(array, start, mid);
        }
        if (array[end] < array[mid]) {
            swap1(array, end, mid);
        }

        long key = array[start];
        int lo = start, hi = end;
        while (lo < hi) {
            while (array[lo++] < key && lo <= hi) ;
            while (array[hi--] > key && lo <= hi) ;
            swap1(array, lo, hi);
        }
        array[hi] = key;
        return hi;
    }

    public void mergeSort(long[] array, int start, int end) {
        int mid = (end + start) / 2;
        if (start < end) {
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public void merge(long[] array, int start, int mid, int end) {
        long[] tmp = new long[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && mid <= j) {
            if (array[i] < array[j]) {
                tmp[k++] = tmp[i++];
            } else {
                tmp[k++] = tmp[j++];
            }
        }

        while (i < mid) {
            tmp[k++] = tmp[i++];
        }

        while (j < end) {
            tmp[k++] = tmp[j++];
        }

        for (int m = 0; m < tmp.length; m++) {
            array[m + start] = tmp[m];
        }
    }

    public void swap1(long[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[j] ^ array[i];
        array[i] = array[i] ^ array[j];
    }

    public void swap2(int a, int b) {
        if (a == b) {
            return;
        }

        a = a + b - (a = b);
    }
}
