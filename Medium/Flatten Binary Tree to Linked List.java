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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // Store left and right of root
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        // Make root.right to null and traverse to last node of right
        root.right = left;
        TreeNode curr = root;
        
        while (curr.right != null) {
            curr = curr.right;
        }
        
        // Make last node's right equal to stored right
        curr.right = right;
    }
}
