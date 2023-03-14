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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<NodeSumPair> queue = new LinkedList<>();
        queue.add(new NodeSumPair(root, 0));
        int totalSum = 0;
        while (!queue.isEmpty()) {
            NodeSumPair removed = queue.remove();
            TreeNode node = removed.node;
            int currSum = removed.sum * 10 + node.val;
            if (node.left == null && node.right == null) {
                totalSum += currSum;
            }
            if (node.left != null) {
                queue.add(new NodeSumPair(node.left, currSum));
            }
            if (node.right != null) {
                queue.add(new NodeSumPair(node.right, currSum));
            }
        }
        return totalSum;
    }
    
    private static record NodeSumPair(TreeNode node, int sum) {}
}
