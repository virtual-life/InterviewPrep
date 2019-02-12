/**
Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

Time - O(rows*column) - DFS
Space -  worst case O(rows*column) in case that the grid map is filled with lands where DFS goes by (row * column) deep.

 */

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    numIslandsHelper(grid, visited, i, j);
                }
            }
        }

        return result;
    }

    private void numIslandsHelper(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }

        if (j < 0 || j >= grid[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        // If water
        if (grid[i][j] == '0') {
            return;
        }

        // Mark the visted[i][j] = true
        visited[i][j] = true;

        // Go up, down, left and right
        numIslandsHelper(grid, visited, i - 1, j);
        numIslandsHelper(grid, visited, i + 1, j);
        numIslandsHelper(grid, visited, i, j - 1);
        numIslandsHelper(grid, visited, i, j + 1);
    }

}
