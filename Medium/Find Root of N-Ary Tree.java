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
  public Node findRoot(List<Node> tree) {
    Set<Node> set = new HashSet<>();
    for (Node node : tree) {
      for (Node child : node.children) {
        set.add(child);
      }
    }
    for (Node node : tree) {
      if (!set.contains(node)) {
        return node;
      }
    }
    return null;
  }
}
