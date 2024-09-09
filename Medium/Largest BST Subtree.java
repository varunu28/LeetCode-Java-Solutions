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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] isBstResult = isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (isBstResult[0] == 1) {
            return isBstResult[1];
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int[] isBst(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return new int[]{1, 0};
        }
        int[] result = new int[2];
        if (!(root.val > minValue && root.val < maxValue)) {
            return result;
        }
        int[] leftIsBst = isBst(root.left, minValue, root.val);
        int[] rightIsBst = isBst(root.right, root.val, maxValue);
        if (leftIsBst[0] == 1 && rightIsBst[0] == 1) {
            result[0] = 1;
            result[1] = 1 + leftIsBst[1] + rightIsBst[1];
        }
        return result;
    }
}
