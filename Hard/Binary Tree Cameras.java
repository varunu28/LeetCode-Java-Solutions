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
  private final int NOT_MONITORED = 0;
  private final int MONITORED_NOCAM = 1;
  private final int MONITORED_WITHCAM = 2;

  public int minCameraCover(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] cameras = {0};
    int top = dfs(root, cameras);
    return cameras[0] + (top == NOT_MONITORED ? 1 : 0);
  }

  private int dfs(TreeNode root, int[] cameras) {
    if (root == null) {
      return MONITORED_NOCAM;
    }
    int left = dfs(root.left, cameras);
    int right = dfs(root.right, cameras);
    if (left == MONITORED_NOCAM && right == MONITORED_NOCAM) {
      return NOT_MONITORED;
    } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
      cameras[0]++;
      return MONITORED_WITHCAM;
    } else {
      return MONITORED_NOCAM;
    }
  }
}
