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
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> result = new HashMap<>();
        Map<TreeNode, Integer> heightCache = new HashMap<>();
        dfs(root, 0, 0, result, heightCache);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = result.get(queries[i]);
        }
        return answer;
    }

    private void dfs(TreeNode node, int depth, int maxDepth, Map<Integer, Integer> result, Map<TreeNode, Integer> heightCache) {
        if (node == null) {
            return;
        }
        result.put(node.val, maxDepth);
        dfs(node.left, depth + 1, Math.max(maxDepth, depth + 1 + height(node.right, heightCache)), result, heightCache);
        dfs(node.right, depth + 1, Math.max(maxDepth, depth + 1 + height(node.left, heightCache)), result, heightCache);
    }
    
    private int height(TreeNode node, Map<TreeNode, Integer> heightCache) {
        if (node == null) {
            return -1;
        }
        if (heightCache.containsKey(node)) {
            return heightCache.get(node);
        }
        int currHeight = 1 + Math.max(height(node.left, heightCache), height(node.right, heightCache));
        heightCache.put(node, currHeight);
        return currHeight;
    }
}
