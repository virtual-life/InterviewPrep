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
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
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

    /** Print the ladder */
    /**
     To track the actual ladder, we need to add a pointer that points to the previous node in the WordNode class
     In addition, the used word can not directly removed from the dictionary. The used word is only removed when steps change.

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

    public List<List<String>> printLadder(String beginWord, String endWord, Set<String> wordDict) {

        List<List<String>> result = new ArrayList<List<String>>();

        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNodeLadder(beginWord, 1, null));

        wordDict.add(endWord);

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(dict);

        int minStep = 0;
        int preNumSteps = 0;



        while(!queue.isEmpty()){
            WordNodeLadder top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;

            if(word.equals(endWord)){
                if(minStep == 0){
                    minStep = top.numSteps;
                }

                if(top.numSteps == minStep && minStep !=0){
                    //nothing
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add(top.word);
                    while(top.pre !=null){
                        temp.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(temp);
                    continue;
                }

            }

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
