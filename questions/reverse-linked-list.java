/**
Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

Time Complexity: O(n)
Space Complexity: O(1)
 */

public class Solution {
    public ListNode reverseListIterative(ListNode head) {
        if(head==null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;

        }
        
        return prev;
    }



    public ListNode reverseListRecursive(ListNode head) {
        if(head==null || head.next == null)
            return head;

        //get second node
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;
        
        //recursuvely call with second node
        ListNode rest = reverseListRecursive(second);
        
        // set second's next to head
        second.next = head;

        return rest;
    }
}
