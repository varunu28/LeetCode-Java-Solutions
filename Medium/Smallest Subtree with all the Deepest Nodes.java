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
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return dfs(root).node;
  }
  
  private NodeResult dfs(TreeNode root) {
    if (root == null) {
      return new NodeResult(null, 0);
    }
    NodeResult leftResult = dfs(root.left);
    NodeResult rightResult = dfs(root.right);
    if (leftResult.distance > rightResult.distance) {
      return new NodeResult(leftResult.node, leftResult.distance + 1);
    }
    if (leftResult.distance < rightResult.distance) {
      return new NodeResult(rightResult.node, rightResult.distance + 1);
    }
    return new NodeResult(root, rightResult.distance + 1);
  }
  
  private static class NodeResult {
    TreeNode node;
    int distance;
    
    public NodeResult(TreeNode node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }
}
