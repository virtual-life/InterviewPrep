/**
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 http://buttercola.blogspot.com/2014/08/leetcode-rotate-image.html
 */

/**
 An in-place method is to first transpose the array, then swap the elements in each row.
 For example, for array
 1  2  3
 4  5  6
 7  8  9
 The transposed array is:
 1  4  7
 2  5  8
 3  6  9
 Then swap elements in each row
 7  4  1
 8  5  2
 9  6  3

 */


public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) return;

        // length of the matrix
        int n = matrix.length;

        // transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // swap elements for each row
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
