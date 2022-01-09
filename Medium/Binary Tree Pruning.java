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
    boolean isRootOne = helper(root);
    return isRootOne ? root : null;
  }
  
  private boolean helper(TreeNode root) {
    if (root == null) {
      return false;
    }
    boolean selfOne = root.val == 1;
    boolean leftContainsOne = helper(root.left);
    boolean rightContainsOne = helper(root.right);
    if (!leftContainsOne) {
      root.left = null;
    }
    if (!rightContainsOne) {
      root.right = null;
    }
    return selfOne || leftContainsOne || rightContainsOne;
  }
}
