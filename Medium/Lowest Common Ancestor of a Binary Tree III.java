/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
  public Node lowestCommonAncestor(Node p, Node q) {
    int pDepth = getDepth(p);
    int qDepth = getDepth(q);
    while (pDepth > qDepth) {
      pDepth--;
      p = p.parent;
    }
    while (pDepth < qDepth) {
      qDepth--;
      q = q.parent;
    }
    while (p != q) {
      p = p.parent;
      q = q.parent;
    }
    return p;
  }
  
  private int getDepth(Node node) {
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.parent;
    }
    return depth;
  }
}
