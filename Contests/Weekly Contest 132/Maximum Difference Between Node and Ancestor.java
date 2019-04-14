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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    
    public int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return 0;
        }
        
        int res = Math.max(max - root.val, root.val - min);
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        
        res = Math.max(res, dfs(root.left, min, max));
        res = Math.max(res, dfs(root.right, min, max));
        
        return res;
    }
}
