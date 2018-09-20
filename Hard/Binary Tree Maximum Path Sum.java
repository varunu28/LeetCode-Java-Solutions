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
    int maxDownVal;
    public int maxPathSum(TreeNode root) {
        maxDownVal = Integer.MIN_VALUE;
        updateVal(root);
        return maxDownVal;
    }
    
    private int updateVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, updateVal(root.left));
        int right = Math.max(0, updateVal(root.right));
        
        maxDownVal = Math.max(maxDownVal, left+right+root.val);
        
        return Math.max(left, right) + root.val;
    }
}
