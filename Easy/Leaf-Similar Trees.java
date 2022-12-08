/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leavesOne = new StringBuilder();
        StringBuilder leavesTwo = new StringBuilder();
        populateLeaves(root1, leavesOne);
        populateLeaves(root2, leavesTwo);
        return leavesOne.toString().equals(leavesTwo.toString());
    }
    
    private void populateLeaves(TreeNode root, StringBuilder leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.append(root.val).append(",");
            return;
        }
        populateLeaves(root.left, leaves);
        populateLeaves(root.right, leaves);
    }
}
