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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean result = root.val == subRoot.val && isSubtreeHelper(root, subRoot);
        return result || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSubtreeHelper(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && isSubtreeHelper(root.left, subRoot.left) && isSubtreeHelper(root.right, subRoot.right);
    }
}
