/**
 * Definition for a binary tree node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */
class Solution {
  Map<Node, NodeCopy> copyMap;
  public NodeCopy copyRandomBinaryTree(Node root) {
    copyMap = new HashMap<>();
    fillMapTraverse(root);
    cloneMapTraverse(root);
    return copyMap.get(root);
  }
  
  private void cloneMapTraverse(Node root) {
    if (root == null) {
      return;
    }
    NodeCopy copy = copyMap.get(root);
    copy.left = copyMap.get(root.left);
    copy.right = copyMap.get(root.right);
    copy.random = copyMap.get(root.random);
    cloneMapTraverse(root.left);
    cloneMapTraverse(root.right);
  }
  
  private void fillMapTraverse(Node root) {
    if (root == null) {
      return;
    }
    copyMap.put(root, new NodeCopy(root.val));
    fillMapTraverse(root.left);
    fillMapTraverse(root.right);
  }
}
