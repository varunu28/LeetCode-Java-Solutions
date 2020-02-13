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
  public boolean isCousins(TreeNode root, int x, int y) {
    if (root == null || x == y) {
      return true;
    }
    ParentData p1 = new ParentData();
    ParentData p2 = new ParentData();
    helper(root, x, 0, null, p1);
    helper(root, y, 0, null, p2);
    return p1.depth == p2.depth && p1.parent != p2.parent;
  }
  
  private void helper(TreeNode root, int x, int currDepth, TreeNode parent, ParentData p) {
    if (root == null) {
      return;
    }
    if (root.val == x) {
      p.depth = currDepth;
      p.parent = parent;
    }
    else {
      helper(root.left, x, currDepth + 1, root, p);
      helper(root.right, x, currDepth + 1, root, p);
    }
  }
}

class ParentData {
  int depth;
  TreeNode parent;
  
  public ParentData() {
    this.depth = 0;
    this.parent = null;
  }
}
