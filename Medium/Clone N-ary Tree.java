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
      return null;
    }
    Node copy = new Node(root.val);
    for (Node child : root.children) {
      copy.children.add(cloneTree(child));
    }
    return copy;
  }

  Map<Node, Node> map;
  public Node cloneTreeDetailed(Node root) {
    if (root == null) {
      return null;
    }
    map = new HashMap<>();
    copyTree(root);
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node removed = queue.remove();
      Node copy = map.get(removed);
      List<Node> children = removed.children;
      for (Node child : children) {
        copy.children.add(map.get(child));
        queue.add(child);
      }
    }
    return map.get(root);
  }
  
  private void copyTree(Node root) {
    if (root == null) {
      return;
    }
    map.put(root, new Node(root.val));
    for (Node child : root.children) {
      copyTree(child);
    }
  }
}
