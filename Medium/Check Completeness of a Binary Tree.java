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
  public boolean isCompleteTree(TreeNode root) {
    List<HelperNode> nodes = new ArrayList<>();
    nodes.add(new HelperNode(root, 1));
    int idx = 0 ;
    while (idx < nodes.size()) {
      HelperNode hnode = nodes.get(idx++);
      if (hnode.node != null) {
        nodes.add(new HelperNode(hnode.node.left, 2 * hnode.level));
        nodes.add(new HelperNode(hnode.node.right, 2 * hnode.level + 1));
      }
    }
    return nodes.get(idx - 1).level == nodes.size();
  }
}


class HelperNode {
  TreeNode node;
  int level;
  
  public HelperNode(TreeNode node, int level) {
    this.node = node;
    this.level = level;
  }
}
