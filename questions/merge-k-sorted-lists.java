/**
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 Time - O( log(k) * n )
 k is number of list and n is number of total elements.
 */

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());
        
       // add list heads to the heap
        for(ListNode l : lists){
            if (l != null)
                queue.add(l);
        }
     
        ListNode head = new ListNode(0);
     
     
        ListNode p = head;
        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;

            if(n.next != null){
                queue.add(n.next);
            }

            p = p.next;
        }

        return head.next;
    }
}

class ListNodeComparator implements Comparator<ListNode>{
    public int compare(ListNode n1, ListNode n2){
        if(n1.val>n2.val){
            return 1;
        }if(n1.val <n2.val){
            return -1;
        }else{
            return 0;
        }
    }
}


// For Arrays 


public class Solution{    

 public static List<Integer> mergeKArrays(int[][] arrays) {
      if (arrays == null || arrays.length == 0) {
          throw new IllegalArgumentException("Invalid input!");
      }     
      
      PriorityQueue<HeapItem> pq = new PriorityQueue<HeapItem>();             
      int total=0;
      
      // add arrays to the heap
      for (int i = 0; i < arrays.length; i++) {
          pq.add(new HeapItem(arrays[i], 0));
          total = total + arr[i].length;
      }
  
      List<Integer> result = new ArrayList<Integer> (total);  
  
      while (!pq.isEmpty()) {             
          HeapItem current = pq.remove();
          result.add(current.array[current.index]);                       
          if (current.index < current.array.length-1) {  
             current.index++;
             pq.add(current);  
          }
     }
     return result;
 }
 
  public static class HeapItem implements Comparable<HeapItem>{               
      int[] array;                
      int index;        // the index of current element               
      public HeapItem(int[] arr, int index) {
           this.array = arr;
           this.index = index;
      }  
  
      @Override
      public int compareTo(HeapItem h){
          if(this.array[this.index] > h.array[h.index]){
              return 1;
          }else if(this.array[this.index] < h.array[h.index]){
              return -1;
          }else{
              return 0;
          }
      }
 }
 
 
 // merge two arrays:
 
 public static int[] mergeArrays(int[] arr1, int[] arr2) {

    // set up our mergedArray
    int[] result = new int[arr1.length + arr2.length];

    int i = 0;
    int j = 0;
    int k = 0;

    while (k < result.length) {

        boolean arr1Exhausted = i >= arr1.length;
        boolean arr2Exhausted = j >= arr2.length;

        // case: next comes from my array
        // my array must not be exhausted, and EITHER:
        // 1) Alice's array IS exhausted, or
        // 2) the current element in my array is less
        //    than the current element in Alice's array
     
        if (!arr1Exhausted && (arr2Exhausted || (arr2[i] < arr2[j]) ) ) {

            result[k] = arr1[i];
            i++;

        // case: next comes from Alice's array
        } else {
            result[k] = arr2[j];
            j++;
        }

        k++;
    }

    return result;
}
 
}

