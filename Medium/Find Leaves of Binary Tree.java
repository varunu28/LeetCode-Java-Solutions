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
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    helper(result, root);
    return result;
  }
  
  private int helper(List<List<Integer>> result, TreeNode root) {
    if (root == null) {
      return -1;
    }
    int left = helper(result, root.left);
    int right = helper(result, root.right);
    int maxDepth = Math.max(left, right) + 1;
    if (maxDepth == result.size()) {
      result.add(new ArrayList<>());
    }
    result.get(maxDepth).add(root.val);
    // Cut the tree
    root.left = root.right = null;
    return maxDepth;
  }
}
