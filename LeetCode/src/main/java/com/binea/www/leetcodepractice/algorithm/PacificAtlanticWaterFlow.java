package com.binea.www.leetcodepractice.algorithm;
// Created by binea on 3/28/17.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a
 * continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic
 * ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with
 * height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above
 * matrix).
 */
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic_33ms(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
        return res;
    }

    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for (int[] d : dir) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }

    //23ms
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public List<int[]> pacificAtlantic_23ms(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            pacific[i][0] = true;
            atlantic[i][matrix[0].length - 1] = true;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            pacific[0][j] = true;
            atlantic[matrix.length - 1][j] = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            explore(pacific, matrix, i, 0);
            explore(atlantic, matrix, i, matrix[0].length - 1);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            explore(pacific, matrix, 0, j);
            explore(atlantic, matrix, matrix.length - 1, j);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j] == true)
                    res.add(new int[]{i, j});
            }
        }
        return res;

    }

    private void explore(boolean[][] grid, int[][] matrix, int i, int j) {
        grid[i][j] = true;
        for (int d = 0; d < dx.length; d++) {
            if (i + dy[d] < grid.length && i + dy[d] >= 0 &&
                    j + dx[d] < grid[0].length && j + dx[d] >= 0 &&
                    grid[i + dy[d]][j + dx[d]] == false && matrix[i + dy[d]][j + dx[d]] >= matrix[i][j])
                explore(grid, matrix, i + dy[d], j + dx[d]);
        }
    }

    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<int[]> pacificAtlantic_20ms(int[][] matrix) {
        List<int[]> result = new ArrayList<int[]>();
        if (matrix.length == 0) return result;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] waterFlowCount = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) { // from top row
            dfs(matrix, 0, i, visited, waterFlowCount);
        }
        for (int i = 0; i < matrix.length; i++) { // from left
            dfs(matrix, i, 0, visited, waterFlowCount);
        }

        visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) { // from bottom
            dfs(matrix, matrix.length - 1, i, visited, waterFlowCount);
        }
        for (int i = 0; i < matrix.length; i++) { // from right
            dfs(matrix, i, matrix[0].length - 1, visited, waterFlowCount);
        }

        for (int i = 0; i < waterFlowCount.length; i++) {
            for (int j = 0; j < waterFlowCount[0].length; j++) {
                if (waterFlowCount[i][j] == 2)
                    result.add(new int[]{i, j});
            }
        }

        return result;
    }

    public void dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] waterFlowCount) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        waterFlowCount[i][j]++;
        for (int[] dir : dirs) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if (nexti >= 0 && nexti < matrix.length && nextj >= 0 && nextj < matrix[0].length && !visited[nexti][nextj]) {
                if (matrix[nexti][nextj] >= matrix[i][j]) dfs(matrix,
                                                              nexti,
                                                              nextj,
                                                              visited,
                                                              waterFlowCount); // has to be higher than the height of itself so when water poured on this cell can reach the ocean
            }
        }
    }
}
