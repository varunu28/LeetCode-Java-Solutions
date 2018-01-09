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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while (root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            if (prev != null && prev.val >= stack.peek().val) {
                return false;
            }
            
            root = stack.pop();
            prev = root;
            root = root.right;
        }
        
        return true;
    }
}
