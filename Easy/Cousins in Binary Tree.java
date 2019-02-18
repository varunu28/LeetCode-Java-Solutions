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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        DetailedNode nodeX = helper(root, null, x, 0);
        DetailedNode nodeY = helper(root, null, y, 0);
        
        if (nodeX == null || nodeY == null) {
            return false;
        }
        
        return nodeX.depth == nodeY.depth && nodeX.parent != nodeY.parent;
    }
    
    private DetailedNode helper(TreeNode root, TreeNode parent, int num, int depth) {
        if (root == null) {
            return null;
        }
        
        if (root.val == num) {
            return new DetailedNode(root, parent, depth - 1);
        }
        
        DetailedNode left = helper(root.left, root, num, depth + 1);
        DetailedNode right = helper(root.right, root, num, depth + 1);
        
        if (left == null) {
            return right;
        }
        
        return left;
    }
    
    class DetailedNode {
        public TreeNode node;
        public TreeNode parent;
        public int depth;
        
        public DetailedNode(TreeNode node, TreeNode parent, int depth) {
            this.node = node;
            this.parent = parent;
            this.depth = depth;
        }
    }
}
