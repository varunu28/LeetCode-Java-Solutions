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
  public Node inorderSuccessor(Node node) {
    if (node.right != null) {
      Node rightNode = node.right;
      while (rightNode.left != null) {
        rightNode = rightNode.left;
      }
      return rightNode;
    }
    while (node.parent != null) {
      Node parent = node.parent;
      if (parent.left == node) {
        return parent;
      }
      node = parent;
    }
    return null;
  } 
}
