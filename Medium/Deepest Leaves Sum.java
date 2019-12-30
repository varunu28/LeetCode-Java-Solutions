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
  Map<Integer, Integer> map;
  int deepestLevel;
  public int deepestLeavesSum(TreeNode root) {
    map = new HashMap<>();
    deepestLevel = 0;
    helper(root, 0);
    return map.get(deepestLevel);
  }
  
  private void helper(TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      map.put(level, map.getOrDefault(level, 0) + root.val);
      deepestLevel = Math.max(deepestLevel, level);
      return;
    }
    helper(root.left, level + 1);
    helper(root.right, level + 1);
  }
}
