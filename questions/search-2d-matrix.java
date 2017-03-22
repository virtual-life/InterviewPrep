/**

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.

 Time - O(m+n)
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int row = m - 1;
        int col = 0;

       // start from botton left corner
        while (row >= 0 && col < n) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }


    /**
     *
     * Sorted 2d Matrix
     * Binary Search
     * Time - O(mn)
     */

    public boolean searchMatrixSorted(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length; // row
        int n = matrix[0].length; // column

        return binaryMatrixSearch(matrix, target, 0, m * n - 1, n);
    }

    private boolean binaryMatrixSearch(int[][] matrix, int target, int lo, int hi, int n) {
        if (lo > hi) return false;

        int mid = (lo + hi) / 2;
        int i = getRowIndex(mid, n);
        int j = getColIndex(mid, n);

        if (matrix[i][j] == target) return true;
        else if (matrix[i][j] > target) return binaryMatrixSearch(matrix, target, lo, mid - 1, n);
        else return binaryMatrixSearch(matrix, target, mid + 1, hi, n);
    }

    // Calculate the row index
    private int getRowIndex(int mid, int n) {
        return mid / n;
    }

    // Calculate the column index
    private int getColIndex(int mid, int n) {
        return mid % n;
    }
}
