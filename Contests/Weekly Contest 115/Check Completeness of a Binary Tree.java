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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int numOfNodes = getNumOfNodes(root);
        return isCompleteTreeHelper(root, 0, numOfNodes);
    }
    
    private boolean isCompleteTreeHelper(TreeNode root, int curr, int numOfNodes) {
        if (root == null) {
            return true;
        }
        
        if (curr >= numOfNodes) {
            return false;
        }
        
        return isCompleteTreeHelper(root.left, 2 * curr + 1, numOfNodes) && isCompleteTreeHelper(root.right, 2 * curr + 2, numOfNodes);
    }
    
    private int getNumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + getNumOfNodes(root.left) + getNumOfNodes(root.right);
    }
}
