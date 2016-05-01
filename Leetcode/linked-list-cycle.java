/**

 Given a linked list, determine if it has a cycle in it.

 If we have 2 pointers - fast and slow. It is guaranteed that the fast one will meet the slow one if there exists a circle.

 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        return false;
    }
}