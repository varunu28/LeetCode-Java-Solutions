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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<NodeColIndex> queue = new LinkedList<>();
        queue.add(new NodeColIndex(root, 0));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            NodeColIndex head = queue.peek();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                NodeColIndex removed = queue.remove();
                TreeNode node = removed.node;
                if (node.left != null) {
                    queue.add(new NodeColIndex(node.left, 2 * removed.colIdx));
                }
                if (node.right != null) {
                    queue.add(new NodeColIndex(node.right, 2 * removed.colIdx + 1));
                }
                maxWidth = Math.max(maxWidth, removed.colIdx - head.colIdx + 1);
            }
        }
        return maxWidth;
    }
    
    private record NodeColIndex(TreeNode node, int colIdx) {}
}
