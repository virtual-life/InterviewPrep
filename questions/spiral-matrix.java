import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example, given the following matrix:

 [
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].

 Time - O(mn)

 */

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        // if matrix is null or empty
        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = 0;


        // Handle the circle
        while (m > 0 & n > 0) {
            // For matrix has only 1 row
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[row][col++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[row++][col]);
                }
                break;
            }

            // move right
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[row][col++]);
            }

            // move down
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[row++][col]);
            }

            // move left
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[row][col--]);
            }

            // move up
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[row--][col]);
            }

            // move to the inner circle
            row++;
            col++;
            m -= 2;
            n -= 2;
        }

        return result;
    }


/**
 *
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
    [ 1, 2, 3 ],
    [ 8, 9, 4 ],
    [ 7, 6, 5 ]
 ]

 */

public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    if (n == 0) {
        return result;
    }

    int start = 1;
    int row = 0;
    int col = 0;

    while (n > 0) {
        if (n == 1) {
            result[row][col] = start;
            break;
        }

        // Move right
        for (int i = 0; i < n - 1; i++) {
            result[row][col++] = start++;
        }

        // Move down
        for (int i = 0; i < n - 1; i++) {
            result[row++][col] = start++;
        }

        // Move left
        for (int i = 0; i < n - 1; i++) {
            result[row][col--] = start++;
        }

        // Move up
        for (int i = 0; i < n - 1; i++) {
            result[row--][col] = start++;
        }

        row++;
        col++;
        n -= 2;
    }

    return result;
}



}