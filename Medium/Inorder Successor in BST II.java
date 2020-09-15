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
    if (node == null) {
      return null;
    }
    if (node.right != null) {
      Node rightNode = node.right;
      while (rightNode.left != null) {
        rightNode = rightNode.left;
      }
      return rightNode;
    }
    else {
      Node curr = node;
      Node parentNode = node.parent;
      while (parentNode != null) {
        if (parentNode.left == curr) {
          return parentNode;
        }
        curr = parentNode;
        parentNode = parentNode.parent;
      }
    }
	return null;
  }
}
