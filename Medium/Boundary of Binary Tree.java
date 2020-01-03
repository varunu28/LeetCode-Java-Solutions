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
  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    if (root == null) {
      return list;
    }
    list.add(root.val);
    addLeft(root.left, list);
    addLeaves(root.left, list);
    addLeaves(root.right, list);
    addRight(root.right, right);
    for (int i = right.size() - 1; i >= 0; i--) {
      list.add(right.get(i));
    }
    return list;
  }
  
  private void addLeft(TreeNode root, List<Integer> list) {
    if (root == null || (root.left == null && root.right == null)) {
      return;
    }
    list.add(root.val);
    addLeft(root.left == null ? root.right : root.left, list);
  }
  
  private void addRight(TreeNode root, List<Integer> list) {
    if (root == null || (root.left == null && root.right == null)) {
      return;
    }
    list.add(root.val);
    TreeNode next = root.right == null ? root.left : root.right;
    addRight(root.right == null ? root.left : root.right, list);
  }
  
  private void addLeaves(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      list.add(root.val);
    }
    else {
      addLeaves(root.left, list);
      addLeaves(root.right, list);
    }
  }
}
