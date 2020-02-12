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
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leaf1 = new ArrayList<>();
    List<Integer> leaf2 = new ArrayList<>();
    populateLeaves(root1, leaf1);
    populateLeaves(root2, leaf2);
    return leaf1.equals(leaf2);
  }
  
  private void populateLeaves(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      list.add(root.val);
    }
    else {
      populateLeaves(root.left, list);
      populateLeaves(root.right, list);
    }
  }
}
