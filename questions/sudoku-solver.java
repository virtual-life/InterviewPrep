/**

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


Time - O(n^m)  n - number of possibilities ( 9 in this case )    m - number of blank cells to fill 

O(n ^ m) where n is the number of possibilities for each square (i.e., 9 in classic Sudoku) and m is the number of spaces that are blank.

This can be seen by working backwards from only a single blank. If there is only one blank, then you have n possibilities that you must work through in the worst case. 
If there are two blanks, then you must work through n possibilities for the first blank and n possibilities for the second blank for each of the possibilities for the first blank. 
If there are three blanks, then you must work through n possibilities for the first blank. Each of those possibilities will yield a puzzle with two blanks that has n^2 possibilities.

This algorithm performs a depth-first search through the possible solutions. Each level of the graph represents the choices for a single square. 
The depth of the graph is the number of squares that need to be filled. With a branching factor of n and a depth of m, finding a solution in the graph has a worst-case performance of O(n ^ m).


*/


public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
         
        solveHelper(board);
    }
     
    private boolean solveHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(i, j, k, board)) {
                            board[i][j] = k;
                            if (solveHelper(board) == true) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
     
    private boolean isValid(int row, int col, char target, char[][] board) {
        // check the row and column
        for (int i = 0; i < 9; i++) {
            if ((board[row][i] == target) || (board[i][col] == target)) {
                return false;
            }
        }
         
        // check the block
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = row / 3 * 3 + i; // nth block * block_size  + offset
                int y = col / 3 * 3 + j;
                if (board[x][y] == target) {
                    return false;
                }
            }
        }
        return true;
    }
}
