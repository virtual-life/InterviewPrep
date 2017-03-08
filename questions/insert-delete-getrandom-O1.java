/**
Design a data structure that supports all following operations in O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

*/


import java.util.Random;
 
public class RandomizedSet {
 
    HashMap<Integer, Integer> map1;
    HashMap<Integer, Integer> map2;
 
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map1  = new HashMap<Integer, Integer>();
        map2  = new HashMap<Integer, Integer>();
    }
 
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map1.containsKey(val)){
            return false;
        }else{
            map1.put(val, map1.size());
            map2.put(map2.size(), val);
        }
        return true;
    }
 
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int key) {
        if(map1.containsKey(key)){
            int index = map1.get(key);
 
            //remove the entry from both maps
            map1.remove(key);
            map2.remove(index);
 
            if(map1.size()==0){
                return true;
            }
 
            //if the key is the last element added 
            if(index==map1.size()+1){
                return true;
            }    
 
            //update the last element's index     
            int key1 = map2.get(map2.size());
 
            map1.put(key1, index);
            map2.remove(map2.size()+1);
            map2.put(index, key1);
 
        }else{
            return false;
        }
 
        return true;
    }
 
    /** Get a random element from the set. */
    public int getRandom() {
        if(map1.size()==0){
            return -1; 
        }
 
//         if(map1.size()==1){
//             return map2.get(1);    
//         }    
        Random rand = new Random();
        return map2.get(rand.nextInt(map1.size())+1);
    }
}


/**
With duplicates 
For example, after insert(1), insert(1), insert(2), getRandom() should have 2/3 chance return 1 and 1/3 chance return 2.
Then, remove(1), 1 and 2 should have an equal chance of being selected by getRandom().
*/

public class RandomizedSet {
 
    ArrayList<Integer> nums; // keeps track of all numbers added so far 
    HashMap<Integer, Set<Integer>> map; // key is the number added and value is a hashset of the position it occurs 

 
    /** Initialize your data structure here. */
    public RandomizedSet() {
         nums = new ArrayList<Integer>();
         map = new HashMap<Integer, Set<Integer>>();
    }
 
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
     
        if(map.containsKey(val)){
           map.put(val, map.get(val).add(nums.size());
           return false;        
        }else{
            map.put(val, new HashSet<Integer>(Arrays.asList(nums.size())));
        } 
        
        nums.add(val);           
        return true;
    }
 
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int key) {
        if(map.containsKey(key)){
           int index = map.get(key).iterator().next();
            
            //update the last element's index   
            if(index < nums.size()){
               int lastElement = nums.get(nums.size() -1);
               nums.set(index , lastElement );
               map.get(lastElement).remove(nums.size() - 1);
               map.get(lastElement).add(index);
            } 
      
           nums.remove(nums.size() - 1);
           map.get(key).remove(index);
           if (map.get(key).isEmpty()){            
              map.remove(key);
           }
            return true;
 
        }else{
            return false;
        }
 
        return true;
    }
 
    /** Get a random element from the set. */
    public int getRandom() {
        if(map.size()==0){
            return -1; 
        }
 
//         if(map.size()==1){
//             return nums.gets(1);    
//         }    
        Random rand = new Random();
        return nums.get(rand.nextInt(nums.size())+1);
    }
}

