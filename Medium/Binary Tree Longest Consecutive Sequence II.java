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
        int[] ans = new int[1];
        helper(root, ans);
        return ans[0];
    }
    
    private int[] helper(TreeNode root, int[] ans) {
        if (root == null) {
            return new int[]{0,0};
        }
        
        int increase = 1;
        int decrease = 1;
        
        if (root.left != null) {
            int[] left = helper(root.left, ans);
            if (root.val == root.left.val - 1) {
                increase = left[0] + 1;
            }
            if (root.val == root.left.val + 1) {
                decrease = left[1] + 1;
            }
        }
        
        if (root.right != null) {
            int[] right = helper(root.right, ans);
            if (root.val == root.right.val - 1) {
                increase = Math.max(right[0] + 1, increase);
            }
            if (root.val == root.right.val + 1) {
                decrease = Math.max(right[1] + 1, decrease);
            }
        }
        
        ans[0] = Math.max(ans[0], increase + decrease - 1);
        
        return new int[]{increase, decrease};
    }
}
