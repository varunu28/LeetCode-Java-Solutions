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
    public TreeNode buildTree(int[] inorder, int[] postorder) { 
        if (postorder.length == 0) {
            return null;
        }
        
        TreeNode root = constructTree(inorder, 0, inorder.length - 1, postorder, postorder.length-1);
        
        return root;
    }
    
    private TreeNode constructTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
        if (inStart > inEnd) {
            return null;
        }
        
        int idx = getIndex(inorder, postorder[postStart], inStart, inEnd);

        TreeNode node = new TreeNode(inorder[idx]);
        node.left = constructTree(inorder, inStart, idx - 1, postorder, postStart-(inEnd - idx) - 1);
        node.right = constructTree(inorder, idx + 1, inEnd, postorder, postStart-1);
        
        return node;
    }
    
    private int getIndex(int[] arr, int num, int start, int end) {
        for (int i=start; i<=end; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        
        return -1;
    }
}
