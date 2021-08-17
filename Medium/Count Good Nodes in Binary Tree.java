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
  public int goodNodes(TreeNode root) {
    int[] count = {0};
    getGoodNodesCountRecursive(root, Integer.MIN_VALUE, count);
    return count[0];
  }
  
  private void getGoodNodesCountRecursive(TreeNode root, int currMax, int[] count) {
    if (root == null) {
      return;
    }
    if (root.val >= currMax) {
      count[0]++;
    }
    getGoodNodesCountRecursive(root.left, Math.max(currMax, root.val), count);
    getGoodNodesCountRecursive(root.right, Math.max(currMax, root.val), count);
  }
  
  private int getGoodNodesCountNonRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    Queue<TreePair> queue = new LinkedList<>();
    queue.add(new TreePair(root, Integer.MIN_VALUE));
    while (!queue.isEmpty()) {
      TreePair removed = queue.remove();
      if (removed.node.val >= removed.currMax) {
        count++;
      }
      if (removed.node.left != null) {
        queue.add(new TreePair(removed.node.left, Math.max(removed.node.val, removed.currMax)));
      }
      if (removed.node.right != null) {
        queue.add(new TreePair(removed.node.right, Math.max(removed.node.val, removed.currMax)));
      }
    }
    return count;
  }
  
  class TreePair {
    int currMax;
    TreeNode node;

    public TreePair(TreeNode node, int currMax) {
      this.currMax = currMax;
      this.node = node;
    }
  }
}
