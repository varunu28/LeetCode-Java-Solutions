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
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> averages = new ArrayList<>();
    if (root == null) {
      return averages;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      long sum = 0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode removed = queue.remove();
        sum += removed.val;
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      averages.add(((double) sum) / size);
    }
    return averages;
  }
}
