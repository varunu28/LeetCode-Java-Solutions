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
  public TreeNode createBinaryTree(int[][] descriptions) {
    Map<Integer, TreeNode> nodeMapping = new HashMap<>();
    Set<Integer> childNodes = new HashSet<>();
    for (int[] description : descriptions) {
      nodeMapping.putIfAbsent(description[0], new TreeNode(description[0]));
      nodeMapping.putIfAbsent(description[1], new TreeNode(description[1]));
      if (description[2] == 1) {
        nodeMapping.get(description[0]).left = nodeMapping.get(description[1]);
      } else {
        nodeMapping.get(description[0]).right = nodeMapping.get(description[1]);
      }
      childNodes.add(description[1]);
    }
    for (Integer key : nodeMapping.keySet()) {
      if (!childNodes.contains(key)) {
        return nodeMapping.get(key);
      }
    }
    return null;
  }
}
