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
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    int[] postIdx = {postorder.length - 1}; 
    return helper(postorder, map, 0, inorder.length - 1, postIdx);
  }
  
  private TreeNode helper(int[] postorder, Map<Integer, Integer> map, int leftIdx, int rightIdx, int[] postIdx) {
    if (leftIdx > rightIdx) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postIdx[0]--]);
    int index = map.get(root.val);
    root.right = helper(postorder, map, index + 1, rightIdx, postIdx);
    root.left = helper(postorder, map, leftIdx, index - 1, postIdx);
    return root;
  }
}
