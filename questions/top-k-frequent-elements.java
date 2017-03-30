/**
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/


/*
Using max-heap using priority queue
Time - O(nlogk)
*/

class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}
 
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
         //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
 
        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new PairComparator());
 
        //maintain a heap of size k. 
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            if(queue.size()< k){
                queue.offer(p); 
            }else if(p.count > queue.peek().count){
              queue.poll();
              queue.offer(p);
            }            
        }
 
        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while(queue.size()>0){
            result.add(queue.poll().num);
        }
        //reverse the order
        Collections.reverse(result);

 
        return result;
    }
    private class PairComparator implements Comparator<Pair>{
      @Override
      public int compare(Pair a, Pair b){
        return a.count-b.count;
      }
        
    }
}


/*
Using bucket sort
Time - O(n)
*/

public List<Integer> topKFrequent(int[] nums, int k) {
    //count the frequency for each element
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int num: nums){
        if(map.containsKey(num)){
            map.put(num, map.get(num)+1);
        }else{
            map.put(num, 1);
        }
    }
 
    //get the max frequency
    int max = 0;
    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        max = Math.max(max, entry.getValue());
    }
 
    //initialize an array of ArrayList. index is frequency, value is list of numbers
    ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
    for(int i=1; i<=max; i++){
        arr[i]=new ArrayList<Integer>();
    }
 
    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        int count = entry.getValue();
        int number = entry.getKey();
        arr[count].add(number);
    }
 
    List<Integer> result = new ArrayList<Integer>();
 
    //add most frequent numbers to result
    for(int j=max; j>=1; j--){
        if(arr[j].size()>0){
            for(int a: arr[j]){
                result.add(a);
            }
        }
 
        if(result.size()==k)
            break;
    }
 
    return result;
}

