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
    int[] depthAndParentX = {0, 0};
    int[] depthAndParentY = {0, 0};
    helper(root, x, 0, null, depthAndParentX);
    helper(root, y, 0, null, depthAndParentY);
    return depthAndParentX[0] == depthAndParentY[0] && depthAndParentX[1] != depthAndParentY[1];
  }
  
  private void helper(
    TreeNode root, int num, int currDepth, TreeNode currParent, int[] depthAndParent
  ) {
    if (root == null) {
      return;
    }
    if (root.val == num) {
      System.out.println(root.val + " " + num + " " + (currParent == null ? -1 : currParent.val));
      depthAndParent[0] = currDepth;
      depthAndParent[1] = currParent == null ? -1 : currParent.val;
    }
    else {
      helper(root.left, num, currDepth + 1, root, depthAndParent);
      helper(root.right, num, currDepth + 1, root, depthAndParent);
    }
  }
}
