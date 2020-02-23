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
  List<Integer> list;
  List<Integer> rightVal;
  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    list = new ArrayList<>();
    rightVal = new ArrayList<>();
    if (root == null) {
      return list;
    }
    if (root.left == null && root.right == null) {
      list.add(root.val);
      return list;
    }
    list.add(root.val);
    addLeft(root.left);
    addLeaves(root);
    addRight(root.right);
    for (int i = rightVal.size() - 1; i >= 0; i--) {
      list.add(rightVal.get(i));
    }
    return list;
  }
  
  private void addLeft(TreeNode left) {
    if (left == null || (left.left == null && left.right == null)) {
      return;
    }
    list.add(left.val);
    addLeft(left.left == null ? left.right : left.left);
  }
  
  private void addLeaves(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      list.add(root.val);
      return;
    }
    addLeaves(root.left);
    addLeaves(root.right);
  }
  
  private void addRight(TreeNode right) {
    if (right == null || (right.left == null && right.right == null)) {
      return;
    }
    rightVal.add(right.val);
    addRight(right.right == null ? right.left : right.right);
  }
}
