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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null || root.right == null) {
                TreeNode temp = root.left == null ? root.right : root.left;
                
                if (temp == null) {
                    return null;
                }
                else {
                    return temp;
                }
            }
            else {
                TreeNode rightSuccessor = getRightSuccessor(root);
                root.val = rightSuccessor.val;
                root.right = deleteNode(root.right, rightSuccessor.val);
            }
        }
        
        return root;
    }
    
    private TreeNode getRightSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }    
        
        TreeNode temp = node.right;
        if (temp != null) {
            while (temp.left != null) {
                temp = temp.left;
            }
        }
        
        return temp;
    }
}
