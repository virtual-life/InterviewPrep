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
    Random rand;
 
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map1  = new HashMap<Integer, Integer>();
        map2  = new HashMap<Integer, Integer>();
        rand = new Random(System.currentTimeMillis());
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
    public boolean remove(int val) {
        if(map1.containsKey(val)){
            int index = map1.get(val);
 
            //remove the entry from both maps
            map1.remove(val);
            map2.remove(index);
 
            if(map1.size()==0){
                return true;
            }
 
            //if last is deleted, do nothing 
            if(index==map1.size()){
                return true;
            }    
 
            //update the last element's index     
            int key1 = map2.get(map2.size());
 
            map1.put(key1, index);
            map2.remove(map2.size());
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
 
        if(map1.size()==1){
            return map2.get(0);    
        }    
 
        return map2.get(new Random().nextInt(map1.size()));
        //return 0;
    }
}


/**
With duplicates 
*/

