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
    public List<TreeNode> generateTrees(int n) {
        Map<int[], List<TreeNode>> dp = new HashMap<>();
        return helper(1, n, dp);
    }

    private List<TreeNode> helper(int start, int end, Map<int[], List<TreeNode>> dp) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        int[] pair = {start, end};
        if (dp.containsKey(pair)) {
            return dp.get(pair);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = helper(start, i - 1, dp);
            List<TreeNode> rightSubtrees = helper(i + 1, end, dp);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    result.add(root);
                }
            }
        }
        dp.put(pair, result);
        return result;
    }
}
