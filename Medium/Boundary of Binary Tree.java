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
    int backIdx;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        list = new ArrayList<>();
        backIdx = 0;
        
        if (root == null) {
            return list;
        }
        
        list.add(root.val);
        
        addLeft(root.left);
        addLeaves(root.left);
        addLeaves(root.right);
        addRight(root.right);
        
        return list;
    }
    
    private void addLeft(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        
        list.add(node.val);
        
        addLeft(node.left == null ? node.right : node.left);
    }
    
    private void addRight(TreeNode node) {
        if (node == null || (node.right == null && node.left == null)) {
            return;
        }
        
        list.add(list.size() - backIdx, node.val);
        backIdx++;
        
        addRight(node.right == null ? node.left : node.right);
    }
    
    private void addLeaves(TreeNode node) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            list.add(node.val);    
            return;
        } 
        
        addLeaves(node.left);
        addLeaves(node.right);
    }
}
