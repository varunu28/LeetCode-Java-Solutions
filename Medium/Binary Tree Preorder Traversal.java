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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> s = new Stack<>();
        
        s.push(root);
        
        while(s.size() > 0) {
            TreeNode curr = s.pop();
            ans.add(curr.val);
            if(curr.right != null) {
                s.push(curr.right);
            }
            
            if(curr.left != null) {
                s.push(curr.left);
            }
        }
        
        return ans;
    }
}
