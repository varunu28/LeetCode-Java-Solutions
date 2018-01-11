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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) return ans;
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                temp.add(queue.remove());
            }
            
            List<Integer> lst = new ArrayList<>();
            
            for (TreeNode t : temp) {
                lst.add(t.val);
                
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            
            ans.add(lst);
        }
        
        return ans;
    }
}
