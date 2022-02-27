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
  public int widthOfBinaryTree(TreeNode root) {
    int maxWidth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    Map<TreeNode, Integer> map = new HashMap<>();
    map.put(root, 1);
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int start = 0;
      int end = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (i == 0) {
          start = map.get(node);
        }
        if (i == size - 1) {
          end = map.get(node);
        }
        if (node.left != null) {
          map.put(node.left, map.get(node) * 2);
          queue.add(node.left);
        }
        if (node.right != null) {
          map.put(node.right, map.get(node) * 2 + 1);
          queue.add(node.right);
        }
      }
      maxWidth = Math.max(maxWidth, end - start + 1);
    }
    return maxWidth;
  }
}
