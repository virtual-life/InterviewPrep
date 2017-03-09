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
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }
        head = prev;
        return head;
    }



    public ListNode reverseListRecursive(ListNode head) {
        if(head==null || head.next == null)
            return head;

        //get second node
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;

        ListNode rest = reverseListRecursive(second);
        second.next = head;

        return rest;
    }
}
