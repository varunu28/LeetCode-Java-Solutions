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
  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> levels = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currLevel = new ArrayList<>();
      while (size-- > 0) {
        Node removed = queue.remove();
        currLevel.add(removed.val);
        queue.addAll(removed.children);
      }
      levels.add(currLevel);
    }
    return levels;
  }   
}
