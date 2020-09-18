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
  int leftCount;
  int rightCount;
  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    leftCount = 0;
    rightCount = 0;
    countNodes(root, x);
    return Math.max(Math.max(leftCount, rightCount), n - leftCount - rightCount - 1) > n / 2;
  }
  
  private int countNodes(TreeNode root, int x) {
    if (root == null) {
      return 0;
    }
    int l = countNodes(root.left, x);
    int r = countNodes(root.right, x);
    if (root.val == x) {
      leftCount = l;
      rightCount = r;
    }
    return l + r + 1;
  }
}
