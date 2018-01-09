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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode rLeft, TreeNode rRight) {
        if (rLeft == null && rRight == null) {
            return true;
        }
        if ((rLeft == null && rRight != null) || (rLeft != null && rRight == null)) {
            return false;
        }
        
        if (rLeft != null && rRight != null) {
            if (rLeft.val != rRight.val) return false;
        }
        
        return isSymmetric(rLeft.left, rRight.right) && isSymmetric(rLeft.right, rRight.left);
    }
}
