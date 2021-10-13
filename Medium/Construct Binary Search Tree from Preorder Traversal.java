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
  public TreeNode bstFromPreorder(int[] preorder) {
    int[] idx = {0};
    return formBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, idx);
  }
  
  private TreeNode formBST(int[] preorder, int min, int max, int[] idx) {
    if (idx[0] == preorder.length || preorder[idx[0]] < min || preorder[idx[0]] > max) {
      return null;
    }
    int val = preorder[idx[0]++];
    TreeNode node = new TreeNode(val);
    node.left = formBST(preorder, min, val, idx);
    node.right = formBST(preorder, val, max, idx);
    return node;
  }
}
