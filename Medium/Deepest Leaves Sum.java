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
  public int deepestLeavesSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    helper(root, 0, map);
    return map.getOrDefault(
      map.keySet().stream().mapToInt(Integer::valueOf).max().orElse(0), 0
    );
  }
  
  private void helper(TreeNode root, int currLevel, Map<Integer, Integer> map) {
    if (root == null) {
      return;
    }
    map.put(currLevel, map.getOrDefault(currLevel, 0) + root.val);
    helper(root.left, currLevel + 1, map);
    helper(root.right, currLevel + 1, map);
  }
}
