/**
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 For example, given the following matrix:
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.

 http://yucoding.blogspot.com/2015/10/leetcode-question-maximal-square.html
 http://buttercola.blogspot.com/2015/09/leetcode-maximal-square.html
 
 Define dp[i][j] as the length of the maximal square of which the right bottom point ended with matrix[i][j]. 
  -- Initial value 
        dp[0][j] = matrix[0][j]; 
        dp[i][0] = matrix[i][0];
  -- Transit function: 
        If matrix[i][j] == 1, 
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
  -- Final state, max(dp[i][j] * dp[i][j])


 */


public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],
                            dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
            }
        }

        return maxArea;
    }
}
