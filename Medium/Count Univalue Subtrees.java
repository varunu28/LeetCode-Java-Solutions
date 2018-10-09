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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        updateCount(root);
        return count;
    }
    
    private void updateCount(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (isUnivalue(root, root.val)) {
            count++;
        }
        
        updateCount(root.left);
        updateCount(root.right);
    }
    
    private boolean isUnivalue(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        
        return isUnivalue(root.left, val) && isUnivalue(root.right, val);
    }
}
