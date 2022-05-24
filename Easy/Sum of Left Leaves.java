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
  public int sumOfLeftLeaves(TreeNode root) {
    int sum = 0;
    Queue<TreeNode[]> queue = new LinkedList<>();
    queue.add(new TreeNode[]{root, null});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode[] removed = queue.remove();
        TreeNode node = removed[0];
        TreeNode parent = removed[1];
        if (node.left == null && node.right == null) {
          if (parent != null && parent.left == node) {
            sum += node.val;
          }
        } else {
          if (node.left != null) {
            queue.add(new TreeNode[]{node.left, node});
          }
          if (node.right != null) {
            queue.add(new TreeNode[]{node.right, node});
          }
        }
      }
    }
    return sum;
  }
}
