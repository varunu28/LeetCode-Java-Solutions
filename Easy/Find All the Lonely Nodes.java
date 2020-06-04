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
  public List<Integer> getLonelyNodes(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    helper(root, null, list);
    return list;
  }
  
  private void helper(TreeNode node, TreeNode parent, List<Integer> list) {
    if (node == null) {
      return;
    }
    if (parent != null && ((parent.left != null && parent.right == null) || (parent.right != null && parent.left == null))) {
      list.add(node.val);
    }
    helper(node.left, node, list);
    helper(node.right, node, list);
  }
}
