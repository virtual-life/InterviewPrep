/**
Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.
*/

/**
Similar to LFU

It requires three data structures. One is a hash table which is used to cache the key/values so that given a key we can retrieve the cache entry at O(1). 
Second one is a double linked list for each frequency of access. 


The max frequency is capped at the cache size to avoid creating more and more frequency list entries. 
If we have a cache of max size 4 then we will end up with 4 different frequencies. 
Each frequency will have a double linked list to keep track of the cache entries belonging to that particular frequency.


*/

public class AllOne {

    private final Map<String, Integer> map;
    private final LinkedHashSet<String>[] frequencyList;
    private int lowestFrequency;
    private int maxFrequency;

    /** Initialize your data structure here. */
    public AllOne() {
    
        this.map = new HashMap<String, Integer>();
        this.frequencyList = new LinkedHashSet<String>[];
        this.lowestFrequency = 0;
        this.maxFrequency = Integer.MIN_VALUE;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    
        if(map.containskey(key){
          int curFreq = map.get(key)
          int newFreq = curFreq +1
          map.put(key,newFreq);
          LinkedHashSet<String> curFreqList = frequencyList[curFreq];
          LinkedHashSet<String> newFreqList = frequencyList[newFreq];
          curFreqList.remove(key);
          newFreqList.add(key);
          if(lowestFrequency == curFreq && curFreqList.isEmpty()){
            lowestFrequency = newFreq;
          }
          if(newFreq > maxFrequency){
            maxFrequency = newFreq;
          }
        }else{
          map.put(key,0);
          LinkedHashSet<String> freqList = frequencyList[0];
          freqList.add(key);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
    
        if(map.containskey(key){
          int curFreq = map.get(key)
          if( curFreq == 1){
            map.remove(key);
          }
          LinkedHashSet<String> curFreqList = frequencyList[curFreq];
          curFreqList.remove(key);
          else{
            int newFreq = curFreq - 1
            map.put(key,newFreq);
            LinkedHashSet<String> newFreqList = frequencyList[newFreq];
            curFreqList.remove(key);
            newFreqList.add(key);
          }
          
          if(lowestFrequency == curFreq && curFreq != 1){
            lowestFrequency = newFreq;
          }
          if(curFreq > maxFrequency && curFreqList.isEmpty()) ){
            maxFrequency = newFreq;
          }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        LinkedHashSet<String> maxFreqList = frequencyList[maxFrequency];
        return maxfreqList(new Random().nextInt(maxFreqList.sixe()));
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {    
        LinkedHashSet<String> minFreqList = frequencyList[lowestFrequency];
        return maxfreqList(new Random().nextInt(maxFreqList.sixe()));
    }
}
