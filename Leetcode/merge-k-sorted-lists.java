/**
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 Time - log(k) * n
 k is number of list and n is number of total elements.
 */

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());

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