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
    List<TreeNode> forest;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for (int val : to_delete) {
            toDelete.add(val);
        }
        
        helper(root, toDelete);
        
        if (!toDelete.contains(root.val)) {
            forest.add(root);
        }
        
        return forest;
    }
    
    private TreeNode helper(TreeNode root, Set<Integer> toDelete) {
        if (root == null) {
            return null;
        }
        
        root.left = helper(root.left, toDelete);
        root.right = helper(root.right, toDelete);
        
        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            
            if (root.right != null) {
                forest.add(root.right);
            }
            
            return null;
        }
        
        return root;
    }
}
