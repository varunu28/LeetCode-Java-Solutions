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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int ans = -1;
        
        while(root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            k--;
            root = stack.pop();
            
            if (k == 0) {
                ans = root.val;
                break;
            }
            
            root = root.right;
        }
        
        return ans;
    }
}
