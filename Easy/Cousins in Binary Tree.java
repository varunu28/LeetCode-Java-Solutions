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
  public boolean isCousins(TreeNode root, int x, int y) {
    ParentDepthPair xPair = getParentDepthPair(root, x, 0);
    ParentDepthPair yPair = getParentDepthPair(root, y, 0);
    return xPair.parent != yPair.parent && xPair.depth == yPair.depth;
  }
  
  private ParentDepthPair getParentDepthPair(TreeNode root, int val, int currDepth) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return new ParentDepthPair(root, currDepth);
    }
    if ((root.left != null && root.left.val == val) || (root.right != null && root.right.val == val)) {
      return new ParentDepthPair(root, currDepth);
    }
    ParentDepthPair leftPair = getParentDepthPair(root.left, val, currDepth + 1);
    return leftPair != null ? leftPair : getParentDepthPair(root.right, val, currDepth + 1);
  }
  
  private static class ParentDepthPair {
    TreeNode parent;
    int depth;
    
    public ParentDepthPair(TreeNode parent, int depth) {
      this.parent = parent;
      this.depth = depth;
    }
  }
}
