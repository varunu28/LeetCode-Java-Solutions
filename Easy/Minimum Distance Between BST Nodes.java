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
    
    int t = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        
        return t;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        if (prev != Integer.MAX_VALUE) {
            t = Math.min(t, Math.abs(root.val - prev));
        }
        
        prev = root.val;
        inorder(root.right);
    }
}
