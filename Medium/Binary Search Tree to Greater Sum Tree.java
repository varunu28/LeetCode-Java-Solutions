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
    public TreeNode bstToGst(TreeNode root) {
        inorderReverse(root, new int[]{0});
        return root;
    }
    
    private void inorderReverse(TreeNode root, int[] currVal) {
        if (root == null) {
            return;
        }
        
        inorderReverse(root.right, currVal);
        currVal[0] += root.val;
        root.val = currVal[0];
        inorderReverse(root.left, currVal);
    }
}
