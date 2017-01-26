/**
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

 Time - O(mn)

 */

/*
check each row, and then each column, and each block( 3*3 grid ) , respectively. Use hash set to store the visited numbers.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                /** if empty continue */
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '1';

                int x = 3 * (i / 3) + num / 3;
                int y = 3 * (j / 3) + num % 3;
                if (rows[i][num] || cols[num][j] || grid[x][y]) {
                    return false;
                }

                rows[i][num] = true;
                cols[num][j] = true;
                grid[x][y] = true;
            }
        }
        return true;
    }
}

