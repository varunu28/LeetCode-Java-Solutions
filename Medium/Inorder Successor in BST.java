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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            
            return node;
        }
        
        return getLastLeft(root, p);
    }

    private TreeNode getLastLeft(TreeNode root, TreeNode p) {
        TreeNode lastLeft = null;
        
        while (root != null) {
            if (root == p) {
                break;
            }
            else if (root.val < p.val) {
                root = root.right;
            }
            else {
                lastLeft = root;
                root = root.left;
            }
        }
        
        return lastLeft;
    }
}
