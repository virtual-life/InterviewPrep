/**
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, 
                  it should invalidate the least frequently used item before inserting a new item. 
                  For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), 
                  the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 /* capacity */ );

cache.set(1, 1);
cache.set(2, 2);
cache.get(1);       // returns 1
cache.set(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.set(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/


/**
O(1) for all of LFU cache operations, which include insertion, access and deletion(eviction)

It requires three data structures. One is a hash table which is used to cache the key/values so that given a key we can retrieve the cache entry at O(1). 

Second one is a double linked list for each frequency of access. 
The max frequency is capped at the cache size to avoid creating more and more frequency list entries. 
If we have a cache of max size 4 then we will end up with 4 different frequencies. 
Each frequency will have a double linked list to keep track of the cache entries belonging to that particular frequency.

The third data structure would be to somehow link these frequencies lists. 
It can be either an array or another linked list so that on accessing a cache entry it can be easily promoted to the next frequency list in time O(1). 
In our article it is based on array as traversing would be faster than linked list.
*/

/**
Reference - https://github.com/chirino/hawtdb/blob/master/hawtdb/src/main/java/org/fusesource/hawtdb/util/LFUCache.java
*/
    
/*
Frequency list is stored as an array with no next/prev pointers between nodes: looping over the array should be faster and more CPU-cache friendly than
using an ad-hoc linked-pointers structure.
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;


public class LFUCache {
    
    private class CacheNode {
        public final int key;
        public int value;
        public int frequency;

        public CacheNode(int key, int value int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }

    }

    private final Map<Integer, CacheNode> map;
    private final LinkedHashSet[] frequencyList;
    private int lowestFrequency;
    private int maxFrequency;
    private final int maxCacheSize;


    public LFUCache(int capacity) {

        this.map = new HashMap<Integer, CacheNode>(capacity);
        this.lowestFrequency = 0;
        this.maxFrequency = capacity - 1;
        this.maxCacheSize = capacity;
        
        this.frequencyList = (LinkedHashSet[])new LinkedHashSet[capacity];
        for(int i=0; i<capacity; i++){
            frequencyList[i]=new LinkedHashSet();
        }
    }


    public void put(int key, int value) {
      
        if(map.containsKey(key)){
            CacheNode currentNode = map.get(key);
            currentNode.value = value;
            addFrequency();
        }else{
            if(map.size() == maxCacheSize){
                doEviction();
            }
            // Create New node
            CacheNode currentNode = new CacheNode(key, value, 0);
            // Add to map 
            map.put(key,currentNode);
            // Add to frequency list 
            lowestFrequency = 0;
            LinkedHashSet<CacheNode> nodes = frequncyList[0];
            nodes.add(currentNode);
        }    
    }

    public int get(int key) {
        
        if(map.containsKey(key)){
            addFrequency(currentNode);
            return currentNode.value;
        }else{
            return -1;
        }    
    }

    public void addFrequency(CacheNode currentNode) {
        int currentFrequency = currentNode.frequency;
        if (currentFrequency < maxFrequency) {
            int nextFrequency = currentFrequency + 1;
            LinkedHashSet<CacheNode> currentNodes = frequencyList[currentFrequency];
            LinkedHashSet<CacheNode> newNodes = frequencyList[nextFrequency];
            moveToNextFrequency(currentNode, nextFrequency, currentNodes, newNodes); // remove from curr, add to next, next new frequency
            map.put(currentNode.key, currentNode);
            if (lowestFrequency == currentFrequency && currentNodes.isEmpty()) {
                lowestFrequency = nextFrequency;
            }
        } else {
            // Hybrid with LRU: put most recently accessed ahead of others:
            LinkedHashSet<CacheNode> nodes = frequencyList[currentFrequency];
            nodes.remove(currentNode);
            nodes.add(currentNode);
        }
    }

    public int remove(int key) {
        CacheNode currentNode = map.remove(key);
        if (currentNode != null) {
            LinkedHashSet<CacheNode> nodes = frequencyList[currentNode.frequency];
            nodes.remove(currentNode);
            if (lowestFrequency == currentNode.frequency) {
                findNextLowestFrequency();
            }
            return currentNode.value;
        } else {
            return -1;
        }
    }

    private void doEviction() {
        int currentlyDeleted = 0;
        double target = 1; // just one
        while (currentlyDeleted < target) {
            LinkedHashSet<CacheNode> nodes = frequencyList[lowestFrequency];
            if (nodes.isEmpty()) {
                continue;
            } else {
                Iterator<CacheNode> it = nodes.iterator();
                while (it.hasNext() && currentlyDeleted++ < target) {
                    CacheNode node = it.next();
                    it.remove();
                    map.remove(node.key);
                }
                if (!it.hasNext()) {
                    findNextLowestFrequency();
                }
            }
        }
    }

    private void moveToNextFrequency(CacheNode currentNode, int nextFrequency,
                                     LinkedHashSet<CacheNode> currentNodes,
                                     LinkedHashSet<CacheNode> newNodes) {
        currentNodes.remove(currentNode);
        newNodes.add(currentNode);
        currentNode.frequency = nextFrequency;
    }

    private void findNextLowestFrequency() {
        while (lowestFrequency <= maxFrequency && frequencyList[lowestFrequency].isEmpty()) {
            lowestFrequency++;
        }
        if (lowestFrequency > maxFrequency) {
            lowestFrequency = 0;
        }
    }
}
