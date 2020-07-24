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
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (!queue.isEmpty() && queue.peek() != null) {
      int size = queue.size() - 1;
      while (size-- > 0) {
        Node removed = queue.remove();
        removed.next = queue.peek();
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      queue.remove();
      queue.add(null);
    }
    return root;
  }
}
