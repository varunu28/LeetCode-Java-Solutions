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
    public int sumRootToLeaf(TreeNode root) {
        return dfsHelper(root, 0);
    }
    
    private int MOD = 1000000007;
    
    private int dfsHelper(TreeNode root, int curr) {
        if (root == null) {
            return curr % MOD;
        }
        
        curr = (curr * 2 + root.val) % MOD;
        
        if (root.left == null && root.right == null) {
            return curr % MOD;
        }
        
        int sum = 0;
        
        if (root.left != null) {
            sum += dfsHelper(root.left, curr);
        }
        
        if (root.right != null) {
            sum += dfsHelper(root.right, curr);
        }
        
        return sum % MOD;
    }
}
