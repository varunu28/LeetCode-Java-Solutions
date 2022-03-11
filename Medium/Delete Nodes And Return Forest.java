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
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> result = new ArrayList<>();
    Set<Integer> deleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
    helper(root, deleteSet, result, null);
    return result;
  }
  
  private void helper(TreeNode node, Set<Integer> deleteSet, List<TreeNode> result, TreeNode parent) {
    if (node == null) {
      return;
    }
    TreeNode nextParent = null;
    if (deleteSet.contains(node.val)) {
      if (parent != null) {
        if (parent.left == node) {
          parent.left = null;
        } else {
          parent.right = null;
        }
      }
    } else {
      if (parent == null) {
        result.add(node); 
      }
      nextParent = node;
    }
    helper(node.left, deleteSet, result, nextParent);
    helper(node.right, deleteSet, result, nextParent);
  }
}
