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
    int[] diameter = {0};
    getHeight(root, diameter);
    return diameter[0];
  }
  
  private int getHeight(Node node, int[] diameter) {
    if (node.children.size() == 0) {
      return 0;
    }
    int maxHeightOne = 0;
    int maxHeightTwo = 0;
    for (Node child : node.children) {
      int parentHeight = getHeight(child, diameter) + 1;
      if (parentHeight > maxHeightOne) {
        maxHeightTwo = maxHeightOne;
        maxHeightOne = parentHeight;
      } else if (parentHeight > maxHeightTwo) {
        maxHeightTwo = parentHeight;
      }
      int currentDiameter = maxHeightOne + maxHeightTwo;
      diameter[0] = Math.max(diameter[0], currentDiameter);
    }
    return maxHeightOne;
  }
}
