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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        while (root != null) {
            List<Integer> leaves = getLeaves(root);
            root = removeLeaves(root);
            list.add(leaves);
        }
        
        return list;
    }
    
    private TreeNode removeLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            return null;
        }
        
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        
        return root;
    }
    
    private List<Integer> getLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
        return list;
    } 
}
