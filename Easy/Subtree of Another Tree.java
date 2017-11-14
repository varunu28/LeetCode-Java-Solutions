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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverseAndString(s).contains(traverseAndString(t));
    }
    
    public String traverseAndString(TreeNode root) {
        StringBuilder res = new StringBuilder();
        traverse(root, res);
        return res.toString();
    }
    
    public void traverse(TreeNode root, StringBuilder res) {
        
        if (root == null) {
            res.append("-");
            return;
        }
        
        traverse(root.left, res);
        traverse(root.right, res);
        res.append(String.valueOf(root.val) + ",");
    }
}
