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
    public int countNodes(TreeNode root) {
        int leftDepth = getDepth(root, -1);
        int rightDepth = getDepth(root, 1);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int getDepth(TreeNode root, int dir) {
        int depth = 0;
        while (root != null) {
            depth++;
            if (dir == -1) {
                root =  root.left;
            } else {
                root = root.right;
            }
        }
        return depth;
    }
}
