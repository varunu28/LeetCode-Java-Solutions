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
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    return getLeafSequence(root1).equals(getLeafSequence(root2));
  }
  
  private String getLeafSequence(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    helper(root, list);
    return list.toString();
  }
  
  private void helper(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      list.add(root.val);
    }
    else {
      helper(root.left, list);
      helper(root.right, list);
    }
  }
}
