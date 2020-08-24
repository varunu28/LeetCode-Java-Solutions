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
    if (root == null) {
      return 0;
    }
    int sum = 0;
    Queue<TreeNode[]> queue = new LinkedList<>();
    queue.add(new TreeNode[]{root, null});
    while (!queue.isEmpty()) {
      TreeNode[] removed = queue.remove();
      if (removed[0].left == null && removed[0].right == null) {
        if (removed[1] != null && removed[1].left == removed[0]) {
          sum += removed[0].val;
        }
      }
      else {
        if (removed[0].left != null) {
          queue.add(new TreeNode[]{removed[0].left, removed[0]});
        }
        if (removed[0].right != null) {
          queue.add(new TreeNode[]{removed[0].right, removed[0]});
        }
      }
    }
    return sum;
  }
}
