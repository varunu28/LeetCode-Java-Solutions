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
    public int averageOfSubtree(TreeNode root) {
        int[] result = {0};
        recurse(root, result);
        return result[0];
    }

    private int[] recurse(TreeNode root, int[] result) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = recurse(root.left, result);
        int[] right = recurse(root.right, result);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        if (count != 0 && sum / count == root.val) {
            result[0]++;
        }
        return new int[]{sum, count};
    }
}
