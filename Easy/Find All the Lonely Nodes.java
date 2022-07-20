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
  public List<Integer> getLonelyNodes(TreeNode root) {
    List<Integer> lonelyNodes = new ArrayList<>();
    Queue<TreeNode[]> queue = new LinkedList<>();
    queue.add(new TreeNode[]{root, null});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode[] removed = queue.remove();
        TreeNode node = removed[0];
        TreeNode parent = removed[1];
        if (parent != null && ((parent.left == node && parent.right == null) || (parent.right == node && parent.left == null))) {
          lonelyNodes.add(node.val);
        }
        if (node.left != null) {
          queue.add(new TreeNode[]{node.left, node});
        }
        if (node.right != null) {
          queue.add(new TreeNode[]{node.right, node});
        }
      }
    }
    return lonelyNodes;
  }
}
