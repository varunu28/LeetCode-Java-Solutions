/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public Node cloneTree(Node root) {
    if (root == null) {
      return root;
    }
    Queue<Node> queue = new LinkedList<>();
    Map<Node, Node> map = new HashMap<>();
    queue.add(root);
    map.put(root, new Node(root.val));
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        Node removed = queue.remove();
        for (Node child : removed.children) {
          queue.add(child);
          map.put(child, new Node(child.val));
          map.get(removed).children.add(map.get(child));
        }
      }
    }
    return map.get(root);
  }
}
