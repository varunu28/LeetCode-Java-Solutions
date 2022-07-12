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
  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (!isLeaf(root)) {
      result.add(root.val);
    }
    if (root.left != null) {
      addLeft(result, root.left);
    }
    addLeaves(result, root);
    if (root.right != null) {
      addRight(result, root.right);
    }
    return result;
  }
  
  private void addRight(List<Integer> result, TreeNode node) {
    Stack<Integer> stack = new Stack<>();
    while (node != null) {
      if (!isLeaf(node)) {
        stack.push(node.val);
      }
      if (node.right != null) {
        node = node.right;
      } else {
        node = node.left;
      }
    }
    while (!stack.isEmpty()) {
      result.add(stack.pop());
    }
  }
  
  private void addLeft(List<Integer> result, TreeNode node) {
    while (node != null) {
      if (!isLeaf(node)) {
        result.add(node.val);
      }
      if (node.left != null) {
        node = node.left;
      } else {
        node = node.right;
      }
    }
  }
  
  private void addLeaves(List<Integer> result, TreeNode root) {
    if (isLeaf(root)) {
      result.add(root.val);
    } else {
      if (root.left != null) {
        addLeaves(result, root.left);
      }
      if (root.right != null) {
        addLeaves(result, root.right);
      }
    }
  }
  
  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  } 
}
