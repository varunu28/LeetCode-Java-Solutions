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
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.right) + findTilt(root.left);
    }
    
    
    public int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
}
