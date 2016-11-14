package com.example.dp;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by binea on 2016/11/13.
 */

public class DpPractice {
    public int countWays(int n) {
        int[] steps = new int[n + 1];
        if (n >= 0) {
            steps[0] = 1;
        }
        if (n >= 1) {
            steps[1] = 1;
        }
        if (n >= 2) {
            steps[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2] + steps[i - 3];
        }
        return steps[n];
    }

    public boolean getPathRecur(int x, int y, ArrayList<Point> path) {
        if (x == 0 && y == 0) {
            return true;
        }

        boolean success = false;
        if (x >= 1 && isFree(x - 1, y)) {
            success = getPathRecur(x - 1, y, path);
        }

        if (!success && y >= 1 && isFree(x, y - 1)) {
            success = getPathRecur(x, y - 1, path);
        }

        if (success) {
            path.add(new Point(x, y));
        }
        return success;
    }

    public boolean getPathCache(int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
        Point point = new Point(x, y);
        if (cache.containsKey(point)) {
            return cache.get(point);
        }

        path.add(point);
        if (x == 0 && y == 0) {
            return true;
        }

        boolean success = false;
        if (x >= 1 && isFree(x - 1, y)) {
            success = getPathCache(x - 1, y, path, cache);
        }

        if (!success && y >= 1 && isFree(x, y - 1)) {
            success = getPathCache(x, y - 1, path, cache);
        }
        if (!success) {
            path.add(point);
        }
        cache.put(point, success);
        return success;
    }


    public boolean isFree(int x, int y) {
        return true;
    }

    public int getPathDp(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        }

        if (x == 1 || y == 1) {
            return 1;
        }

        int[][] cache = new int[x][y];
        for (int i = 0; i < x; i++) {
            cache[i][0] = 1;
        }
        for (int j = 0; j < y; j++) {
            cache[0][j] = 1;
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cache[i][j] = cache[i - 1][j] + cache[i][j];
            }
        }
        return cache[x][y];
    }

}
