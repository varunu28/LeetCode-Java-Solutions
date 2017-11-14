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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(q.size()>0) {
            List<Integer> arr = new ArrayList<>();
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode n = q.poll();
                arr.add(n.val);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            ans.add(0, arr);
        }
        
        return ans;
    }
}
