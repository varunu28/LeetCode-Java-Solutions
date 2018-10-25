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
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] ans = new TreeNode[2]; 
        if (root == null) {
            return ans;
        }
        
        if (root.val <= V) {
            ans = splitBST(root.right, V);
            root.right = ans[0];
            ans[0] = root;
        }
        else {
            ans = splitBST(root.left, V);
            root.left = ans[1];
            ans[1] = root;
        }
        
        return ans;
    }
}
