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
  public TreeNode balanceBST(TreeNode root) {
    List<Integer> sortedList = new ArrayList<>();
    inorderTraversal(root, sortedList);
    return buildBST(sortedList, 0, sortedList.size() - 1);
  }   
  
  private TreeNode buildBST(List<Integer> sortedList, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(sortedList.get(mid));
    root.left = buildBST(sortedList, start, mid - 1);
    root.right = buildBST(sortedList, mid + 1, end);
    return root;
  }
  
  private void inorderTraversal(TreeNode root, List<Integer> sortedList) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left, sortedList);
    sortedList.add(root.val);
    inorderTraversal(root.right, sortedList);
  }
}
