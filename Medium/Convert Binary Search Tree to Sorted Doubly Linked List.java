/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return root;
    }
    Stack<Node> stack = new Stack<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    Node head = null;
    Node prev = null;
    while (!stack.isEmpty()) {
      Node removed = stack.pop();
      Node rightNode = removed.right;
      while (rightNode != null) {
        stack.push(rightNode);
        rightNode = rightNode.left;
      }
      if (head == null) {
        head = removed;
      }
      if (prev != null) {
        prev.right = removed;
      }
      removed.left = prev;
      prev = removed;
    }
    head.left = prev;
    prev.right = head;
    return head;
  }
}
