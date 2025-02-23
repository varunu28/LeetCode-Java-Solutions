/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer, Integer> postorderIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            postorderIndex.put(postorder[i], i);
        }
        return constructTree(0, n - 1, 0, preorder, postorderIndex);
    }

    private TreeNode constructTree(int preStart, int preEnd, int postStart, int[] preorder, Map<Integer, Integer> postorderIndex) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int leftRoot = preorder[preStart + 1];
        int leftCount = postorderIndex.get(leftRoot) - postStart + 1;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = constructTree(preStart + 1, preStart + leftCount, postStart, preorder, postorderIndex);
        root.right = constructTree(preStart + leftCount + 1, preEnd, postStart + leftCount, preorder, postorderIndex);
        return root;
    }
}
