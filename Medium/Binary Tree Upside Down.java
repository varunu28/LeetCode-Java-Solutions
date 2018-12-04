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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        root.right = null;
        
        return helper(left, root, right);
    }
    
    private TreeNode helper(TreeNode rootLeft, TreeNode root, TreeNode rootRight) {
        if (rootLeft == null) {
            return root;
        }
        
        TreeNode rootLeftLeft = rootLeft.left;
        TreeNode rootLeftRight = rootLeft.right;
        
        rootLeft.left = rootRight;
        rootLeft.right = root;
        
        return helper(rootLeftLeft, rootLeft, rootLeftRight);
    }
}
