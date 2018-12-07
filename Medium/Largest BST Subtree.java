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
    public int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtreeHelper(root);
    }
    
    private int largestBSTSubtreeHelper(TreeNode root) {
        if (isBST(root)) {
            return getNodeCount(root);
        }
        
        return Math.max(-1, Math.max(largestBSTSubtreeHelper(root.left), largestBSTSubtreeHelper(root.right)));
    }
    
    private boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    private boolean isBSTHelper(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }
        
        if (root.val >= max || root.val <= min) {
            return false;
        }
        
        return isBSTHelper(root.left, root.val, min) && isBSTHelper(root.right, max, root.val);
    }

    private int getNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + getNodeCount(root.left) + getNodeCount(root.right);
    }
}
