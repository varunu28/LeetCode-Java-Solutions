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
  public int pseudoPalindromicPaths (TreeNode root) {
    Queue<NodePathPair> queue = new LinkedList<>();
    NodePathPair nodePathPair = new NodePathPair(root, 0);
    queue.add(nodePathPair);
    int count = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        NodePathPair removed = queue.remove();
        TreeNode node = removed.node;
        int path = removed.path;
        // XOR operation ensures that the bit corresponding to the number only appears in the
        // path if it has occurred odd number of times. 
        // 1 << node.val decides the bit of the value
        path = path ^ (1 << node.val);
        if (node.left == null && node.right == null) {
          // Subtracting 1 means setting rightmost 1 bit to 0 and setting all lower bits to 1
          count += (path & (path - 1)) == 0 ? 1 : 0;
        } 
        if (node.left != null) {
          queue.add(new NodePathPair(node.left, path));
        }
        if (node.right != null) {
          queue.add(new NodePathPair(node.right, path));
        }
      }
    }
    return count;
  }
  
  private static class NodePathPair {
    TreeNode node;
    Integer path;
    
    public NodePathPair(TreeNode node, int path) {
      this.node = node;
      this.path = path;
    }
  }
}
