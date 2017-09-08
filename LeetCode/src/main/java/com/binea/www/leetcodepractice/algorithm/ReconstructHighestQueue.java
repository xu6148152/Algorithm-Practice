package com.binea.www.leetcodepractice.algorithm;
// Created by binea on 3/17/17.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair
 * of integers (h, k), where h is the height of the person and k is the number of people in front of
 * this person who have a height greater than or equal to h. Write an algorithm to reconstruct the
 * queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class ReconstructHighestQueue {

    public int[][] reconstructQueue_144ms(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p2[0] == p1[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> result = new LinkedList<>();
        Arrays.stream(people).forEach(p -> result.add(p[1], p));
        return result.toArray(people);
    }

    public int[][] reconstructQueue_12ms(int[][] people) {
        if (people == null || people.length == 0)
            return people;
        ArrayList<int[]> h_k = new ArrayList<>();
        quickSortReverse(people, 0, people.length - 1);
        for (int i = 0; i < people.length; i++) {
            h_k.add(people[i][1], people[i]);
        }

        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            result[i][0] = h_k.get(i)[0];
            result[i][1] = h_k.get(i)[1];
        }

        return result;
    }


    public void quickSortReverse(int[][] people, int left, int right) {
        int l = left;
        int r = right;
        int pivot_h = people[left + (right - left) / 2][0];
        int pivot_k = people[left + (right - left) / 2][1];

        while (l <= r) {
            while (a_minus_b(people[l][0], people[l][1], pivot_h, pivot_k) > 0)
                l++;
            while (a_minus_b(people[r][0], people[r][1], pivot_h, pivot_k) < 0)
                r--;

            if (l <= r) {
                int temp_h = people[l][0];
                int temp_k = people[l][1];

                people[l][0] = people[r][0];
                people[l][1] = people[r][1];

                people[r][0] = temp_h;
                people[r][1] = temp_k;
                l++;
                r--;
            }
        }

        if (left < r)
            quickSortReverse(people, left, r);
        if (l < right)
            quickSortReverse(people, l, right);

    }

    public int a_minus_b(int ah, int ak, int bh, int bk) {
        if (ah != bh)
            return ah - bh;
        else return bk - ak;
    }
}
