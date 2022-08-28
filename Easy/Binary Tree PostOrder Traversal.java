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
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.push(node);
        result.add(node.val);
        node = node.right;
      } else {  
        TreeNode removed = stack.pop();
        node = removed.left; 
      }
    }
    Collections.reverse(result);
    return result;
  }
}
