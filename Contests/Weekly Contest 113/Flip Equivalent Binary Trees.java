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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        
        if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
            return false;
        }
        
        if (root1.left == null && root1.right == null && (root2.left != null || root2.right != null)) {
            System.out.println("HERE1");
            return false;
        }
        
        if ((root1.left != null || root1.right != null) && root2.left == null && root2.right == null) {
            System.out.println("HERE2");
            return false;
        }
        
        if (root1.left == null && root1.right != null && root2.left != null && root2.right == null) {
            if (root1.right.val != root2.left.val) {
                return false;
            }
            
            TreeNode temp = root1.right;
            root1.right = root1.left;
            root1.left = temp;
        }
        else if (root1.left != null && root1.right == null && root2.left == null && root2.right != null) {
            if (root1.left.val != root2.right.val) {
                return false;
            }
            
            TreeNode temp = root1.right;
            root1.right = root1.left;
            root1.left = temp;
        }
        else if (root1.left != null && root1.right != null && root2.left != null && root2.right != null && 
                 (root1.left.val == root2.right.val && root1.right.val == root2.left.val)) {
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
        }
        else if (root1.left != null && root1.right != null && root2.left != null && root2.right != null &&
                ((root1.left.val != root2.right.val && root1.right.val != root2.right.val) ||
               (root1.right.val != root2.left.val && root1.left.val != root2.left.val))) {
            System.out.println("HERE3");
            return false;
        }
        
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right); 
    }
}
