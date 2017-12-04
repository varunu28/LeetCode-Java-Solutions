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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int lDepth = minDepth(root.left);
        int rDepth = minDepth(root.right);
        
        return (lDepth == 0 || rDepth == 0) ? lDepth + rDepth + 1 : Math.min(lDepth,rDepth) + 1;
    }
}
