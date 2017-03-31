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
    private int capacity;

    /** Initialize your data structure here. */
    public AllOne() {
        this.capacity = 100;
        this.map = new HashMap<String, Integer>();
        this.lowestFrequency = -1;
        this.maxFrequency = Integer.MIN_VALUE;
        
        this.frequencyList = (LinkedHashSet<String>[])new LinkedHashSet[capacity];
        for(int i=0; i<capacity; i++){
            frequencyList[i]=new LinkedHashSet<String>();
        }
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    
        if(map.containsKey(key)){
          int curFreq = map.get(key);
          int newFreq = curFreq +1;
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
          
          lowestFrequency = 0;

          if(maxFrequency == Integer.MIN_VALUE){
              maxFrequency = 0;
          }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 0, remove it from the data structure. */
    public void dec(String key) {
    
        if(map.containsKey(key)){
          
          int curFreq = map.get(key);  
          LinkedHashSet<String> curFreqList = frequencyList[curFreq];
          
          if( curFreq == 0){
            curFreqList.remove(key);
            map.remove(key);
          }else{
            int newFreq = curFreq - 1;
            map.put(key,newFreq);
            LinkedHashSet<String> newFreqList = frequencyList[newFreq];
            curFreqList.remove(key);
            newFreqList.add(key);
          }
          
          if(curFreq == lowestFrequency ){
             findNextLowestFrequency();
          }
          if(curFreq == maxFrequency){
             findNextHighestFrequency();
          }
         
        }
    }
    
    public void findNextLowestFrequency() {
        while (lowestFrequency <= maxFrequency && frequencyList[lowestFrequency].isEmpty()) {
            lowestFrequency++;
        }
        if (lowestFrequency > maxFrequency) {
            lowestFrequency = Integer.MIN_VALUE;
        }
    }
    
    public void findNextHighestFrequency() {
        while (maxFrequency >= 0 && frequencyList[maxFrequency].isEmpty()) {
            maxFrequency--;
        }
        if (maxFrequency < 0) {
            maxFrequency = Integer.MIN_VALUE;
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(maxFrequency > Integer.MIN_VALUE){
            LinkedHashSet<String> maxFreqList = frequencyList[maxFrequency];
            if(maxFreqList.size() >0){
                int randNum = new Random().nextInt(maxFreqList.size()); 
                //int i = 0;
                Iterator<String> itr = maxFreqList.iterator();
                while(itr.hasNext()){
                    if (randNum >= 0)
                        return itr.next();
                    randNum--;
                }
            }
            
        }
        
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(lowestFrequency > -1){
           LinkedHashSet<String> minFreqList = frequencyList[lowestFrequency];
            if(minFreqList.size() >0){
                int randNum = new Random().nextInt(minFreqList.size()); 
                // int i = 0;
                Iterator<String> itr = minFreqList.iterator();
                while(itr.hasNext()){
                    if (randNum >= 0)
                        return itr.next();
                    randNum--;
                }
            }
             
        }
        return "";
    }
}
