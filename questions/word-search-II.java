/*
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
For example,
Given words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

*/

// This can be solved using DFS similar to earlier but it exceeds time , we use TRIE data structure instead 

/*
Use a trie to save the word which does not exist in the board. 
So each time for a new word, we first search if the prefix exist in the trie. If yes, no need to search the board again. 
Simply put, the trie stores the prefix which does not exist in the board, so we don't need to waste of time to search again and again. 
*/

/*
Let's think about the naive solution first. The naive solution is we search the board for each word. 
So for the dict with n words, and assume the ave. length of each word has length of m. 
Then without using a Trie, the time complexity would be O(n * rows * cols  * 4^m). 

Now let's analyze the time complexity of using a Trie. 
We put each word into the trie. Search in the Trie takes O(m) time, so the time complexity would be O(rows * cols * m * 4^m). 
Since mostly m << n, using a trie would save lots of time. 
*/

public class Solution {
    Set<String> result = new HashSet<String>(); 
 
    public List<String> findWords(char[][] board, String[] words) {
 
        Trie trie = new Trie();
        // Insert all words into trie
        for(String word: words){
            trie.insert(word);
        }
 
        int m=board.length;
        int n=board[0].length;
 
        boolean[][] visited = new boolean[m][n];
 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               dfs(board, visited, "", i, j, trie);
            }
        }
 
        return new ArrayList<String>(result);
    }
 
    public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie){
 
        if(i<0 || j<0||i>=board.length||j>=board[0].length){
            return;
        }
 
        if(visited[i][j])
            return;
 
        str = str + board[i][j];
        
        // Check if prefix exists in the trie, if not retrun, dont have to search the board
        if(!trie.startsWith(str))
            return;
        
        // if the word is found in the trie 
        if(trie.search(str)){
            result.add(str);
        }
 
        visited[i][j]=true;
        dfs(board, visited, str, i-1, j, trie);
        dfs(board, visited, str, i+1, j, trie);
        dfs(board, visited, str, i, j-1, trie);
        dfs(board, visited, str, i, j+1, trie);
        visited[i][j]=false;
    }
}    
    
//Trie Node
class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
}
 
//Trie
class Trie{
    public TrieNode root = new TrieNode();
 
    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null){
                node.children[c-'a']= new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.item = word;
    }
 
    public boolean search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        if(node.item.equals(word)){
            return true;
        }else{
            return false;
        }
    }
 
    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}

