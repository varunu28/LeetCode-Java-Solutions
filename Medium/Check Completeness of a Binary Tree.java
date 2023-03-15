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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isEnd = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode removed = queue.remove();
            if (removed == null) {
                isEnd = true;
            } 
            if (removed != null) {
                if (isEnd) {
                    return false;
                }
                queue.add(removed.left);
                queue.add(removed.right);
            }
        }
        return true;
    }
}
