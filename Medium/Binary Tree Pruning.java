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
    public TreeNode pruneTree(TreeNode root) {
        return checker(root);   
    }
    
// A checker method which checks every node and makes it null if it doesn't contain a 1
    public TreeNode checker(TreeNode root) {
        if (!checkForOnes(root)) {
            root = null;
            return root;
        }
        
        root.left = checker(root.left);
        root.right = checker(root.right);
        
        return root;
    }

// Checks for a 1 in the node
    public boolean checkForOnes(TreeNode root) {
        if (root == null) return false;
        if (root.val == 1) return true;
        
        return checkForOnes(root.left) || checkForOnes(root.right);
    }
}
