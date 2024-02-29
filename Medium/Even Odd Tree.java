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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean even = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (size-- > 0) {
                TreeNode removed = queue.remove();
                if ((even && removed.val % 2 == 0) || (!even && removed.val % 2 != 0)) {
                    return false;
                }
                if ((even && removed.val <= prev) || (!even && removed.val >= prev)) {
                    return false;
                }
                prev = removed.val;
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
            }
            even = !even;
        }
        return true;
    }
}
