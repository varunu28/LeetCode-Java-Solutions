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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> nodeValues = new ArrayList<>();
        inorder(root, nodeValues);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < nodeValues.size(); i++) {
            minDifference = Math.min(minDifference, nodeValues.get(i) - nodeValues.get(i - 1));
        }
        return minDifference;
    }

    private void inorder(TreeNode root, List<Integer> nodeValues) {
        if (root == null) {
            return;
        }
        inorder(root.left, nodeValues);
        nodeValues.add(root.val);
        inorder(root.right, nodeValues);
    }
}
