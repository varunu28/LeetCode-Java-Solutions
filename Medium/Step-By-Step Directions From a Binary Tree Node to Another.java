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
  public String getDirections(TreeNode root, int startValue, int destValue) {
    StringBuilder sourcePath = new StringBuilder();
    StringBuilder destinationPath = new StringBuilder();
    findPath(root, startValue, sourcePath);
    findPath(root, destValue, destinationPath);
    int idx = 0;
    // Remove common prefix
    while (idx < Math.min(sourcePath.length(), destinationPath.length()) && 
           sourcePath.charAt(sourcePath.length() - idx - 1) == destinationPath.charAt(destinationPath.length() - idx - 1)) {
      idx++;
    }
    // Replace remaining sourcePath with 'U' and append remaining destinationPath
    return "U".repeat(sourcePath.length() - idx) + destinationPath.reverse().toString().substring(idx);
  }
  
  private boolean findPath(TreeNode root, int value, StringBuilder sb) {
    if (root.val == value) {
      return true;
    }
    if (root.left != null && findPath(root.left, value, sb)) {
      sb.append("L");
    }
    else if (root.right != null && findPath(root.right, value, sb)) {
      sb.append("R");
    }
    return sb.length() > 0;
  }
}
