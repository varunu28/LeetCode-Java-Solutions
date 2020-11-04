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
  public int pseudoPalindromicPaths (TreeNode root) {
    int[] map = new int[10];
    int[] count = {0};
    pseudoPalindromicPathsUtil(root, map, count);
    return count[0];
  }
  
  private boolean isPalindrome(int[] map) {
    boolean oddFound = false;
    for(int i = 1; i <= 9; i++) {
      if (map[i] % 2 != 0) {
        if (oddFound) {
          return false;
        }
        oddFound = true;
      }
    }
    return true;
  }
  
  private void pseudoPalindromicPathsUtil(TreeNode root, int[] map, int[] count) {
    if (root == null) {
      return;
    }
    map[root.val] = map[root.val] + 1;
    if (root.left == null && root.right == null) {
      if (isPalindrome(map)) {
        count[0]++;
      }
    }
    pseudoPalindromicPathsUtil(root.left, map, count);
    pseudoPalindromicPathsUtil(root.right, map, count);
    map[root.val] = map[root.val] - 1;
  }
}
