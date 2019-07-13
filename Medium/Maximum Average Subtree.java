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
    Map<TreeNode, Integer> sumMap = new HashMap<>();
    Map<TreeNode, Integer> numNodesMap = new HashMap<>();
    double maxAvg = -1.0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return maxAvg;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        
        int sum = getSum(root);
        int nodes = getNumOfNodes(root);
        
        maxAvg = Math.max(maxAvg, ((double) (sum) / nodes));
        
        dfs(root.left);
        dfs(root.right);
    }
    
    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (sumMap.containsKey(root)) {
            return sumMap.get(root);
        }
        
        int sum = root.val + getSum(root.left) + getSum(root.right);
        sumMap.put(root, sum);
        
        return sum;
    }
    
    private int getNumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (numNodesMap.containsKey(root)) {
            return numNodesMap.get(root);
        }
        
        int numNodes = 1 + getNumOfNodes(root.left) + getNumOfNodes(root.right);
        numNodesMap.put(root, numNodes);
        
        return numNodes;
    }
}
