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
  public List<TreeNode> allPossibleFBT(int n) {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();
    return allPossibleFBTHelper(n, dp);
  }
  
  private List<TreeNode> allPossibleFBTHelper(int n, Map<Integer, List<TreeNode>> dp) {
    if (dp.containsKey(n)) {
      return dp.get(n);
    }
    List<TreeNode> result = new ArrayList<>();
    if (n == 1) {
      result.add(new TreeNode(0));
    } else if (n % 2 == 1) {
      for (int i = 0; i < n; i++) {
        int j = n - 1 - i;
        for (TreeNode left : allPossibleFBTHelper(i, dp)) {
          for (TreeNode right : allPossibleFBTHelper(j, dp)) {
            TreeNode root = new TreeNode(0);
            root.left = left;
            root.right = right;
            result.add(root);
          }
        }
      }
    }
    dp.put(n, result);
    return dp.get(n);
  }
}
