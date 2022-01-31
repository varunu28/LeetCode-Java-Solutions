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
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Map<Integer, List<Integer>> map = new TreeMap<>();
    Queue<TreeLevel> queue = new LinkedList<>();
    queue.add(new TreeLevel(root, 0));
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeLevel removed = queue.remove();
        map.computeIfAbsent(removed.level, k -> new ArrayList<>()).add(removed.node.val);
        if (removed.node.left != null) {
          queue.add(new TreeLevel(removed.node.left, removed.level - 1));
        }
        if (removed.node.right != null) {
          queue.add(new TreeLevel(removed.node.right, removed.level + 1));
        }
      }
    }
    return new ArrayList<>(map.values());
  }
  

  private class TreeLevel {
    TreeNode node;
    int level;

    public TreeLevel(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }
}
