


public class Solution {
    public void deleteNode(ListNode node) {
        if(node != null && node.next != null){
          ListNode next = node.next;
          node.val = next.val;
          node.next = next.next;
        }
        
    }
}
