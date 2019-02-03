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
    public String smallestFromLeaf(TreeNode root) {
        return helper(root);
    }
    
    private String helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        char ch = (char) (97 + root.val);
        String leftVal = helper(root.left);
        String rightVal = helper(root.right);
        
        if (leftVal == null && rightVal == null) {
            return "" + ch;
        }
        
        if (root.left == null || root.right == null) {
            return rightVal == null ? leftVal + ch : rightVal + ch;
        }
        
        if (rightVal.compareTo(leftVal) > 0) {
            return leftVal + ch;
        }
        else {
            return rightVal + ch;
        }
    }
}
