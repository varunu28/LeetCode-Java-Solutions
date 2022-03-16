/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
  public Node flatten(Node head) {
    if (head == null) {
      return head;
    }
    Stack<Node> stack = new Stack<>();
    stack.push(head);
    while (!stack.isEmpty()) {
      Node removed = stack.pop();
      if (removed.next != null) {
        stack.push(removed.next);
      }
      if (removed.child != null) {
        stack.push(removed.child);
      }
      removed.child = null;
      if (!stack.isEmpty()) {
        removed.next = stack.peek();
        stack.peek().prev = removed;
      }
    }
    return head;
  } 
}
