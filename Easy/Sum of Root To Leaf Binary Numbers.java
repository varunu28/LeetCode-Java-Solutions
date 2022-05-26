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
  public int sumRootToLeaf(TreeNode root) {
    Queue<NodeToBinaryRepresentation> queue = new LinkedList<>();
    queue.add(new NodeToBinaryRepresentation(root, new StringBuilder()));
    int sum = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        NodeToBinaryRepresentation removed = queue.remove();
        StringBuilder sb = new StringBuilder().append(removed.sb.toString()).append(removed.node.val);
        if (removed.node.left == null && removed.node.right == null) {
          sum += getIntegerValue(sb.toString());
        } else {
          if (removed.node.left != null) {
            queue.add(new NodeToBinaryRepresentation(removed.node.left, sb));
          }
          if (removed.node.right != null) {
            queue.add(new NodeToBinaryRepresentation(removed.node.right, sb));
          }
        }
      }
    }
    return sum;
  }
  
  private int getIntegerValue(String s) {
    int value = 0;
    int multiplier = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      value += Character.getNumericValue(s.charAt(i)) * multiplier;
      multiplier *= 2;
    }
    return value;
  }
  
  private static class NodeToBinaryRepresentation {
    TreeNode node;
    StringBuilder sb;
    
    public NodeToBinaryRepresentation(TreeNode node, StringBuilder sb) {
      this.node = node;
      this.sb = sb;
    }
  }
}
