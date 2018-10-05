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
    int ans = 0;
    double minDiff = Double.MAX_VALUE;
    
    public int closestValue(TreeNode root, double target) {
        updateVal(root, target);    
        return ans;
    }
    
    private void updateVal(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        
        if (Math.abs(root.val - target) < minDiff) {
            minDiff = Math.abs(root.val - target);
            ans = root.val;
        }
        
        if (root.val < target) {
            updateVal(root.right, target);
        }
        else {
            updateVal(root.left, target);
        }
    }
}
