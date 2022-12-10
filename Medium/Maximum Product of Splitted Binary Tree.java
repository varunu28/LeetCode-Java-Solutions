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
    public int maxProduct(TreeNode root) {
        List<Integer> allNodeSums = new ArrayList<>();
        long totalSum = treeSum(root, allNodeSums);
        long best = 0;
        for (long sum : allNodeSums) {
            best = Math.max(best, sum * (totalSum - sum));
        }
        return (int) (best % 1000_000_007);
    }
    
    private int treeSum(TreeNode root, List<Integer> allNodeSums) {
        if (root == null) {
            return 0;
        }
        int leftSum = treeSum(root.left, allNodeSums);
        int rightSum = treeSum(root.right, allNodeSums);
        int totalSum = leftSum + rightSum + root.val;
        allNodeSums.add(totalSum);
        return totalSum;
    }
}
