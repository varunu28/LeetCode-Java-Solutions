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
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int d = getDepth(root);
    if (d == 0) {
      return 1;
    }
    int start = 0;
    int end = (int) Math.pow(2, d) - 1;
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (exists(mid, d, root)) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return (int) Math.pow(2, d) - 1 + start;
  }
  
  private int getDepth(TreeNode node) {
    int d = 0;
    while (node.left != null) {
      node = node.left;
      d++;
    }
    return d;
  }
  
  private boolean exists(int idx, int d, TreeNode root) {
    int left = 0;
    int right = (int) Math.pow(2, d) - 1;
    int mid;
    for(int i = 0; i < d; ++i) {
      mid = left + (right - left) / 2;
      if (idx <= mid) {
        root = root.left;
        right = mid;
      }
      else {
        root = root.right;
        left = mid + 1;
      }
    }
    return root != null;
  }
}
