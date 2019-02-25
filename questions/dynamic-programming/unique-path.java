/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28

*/


public class Solution {
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    
    //left column - only 1 way of going down 
    for(int i=0; i<m; i++){
        dp[i][0] = 1;
    }
 
    //top row - only one way of going right 
    for(int j=0; j<n; j++){
        dp[0][j] = 1;
    }
    
    for(int i=1; i<m; i++){
        for(int j=1; j<n; j++){
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
 
    return dp[m-1][n-1];
}

// with memoization - top down 

public int uniquePaths(int m, int n) {
    int[][] mem = new int[m][n];
 
    //init with -1 value
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            mem[i][j]=-1;
        }
    }
 
    return helper(mem, m-1, n-1);
}
 
private int helper(int[][] mem, int m, int n){
    //edge has only one path
    if(m==0||n==0){
        mem[m][n]=1;
        return 1;
    }
 
    if(mem[m][n]!=-1){
        return mem[m][n];
    }
 
    mem[m][n] = helper(mem, m, n-1) + helper(mem, m-1, n);
 
    return mem[m][n];
}
