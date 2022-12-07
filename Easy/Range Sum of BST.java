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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode removed = queue.remove();
            if (removed.val >= low && removed.val <= high) {
                sum += removed.val;
            }
            if (removed.val >= low && removed.left != null) {
                queue.add(removed.left);
            }
            if (removed.val <= high && removed.right != null) {
                queue.add(removed.right);
            }
        }
        return sum;
    }
}
