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
  int idx;
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    idx = postorder.length - 1;
    return helper(inorder, postorder, 0, postorder.length - 1, map);
  }
  
  private TreeNode helper(int[] inorder, int[] postorder, int start, int end, Map<Integer, Integer> map) {
    if (start > end) {
      return null;
    }
    TreeNode node = new TreeNode(postorder[idx]);
    int pos = map.get(postorder[idx--]);
    node.right = helper(inorder, postorder, pos + 1, end, map);
    node.left = helper(inorder, postorder, start, pos - 1, map);
    return node;
  }
}
