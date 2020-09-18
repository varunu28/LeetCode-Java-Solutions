/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  int sum;
  public int sumEvenGrandparent(TreeNode root) {
    sum = 0;
    helper(root, null, null);
    return sum;
  }
  
  private void helper(TreeNode root, TreeNode parent, TreeNode grandparent) {
    if (root == null) {
      return;
    }
    if (grandparent != null && grandparent.val % 2 == 0) {
      sum += root.val;
    }
    helper(root.left, root, parent);
    helper(root.right, root, parent);
  }
}
