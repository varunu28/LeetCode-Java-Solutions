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
  public TreeNode pruneTree(TreeNode root) {
    return subtreeContainsOne(root) ? root : null;
  }
  
  private boolean subtreeContainsOne(TreeNode root) {
    if (root == null) {
      return false;
    }
    boolean leftContains = subtreeContainsOne(root.left);
    boolean rightContains = subtreeContainsOne(root.right);
    if (!leftContains) {
      root.left = null;
    }
    if (!rightContains) {
      root.right = null;
    }
    return leftContains || rightContains || root.val == 1;
  }
}
