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
  Map<TreeNode, TreeNode> map;  // A Node-Parent map
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    map = new HashMap<>();
    updateParentMap(root, null);
    deleteLeaf(root, target);
    return map.get(root) != null ? null : root;
  }

  public TreeNode removeLeafNodesRecursive(TreeNode root, int target) {
    if (root.left != null) {
      root.left = removeLeafNodes(root.left, target);
    }
    if (root.right != null) {
      root.right = removeLeafNodes(root.right, target);
    }
    return root.left == root.right && root.val == target ? null : root;
  }
  
  private void updateParentMap(TreeNode curr, TreeNode parent) {
    if (curr == null) {
      return;
    }
    map.put(curr, parent);
    updateParentMap(curr.left, curr);
    updateParentMap(curr.right, curr);
  }
  
  private void deleteLeaf(TreeNode curr, int target) {
    if (curr == null) {
      return;
    }
    if (curr.left == null && curr.right == null) {
      if (curr.val == target) {
        TreeNode parent = map.get(curr);
        if (parent == null) {  // If parent is null then mark the parent as -1
          map.put(curr, new TreeNode(-1));
          return;
        }
        // Else delete the node
        if (parent.left == curr) {
          parent.left = null;
        }
        else {
          parent.right = null;
        }
        // If parent is leaf with target value then call recursion on parent
        if (parent.left == null && parent.right == null && parent.val == target) {
          deleteLeaf(parent, target);
        }
      }
    }
    else {
      deleteLeaf(curr.left, target);
      deleteLeaf(curr.right, target);
    }
  }
}
