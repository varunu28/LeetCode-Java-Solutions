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
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] ans = {1};
        helper(root, ans, null, 1);
        
        return ans[0];
    }
    
    private void helper(TreeNode root, int[] ans, TreeNode parent, int count) {
        if (root == null) {
            return;
        }
        
        if (parent != null) {
            if (root.val == parent.val + 1) {
                count++;
                ans[0] = Math.max(ans[0], count);
            }
            else {
                count = 1;
            }
        }
        
        helper(root.left, ans, root, count);
        helper(root.right, ans, root, count);
    }
}
