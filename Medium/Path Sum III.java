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
  public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> map = new HashMap<>();
    map.put(0L, 1);
    int[] count = {0};
    preorder(root, 0L, map, count, targetSum);
    return count[0];
  }
  
  private void preorder(TreeNode root, long currSum, Map<Long, Integer> map, int[] count, int targetSum) {
    if (root == null) {
      return;
    }
    currSum += root.val;
    count[0] += map.getOrDefault(currSum - targetSum, 0);
    map.put(currSum, map.getOrDefault(currSum, 0) + 1);
    preorder(root.left, currSum, map, count, targetSum);
    preorder(root.right, currSum, map, count, targetSum);
    map.put(currSum, map.get(currSum) - 1);
  }
}
