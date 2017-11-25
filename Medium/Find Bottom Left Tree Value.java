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
    int ans = 0;
    int height = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }
    
    public void findBottomLeftValue(TreeNode root, int depth) {
        if (height < depth) {
            ans = root.val;
            height = depth;
        }
        if (root.left!=null) findBottomLeftValue(root.left, depth+1);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1);
    }
}
