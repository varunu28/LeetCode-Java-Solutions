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
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode removed = queue.remove();
            if (removed.val == val) {
                return removed;
            }
            if (removed.val > val && removed.left != null) {
                queue.add(removed.left);
            } 
            if (removed.val < val && removed.right != null) {
                queue.add(removed.right);
            }
        }
        return null;
    }
}
