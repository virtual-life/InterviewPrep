/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5


Time - O(n)
Space - O(1)

*/

/*
 * 0->1->2->3->4->5->6
 * |           |   
 * pre        end
 *
 * after calling pre = reverse(pre, end)
 * 
 * 0->3->2->1->4->5->6
 *          |  |
 *          pre end 
 */


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
         
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
         
        ListNode pre = dummyNode;
        ListNode cur = head;
         
        int counter = 0;
         
        while (cur != null) {
            counter++;
             
            if (counter % k == 0) {
                pre = reverseRange(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
         
        return dummyNode.next;
    }
     
    // Reverse the linked list from pre to end, exclusively
    private ListNode reverseRange(ListNode prev, ListNode end) {
        ListNode head = prev.next;
        ListNode curr = head.next;
         
        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
             
            curr = temp;
        }
         
        head.next = end;
        return head;
    }
}
