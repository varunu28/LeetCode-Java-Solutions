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
  int idx;
  public TreeNode bstFromPreorder(int[] preorder) {
    idx = 0;
    return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  private TreeNode helper(int[] preorder, int lower, int upper) {
    if (idx == preorder.length || preorder[idx] < lower || preorder[idx] > upper) {
      return null;
    }
    int val = preorder[idx];
    idx++;
    TreeNode root = new TreeNode(val);
    root.left = helper(preorder, lower, val);
    root.right = helper(preorder, val, upper);
    return root;
  }
}
