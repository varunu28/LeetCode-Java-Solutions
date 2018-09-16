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
    
    public List<TreeNode> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        inorderTraversal(root);
        
        if (list.size() == 0) return null;
        
        TreeNode ans = list.get(0);
        TreeNode curr = ans;
        
        for (int i=1; i<list.size(); i++) {
            curr.right = list.get(i);
            curr.left = null;
            curr = curr.right;
        }
        
        curr.left = null;
        
        return ans;
    }
    
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }
}
