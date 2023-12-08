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
    public double maximumAverageSubtree(TreeNode root) {
        double[] result = {0.0};
        traverse(root, result);
        return result[0];
    }

    private double[] traverse(TreeNode root, double[] result) {
        if (root == null) {
            return new double[]{0.0, 0.0};
        }
        double[] leftValues = traverse(root.left, result);
        double[] rightValues = traverse(root.right, result);
        double sum = root.val + leftValues[0] + rightValues[0];
        double count = 1 + leftValues[1] + rightValues[1];
        double avg = sum / count;
        result[0] = Math.max(result[0], avg);
        return new double[]{sum, count};
    }
}
