/**
Given two arrays, write a function to compute their intersection.

Time = O(n).
Space = O(n) - HashSet
*/

// Ignore duplicates 

public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for(int i: nums1){
        set1.add(i);
    }
 
    HashSet<Integer> set2 = new HashSet<Integer>();
    for(int i: nums2){
        if(set1.contains(i)){
            set2.add(i);
        }
    }
 
    int[] result = new int[set2.size()];
    int i=0;
    for(int n: set2){
        result[i++] = n;
    }
 
    return result;
}


// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
// With duplicates 

public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i: nums1){
        if(map.containsKey(i)){
            map.put(i, map.get(i)+1);
        }else{
            map.put(i, 1);
        }
    }
 
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i: nums2){
        if(map.containsKey(i)){
            if(map.get(i)>1){
                map.put(i, map.get(i)-1);
            }else{
                map.remove(i);
            }
            list.add(i);
        }
    }
 
    int[] result = new int[list.size()];
    int i =0;
    while(i<list.size()){
        result[i]=list.get(i);
        i++;
    }
 
    return result;
}

