/**

 Given a linked list, determine if it has a cycle in it.

 If we have 2 pointers - fast and slow. It is guaranteed that the fast one will meet the slow one if there exists a circle.
 
 Time - O(n)
 Space - O(1)

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

    public ListNode hasCycleGetStartOfLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                break;
        }

        if( fast == null || fast.next == null)
            return null;

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}

/*

Would the program always work if the fast runner moves three steps every time the slow runner moves one step?
What if instead of a simple linked list, you had a structure where each node could have several "next" nodes? 
This data structure is called a "directed graph." How would you test if your directed graph had a cycle?

*/
