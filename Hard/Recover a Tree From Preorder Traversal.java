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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int idx = 0;
        while (idx < traversal.length()) {
            int depth = 0;
            while (idx < traversal.length() && traversal.charAt(idx) == '-') {
                depth++;
                idx++;
            }
            int value = 0;
            while (idx < traversal.length() && Character.isDigit(traversal.charAt(idx))) {
                value = value * 10 + Character.getNumericValue(traversal.charAt(idx++));
            }
            TreeNode node = new TreeNode(value);
            while (stack.size() > depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}
