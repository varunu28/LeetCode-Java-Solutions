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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode t = new TreeNode(v);
            t.left = root;
            return t;
        }
        
        helper(root, v, d, 1);
        return root;
    }
    
    private void helper(TreeNode root, int v, int d, int currLevel) {
        if (currLevel == d-1) {
            TreeNode t1 = new TreeNode(v);
            TreeNode t2 = new TreeNode(v);
            
            t1.left = root.left;
            t2.right = root.right;
            root.left = t1;
            root.right = t2;
            
            return;
        }
        
        if (root.left != null) {
            helper(root.left, v, d, currLevel + 1);
        }
        
        if (root.right != null) {
            helper(root.right, v, d, currLevel + 1);
        }
    }
}
