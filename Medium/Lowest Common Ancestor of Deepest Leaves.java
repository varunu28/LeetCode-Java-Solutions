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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).lowesetCommonAncestor;
    }
    
    private UpdatedTreeNode helper(TreeNode root) {       
        if (root == null) {
            return new UpdatedTreeNode(0, null);
        }
        
        UpdatedTreeNode leftUpdated = helper(root.left);
        UpdatedTreeNode rightUpdated = helper(root.right);
        
        if (leftUpdated.depth == rightUpdated.depth) {
            return new UpdatedTreeNode(leftUpdated.depth + 1, root);
        }
        else if (leftUpdated.depth > rightUpdated.depth) {
            return new UpdatedTreeNode(leftUpdated.depth + 1, leftUpdated.lowesetCommonAncestor);
        }
        else {
            return new UpdatedTreeNode(rightUpdated.depth + 1, rightUpdated.lowesetCommonAncestor);
        }
    }
}

class UpdatedTreeNode {
    public int depth;
    public TreeNode lowesetCommonAncestor;

    public UpdatedTreeNode(int depth, TreeNode node) {
        this.depth = depth;
        this.lowesetCommonAncestor = node;
    }
}
