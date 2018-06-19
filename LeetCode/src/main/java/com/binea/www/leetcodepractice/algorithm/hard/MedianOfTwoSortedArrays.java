package com.binea.www.leetcodepractice.algorithm.hard;

/**
 * Created by xbg on 2018/6/19.
 */

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = iMin + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = iMax - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if((len1+len2)%2==0){
            return (double)(findKnum(nums1,nums2, 0,0,len1,len2,(len1+len2)/2)+findKnum(nums1,nums2, 0,0,len1,len2,(len1+len2)/2+1))/2;
        }else{
            return findKnum(nums1,nums2, 0,0,len1,len2,(len1+len2)/2+1);
        }
    }

    public int findKnum(int[] num1, int[] num2, int start, int start2, int len1, int len2, int k){
        if(len1>len2){
            return findKnum(num2,num1, start2,start,len2,len1,k);
        }
        if(len1 == 0)
            return num2[start2+k-1];
        if(k==1)
            return Math.min(num1[start], num2[start2]);
        int pa = Math.min(len1, k/2);
        int pb = k - pa;
        if(num1[start+pa-1]<num2[start2+pb-1]){
            return findKnum(num1,num2,start+pa,start2,len1-pa,len2,k-pa);
        }else if(num1[start+pa-1]>num2[start2+pb-1]){
            return findKnum(num1, num2, start, start2+pb,len1, len2-pb, k-pb);
        }else{
            return num1[start+pa-1];
        }

    }
}
