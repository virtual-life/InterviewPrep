
/*
Time - O(n)
Space - O(1) 

maintain a k-wide "stick" in one walk down the list.

 - Walk one pointer kk nodes from the head. Call it rightNode.
 - Put another pointer at the head. Call it leftNode.
 - Walk both pointers, at the same speed, towards the tail. This keeps a distance of kk between them.
 - When rightNode hits the tail, leftNode is on the target (since it's kk nodes from the end of the list).

*/

public static Node kthToLastNode(int k, Node head) {

    if (k < 1) {
        throw new IllegalArgumentException(
            "Impossible to find less than first to last node: " + k);
    }

    Node leftNode  = head;
    Node rightNode = head;

    // move rightNode to the kth node
    for (int i = 0; i < k - 1; i++) {

        // but along the way, if a rightNode doesn't have a next,
        // then k is greater than the length of the list and there
        // can't be a kth-to-last node! we'll raise an error
        if (rightNode.next == null) {
            throw new IllegalArgumentException(
                "k is larger than the length of the linked list: " + k);
        }

        rightNode = rightNode.next;
    }

    // starting with leftNode on the head,
    // move leftNode and rightNode down the list,
    // maintaining a distance of k between them,
    // until rightNode hits the end of the list
    while (rightNode.next != null) {
        leftNode  = leftNode.next;
        rightNode = rightNode.next;
    }

    // since leftNode is k nodes behind rightNode,
    // leftNode is now the kth to last node!
    return leftNode;
}

public int kthByRecursion(int k, Node head){
		if(head==null){
			return 0;
		}
		int i =  kthByRecursion(k, head.next)+1;
		if(i==k){
			System.out.println(head.data);
		}
		return i;
	}
