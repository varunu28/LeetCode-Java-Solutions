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
        if (nums.length == 0) {
            return null;
        }
        
        return constructTree(nums, 0, nums.length-1);
    }
    
    private TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int idx = start;
        for (int i=start+1; i<=end; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[idx]);
        
        root.left = constructTree(nums, start, idx-1);
        root.right = constructTree(nums, idx+1, end);
        
        return root;
    }
}
