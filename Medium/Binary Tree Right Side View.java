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
    List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        
        helper(root);
        return list;
    }
    
    private void helper(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i=1; i<=size; i++) {
                TreeNode popped = queue.remove();
                if (popped.left != null) {
                    queue.add(popped.left);
                }
                if (popped.right != null) {
                    queue.add(popped.right);
                }
                
                if (i == size) {
                    list.add(popped.val);
                }
            }
        }
    }
}
