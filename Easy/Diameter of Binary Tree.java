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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int rootDiam = depth(root.left) + depth(root.right);
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        
        return Math.max(rootDiam, Math.max(leftDia, rightDia));
    }
    
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
