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
  public int longestConsecutive(TreeNode root) {
    int maxLength = 0;
    Queue<NodePair> queue = new LinkedList<>();
    queue.add(new NodePair(root, 1));
    while (!queue.isEmpty()) {
      NodePair removed = queue.remove();
      maxLength = Math.max(maxLength, removed.currLength);
      if (removed.node.left != null) {
        int sequenceLength = (removed.node.left.val == removed.node.val + 1 
                              ? removed.currLength + 1 : 1);
        queue.add(new NodePair(removed.node.left, sequenceLength));
      }
      if (removed.node.right != null) {
        int sequenceLength = (removed.node.right.val == removed.node.val + 1 
                              ? removed.currLength + 1 : 1);
        queue.add(new NodePair(removed.node.right, sequenceLength));
      }
    }
    return maxLength;
  }
  
  private class NodePair {
    TreeNode node;
    int currLength;
    
    public NodePair(TreeNode node, int currLength) {
      this.node = node;
      this.currLength = currLength;
    }
  }
}
