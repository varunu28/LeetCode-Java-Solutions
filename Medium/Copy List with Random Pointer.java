/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
    if (head == null) {
      return head;
    }
    Node curr = head;
    /*
    List A->B->C
    Expected outcome: A->A`->B->B`->C->C` 
    Where node marked with ` is copied node
    */
    while (curr != null) {
      Node newNode = new Node(curr.val);
      newNode.next = curr.next;
      curr.next = newNode; 
      curr = newNode.next;
    }
    curr = head;
    /*
    List A->A`->B->B`->C->C`
         |      |      | (Random pointers)
         C      A      B
    Expected outcome: A->A`->B->B`->C->C`
                      |  |   |  |   |  |
                      C  C`  A  A`  B  B`
    */
    while (curr != null) {
      curr.next.random = curr.random != null ? curr.random.next : null;
      curr = curr.next.next;
    }
    Node oldCurr = head;
    Node newCurr = head.next;
    Node newHead = head.next; // Retain a pointer to copied list's head
    // Separate merged lists into original list & copied list.
    while (oldCurr != null) {
      oldCurr.next = oldCurr.next.next;
      newCurr.next = newCurr.next != null ? newCurr.next.next : null;
      oldCurr = oldCurr.next;
      newCurr = newCurr.next;
    }
    return newHead;
  }
}
