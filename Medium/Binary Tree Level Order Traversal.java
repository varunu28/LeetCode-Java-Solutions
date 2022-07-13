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
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currLevel = new ArrayList<>();
      while (size-- > 0) {
        TreeNode removed = queue.remove();
        currLevel.add(removed.val);
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      result.add(currLevel);
    }
    return result;
  }
}
