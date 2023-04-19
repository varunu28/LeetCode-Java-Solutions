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
    
    private enum DIRECTION {
        LEFT, RIGHT;
    }
    
    public int longestZigZag(TreeNode root) {
        int[] pathLength = {0};
        dfs(root, DIRECTION.LEFT, 0, pathLength);
        dfs(root, DIRECTION.RIGHT, 0, pathLength);
        return pathLength[0];
    }
    
    private void dfs(TreeNode node, DIRECTION direction, int steps, int[] pathLength) {
        if (node == null) {
            return;
        }
        pathLength[0] = Math.max(pathLength[0], steps);
        if (direction == DIRECTION.LEFT) {
            dfs(node.left, DIRECTION.RIGHT, steps + 1, pathLength);
            dfs(node.right, DIRECTION.LEFT, 1, pathLength);
        } else {
            dfs(node.left, DIRECTION.RIGHT, 1, pathLength);
            dfs(node.right, DIRECTION.LEFT, steps + 1, pathLength);
        }
    }
}
