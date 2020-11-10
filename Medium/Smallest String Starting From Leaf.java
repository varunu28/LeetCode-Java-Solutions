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
  public String smallestFromLeaf(TreeNode root) {
    return dfs(root, "");
  }
  
  private String dfs(TreeNode root, String curr) {
    if (root == null) {
      return curr;
    }
    curr = "" + (char)(97 + root.val) + curr;
    if (root.left == null && root.right == null) {
      return curr;
    } else if (root.left == null || root.right == null) {
      return root.left == null ? dfs(root.right, curr) : dfs(root.left, curr);
    } else {
      String left = dfs(root.left, curr);
      String right = dfs(root.right, curr);
      return left.compareTo(right) <= 0 ? left : right;
    }
  }
}
