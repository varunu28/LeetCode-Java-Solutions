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
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> forest = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int num : to_delete) {
      set.add(num);
    }
    helper(root, set, forest, null, 0);
    return forest;
  }
  
  private void helper(TreeNode root, Set<Integer> set, List<TreeNode> forest, TreeNode parent, int side) {
    if (root == null) {
      return;
    }
    // Deletion 
    if (set.contains(root.val)) {
      if (parent != null) { 
        // Decide which node we want to make null based on side
        if (side == -1) {
          parent.left = null;
        }
        else {
          parent.right = null;
        }
      } 
      // Call the recursive function for left & right with parent as null as we deleted the node
      helper(root.left, set, forest, null, 0);
      helper(root.right, set, forest, null, 0);
    }
    // No Deletion
    else {
      if (parent == null) { // Don't add if we have already added the parent and this is a child node
        forest.add(root);
      }  
      helper(root.left, set, forest, root, -1);
      helper(root.right, set, forest, root, 1);
    }
  }
}
