/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    Deque<TreeNode> stackOriginal = new ArrayDeque<>();
    Deque<TreeNode> stackCloned = new ArrayDeque<>();
    TreeNode nodeOriginal = original;
    TreeNode nodeCloned = cloned;
    while (!stackOriginal.isEmpty() || nodeOriginal != null) {
      while (nodeOriginal != null) {
        stackOriginal.add(nodeOriginal);
        stackCloned.add(nodeCloned);
        nodeOriginal = nodeOriginal.left;
        nodeCloned = nodeCloned.left;
      }
      nodeOriginal = stackOriginal.removeLast();
      nodeCloned = stackCloned.removeLast();
      if (nodeOriginal == target) {
        return nodeCloned;
      }
      nodeOriginal = nodeOriginal.right;
      nodeCloned = nodeCloned.right;
    }
    return null;
  }
}
