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
    public int maxAncestorDiff(TreeNode root) {
        int maxDiff = 0;
        Queue<NodeValuePair> queue = new LinkedList<>();
        queue.add(new NodeValuePair(root, root.val, root.val));
        while (!queue.isEmpty()) {
            NodeValuePair removed = queue.remove();
            TreeNode node = removed.node;
            Integer minNodeValue = removed.minNodeValue;
            Integer maxNodeValue = removed.maxNodeValue;
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(node.val - minNodeValue), Math.abs(node.val - maxNodeValue)));
            Integer updatedMinNodeValue = Math.min(node.val, minNodeValue);
            Integer updatedMaxNodeValue = Math.max(node.val, maxNodeValue);
            if (node.left != null) {
                queue.add(new NodeValuePair(node.left, updatedMinNodeValue, updatedMaxNodeValue));
            }
            if (node.right != null) {
                queue.add(new NodeValuePair(node.right, updatedMinNodeValue, updatedMaxNodeValue));
            }
        }
        return maxDiff;
    }
    
    
    private static class NodeValuePair {
        private TreeNode node;
        private Integer minNodeValue;
        private Integer maxNodeValue;
        
        public NodeValuePair(TreeNode node, Integer minNodeValue, Integer maxNodeValue) {
            this.node = node;
            this.minNodeValue = minNodeValue;
            this.maxNodeValue = maxNodeValue;
        }
    }
}
