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
  public int maxLevelSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int currLevel = 1;
    int maxSum = Integer.MIN_VALUE;
    int maxSumLevel = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int currSum = 0;
      while (size-- > 0) {
        TreeNode removed = queue.remove();
        currSum += removed.val;
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      if (maxSum < currSum) {
        maxSum = currSum;
        maxSumLevel = currLevel;
      }
      currLevel++;
    }
    return maxSumLevel;
  }
}
