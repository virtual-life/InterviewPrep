/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
For example,
Given board =
[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Understand the problem:
The problem asks for if a Word exists in the board, where the word can be constructed from letters of sequentially adjacent cell. Note that the same letter cell may not be used more than once, which means the solution cannot contain a circle. 

*/


public boolean exist(char[][] board, String word) {

    if (board == null || word == null) {
            return true;
    }
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[rows][cols];
    
    
    boolean result = false;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
           if(dfs(board,word,i,j,0, visited)){
               result = true;
           }
        }
    }
 
    return result;
}
 
public boolean dfs(char[][] board, String word, int i, int j, int k, boolean[][] visited){

    if(k==word.length()-1){
            return true;
    } 
                
    if(i<0 || j<0 || i>=board.length || j>=board[0].length){
        return false;
    }
    
    if (visited[row][col]) {
            return false;
        }
    
    if(board[i][j] != word.charAt(k)){
      return false;
    }
 
    visited[row][col] = true;
    
    if(dfs(board, word, i-1, j, k+1)
        ||dfs(board, word, i+1, j, k+1)
        ||dfs(board, word, i, j-1, k+1)
        ||dfs(board, word, i, j+1, k+1)){
            return true;
     }
     
        visited[row][col] = true;
    }
 
    return false;
}

