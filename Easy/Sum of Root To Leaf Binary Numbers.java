/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  List<String> list;
  public int sumRootToLeaf(TreeNode root) {
    list = new ArrayList<>();
    helper(root, new StringBuilder());
    int ans = 0;
    for (String num : list) {
      ans += getIntegerVal(num);
    }
    return ans;
  }
  
  private void helper(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(root.val);
    if (root.left == null && root.right == null) {
      list.add(sb.toString());
    }
    else {
      helper(root.left, new StringBuilder(sb.toString()));
      helper(root.right, new StringBuilder(sb.toString()));
    }
  }
  
  private int getIntegerVal(String s) {
    int num = 0;
    int pow = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      num += Character.getNumericValue(s.charAt(i)) * pow;
      pow *= 2;
    }
    return num;
  }
}
