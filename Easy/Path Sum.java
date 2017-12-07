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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        boolean ans = false;
        int subSum = sum - root.val;
        
        if (subSum == 0 && root.left == null && root.right == null) return true;
        
        if (root.left != null) {
            ans = ans || hasPathSum(root.left, subSum);
        }
        
        if (root.right != null) {
            ans = ans || hasPathSum(root.right, subSum);
        }
        
        
        return ans;
    }
}
