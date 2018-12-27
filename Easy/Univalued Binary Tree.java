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
    int currVal;
    public boolean isUnivalTree(TreeNode root) {
        currVal = Integer.MAX_VALUE;
        return isUnivalTreeHelper(root);
    }
    
    private boolean isUnivalTreeHelper(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (currVal == Integer.MAX_VALUE) {
            currVal = root.val;
        }
        else if (currVal != root.val) {
            return false;
        }
        
        return isUnivalTreeHelper(root.left) && isUnivalTreeHelper(root.right);
    }
}
