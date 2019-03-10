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
    int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return bstFromPreorderHelper(preorder, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode bstFromPreorderHelper(int[] preorder, int key, int min, int max) {
        if (idx >= preorder.length) {
            return null;
        }
        
        TreeNode root = null;
        
        if (preorder[idx] > min && preorder[idx] < max) {
            root = new TreeNode(key);
            idx++;
            
            if (idx < preorder.length) {
                root.left = bstFromPreorderHelper(preorder, preorder[idx], min, key);
                
                if (idx < preorder.length) {
                    root.right = bstFromPreorderHelper(preorder, preorder[idx], key, max);
                }
            }
        }
        
        return root;
    }
}
