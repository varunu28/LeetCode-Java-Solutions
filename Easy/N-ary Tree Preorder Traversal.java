/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public List<Integer> preorder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node popped = stack.pop();
      list.add(popped.val);
      List<Node> children = popped.children;
      for (int i = children.size() - 1; i >= 0; i--) {
        stack.push(children.get(i));
      }
    }
    return list;
  }
}
