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
  List<String> list;
  public List<String> binaryTreePaths(TreeNode root) {
    list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    helper(root, new StringBuilder());
    return list;
  }
  
  private void helper(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      sb.append(root.val);
      list.add(sb.toString());
    }
    else {
      sb.append(root.val).append("->");
      helper(root.left, new StringBuilder(sb.toString()));
      helper(root.right, new StringBuilder(sb.toString()));
    }
  }
}
