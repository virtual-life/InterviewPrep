/**
 Given a singly linked list, determine if it is a palindrome.

 Time - O(n)
 Space - O(1)

 */

public class Solution {
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next==null)
            return true;

        //find list center
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = reverse(slow);
        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode cur) {
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}