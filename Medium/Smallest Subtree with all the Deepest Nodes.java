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
  Map<TreeNode, Integer> map;
  int maxDepth;
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    map = new HashMap<>();
    maxDepth = -1;
    map.put(null, -1);
    dfs(root, null);
    return helper(root);
  }
  
  private void dfs(TreeNode root, TreeNode parent) {
    if (root == null) {
      return;
    }
    map.put(root, map.get(parent) + 1);
    maxDepth = Math.max(maxDepth, map.get(root));
    dfs(root.left, root);
    dfs(root.right, root);
  }
  
  private TreeNode helper(TreeNode root) {
    if (root == null || map.get(root) == maxDepth) {
      return root;
    }
    TreeNode left = helper(root.left);
    TreeNode right = helper(root.right);
    if (left != null && right != null) {
      return root;
    }
    if (left != null) {
      return left;
    }
    if (right != null) {
      return right;
    }
    return null;
  }
}
