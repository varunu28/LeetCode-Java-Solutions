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
  public int diameter(Node root) {
    int[] max = {0};
    helper(root, max);
    return max[0];
  }
  
  private int helper(Node root, int[] max) {
    if (root == null) {
      return 0;
    }
    int max1 = 0;
    int max2 = 0;
    for (Node child : root.children) {
      int height = helper(child, max);
      if (max1 < height) {
        max2 = max1;
        max1 = height;
      }
      else if (max2 < height) {
        max2 = height;
      }
    }
    max[0] = Math.max(max[0], max1 + max2);
    return max1 + 1;
  }
}
