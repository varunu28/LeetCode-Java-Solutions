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
  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    if (depth == 1) {
      TreeNode newRoot = new TreeNode(val);
      newRoot.left = root;
      return newRoot;
    }
    int currDepth = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (currDepth < depth - 1) {
      Queue<TreeNode> temp = new LinkedList<>();
      while (!queue.isEmpty()) {
        TreeNode removed = queue.remove();
        if (removed.left != null) {
          temp.add(removed.left);
        }
        if (removed.right != null) {
          temp.add(removed.right);
        }
      }
      queue = temp;
      currDepth++;
    }
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      TreeNode temp = node.left;
      node.left = new TreeNode(val);
      node.left.left = temp;
      temp = node.right;
      node.right = new TreeNode(val);
      node.right.right = temp;
    }
    return root;
  }
}
