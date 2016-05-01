/**
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.

 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return null;

        RandomListNode p = head;

        /** Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List,
        // create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N afte the Nth node */
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        /**

         Now copy the arbitrary link in this fashion
         original->next->arbitrary = original->arbitrary->next;
        This works because original->next is nothing but copy of original and Original->arbitrary->next is nothing but copy of arbitrary */
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        /**
         Now restore the original and copy linked lists in this fashion in a single loop.
         original->next = original->next->next;
         copy->next = copy->next->next;

         */
        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            p = p.next;
        }

        return newHead;
    }
}
