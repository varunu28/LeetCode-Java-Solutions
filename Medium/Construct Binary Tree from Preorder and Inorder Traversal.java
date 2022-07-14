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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorderIndex = {0};
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return buildTree(preorder, 0, preorder.length - 1, map, preorderIndex);
  }
  
  private TreeNode buildTree(int[] preorder, int left, int right, Map<Integer, Integer> map, int[] preorderIndex) {
    if (left > right) {
      return null;
    }
    int rootVal = preorder[preorderIndex[0]++];
    TreeNode root = new TreeNode(rootVal);
    root.left = buildTree(preorder, left, map.get(rootVal) - 1, map, preorderIndex);
    root.right = buildTree(preorder, map.get(rootVal) + 1, right, map, preorderIndex);
    return root;
  }
}
