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
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> list = new ArrayList<>();
    helper(root, targetSum, new ArrayList<>(), list);
    return list;
  }
  
  private void helper(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> list) {
    if (root == null) {
      return;
    }
    curr.add(root.val);
    if (isLeaf(root) && (targetSum - root.val) == 0) {
      list.add(new ArrayList<>(curr));
    }
    helper(root.left, targetSum - root.val, curr, list);
    helper(root.right, targetSum - root.val, curr, list);
    curr.remove(curr.size() - 1);
  }
  
  private boolean isLeaf(TreeNode root) {
    return root.left == null && root.right == null;
  }
}
