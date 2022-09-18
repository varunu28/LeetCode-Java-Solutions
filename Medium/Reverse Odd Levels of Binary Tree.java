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
  public TreeNode reverseOddLevels(TreeNode root) {
    int level = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<TreeNode> currLevel = new ArrayList<>();
      int size = queue.size();
      while (size-- > 0) {
        TreeNode removed = queue.remove();
        if (level % 2 != 0) {
          currLevel.add(removed);
        }
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      if (level % 2 != 0) {
        reverseLevel(currLevel);
      }
      level++;
    }
    return root;
  }
  
  private void reverseLevel(List<TreeNode> currLevel) {
    int start = 0;
    int end = currLevel.size() - 1;
    while (start < end) {
      TreeNode startNode = currLevel.get(start++);
      TreeNode endNode = currLevel.get(end--);
      int temp = startNode.val;
      startNode.val = endNode.val;
      endNode.val = temp;
    }
  }
}
