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
  public List<List<Integer>> findLeaves(TreeNode root) {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    Queue<TreeNode> leaves = new LinkedList<>();
    updateParentAndFindLeaves(root, null, parentMap, leaves);
    List<List<Integer>> result = new ArrayList<>();
    while (!leaves.isEmpty()) {
      int size = leaves.size();
      List<Integer> temp = new ArrayList<>();
      while (size-- > 0) {
        TreeNode removed = leaves.remove();
        temp.add(removed.val);
        if (parentMap.get(removed) == null) {
          continue;
        }
        if (parentMap.get(removed).left == removed) {
          parentMap.get(removed).left = null;
        } else {
          parentMap.get(removed).right = null;
        }
        if (parentMap.get(removed).left == null && parentMap.get(removed).right == null) {
          leaves.add(parentMap.get(removed));
        }
      }
      result.add(temp);
    }
    return result;
  }
  
  private void updateParentAndFindLeaves(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap, Queue<TreeNode> leaves) {
    if (node == null) {
      return;
    }
    parentMap.put(node, parent);
    if (node.left == null && node.right == null) {
      leaves.add(node);
      return;
    }
    updateParentAndFindLeaves(node.left, node, parentMap, leaves);
    updateParentAndFindLeaves(node.right, node, parentMap, leaves);
  }
}
