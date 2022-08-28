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
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    helper(root, result, new StringBuilder());
    return result;
  }
  
  private void helper(TreeNode root, List<String> result, StringBuilder path) {
    if (root == null) {
      return;
    }
    path.append(root.val);
    if (root.left == null && root.right == null) {
      result.add(path.toString());
    } else {
      path.append("->");
      helper(root.left, result, new StringBuilder(path));
      helper(root.right, result, new StringBuilder(path));
    }
  }
}
