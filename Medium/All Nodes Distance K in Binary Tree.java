/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        dfs(root, target, k, result);
        return result;
    }
    
    private int dfs(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null) {
            return -1;
        }
        if (node == target) {
            dfs(node, 0, k, result);
            return 1;
        }
        int left = dfs(node.left, target, k, result);
        if (left != -1) {
            if (left == k) {
               result.add(node.val);
            }
            dfs(node.right, left + 1, k, result);
            return left + 1;
        }
        int right = dfs(node.right, target, k, result);
        if (right != -1) {
            if (right == k) {
               result.add(node.val);
            }
            dfs(node.left, right + 1, k, result);
            return right + 1;
        }
        return -1;
    }
    
    private void dfs(TreeNode node, int distance, int k, List<Integer> result) {
        if (node == null || distance > k) {
            return;
        }
        if (distance == k) {
            result.add(node.val);
            return;
        }
        dfs(node.left, distance + 1, k, result);
        dfs(node.right, distance + 1, k, result);
    }
}
