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
  Integer prev = null;
  int count = 1;
  int max = 0;
  public int[] findMode(TreeNode root) {
    if (root == null) {
      return new int[0];
    }
    List<Integer> list = new ArrayList<>();
    traverse(root, list);
    int[] ans = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }
  
  private void traverse(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    traverse(root.left, list);
    if (prev != null) {
      if (root.val == prev) {
        count++;
      }
      else {
        count = 1;
      }
    }
    if (count > max) {
      max = count;
      list.clear();
      list.add(root.val);
    }
    else if (count == max) {
      list.add(root.val);
    }
    prev = root.val;
    traverse(root.right, list);
  }
}
