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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root != null) {
            getString(root, "", list);
        }
        
        return list;
    }
    
    public void getString(TreeNode root, String s, List<String> list) {
        if (root.left == null && root.right == null) {
            list.add(s + root.val);
        }
        
        if (root.left != null) {
            getString(root.left, s + root.val + "->", list);
        }
        
        if (root.right != null) {
            getString(root.right, s + root.val + "->", list);
        }
    }
}
