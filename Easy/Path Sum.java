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
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    Queue<Integer> sumQueue = new LinkedList<>();
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    sumQueue.add(targetSum - root.val);
    nodeQueue.add(root);
    while (!nodeQueue.isEmpty()) {
      TreeNode removedNode = nodeQueue.remove();
      int removedSum = sumQueue.remove();
      if (removedNode.left == null && removedNode.right == null && removedSum == 0) {
        return true;
      }
      if (removedNode.left != null) {
        nodeQueue.add(removedNode.left);
        sumQueue.add(removedSum - removedNode.left.val);
      }
      if (removedNode.right != null) {
        nodeQueue.add(removedNode.right);
        sumQueue.add(removedSum - removedNode.right.val);
      }
    }
    return false;
  }
}
