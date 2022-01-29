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
  public int rangeSumBST(TreeNode root, int low, int high) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    int sum = 0;
    while (!stack.isEmpty()) {
        TreeNode removed = stack.pop();
        if (removed.val > low && removed.left != null) { 
          stack.push(removed.left); 
        } 
        if (removed.val < high && removed.right != null) { 
          stack.push(removed.right); 
        }
        if (low <= removed.val && removed.val <= high) {
          sum += removed.val; 
        }
    }
    return sum;
  }
}
