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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeaves(root1).equals(getLeaves(root2));
    }

    private static List<Integer> getLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode removed = stack.pop();
            if (removed.left == null && removed.right == null) {
                result.add(removed.val);
            }
            if (removed.right != null) {
                stack.push(removed.right);
            }
            if (removed.left != null) {
                stack.push(removed.left);
            }
        }
        return result;
    }
}
