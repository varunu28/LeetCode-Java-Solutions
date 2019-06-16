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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root, 0);
        int rightHeight = getHeight(root, 1);
        
        if (leftHeight == rightHeight) {
            return (2 << (leftHeight - 1)) - 1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int getHeight(TreeNode root, int dir) {
        if (root == null) {
            return 0;
        }
        
        int height = 1;
        while (root != null) {
            root = dir == 0 ? root.left : root.right;
            height++;
        }
        
        return height - 1;
    }
}
