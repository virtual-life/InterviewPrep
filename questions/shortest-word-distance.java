/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.


Time - O(n)
Space - O(1)
*/


class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        int dist = words.length;
        int index1 = -1, index2  =-1 ;
        
        for (int i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                index1 = i;
            else if(words[i].equals(word2))
                index2 = i;
            
            if (index1 != -1 && index2 != -1) {
                dist = Math.min(dist, Math.abs(index1 - index2));
            }  
        }
          
        
        return dist;
    }
}


/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Time - O(n)
Space - O(n)

*/


class WordDistance {

 HashMap<String,List<Integer>> map = new HashMap<String,List<Integer>>();
    
 // constructor   
 public WordDistance(String[] words) {

    for(int i=0; i<words.length; i++){            
            if(map.containsKey(words[i])){
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }   
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> index1 = map.get(word1);
        List<Integer> index2 = map.get(word2);
        
        int i=0, j=0;
        int shortest = Integer.MAX_VALUE;
        
        while (i < index1.size() && j < index2.size()) {
            int a = index1.get(i);
            int b = index2.get(j);
            shortest = Math.min(shortest, Math.abs(b-a));
            if (a<b) {
               i++; 
            }
            else {
               j++; 
            }
        }
        return shortest;
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
