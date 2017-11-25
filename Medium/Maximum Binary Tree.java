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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return constructMaximumBinaryTreeImpl(nums,0,nums.length-1);
    }
    
    public TreeNode constructMaximumBinaryTreeImpl(int[] nums, int start, int end) {
        
        if (start > end) {
            return null;
        }
        
        int idx = start;
        
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[idx]);
        
        root.left = constructMaximumBinaryTreeImpl(nums, start, idx-1);
        
        root.right = constructMaximumBinaryTreeImpl(nums, idx+1, end);
        
        return root;
    }
}
