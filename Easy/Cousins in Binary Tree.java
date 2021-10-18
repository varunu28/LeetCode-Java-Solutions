/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    NodeDetail nodeDetailX = getNodeDetail(root, x, null, 0);
    NodeDetail nodeDetailY = getNodeDetail(root, y, null, 0);
    return nodeDetailX.depth == nodeDetailY.depth && nodeDetailX.parent != nodeDetailY.parent;
  }
  
  private NodeDetail getNodeDetail(TreeNode root, int n, TreeNode parent, int depth) {
    if (root == null) {
      return null;
    }
    if (root.val == n) {
      return new NodeDetail(parent, depth);
    }
    NodeDetail left = getNodeDetail(root.left, n, root, depth + 1);
    if (left != null) {
      return left;
    }
    return getNodeDetail(root.right, n, root, depth + 1);
  }
  
  private class NodeDetail {
    TreeNode parent;
    int depth;

    public NodeDetail(TreeNode parent, int depth) {
      this.parent = parent;
      this.depth = depth;
    }
  }
}
