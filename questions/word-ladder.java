/**

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

https://www.programcreek.com/2012/12/leetcode-word-ladder/

 Time - O(n * length of string )  - BFS

 */

class WordNode{
    String word;
    int numSteps;

    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Queue<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));

        wordDict.add(endWord);

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(endWord)){
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;
    }

    /** Print the ladder 
 
    [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
    ]
    */
    /**
     To track the actual ladder, we need to add a pointer that points to the previous node in the WordNode class
     In addition, the used word can not directly removed from the dictionary. The used word is only removed when steps change.
     
    If we find one path using the BFS, then all the other shortest paths must also in this level, so the search will stop once this level ends.


     */

    class WordNodeLadder{
        String word;
        int numSteps;
        WordNodeLadder prev;

        public WordNodeLadder(String word, int numSteps, WordNodeLadder prev){
            this.word = word;
            this.numSteps = numSteps;
            this.prev = prev;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       
        Set dict = new HashSet(wordList);

        List<List<String>> result = new ArrayList<List<String>>();
       
       if (!dict.contains(endWord)) return result; // if endWord not in dict then return

        Queue<WordNodeLadder> queue = new LinkedList<WordNodeLadder>();
        queue.add(new WordNodeLadder(beginWord, 1, null));

        dict.add(endWord);

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
     
        unvisited.addAll(dict); // add all dict words to unvisited 

        int preNumSteps = 0;

        while(!queue.isEmpty()){
            WordNodeLadder top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;

            // if its the endWord 
            if(word.equals(endWord)){
                
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(top.word);
                while(top.prev !=null){
                    // add to begining of the list 
                    temp.add(0, top.prev.word);
                    top = top.prev;
                }
                result.add(temp);
                continue;
                
            }

           // The used word is only removed when steps change. BFS traverse every level 
            if(preNumSteps < currNumSteps){
                unvisited.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){
                        queue.add(new WordNodeLadder(newWord, top.numSteps+1,top));
                        visited.add(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return result;
    }
}
