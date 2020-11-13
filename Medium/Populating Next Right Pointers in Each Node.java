/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
  public Node connect(Node root) {
    Node prev = root;
    Node curr = null;
    while (prev != null && prev.left != null) {
      curr = prev;
      while (curr != null) {
        curr.left.next = curr.right;
        if (curr.next != null) {
          curr.right.next = curr.next.left;
        }
        curr = curr.next;
      }
      prev = prev.left;
    }
    return root;
  }
}
