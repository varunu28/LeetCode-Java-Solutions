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
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        updateSB(root1, sb1);
        updateSB(root2, sb2);
        
        return sb1.toString().equals(sb2.toString());
    }
    
    private void updateSB(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            sb.append(String.valueOf(root.val)).append("-");
        }
        
        updateSB(root.left, sb);
        updateSB(root.right, sb);
    }
}
