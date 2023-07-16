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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = lca(root, p, q);
        if (result == p) {
            return checkIfNodeExist(p, q) ? p : null;
        }
        if (result == q) {
            return checkIfNodeExist(q, p) ? q : null;
        }
        return result;
    }
    
    private boolean checkIfNodeExist(TreeNode root, TreeNode target) {
        if (root == target) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return checkIfNodeExist(root.left, target) || checkIfNodeExist(root.right, target);
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
